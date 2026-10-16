const API_URL = (import.meta.env.VITE_API_URL || "http://localhost:8081").replace(/\/$/, "");

async function request(path, options = {}) {
  const response = await fetch(`${API_URL}${path}`, options);
  const responseText = await response.text();
  let result = null;

  if (responseText) {
    try {
      result = JSON.parse(responseText);
    } catch {
      result = responseText;
    }
  }

  if (!response.ok) {
    const detail =
      typeof result === "string" ? result : result?.message || response.statusText;
    throw new Error(`Request failed (${response.status}): ${detail}`);
  }

  return result;
}

export function getEmployees(options) {
  return request("/person", options);
}

export function getEmployee(id, options) {
  return request(`/person/${encodeURIComponent(id)}`, options);
}

export function createEmployee(employee) {
  return request("/person", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(employee),
  });
}

export function updateEmployee(id, employee) {
  return request(`/person/${encodeURIComponent(id)}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(employee),
  });
}
