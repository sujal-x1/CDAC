# Node.js + Express + MongoDB + React CRUD App — Complete Beginner Guide

Your PDF asks you to build a Node application with customer data, CRUD operations, navigation, login/logout, and a customer list that is accessible only when the user is logged in as `VITA`. It also asks for separate header and footer components, a dropdown of customer names, and displaying the selected customer's details.&#x20;

React node mini app_write.pdf



We'll build that application from scratch, in the correct order, using exact code and simple explanations. No advanced concepts unless they are necessary.

## 1. What are we building?

React — Frontend

Pages, forms, buttons, customer table

HTTP requests (fetch)

Node.js + Express — Backend

Routes, login checks, CRUD operations

Mongoose queries

MongoDB — Database

Stores customer records permanently

### What each technology does

- Node.js: Runs JavaScript outside the browser.
- Express: Helps us create backend routes such as `/api/customers`.
- MongoDB: Stores customer information.
- Mongoose: Lets Node.js work with MongoDB using models.
- React: Creates the user interface.
- Fetch: Sends requests from React to the backend.

We'll use a simple username-based login to match your practical question. This is suitable for learning the requested workflow, not for production security.

## 2. Install and check the prerequisites

Open VS Code, then open Terminal → New Terminal.

Run these commands one at a time:

```
node -v
npm -v
```

Both should display version numbers. If `node` isn't recognized, install the current LTS version of Node.js from [nodejs.org](https://nodejs.org/?utm_source=chatgpt.com), then restart VS Code.

Check MongoDB:

```
sc.exe query MongoDB
```

If the service is installed and stopped, start it in a terminal with administrator privileges:

```
net start MongoDB
```

If it is already running, you don't need to do anything. If MongoDB isn't installed as a service, we'll need to start `mongod` using its configured executable and data directory.

## 3. Create the project folders

In VS Code, choose a folder where you want to keep the project. For example, your `D:` drive.

Open a terminal and run:

```
cd "D:\CDAC"
mkdir customer-crud
cd customer-crud
mkdir server
```

Your project will eventually look like this:

customer-crud/

server/

server.js — starts the backend

models/Customer.js — customer model

routes/customers.js — CRUD and login checks

client/

src/App.jsx — main application

src/components/Header.jsx

src/components/Footer.jsx

src/components/CustomerList.jsx

The `client` folder will be created by Vite in the next step.

## 4. Create the Node.js server

Enter the server directory:

```
cd "D:\CDAC\customer-crud\server"
npm init -y
npm install express mongoose cors
```

What these commands do:

- `npm init -y` creates `package.json`.
- `express` creates the server and API routes.
- `mongoose` connects Node.js to MongoDB.
- `cors` allows the React application to communicate with the backend on a different port.

### 4.1 Create `server.js`

Create a file named `server.js` inside the `server` folder and paste this code:

```

const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");

const app = express();

app.use(cors());
app.use(express.json());

// Connect to MongoDB
mongoose
  .connect("mongodb://127.0.0.1:27017/customerdb")
  .then(() => console.log("MongoDB connected"))
  .catch((err) => console.log("MongoDB error:", err));

// Use customer routes
app.use("/api/customers", require("./routes/customers"));

app.get("/", (req, res) => {
  res.send("Customer CRUD API is running");
});

app.listen(5000, () => {
  console.log("Server running at http://localhost:5000");
});

```

Understand these four important lines:

| Code                 | Meaning                                              |
| -------------------- | ---------------------------------------------------- |
| `express()`          | Creates the Express application.                     |
| `express.json()`     | Reads JSON data sent in requests.                    |
| `mongoose.connect()` | Connects to the MongoDB database named `customerdb`. |
| `app.listen(5000)`   | Starts the backend on port 5000.                     |

MongoDB creates the database when data is first written to it; you do not need to create `customerdb` manually.

## 5. Create the customer model

Inside `server`, create a folder named `models`. Inside it, create `Customer.js`.

Path: `server/models/Customer.js`

```

const mongoose = require("mongoose");

const customerSchema = new mongoose.Schema({
  id: {
    type: Number,
    unique: true
  },
  name: {
    type: String,
    required: true
  },
  mobile: String,
  email: String,
  address: String,
  image: String
});

module.exports = mongoose.model("Customer", customerSchema);

```

