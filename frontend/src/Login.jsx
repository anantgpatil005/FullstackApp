import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Roles } from "./models/roles";
import { useAuth } from "./App"; // 1. Import your hook
import authenticationService from "./services/authentication.service";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();
  const { login } = useAuth(); // 2. Grab login function from context

  const handleSubmit = async (e) => {
    e.preventDefault();

      try{
      const response = await authenticationService.login({ username, password });
      
      const data = response?.data ?? response;
      
      // Handle the API response (token object with {token, type, validUntil})
      if (data?.token) {
        // Save token to localStorage
        localStorage.setItem("token", data.token);
        
        // For now, create a minimal user object. You may need to decode the token or fetch user details
        const user = {
          username: username,
          role: Roles.ADMIN // Default role - adjust based on your needs or token claims
        };
        
        login(user);

        // 4. Divert traffic to the specific routes defined in your App.js
        if (user.role === Roles.ADMIN) {
          navigate("/adminDashboard");
        } else if (user.role === Roles.AGENT) {
          navigate("/agentDashboard");
        } else {
          navigate("/clientDashboard");
        }
      } else {
        // Only set error message as a string, never as an object
        const errorMsg = typeof data === 'string' ? data : "Login failed";
        setErrorMessage(errorMsg);
      }

    }catch(error){
      console.error("Login error:", error);
      setErrorMessage("Something went wrong. Please try again.");
    }
     
    }

    return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="bg-white p-8  rounded shadow-md w-96">
        <h2 className="text-2xl font-bold text-center mb-4">Login</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Username"
            value={username}
            className="w-full mb-4 py-2  px-2 border rounded focus:outline-none focus:ring focus:border-indigo-500"
            onChange={(e) => setUsername(e.target.value)}
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            className="w-full mb-4 py-2  px-2 border rounded focus:outline-none focus:ring focus:border-indigo-500"
            onChange={(e) => setPassword(e.target.value)}
          />{errorMessage ? (
            <p className="mb-4 text-sm text-red-600">{errorMessage}</p>
          ) : null}
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
  };
  
export default Login;
