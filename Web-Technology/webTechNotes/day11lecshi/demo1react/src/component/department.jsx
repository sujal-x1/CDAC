function Department(deptInfo) {
  console.log("Department received:", deptInfo);

  return (
    <div>
      <p>
        Dept Name is : <b>{deptInfo.dept}</b>
      </p>

      <p>
        Dept Head is : <b>{deptInfo.head}</b>
      </p>
    </div>
  );
}
export default Department;