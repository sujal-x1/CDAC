function App() {
  return (
    <div>
     <MyApp/>
    </div>
  );
}

function MyButton(data) {
  return (
    <button>
{data.name}   
 </button>
  );
} 

function MyApp() {
  return (
    <div>
    <h1>Welcome to Group 8</h1>
    <MyButton  name="vita " />
	<MyButton  name="DAC " />
    </div>
  );
}
export default App;
