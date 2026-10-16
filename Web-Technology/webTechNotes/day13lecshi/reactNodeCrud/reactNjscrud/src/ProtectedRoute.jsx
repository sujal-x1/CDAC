import { Navigate, useOutletContext } from "react-router-dom";

function Protected({ children }) {
  const { isSignedIn } = useOutletContext();

  if (!isSignedIn) {
    return <Navigate to="/" replace />;
  }

  return children;
}
export default Protected;