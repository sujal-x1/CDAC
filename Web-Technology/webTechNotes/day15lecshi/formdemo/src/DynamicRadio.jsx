import { useState } from "react";
import ReactDOM from "react-dom";
export default function DynamicRadio() {
    const gender = ["Male", "Female"];
    const [inputsrd, setInputsrd] = useState(null);
    const handleChange = (event) => {
        setInputsrd(event.target.value);
    }
    const handleSubmit = (event) => {
        event.preventDefault();
        alert(inputsrd);
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>Enter Gender:</label>
            {gender.map((g, i) => {
                return <div>
                    <label key="i">{g}</label>
                    <input type="radio" name="nm" value={g} onClick={handleChange} />
                </div>
            })
            }

            <input type="submit" />
        </form>
    )
}
