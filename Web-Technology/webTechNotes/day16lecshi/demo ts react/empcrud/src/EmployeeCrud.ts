// src/components/EmployeeCrud.tsx
import React, { useEffect, useState } from "react";
import type { IPerson } from "./models/IPerson";
import {
  getEmployees,
  addEmployee,
  updateEmployee,
  deleteEmployee,
} from "./services/employeeService";

const EmployeeCrud: React.FC = () => {
  const [employees, setEmployees] = useState<IPerson[]>([]);
  const [form, setForm] = useState<Omit<IPerson, "id">>({
    name: "",
    email: "",
    department: "",
  });
  const [editingId, setEditingId] = useState<number | null>(null);

  useEffect(() => {
    loadEmployees();
  }, []);

  async function loadEmployees() {
    const data = await getEmployees();
    setEmployees(data);
  }

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (editingId) {
      await updateEmployee(editingId, { id: editingId, ...form });
      setEditingId(null);
    } else {
      await addEmployee(form);
    }
    setForm({ name: "", email: "", department: "" });
    loadEmployees();
  }

  async function handleDelete(id: number) {
    await deleteEmployee(id);
    loadEmployees();
  }

  function handleEdit(emp: IPerson) {
    setForm({ name: emp.name, email: emp.email, department: emp.department });
    setEditingId(emp.id);
  }

  return (
    <div>
    <h2>Employee CRUD
      </h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Name"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
          required
        />
        <input
          type="email"
          placeholder="Email"
          value={form.email}
          onChange={(e) => setForm({ ...form, email: e.target.value })}
          required
        />
        <input
          type="text"
          placeholder="Department"
          value={form.department}
          onChange={(e) => setForm({ ...form, department: e.target.value })}
          required
        />
        <button type="submit">{editingId ? "Update" : "Add"} Employee</button>
    </form>

      <ul>
        {employees.map((emp) => (
          <li key={emp.id}>
            {emp.name} - {emp.email} - {emp.department}
            <button onClick={() => handleEdit(emp)}>Edit</button>
            <button onClick={() => handleDelete(emp.id)}>Delete</button>
          </li>
        ))}
      </ul>
  </div>
  );
};

export default EmployeeCrud;
