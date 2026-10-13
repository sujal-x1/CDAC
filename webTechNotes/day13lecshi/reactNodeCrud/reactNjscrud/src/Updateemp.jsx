import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { getEmployee, updateEmployee } from "./api.js";

export default function Employeeup() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [employee, setEmployee] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false);

  useEffect(() => {
    const controller = new AbortController();

    getEmployee(id, { signal: controller.signal })
      .then((result) => setEmployee(result))
      .catch((requestError) => {
        if (requestError.name !== "AbortError") {
          setError(requestError.message);
        }
      })
      .finally(() => {
        if (!controller.signal.aborted) {
          setLoading(false);
        }
      });

    return () => controller.abort();
  }, [id]);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setEmployee((current) => ({ ...current, [name]: value }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    setError("");
    setSaving(true);

    try {
      await updateEmployee(id, {
        firstname: employee.firstname,
        lastname: employee.lastname,
      });
      navigate("/Listperson");
    } catch (requestError) {
      setError(requestError.message);
    } finally {
      setSaving(false);
    }
  };

  if (loading) return <p>Loading employee...</p>;
  if (error && !employee) {
    return <p role="alert">Could not load employee: {error}</p>;
  }
  if (!employee) return <p role="alert">Employee not found.</p>;

  return (
    <section>
      <h1>Update employee</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="employee-id">ID:</label>
          <input id="employee-id" value={employee._id || id} disabled />
        </div>
        <div>
          <label htmlFor="firstname">First name:</label>
          <input
            id="firstname"
            type="text"
            name="firstname"
            value={employee.firstname ?? ""}
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
            value={employee.lastname ?? ""}
            onChange={handleChange}
            required
          />
        </div>
        {error && <p role="alert">Could not update employee: {error}</p>}
        <button type="submit" disabled={saving}>
          {saving ? "Saving..." : "Update employee"}
        </button>
      </form>
      <p>
        <Link to="/Listperson">Back to employees</Link>
      </p>
    </section>
  );
}