### What is a model?

A model describes the structure of the data stored in MongoDB.

For example, a customer will look like this:

```
{
  id: 1,
  name: "Raj",
  mobile: "96189652",
  email: "r@gmail.com",
  address: "Juhu",
  image: "./images/a.png"
}
```

The custom numeric `id` follows your practical's auto-increment requirement. MongoDB also automatically creates its own `_id` field.

## 6. Create the CRUD routes

CRUD means:

- C — Create: Add a customer.
- R — Read: Display customers.
- U — Update: Edit customer details.
- D — Delete: Remove a customer.

Create the `routes` folder inside `server`, and then create `customers.js`.

Path: `server/routes/customers.js`

```

const express = require("express");
const router = express.Router();
const Customer = require("../models/Customer");

// Allow customer-list operations only for logged-in VITA
function checkLogin(req, res, next) {
  if (req.headers["x-username"] !== "VITA") {
    return res.status(403).json({
      message: "Only logged-in VITA can access customers"
    });
  }

  next();
}

// CREATE customer
router.post("/", checkLogin, async (req, res) => {
  try {
    const lastCustomer = await Customer.findOne().sort({ id: -1 });
    const nextId = lastCustomer ? lastCustomer.id + 1 : 1;

    const customer = await Customer.create({
      id: nextId,
      name: req.body.name,
      mobile: req.body.mobile,
      email: req.body.email,
      address: req.body.address,
      image: req.body.image
    });

    res.status(201).json(customer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// READ all customers
router.get("/", checkLogin, async (req, res) => {
  try {
    const customers = await Customer.find().sort({ id: 1 });
    res.json(customers);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// READ one customer
router.get("/:id", checkLogin, async (req, res) => {
  try {
    const customer = await Customer.findOne({
      id: Number(req.params.id)
    });

    if (!customer) {
      return res.status(404).json({ message: "Customer not found" });
    }

    res.json(customer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// UPDATE customer
router.put("/:id", checkLogin, async (req, res) => {
  try {
    const customer = await Customer.findOneAndUpdate(
      { id: Number(req.params.id) },
      {
        name: req.body.name,
        mobile: req.body.mobile,
        email: req.body.email,
        address: req.body.address,
        image: req.body.image
      },
      { new: true, runValidators: true }
    );

    if (!customer) {
      return res.status(404).json({ message: "Customer not found" });
    }

    res.json(customer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// DELETE customer
router.delete("/:id", checkLogin, async (req, res) => {
  try {
    const customer = await Customer.findOneAndDelete({
      id: Number(req.params.id)
    });

    if (!customer) {
      return res.status(404).json({ message: "Customer not found" });
    }

    res.json({ message: "Customer deleted successfully" });
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

module.exports = router;

```

### How the routes work

| HTTP method | URL                | Operation         |
| ----------- | ------------------ | ----------------- |
| POST        | `/api/customers`   | Create            |
| GET         | `/api/customers`   | Read all          |
| GET         | `/api/customers/1` | Read customer 1   |
| PUT         | `/api/customers/1` | Update customer 1 |
| DELETE      | `/api/customers/1` | Delete customer 1 |

`checkLogin` is middleware. It checks the username sent in the `x-username` request header before allowing the operation. The frontend will send that header after the user logs in as `VITA`.

Note: This username check is a practical-exercise demonstration, not real authentication. Anyone can forge the header; a production application needs authenticated sessions or tokens.

## 7. Start and test the backend

Before creating React, let's make sure Node.js and MongoDB work.

In the terminal, ensure you are inside `server`:

```
node server.js
```

Expected output:

```
Server running at http://localhost:5000
MongoDB connected
```

Open this URL in your browser:

