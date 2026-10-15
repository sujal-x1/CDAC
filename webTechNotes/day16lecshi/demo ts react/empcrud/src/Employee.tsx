// src/Employee.tsx
import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import type { IPerson } from "./models/IPerson"; // type-only import
import { getEmployee } from "./services/employeeService";

const Employee: React.FC = () => {
  const [employee, setEmployee] = useState<IPerson | null>(null);
  const { id } = useParams<{ id: string }>();

  useEffect(() => {
    const fetchEmployee = async () => {
      try {
        if (id) {
          const data = await getEmployee(Number(id));
          setEmployee(data);
        }
      } catch (error) {
        console.error("Error fetching employee:", error);
      }
    };

    fetchEmployee();
  }, [id]);

  return (
    <div>
      {employee ? (
        <>
          <label>Id:</label> {employee.id}
          <br />
          <label>Name:</label> {employee.name}
          <br />
          <label>Email:</label> {employee.email}
          <br />
          <label>Department:</label> {employee.department}
        </>
      ) : (
        <p>Loading employee data...</p>
      )}
    </div>
  );
};

export default Employee;
