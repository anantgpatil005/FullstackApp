import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

 const handleSubmit = async (e) => {
    e.preventDefault();

    // Example: backend returns role
   // const response = { success: true, role: "admin" };

    if (response.success) {
      setRole(response.role); // store role in App state
      navigate("/dashboard"); // go to dashboard container
    }
  };



  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="bg-white p-8  rounded shadow-md w-96">
        <h2 className="text-2xl font-bold text-center mb-4">Login</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="User Name"
            value={username}
            className="w-full mb-4 py-2  px-2 border rounded focus:outline-none focus:ring focus:border-indigo-500"
            onChange={(e) => setUserName(e.target.value)}
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            className="w-full mb-4 py-2  px-2 border rounded focus:outline-none focus:ring focus:border-indigo-500"
            onChange={(e) => setPassword(e.target.value)}
          />
          <button type="submit"
          className="w-full bg-indigo-600 rounded text-white py-2 hover:bg-indigo-700"
          >Login</button>
        </form>
        <p className="mt-4 text-sm text-center">
          Don’t have an account? <a href="/register" className="text-indigo-600">Register</a>
        </p>
      </div>
    </div>
  );
}
export default Login;
