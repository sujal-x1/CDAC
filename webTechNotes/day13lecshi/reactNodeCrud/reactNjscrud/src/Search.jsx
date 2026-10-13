import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getEmployees } from "./api.js";

export function Search({ onQuery }) {
  return (
    <label>
      Search employees
      <input
        type="search"
        onChange={(event) => onQuery(event.target.value)}
      />
    </label>
  );
}

export default function SearchEmployees() {
  const [employees, setEmployees] = useState([]);
  const [query, setQuery] = useState("");
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

  const normalizedQuery = query.trim().toLowerCase();
  const filteredEmployees = employees.filter((employee) =>
    `${employee.firstname ?? ""} ${employee.lastname ?? ""}`
      .toLowerCase()
      .includes(normalizedQuery),
  );

  if (loading) return <p>Loading employees...</p>;
  if (error) return <p role="alert">Could not search employees: {error}</p>;

  return (
    <section>
      <h1>Search employees</h1>
      <Search onQuery={setQuery} />
      {filteredEmployees.length === 0 ? (
        <p>No matching employees found.</p>
      ) : (
        <ul>
          {filteredEmployees.map((employee) => (
            <li key={employee._id}>
              {employee.firstname} {employee.lastname}{" "}
              <Link to={`/empup/${encodeURIComponent(employee._id)}`}>
                Edit
              </Link>
            </li>
          ))}
        </ul>
      )}
    </section>
  );
}
