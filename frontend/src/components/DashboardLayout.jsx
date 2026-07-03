import React from "react";
import AdminDashboard from "./AdminDashboard";
import ClientDashboard from "./ClientDashboard";
import AgentDashboard from "./AgentDashboard";
import { Roles } from "../models/roles";

function DashboardLayout({ role }) {
  return (
    <div>
        {role === Roles.ADMIN && <AdminDashboard role={role}/>}
        {role ===  Roles.CLIENT && <ClientDashboard role={role}/>}
        {role ===  Roles.AGENT && <AgentDashboard role={role}/>}
    </div>
  );
}

export default DashboardLayout;
