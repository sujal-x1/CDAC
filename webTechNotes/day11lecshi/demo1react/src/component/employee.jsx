import Department from "./department"

function Employee(data) {
  console.log("Employee received:", data);

  return (
    <div>
      <p>Name : {data.name}</p>
      <p>Salary : {data.salary}</p>

      <Department
        dept={data.dept}
        head={data.head}
      />
    </div>
  );
}

export default Employee;