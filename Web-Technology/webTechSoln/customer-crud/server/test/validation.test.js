const test = require("node:test");
const assert = require("node:assert/strict");
const { parseCustomerId, validateCustomerInput } = require("../src/validation");

test("validates and normalizes customer details", () => {
  assert.deepEqual(
    validateCustomerInput({
      name: "  Raj ",
      mobile: " 96189652 ",
      email: "r@gmail.com",
      address: " Juhu ",
      image: "./images/a.png"
    }),
    {
      value: {
        name: "Raj",
        mobile: "96189652",
        email: "r@gmail.com",
        address: "Juhu",
        image: "./images/a.png"
      }
    }
  );
});

test("rejects missing names, invalid emails, and unknown fields", () => {
  assert.equal(validateCustomerInput({ name: " " }).error, "Name is required");
  assert.equal(
    validateCustomerInput({ name: "Raj", email: "not-an-email" }).error,
    "Email address is invalid"
  );
  assert.equal(
    validateCustomerInput({ name: "Raj", id: 1 }).error,
    "Unexpected field: id"
  );
});

test("accepts only positive safe integer customer IDs", () => {
  assert.equal(parseCustomerId("12"), 12);
  assert.equal(parseCustomerId("0"), null);
  assert.equal(parseCustomerId("-1"), null);
  assert.equal(parseCustomerId("1.5"), null);
  assert.equal(parseCustomerId("9007199254740992"), null);
});
