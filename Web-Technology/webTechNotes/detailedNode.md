The previous guide covers the main parts, but it is not yet an exact, start-to-finish setup for a completely new project. Some steps need to be made more precise, especially folder creation, MongoDB startup, initial customer data, login behavior, and testing.

I'll use your uploaded practical PDF as the requirements and give you one fixed sequence to follow on Windows in VS Code. You won't need to decide what files to create or which code to write.

The project will include:

- Node.js and Express backend.
- MongoDB database and Mongoose model.
- React frontend using Vite.
- Separate Header and Footer components.
- Home, Contact Us and List Customer navigation.
- Login/logout with the practical's `VITA` restriction.
- Add, display, edit and delete customer records.
- Customer-name dropdown that displays the selected record.
- Image path stored as a string.

# Step 1 — Create a new project

Open VS Code → Terminal → New Terminal. Use PowerShell.

Run these commands one at a time:

```
cd "D:\CDAC\self"
mkdir customer-crud
cd customer-crud
mkdir server
```

If `customer-crud` already exists, open that folder instead of creating it again.

# Step 2 — Set up the backend

Run:

```
cd "D:\CDAC\self\customer-crud\server"
npm init -y
npm install express mongoose cors
mkdir models
mkdir routes
```

Create these three files using VS Code's Explorer.

```
server/
├── models/
│   └── Customer.js
├── routes/
│   └── customers.js
├── server.js
├── package.json
└── package-lock.json
```

## File 1: `server/models/Customer.js`

Paste this entire code:

```

const mongoose = require("mongoose");

const customerSchema = new mongoose.Schema({
  id: {
    type: Number,
    required: true,
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

## File 2: `server/routes/customers.js`

Paste this entire code:

```

const express = require("express");
const router = express.Router();
const Customer = require("../models/Customer");

function checkLogin(req, res, next) {
  if (req.headers["x-username"] !== "VITA") {
    return res.status(403).json({
      message: "Only VITA can access this operation"
    });
  }

  next();
}

// CREATE
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

