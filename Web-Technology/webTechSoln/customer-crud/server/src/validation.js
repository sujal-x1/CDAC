const MAX_LENGTHS = {
  name: 120,
  mobile: 40,
  email: 254,
  address: 500,
  image: 500
};

const OPTIONAL_FIELDS = ["mobile", "email", "address", "image"];

function validateCustomerInput(input) {
  if (input === null || typeof input !== "object" || Array.isArray(input)) {
    return { error: "Request body must be a JSON object" };
  }

  const allowedFields = new Set(["name", ...OPTIONAL_FIELDS]);
  const unknownField = Object.keys(input).find((key) => !allowedFields.has(key));
  if (unknownField) {
    return { error: `Unexpected field: ${unknownField}` };
  }

  if (typeof input.name !== "string" || !input.name.trim()) {
    return { error: "Name is required" };
  }

  const customer = { name: input.name.trim() };
  if (customer.name.length > MAX_LENGTHS.name) {
    return { error: `Name must be ${MAX_LENGTHS.name} characters or fewer` };
  }

  for (const field of OPTIONAL_FIELDS) {
    const value = input[field] ?? "";
    if (typeof value !== "string") {
      return { error: `${field} must be a string` };
    }

    const trimmedValue = value.trim();
    if (trimmedValue.length > MAX_LENGTHS[field]) {
      return {
        error: `${field} must be ${MAX_LENGTHS[field]} characters or fewer`
      };
    }

    if (
      field === "email" &&
      trimmedValue &&
      !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(trimmedValue)
    ) {
      return { error: "Email address is invalid" };
    }

    customer[field] = trimmedValue;
  }

  return { value: customer };
}

function parseCustomerId(value) {
  if (!/^[1-9]\d*$/.test(value)) {
    return null;
  }

  const id = Number(value);
  return Number.isSafeInteger(id) ? id : null;
}

module.exports = { parseCustomerId, validateCustomerInput };
