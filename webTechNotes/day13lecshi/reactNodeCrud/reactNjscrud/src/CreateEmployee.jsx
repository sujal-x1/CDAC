import React from 'react';

function CreateEmployee() {
  return (
    <div>
      <h2>Create Employee</h2>
      <form>
        <div>
          <label htmlFor="name">Name:</label>
          <input id="name" type="text" name="name" />
        </div>
        <div>
          <label htmlFor="email">Email:</label>
          <input id="email" type="email" name="email" />
        </div>
        <button type="submit">Save Employee</button>
      </form>
    </div>
  );
}

export default CreateEmployee;
