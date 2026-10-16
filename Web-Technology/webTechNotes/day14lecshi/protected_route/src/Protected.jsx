import { useNavigate } from "react-router-dom";

function Protected ({isSignedIn,children}){
    console.log("isSignedIn",isSignedIn)

    const navigate =useNavigate()
    if(!isSignedIn){
        return navigate("/")
    }
    return children
}

export default Protected