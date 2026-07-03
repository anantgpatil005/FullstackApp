import React, { useState, createContext, useContext } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import Login from "./Login";
import Register from "./Register";
import AgentDashboard from "./components/AgentDashboard";
import ClientDashboard from "./components/ClientDashboard";
import AdminDashboard from "./components/AdminDashboard";
import { Roles } from "./models/roles";
import ProtectedRoute from "./components/ProtectedRoute";

// 1. Setup Context and a custom hook for easy access
const AuthContext = createContext(null);
export const useAuth = () => useContext(AuthContext);

function App() {
  // Keep state centralized in the user object
  const [user, setUser] = useState(() => {
    const savedUser = localStorage.getItem("user");
    return savedUser ? JSON.parse(savedUser) : null;
  });

  const login = (userData) => {
    setUser(userData);
    localStorage.setItem("user", JSON.stringify(userData));
  };

  const logout = () => {
    console.log( localStorage.getItem('user'));
    alert('Logging out'+ localStorage.getItem('user'));
    localStorage.removeItem("user");
    localStorage.removeItem("token");
    console.log( localStorage.getItem('user')); 
    setUser(null);
    <Navigate to="/login" replace />
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      <Router>
        <Routes>
          {/* Root Path: Automatically bounce to their dashboard if logged in, otherwise show login */}
          <Route 
            path="/" 
            element={
              user ? (
                user.role === Roles.ADMIN ? <Navigate to="/adminDashboard" replace /> :
                user.role === Roles.AGENT ? <Navigate to="/agentDashboard" replace /> :
                <Navigate to="/clientDashboard" replace />
              ) : (
                <Navigate to="/login" replace />
              )
            } 
          />

          {/* Auth Pages */}
          <Route path="/login" element={!user ? <Login /> : <Navigate to="/" replace />} />
          <Route path="/register" element={<Register />} />

          {/* Protected Role-Based Routes */}
          <Route 
            path="/agentDashboard" 
            element = {
              user && user.role === Roles.AGENT ?
              <ProtectedRoute role={user.role} allowedRole={Roles.AGENT}>
                  <AgentDashboard />
              </ProtectedRoute>
              : <Navigate to="/login" replace />
            }
            //element={user && user.role === Roles.AGENT ? <AgentDashboard /> : <Navigate to="/login" replace />} 
          />
          <Route 
            path="/adminDashboard" 
            element ={
             user && user.role === Roles.ADMIN ?
            <ProtectedRoute role={user.role} allowedRole={Roles.ADMIN}>
               <AdminDashboard />
            </ProtectedRoute>
             : <Navigate to="/login" replace />
            }
            />
          
          <Route 
            path="/clientDashboard" 
            element = {
               user && user.role === Roles.CLIENT ?
              <ProtectedRoute role={user.role} allowedRole={Roles.CLIENT}>
                <ClientDashboard/>
              </ProtectedRoute>
               : <Navigate to="/login" replace />
            }
          />

          {/* Fallback Catch-all */}
          <Route path="*" element={<Navigate to="/" replace />} />
        </Routes>
      </Router>
    </AuthContext.Provider>
  );
}

export default App;