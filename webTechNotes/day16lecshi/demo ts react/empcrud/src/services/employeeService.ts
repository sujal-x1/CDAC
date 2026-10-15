// src/services/employeeService.ts
import type { IPerson } from "../models/IPerson.ts";


const API_URL = "http://localhost:8081/api/Person"; // Replace with your backend API

export async function getEmployees(): Promise<IPerson[]> {
  const response = await fetch(API_URL);
  return response.json();
}

export async function getEmployee(id: number): Promise<IPerson> {
  const response = await fetch(`${API_URL}/${id}`);
  return response.json();
}

export async function addEmployee(employee: Omit<IPerson, "id">): Promise<IPerson> {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(employee),
  });
  return response.json();
}

export async function updateEmployee(id: number, employee: IPerson): Promise<IPerson|null> {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(employee),
  });
   // If no content, return null
  if (response.status === 204) {
    return null;
  }
  return response.json();
}

export async function deleteEmployee(id: number): Promise<void> {
  await fetch(`${API_URL}/${id}`, { method: "DELETE" });
}
