// src/Employeedel.tsx
import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import type { IPerson } from "./models/IPerson"; // type-only import
import { getEmployee, deleteEmployee } from "./services/employeeService";

const Employeedel: React.FC = () => {
  const [employee, setEmployee] = useState<IPerson | null>(null);
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();

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

  const handleDelete = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    try {
      if (id) {
        await deleteEmployee(Number(id));
        console.log("Employee deleted successfully");
        navigate("/Listemployee"); // redirect to list after deletion
      }
    } catch (error) {
      console.error("Error deleting employee:", error);
    }
  };

  return (
    <div>
      <h1 style={{ color: "red" }}>Are you sure?</h1>
      {employee && (
        <>
          <label>Id:</label> {employee.id}
          <br />
          <label>Name:</label> {employee.name}
          <br />
          <label>Email:</label> {employee.email}
          <br />
          <label>Department:</label> {employee.department}
          <form onSubmit={handleDelete}>
            <input type="submit" value="Confirm Delete" />
          </form>
        </>
      )}
    </div>
  );
};

export default Employeedel;
