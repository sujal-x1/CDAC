import { useCallback, useEffect, useState } from "react";

const emptyForm = {
  name: "",
  mobile: "",
  email: "",
  address: "",
  image: ""
};

async function request(path, user, options = {}) {
  let response;
  try {
    response = await fetch(path, {
      ...options,
      headers: {
        ...(options.body ? { "Content-Type": "application/json" } : {}),
        "x-username": user,
        ...options.headers
      }
    });
  } catch {
    throw new Error("Could not reach the API. Check that the backend is running.");
  }

  const result = await response.json().catch(() => ({}));
  if (!response.ok) {
    throw new Error(result.message || `Request failed (${response.status})`);
  }
  return result;
}

function CustomerList({ user }) {
  const [customers, setCustomers] = useState([]);
  const [selectedId, setSelectedId] = useState("");
  const [form, setForm] = useState(emptyForm);
  const [editId, setEditId] = useState(null);
  const [message, setMessage] = useState(null);
  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false);

  const loadCustomers = useCallback(async () => {
    setLoading(true);
    try {
      const data = await request("/api/customers", user);
      setCustomers(data);
      setSelectedId((currentId) => (
        data.some((customer) => String(customer.id) === currentId)
          ? currentId
          : data.length
            ? String(data[0].id)
            : ""
      ));
      setMessage(null);
    } catch (error) {
      setMessage({ kind: "error", text: error.message });
    } finally {
      setLoading(false);
    }
  }, [user]);

  useEffect(() => {
    loadCustomers();
  }, [loadCustomers]);

  const selected = customers.find((customer) => String(customer.id) === selectedId);

  function handleChange(event) {
    const { name, value } = event.target;
    setForm((currentForm) => ({ ...currentForm, [name]: value }));
  }

  function resetForm() {
    setForm(emptyForm);
    setEditId(null);
  }

  async function handleSubmit(event) {
    event.preventDefault();
    setSaving(true);
    setMessage(null);

    try {
      const result = await request(
        editId ? `/api/customers/${editId}` : "/api/customers",
        user,
        {
          method: editId ? "PUT" : "POST",
          body: JSON.stringify(form)
        }
      );
      resetForm();
      await loadCustomers();
      setSelectedId(String(result.id));
      setMessage({
        kind: "success",
        text: editId ? "Customer updated successfully." : "Customer added successfully."
      });
    } catch (error) {
      setMessage({ kind: "error", text: error.message });
    } finally {
      setSaving(false);
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
    setMessage(null);
    document.getElementById("customer-name")?.focus();
  }

  async function deleteCustomer(customer) {
    if (!window.confirm(`Delete ${customer.name}? This cannot be undone.`)) {
      return;
    }

    setMessage(null);
    try {
      await request(`/api/customers/${customer.id}`, user, { method: "DELETE" });
      if (editId === customer.id) {
        resetForm();
      }
      await loadCustomers();
      setMessage({ kind: "success", text: "Customer deleted successfully." });
    } catch (error) {
      setMessage({ kind: "error", text: error.message });
    }
  }

  return (
    <section className="customers-page">
      <div className="page-heading">
        <div>
          <p className="eyebrow">CUSTOMER DIRECTORY</p>
          <h1>List Customer</h1>
          <p className="page-description">
            Keep customer details organized in one place.
          </p>
        </div>
        <div className="record-count">
          <span className="record-count-number">{customers.length}</span>
          <span>{customers.length === 1 ? "customer" : "customers"}</span>
        </div>
      </div>

      {message && (
        <div className={`notice notice-${message.kind}`} role="status">
          <span aria-hidden="true">{message.kind === "error" ? "!" : "✓"}</span>
          {message.text}
        </div>
      )}

      <div className="customer-layout">
        <section className="panel form-panel">
          <div className="panel-heading">
            <div>
              <p className="eyebrow">{editId ? "EDIT RECORD" : "NEW RECORD"}</p>
              <h2>{editId ? "Update customer" : "Add a customer"}</h2>
            </div>
            <span className="panel-icon" aria-hidden="true">{editId ? "↻" : "+"}</span>
          </div>

          <form className="customer-form" onSubmit={handleSubmit}>
            <label className="field">
              <span>Name <span className="required">*</span></span>
              <input
                id="customer-name"
                name="name"
                autoComplete="name"
                maxLength={120}
                placeholder="e.g. Raj Kumar"
                value={form.name}
                onChange={handleChange}
                required
              />
            </label>
            <div className="field-row">
              <label className="field">
                <span>Mobile</span>
                <input
                  name="mobile"
                  autoComplete="tel"
                  maxLength={40}
                  placeholder="Phone number"
                  value={form.mobile}
                  onChange={handleChange}
                />
              </label>
              <label className="field">
                <span>Email</span>
                <input
                  name="email"
                  type="email"
                  autoComplete="email"
                  maxLength={254}
                  placeholder="name@example.com"
                  value={form.email}
                  onChange={handleChange}
                />
              </label>
            </div>
            <label className="field">
              <span>Address</span>
              <input
                name="address"
                autoComplete="street-address"
                maxLength={500}
                placeholder="Street, city or area"
                value={form.address}
                onChange={handleChange}
              />
            </label>
            <label className="field">
              <span>Image path</span>
              <input
                name="image"
                maxLength={500}
                placeholder="./images/a.png"
                value={form.image}
                onChange={handleChange}
              />
              <small>Enter a path only; image uploads are not enabled.</small>
            </label>
            <div className="form-actions">
              <button className="button button-dark" type="submit" disabled={saving}>
                {saving ? "Saving..." : editId ? "Save changes" : "Add customer"}
                {!saving && <span aria-hidden="true">→</span>}
              </button>
              {editId && (
                <button className="button button-quiet" type="button" onClick={resetForm}>
                  Cancel
                </button>
              )}
            </div>
          </form>
        </section>

        <section className="panel detail-panel">
          <div className="panel-heading">
            <div>
              <p className="eyebrow">CUSTOMER DETAILS</p>
              <h2>Selected record</h2>
            </div>
            <span className="panel-icon panel-icon-soft" aria-hidden="true">◎</span>
          </div>

          <label className="field select-field">
            <span>Choose a customer</span>
            <select
              aria-label="Select customer"
              value={selectedId}
              onChange={(event) => setSelectedId(event.target.value)}
              disabled={loading || customers.length === 0}
            >
              <option value="">Select customer</option>
              {customers.map((customer) => (
                <option key={customer.id} value={customer.id}>
                  {customer.name}
                </option>
              ))}
            </select>
          </label>

          {loading ? (
            <div className="empty-state">
              <span className="loader" aria-hidden="true" />
              <p>Loading customers...</p>
            </div>
          ) : selected ? (
            <div className="customer-details">
              <div className="customer-card-heading">
                <span className="avatar" aria-hidden="true">
                  {selected.name.slice(0, 1).toUpperCase()}
                </span>
                <div>
                  <h3>{selected.name}</h3>
                  <span className="customer-id">Customer #{selected.id}</span>
                </div>
              </div>
              <dl className="details-list">
                <div><dt>Mobile</dt><dd>{selected.mobile || "Not provided"}</dd></div>
                <div><dt>Email</dt><dd>{selected.email || "Not provided"}</dd></div>
                <div><dt>Address</dt><dd>{selected.address || "Not provided"}</dd></div>
                <div><dt>Image path</dt><dd className="image-path">{selected.image || "Not provided"}</dd></div>
              </dl>
              <div className="detail-actions">
                <button className="button button-outline" type="button" onClick={() => startEdit(selected)}>
                  Edit customer
                </button>
                <button className="button button-danger" type="button" onClick={() => deleteCustomer(selected)}>
                  Delete
                </button>
              </div>
            </div>
          ) : (
            <div className="empty-state">
              <span className="empty-icon" aria-hidden="true">◇</span>
              <h3>{customers.length ? "Select a customer" : "No customers yet"}</h3>
              <p>
                {customers.length
                  ? "Choose a name above to view its details."
                  : "Add your first customer using the form."}
              </p>
              {!customers.length && message?.kind === "error" && (
                <button className="button button-outline" type="button" onClick={loadCustomers}>
                  Try again
                </button>
              )}
            </div>
          )}
        </section>
      </div>
    </section>
  );
}

export default CustomerList;
