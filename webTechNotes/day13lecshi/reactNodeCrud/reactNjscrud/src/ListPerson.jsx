import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getEmployees } from "./api.js";

export default function ListPerson() {
  const [employees, setEmployees] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const controller = new AbortController();

    getEmployees({ signal: controller.signal })
      .then((result) => {
        if (!Array.isArray(result)) {
          throw new Error("The server returned an invalid employee list.");
        }
        setEmployees(result);
      })
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
  }, []);

  if (loading) return <p>Loading employees...</p>;
  if (error) return <p role="alert">Could not load employees: {error}</p>;

  return (
    <section>
      <h1>Employees</h1>
      <p>
        <Link to="/CreateEmployee">Create employee</Link>
      </p>
      {employees.length === 0 ? (
        <p>No employees found.</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th scope="col">First name</th>
              <th scope="col">Last name</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee._id}>
                <td>{employee.firstname}</td>
                <td>{employee.lastname}</td>
                <td>
                  <Link to={`/empup/${encodeURIComponent(employee._id)}`}>
                    Edit
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </section>
  );
}