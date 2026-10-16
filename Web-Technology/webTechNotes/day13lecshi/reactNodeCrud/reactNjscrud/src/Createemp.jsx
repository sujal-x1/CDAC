import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { createEmployee } from "./api.js";

export default function Createemp() {
  const [employee, setEmployee] = useState({ firstname: "", lastname: "" });
  const [error, setError] = useState("");
  const [saving, setSaving] = useState(false);
  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setEmployee((current) => ({ ...current, [name]: value }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    setError("");
    setSaving(true);

    try {
      await createEmployee(employee);
      navigate("/Listperson");
    } catch (requestError) {
      setError(requestError.message);
    } finally {
      setSaving(false);
    }
  };

  return (
    <section>
      <h1>Create employee</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="firstname">First name:</label>
          <input
            id="firstname"
            type="text"
            name="firstname"
            value={employee.firstname}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="lastname">Last name:</label>
          <input
            id="lastname"
            type="text"
            name="lastname"
            value={employee.lastname}
            onChange={handleChange}
            required
          />
        </div>
        {error && <p role="alert">Could not create employee: {error}</p>}
        <button type="submit" disabled={saving}>
          {saving ? "Saving..." : "Save employee"}
        </button>
      </form>
      <p>
        <Link to="/Listperson">Back to employees</Link>
      </p>
    </section>
  );
}