// READ ALL
router.get("/", checkLogin, async (req, res) => {
  try {
    const customers = await Customer.find().sort({ id: 1 });
    res.json(customers);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// READ ONE
router.get("/:id", checkLogin, async (req, res) => {
  try {
    const customer = await Customer.findOne({
      id: Number(req.params.id)
    });

    if (!customer) {
      return res.status(404).json({
        message: "Customer not found"
      });
    }

    res.json(customer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// UPDATE
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
      return res.status(404).json({
        message: "Customer not found"
      });
    }

    res.json(customer);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// DELETE
router.delete("/:id", checkLogin, async (req, res) => {
  try {
    const customer = await Customer.findOneAndDelete({
      id: Number(req.params.id)
    });

    if (!customer) {
      return res.status(404).json({
        message: "Customer not found"
      });
    }

    res.json({
      message: "Customer deleted successfully"
    });
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

module.exports = router;

```

## File 3: `server/server.js`

Paste this entire code:

```

const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");

const app = express();

app.use(cors());
app.use(express.json());

mongoose
  .connect("mongodb://127.0.0.1:27017/customerdb")
  .then(() => console.log("MongoDB connected"))
  .catch((err) => console.log("MongoDB error:", err));

app.use("/api/customers", require("./routes/customers"));

app.get("/", (req, res) => {
  res.send("Customer CRUD API is running");
});

app.listen(5000, () => {
  console.log("Server running at http://localhost:5000");
});

```

# Step 3 — Start and verify the backend

Your MongoDB installation is already configured on your D: drive. In a terminal, check the service:

```
sc.exe query MongoDB
```

If it is stopped, open an administrator terminal and run:

```
net start MongoDB
```

Now return to the backend terminal:

```
cd "D:\CDAC\self\customer-crud\server"
node server.js
```

Expected output:

```
Server running at http://localhost:5000
MongoDB connected
```

Open [http://localhost:5000](http://localhost:5000?utm_source=chatgpt.com) in your browser. It should display:

```
Customer CRUD API is running
```

Keep this terminal running.

# Step 4 — Create the React frontend

Open a second terminal in VS Code. Run:

```
cd "D:\CDAC\self\customer-crud"
npm create vite@latest client -- --template react
```

If asked to install `create-vite`, enter `y` and press Enter.

Then run:

```
cd client
npm install
mkdir src\components
```

Create these files:

```
client/
└── src/
    ├── components/
    │   ├── Header.jsx
    │   ├── Footer.jsx
    │   └── CustomerList.jsx
    ├── App.jsx
    ├── index.css
    └── main.jsx
```

# Step 5 — Create the Header

Open `client/src/components/Header.jsx` and replace its contents with:

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
          <span>Login</span>
        )}
      </nav>
    </header>
  );
}

export default Header;

```

# Step 6 — Create the Footer

Open `client/src/components/Footer.jsx` and paste:

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

# Step 7 — Create the Customer List and CRUD page

Open `client/src/components/CustomerList.jsx` and replace its contents with this complete code:

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
    const data = await response.json();

    if (!response.ok) {
      throw new Error(data.message || "Unable to load customers");
    }

    setCustomers(data);

    setSelectedId((oldId) => {
      if (data.some((c) => String(c.id) === oldId)) {
        return oldId;
      }

      return data.length ? String(data[0].id) : "";
    });
  }

  useEffect(() => {
    loadCustomers().catch((err) => setMessage(err.message));
  }, [user]);

  function handleChange(e) {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  }

  async function handleSubmit(e) {
    e.preventDefault();
    setMessage("");

    try {
      const url = editId ? `${API}/${editId}` : API;

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

      setMessage(
        editId ? "Customer updated successfully" : "Customer added successfully"
      );
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
    if (!window.confirm("Are you sure you want to delete this customer?")) {
      return;
    }

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
      setMessage("Customer deleted successfully");
    } catch (err) {
      setMessage(err.message);
    }
  }

  const selected = customers.find(
    (c) => String(c.id) === selectedId
  );

  return (
    <section>
      <h2>List Customer</h2>

      {message && <p>{message}</p>}

      <h3>{editId ? "Update Customer" : "Add Customer"}</h3>

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
          placeholder="Image path (./images/a.png)"
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
        <option value="">Select customer</option>

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

# Step 8 — Create the main React application

Open `client/src/App.jsx`. Delete everything and paste:

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

    const name = username.trim().toUpperCase();

    if (!name) {
      alert("Please enter username");
      return;
    }

    setUser(name);
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
              placeholder="Enter username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />

            <button type="submit">Login</button>
          </form>
        )}

        {page === "home" && (
          <h2>Welcome to Home Page</h2>
        )}

        {page === "contact" && (
          <section>
            <h2>Authorised Training Centre</h2>
            <p>5th Floor, Vidyanidhi Education Complex,</p>
            <p>Vidyanidhi Road, Juhu Scheme</p>
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

# Step 9 — Replace the CSS

Open `client/src/index.css`. Delete its existing contents and paste:

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
  gap: 10px;
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
  width: 100%;
  margin-top: 15px;
  border-collapse: collapse;
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

@media (max-width: 650px) {
  main {
    padding: 12px;
    overflow-x: auto;
  }

  table {
    min-width: 650px;
  }
}

```

# Step 10 — Check `main.jsx`

Open `client/src/main.jsx`. Replace its contents with:

```

import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App />
  </StrictMode>
);

```

# Step 11 — Run the frontend

Open a third terminal in VS Code and run:

```
cd "D:\CDAC\self\customer-crud\client"
npm run dev
```

Wait for Vite to display its local URL. Open:

[http://localhost:5173](http://localhost:5173?utm_source=chatgpt.com)

Do not close either of the other two terminals.

# Step 12 — Test the application in this order

Follow these exact steps in the browser.

## Test 1: Home page

[CodePen - A Pen by Arnel](https://images.openai.com/static-rsc-4/x2o1GUyY2P9wSUM28ZUMGajfCiQ1L7uO8z7PEQLWHUYwU8f3LXHlLrHd8AxrI9snTYaQHvp5YgR7vMkMlk8O-7niotbqm9pl01YrEnShxjT-6YNHFmgoeF59CD-1ccPTwaRMbdZpQtkoPlqyIzU2keCtHImYhry95fxl-pnoEgI?purpose=inline)

[codepen.io](https://codepen.io/cbyte/pen/wrXKWJ?utm_source=chatgpt.com)

1. Open `http://localhost:5173`.
2. Confirm you see Home, Contact Us, Login and the footer.
3. Confirm the page displays Welcome to Home Page.
   ## Test 2: Login
4. Enter `VITA` in the username box.
5. Click Login.
6. Confirm Login changes to Logout and List Customer appears.
   ## Test 3: Add a customer
7. Click List Customer.
8. Fill the form with the following test data.

| Field   | Value            |
| ------- | ---------------- |
| Name    | Raj              |
| Mobile  | 96189652         |
| Email   | r\@gmail.com     |
| Address | Juhu             |
| Image   | `./images/a.png` |

3. Click Add Customer.
4. Confirm Raj appears in the dropdown and the details table.
   ## Test 4: Update and delete
5. Select Raj from the dropdown.
6. Click Edit.
7. Change the address and click Update Customer.
8. Confirm the updated address appears.
9. Click Delete, confirm the deletion and verify the record disappears.
   ## Test 5: Logout
10. Click Logout.
11. Confirm List Customer is no longer shown.
12. Log in using another username and confirm List Customer is not shown.

## Step 13 — If anything fails

Check these items first:

- MongoDB error: Run `sc.exe query MongoDB` in PowerShell.
- Backend not responding: Check that `node server.js` is still running in the `server` terminal.
- Frontend not opening: Check that `npm run dev` is still running in the `client` terminal.
- Customer request returns 403: Log in as `VITA`.
- Missing module error: Run `npm install` in the folder that contains the relevant `package.json`.
- React import error: Check each filename and folder name against the structure in Steps 4–10.

Your MongoDB connection string is:

```
mongodb://127.0.0.1:27017/customerdb
```

The database is created automatically when the first customer is saved.

Important: This completes the basic practical application. The login is only a username check for the exercise, not secure authentication. The image field stores a path as a string; it does not upload image files.