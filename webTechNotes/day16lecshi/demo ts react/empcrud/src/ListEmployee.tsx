// src/components/ListEmployee.tsx
import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import type { IPerson } from "./models/IPerson"; // Import the IPerson interface
import { getEmployees } from "./services/employeeService";

const ListEmployee: React.FC = () => {
  // Explicitly type the state as an array of IPerson
  const [employees, setEmployee] = useState<IPerson[]>([]);

 useEffect(() => {
   let isMounted = true; // Flag to track if the component is mounted
    const controller = new AbortController();
    // define an async function inside useEffect
    const fetchEmployees = async () => {
      try {
        const data = await getEmployees();
         if (isMounted) 
        setEmployee(data);
      } catch (error) {
        if (isMounted) 
        console.error("Error fetching employees:", error);
      }
    };

    fetchEmployees();
    return () => {
      isMounted = false; // prevent state updates after unmount
      controller.abort(); // cancel any ongoing fetch
    };
  }, []);

  return (
    <div> <h4>
        <Link to="/create">Create</Link>
      </h4><h2>Employees Data...</h2>
      <table><thead>
          <tr><th>Id</th><th>Name</th><th>Email</th><th>Department</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.id}>
              <td>{emp.id}</td>
              <td>{emp.name}</td>
              <td>{emp.email}</td>
              <td>{emp.department}</td>
              <td><Link to={`/emp/${emp.id}`}>Display</Link>
              </td>
              <td><Link to={`/empup/${emp.id}`}>Edit</Link>
              </td>
              <td><Link to={`/empdel/${emp.id}`}>Delete</Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployee;
