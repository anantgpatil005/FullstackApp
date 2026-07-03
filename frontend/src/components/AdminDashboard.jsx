import Navbar from "./Navbar";
import TopBar from "./TopBar";
import { renderTableFromJson } from "./Render";

function AdminDashboard({ role }) {
const data = [
    { id: 1, ticket: "Ticket subject 1", description: "Admin", severity: "severity 1" },
    { id: 2, ticket: "Ticket subject 2", description: "Agent", severity: "severity 2" },
    { id: 3, ticket: "Ticket subject 3", description: "Client", severity: "severity 3" },
  ];

  const columns = [
    { header: "Ticet Id", accessor: "id" },
    { header: "Ticket", accessor: "ticket" },
    { header: "Description", accessor: "description" },
    { header: "Severity", accessor: "severity" },
  ];


  return (
    <div className="flex h-screen bg-gray-100 font-sans">
      <Navbar />

      <div className="flex-1 flex flex-col">
        <TopBar role={role} />
        <main className="p-6 grid grid-cols-1 md:grid-cols-4 gap-6">
          <div className="bg-rose-400/20 p-6 backdrop-blur-md border rounded-2xl shadow-xl">
            <h2 className="text-lg font-semibold mb-2">My Tickets</h2>
            <p className="text-gray-600">You have 5 active orders</p>
          </div>
          <div className="bg-violet-400/20 p-6  backdrop-blur-md border rounded-2xl shadow-xl">
            <h2 className="text-lg font-semibold mb-2">Recent Tickets</h2>
            <p className="text-gray-600">2 pending invoices</p>
          </div>
          <div className="bg-cyan-400/20 p-6 border rounded-2xl shadow-xl">
            <h2 className="text-lg font-semibold mb-2">Closed tickets</h2>
            <p className="text-gray-600">You have 5 active orders</p>
          </div>
          <div className="bg-emerald-400/20 p-6 border rounded-2xl shadow-xl">
            <h2 className="text-lg font-semibold mb-2">Open Tickets</h2>
            <p className="text-gray-600">2 pending invoices</p>
          </div>
        </main>
          <div className="p-6">
      <h2 className="text-xl font-bold mb-4">Ticket Table</h2>
      {renderTableFromJson(data, {
        columns,
        hiddenColumns: ["ticket"], // hide email column
        rowsPerPage: 2,
      })}
    </div>
      </div>
    </div>
  );
}

export default AdminDashboard;
