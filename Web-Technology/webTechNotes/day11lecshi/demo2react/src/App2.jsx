function App() {
    return (
        <Toolbar
            onPlayMovie={() => alert('Playing!')}
            onUploadImage={() => alert('Uploading!')}
        />
    );
}

function Toolbar({ onPlayMovie, onUploadImage }) {
    return (
        <div>
            <Button onClick={onPlayMovie}>
                Play Movie
            </Button>
            <Button onClick={onUploadImage}>
                Upload Image
            </Button>
        </div>
    );
}


function Button({ onClick, children }) {
    return (
        <button onClick={onClick}>
            {children}
        </button>
    );
}


// function Button(obj) {
//     console.log(obj)
//     return (
//         <button onClick={obj.onClick}>
//             {obj.children}
//         </button>
//     );
// }

export default App;