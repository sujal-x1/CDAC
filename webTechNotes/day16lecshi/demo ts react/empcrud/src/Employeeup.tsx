// src/Employeeup.tsx
import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import type { IPerson } from "./models/IPerson"; // type-only import
import { getEmployee, updateEmployee } from "./services/employeeService";

const Employeeup: React.FC = () => {
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

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setEmployee((prev) =>
      prev ? { ...prev, [name]: value } as IPerson : null
    );
  };

  const handleSubmit = async (event: React.SubmitEvent<HTMLFormElement>) => {
    event.preventDefault();
    try {
      if (id && employee) {
        const updated = await updateEmployee(Number(id), employee);
        console.log("Employee updated:", updated);
        navigate("/Listemployee"); // redirect to list after update
      }
    } catch (error) {
      console.error("Error updating employee:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>Id:</label>
      <input
        type="text"
        name="id"
        value={employee?.id ?? ""}
        disabled
        onChange={handleChange}
      />
      <br />

      <label>Name:</label>
      <input
        type="text"
        name="name"
        value={employee?.name ?? ""}
        onChange={handleChange}
      />
      <br />

      <label>Email:</label>
      <input
        type="email"
        name="email"
        value={employee?.email ?? ""}
        onChange={handleChange}
      />
      <br />

      <label>Department:</label>
      <input
        type="text"
        name="department"
        value={employee?.department ?? ""}
        onChange={handleChange}
      />
      <br />

      <input type="submit" value="Update Employee" />
    </form>
  );
};

export default Employeeup;