[http://localhost:5000](http://localhost:5000)

You should see:

```
Customer CRUD API is running
```

If you see a MongoDB connection error, check that the MongoDB service is running before continuing.

Keep this terminal open. Do not stop the server.

## 8. Create the React frontend

Open a second terminal in VS Code. Move to the main project folder:

```
cd "D:\CDAC\customer-crud"
npm create vite@latest client -- --template react
cd client
npm install
```

Vite creates the React application in `client`.

Now create the component folder:

```
mkdir src\components
```

Your main structure will be:

```
customer-crud/
├── server/
│   ├── models/
│   │   └── Customer.js
│   ├── routes/
│   │   └── customers.js
│   ├── server.js
│   └── package.json
└── client/
    ├── src/
    │   ├── components/
    │   │   ├── Header.jsx
    │   │   ├── Footer.jsx
    │   │   └── CustomerList.jsx
    │   ├── App.jsx
    │   ├── main.jsx
    │   └── index.css
    └── package.json
```

## 9. Create the Header component

Create `client/src/components/Header.jsx`.

```

function Header({ user, setPage, onLogout }) {
  return (
    <header>
      <h2>Customer Management</h2>

      <nav>
        <button onClick={() => setPage("home")}>
          Home
        </button>

        <button onClick={() => setPage("contact")}>
          Contact Us
        </button>

        {user === "VITA" && (
          <button onClick={() => setPage("customers")}>
            List Customer
          </button>
        )}

        {user ? (
          <button onClick={onLogout}>Logout</button>
        ) : (
          <span>Login →</span>
        )}
      </nav>
    </header>
  );
}

export default Header;

```

The `user`, `setPage`, and `onLogout` values come from the main React component. They let the header change pages and log out without duplicating application logic.

## 10. Create the Footer component

Create `client/src/components/Footer.jsx`.

```

function Footer() {
  return (
    <footer>
      <p>Copyright CDAC.IN</p>
    </footer>
  );
}

export default Footer;

```

Your PDF asks for the header and footer to be separate components. React lets us reuse them on every page.

## 11. Create the Customer List component

Create `client/src/components/CustomerList.jsx`.

This component will:

- Fetch customers from MongoDB through the Express API.
- Display a dropdown containing all customer names.
- Display the selected customer's details in a table.
- Add, edit and delete customers.

```

import { useEffect, useState } from "react";

const API = "http://localhost:5000/api/customers";

const emptyForm = {
  name: "",
  mobile: "",
  email: "",
  address: "",
  image: ""
};

function CustomerList({ user }) {
  const [customers, setCustomers] = useState([]);
  const [selectedId, setSelectedId] = useState("");
  const [form, setForm] = useState(emptyForm);
  const [editId, setEditId] = useState(null);
  const [message, setMessage] = useState("");

  const headers = {
    "Content-Type": "application/json",
    "x-username": user
  };

  async function loadCustomers() {
    const response = await fetch(API, { headers });

    if (!response.ok) {
      throw new Error("Could not load customers");
    }

    const data = await response.json();
    setCustomers(data);

    setSelectedId((oldId) =>
      data.some((c) => String(c.id) === oldId)
        ? oldId
        : data.length > 0
          ? String(data[0].id)
          : ""
    );
  }

  useEffect(() => {
    loadCustomers().catch((err) => setMessage(err.message));
  }, []);

  function handleChange(e) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  async function handleSubmit(e) {
    e.preventDefault();
    setMessage("");

    try {
      const url = editId
        ? `${API}/${editId}`
        : API;

      const response = await fetch(url, {
        method: editId ? "PUT" : "POST",
        headers,
        body: JSON.stringify(form)
      });

      const result = await response.json();

      if (!response.ok) {
        throw new Error(result.message || "Operation failed");
      }

      setForm(emptyForm);
      setEditId(null);
      await loadCustomers();
      setSelectedId(String(result.id));
      setMessage(editId ? "Customer updated" : "Customer added");
    } catch (err) {
      setMessage(err.message);
    }
  }

  function startEdit(customer) {
    setForm({
      name: customer.name || "",
      mobile: customer.mobile || "",
      email: customer.email || "",
      address: customer.address || "",
      image: customer.image || ""
    });

    setEditId(customer.id);
  }

  async function deleteCustomer(id) {
    if (!window.confirm("Delete this customer?")) return;

    try {
      const response = await fetch(`${API}/${id}`, {
        method: "DELETE",
        headers
      });

      const result = await response.json();

      if (!response.ok) {
        throw new Error(result.message || "Delete failed");
      }

      await loadCustomers();
      setMessage("Customer deleted");
    } catch (err) {
      setMessage(err.message);
    }
  }

  const selected = customers.find(
    (c) => String(c.id) === selectedId
  );

  return (
    <section>
      <h2>Customer Management</h2>

      <p>{message}</p>

      <h3>{editId ? "Edit Customer" : "Add Customer"}</h3>

      <form onSubmit={handleSubmit}>
        <input
          name="name"
          placeholder="Name"
          value={form.name}
          onChange={handleChange}
          required
        />

        <input
          name="mobile"
          placeholder="Mobile"
          value={form.mobile}
          onChange={handleChange}
        />

        <input
          name="email"
          type="email"
          placeholder="Email"
          value={form.email}
          onChange={handleChange}
        />

        <input
          name="address"
          placeholder="Address"
          value={form.address}
          onChange={handleChange}
        />

        <input
          name="image"
          placeholder="Image path, e.g. ./images/a.png"
          value={form.image}
          onChange={handleChange}
        />

        <button type="submit">
          {editId ? "Update Customer" : "Add Customer"}
        </button>

        {editId && (
          <button
            type="button"
            onClick={() => {
              setEditId(null);
              setForm(emptyForm);
            }}
          >
            Cancel
          </button>
        )}
      </form>

      <hr />

      <h3>Select Customer</h3>

      <select
        value={selectedId}
        onChange={(e) => setSelectedId(e.target.value)}
      >
        <option value="">Select a customer</option>

        {customers.map((customer) => (
          <option key={customer.id} value={customer.id}>
            {customer.name}
          </option>
        ))}
      </select>

      <h3>Customer Details</h3>

      {selected ? (
        <table border="1" cellPadding="8">
          <thead>
            <tr>
              <th>Name</th>
              <th>Mobile</th>
              <th>Email</th>
              <th>Address</th>
              <th>Image</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td>{selected.name}</td>
              <td>{selected.mobile}</td>
              <td>{selected.email}</td>
              <td>{selected.address}</td>
              <td>{selected.image}</td>
              <td>
                <button onClick={() => startEdit(selected)}>
                  Edit
                </button>

                <button onClick={() => deleteCustomer(selected.id)}>
                  Delete
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      ) : (
        <p>No customer selected.</p>
      )}
    </section>
  );
}

export default CustomerList;

```

### The five React concepts you need to understand

| Concept     | What it does here                                              |
| ----------- | -------------------------------------------------------------- |
| `useState`  | Stores customers, form data and selected customer.             |
| `useEffect` | Loads customer data when the component opens.                  |
| `fetch()`   | Sends HTTP requests to Express.                                |
| `map()`     | Creates dropdown options from customer records.                |
| `onChange`  | Updates the form or selected customer when the user interacts. |

For example, when you select Raj in the dropdown, `setSelectedId()` updates the selected ID. React then finds Raj in the customer array and displays Raj's details.

The `POST`, `GET`, `PUT`, and `DELETE` requests connect the React interface to the backend routes you created earlier.

## 12. Create the main application

Create or replace `client/src/App.jsx` with this code.

This file connects the Header, Footer and CustomerList components and handles navigation and login/logout.

```

import { useState } from "react";
import Header from "./components/Header";
import Footer from "./components/Footer";
import CustomerList from "./components/CustomerList";
import "./index.css";

function App() {
  const [page, setPage] = useState("home");
  const [user, setUser] = useState("");
  const [username, setUsername] = useState("");

  function handleLogin(e) {
    e.preventDefault();

    if (!username.trim()) {
      alert("Enter a username");
      return;
    }

    setUser(username.trim().toUpperCase());
    setUsername("");
  }

  function handleLogout() {
    setUser("");
    setPage("home");
  }

  return (
    <div className="app">
      <Header
        user={user}
        setPage={setPage}
        onLogout={handleLogout}
      />

      <main>
        {!user && (
          <form onSubmit={handleLogin} className="login-form">
            <input
              type="text"
              placeholder="Enter username (VITA)"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />

            <button type="submit">Login</button>
          </form>
        )}

        {page === "home" && (
          <section>
            <h2>Welcome to Home Page</h2>
          </section>
        )}

        {page === "contact" && (
          <section>
            <h2>Authorised Training Centre</h2>
            <p>5th Floor, Vidyanidhi Education Complex,</p>
            <p>Vidyanidhi Road, Juhu Scheme,</p>
            <p>Andheri (W), Mumbai 400 049, India</p>
            <p>Mobile: 9029435311 / 9324095272 / 9987062416</p>
            <p>Email: training@vidyanidhi.com</p>
          </section>
        )}

        {page === "customers" && user === "VITA" && (
          <CustomerList key={user} user={user} />
        )}

        {page === "customers" && user !== "VITA" && (
          <p>Access denied. Please log in as VITA.</p>
        )}
      </main>

      <Footer />
    </div>
  );
}

export default App;

```

Important: This reproduces the practical's login condition, but the login accepts a username without a password. The username check is for your exercise only; it is not secure authentication.

## 13. Add basic styling

Open `client/src/index.css`, delete its existing contents, and paste:

```

* {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: Arial, sans-serif;
  color: #222;
}

.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

header {
  background: #e8e8e8;
  padding: 15px 25px;
}

nav {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  gap: 12px;
}

button {
  padding: 8px 14px;
  margin: 4px;
  cursor: pointer;
}

main {
  flex: 1;
  padding: 25px;
}

input,
select {
  padding: 9px;
  margin: 5px;
}

form {
  margin-bottom: 20px;
}

table {
  margin-top: 15px;
  border-collapse: collapse;
  width: 100%;
}

th,
td {
  text-align: left;
  padding: 10px;
}

footer {
  background: #e8e8e8;
  text-align: center;
  padding: 12px;
}

```

## 14. Start React

Open another terminal in VS Code:

```
cd "D:\CDAC\customer-crud\client"
npm run dev
```

Vite will show a local URL, usually:

[http://localhost:5173](http://localhost:5173)

Open the URL in your browser.

Keep both the Node server and React development server running in their own terminals.

## 15. Test the complete application

Follow this exact sequence.

Testing checklist

0/11 completed

Start MongoDB and confirm it is running.

Run node server.js in the server terminal.

Run npm run dev in the client terminal.

Open the React URL in the browser.

Click Login and enter VITA.

Click List Customer.

Add Raj with mobile, email and address details.

Select Raj from the dropdown and verify the table.

Click Edit, change a field and update the record.

Delete the customer and verify it disappears.

Log out and verify List Customer is no longer available.

### What you should see

- Home: Welcome to Home Page.
- Contact Us: The CDAC training centre's address and contact details.
- Login: Changes to Logout after logging in.
- List Customer: Visible to `VITA`, not to other usernames.
- Customer form: Adds and edits customer records.
- Customer dropdown: Shows saved customer names.
- Customer table: Displays the selected customer's details.
- MongoDB: Keeps the records after you stop and restart the application.

## 16. Common errors and fixes

| Error                                     | What to check                                                          |
| ----------------------------------------- | ---------------------------------------------------------------------- |
| `Cannot find module 'express'`            | Run `npm install express mongoose cors` inside `server`.               |
| `Cannot find module './routes/customers'` | Verify the file is at `server/routes/customers.js`.                    |
| `MongoDB connection error`                | Check that the MongoDB service is running.                             |
| `Failed to fetch`                         | Ensure Node is running on port 5000 and React is running on port 5173. |
| `403 Forbidden`                           | Log in as `VITA` and open List Customer again.                         |
| React import error                        | Check component filenames, spelling and capitalization.                |

## 17. Remember the complete workflow

1. Create the model: Define customer fields in `Customer.js`.
2. Create the server: Start Express and connect MongoDB in `server.js`.
3. Create API routes: Use POST, GET, PUT and DELETE in `customers.js`.
4. Create React components: Build Header, Footer and CustomerList.
5. Connect frontend and backend: Use `fetch()` to call the API.
6. Run and test: Start both servers and perform all CRUD operations.

One limitation to be aware of: the PDF specifies that `Image` should store a path such as `./images/a.png`. This implementation stores and displays that path as text; it does not upload an image file. Also, the numeric ID generation is suitable for a basic single-user practical, but a production system should use a concurrency-safe sequence mechanism.

If you are starting from zero, follow Sections 2–7 first and confirm the backend works before moving to React. This makes errors much easier to locate.