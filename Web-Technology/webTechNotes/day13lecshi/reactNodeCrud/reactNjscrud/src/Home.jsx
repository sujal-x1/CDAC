import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getEmployees } from "./api.js";

export default function Home() {
  const [employeeCount, setEmployeeCount] = useState(null);
  const [error, setError] = useState("");

  useEffect(() => {
    const controller = new AbortController();

    getEmployees({ signal: controller.signal })
      .then((employees) => {
        if (!Array.isArray(employees)) {
          throw new Error("The server returned an invalid employee list.");
        }
        setEmployeeCount(employees.length);
      })
      .catch((requestError) => {
        if (requestError.name !== "AbortError") {
          setError(requestError.message);
        }
      });

    return () => controller.abort();
  }, []);

  return (
    <section>
      <h1>Employee directory</h1>
      {error ? (
        <p role="alert">Could not load employee data: {error}</p>
      ) : (
        <p>
          {employeeCount === null
            ? "Loading employee data..."
            : `${employeeCount} employees`}
        </p>
      )}
      <p>
        <Link to="/Listperson">View employees</Link>
      </p>
    </section>
  );
}
