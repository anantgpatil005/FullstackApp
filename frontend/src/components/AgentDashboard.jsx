import React from "react";
import { Link, useNavigate } from "react-router-dom"; // 1. Import Link and useNavigate
import { useAuth } from "../App"; // 2. Import your useAuth custom hook to get the logout function
import Navbar from "./Navbar";
import TopBar from "./TopBar";

function AgentDashboard() {

  return (
    <div className="flex h-screen bg-gray-100 font-sans">
      <Navbar/>
      <div className="flex-1 flex flex-col">
      <TopBar role = {role}/>
        <main className="p-6 grid grid-cols-1 md:grid-cols-4 gap-6">
          <div className="bg-blue-600/75 p-6 border rounded-2xl shadow-xl"><h2 className="text-lg text-white font-semibold mb-2">My Tickets</h2><p className="text-white">You have 5 active orders</p></div>
          <div className="bg-blue-600/75 p-6 border rounded-2xl shadow-xl"><h2 className="text-lg  text-white font-semibold mb-2">Recent Tickets</h2><p className="text-white">2 pending tickets</p></div>
          <div className="bg-blue-600/75 p-6 border rounded-2xl shadow-xl"><h2 className="text-lg  text-white font-semibold mb-2">Closed tickets</h2><p className="text-white">You have 5 active orders</p></div>
          <div className="bg-blue-600/75 p-6 border rounded-2xl shadow-xl"><h2 className="text-lg  text-white  font-semibold mb-2">Open Tickets</h2><p className="text-white">2 pending tickets</p></div>       
        </main>
      </div>
    </div>
  );
}

export default AgentDashboard;