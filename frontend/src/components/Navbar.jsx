import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../App";

function Navbar() {
  const { logout } = useAuth();

  const handleLogoutClick = (e) => {
    e.preventDefault(); // Stop any default anchor behaviors
    logout(); // Clear localStorage and user state
    navigate("/login"); // Securely redirect back to login page
  };
  return (
    <>
      {/* Sidebar Layout */}
      <aside className="w-64 bg-blue-600/75 text-white flex flex-col">
        <div className="p-6 text-2xl font-bold border-b border-blue-700">
          User Panel
        </div>

        <nav className="flex-1 p-4 space-y-2">
          {/* 4. Swapped <a> for <Link> to keep navigation inside React */}
          <Link
            to="/agentDashboard"
            className="block px-4 py-2 rounded hover:bg-blue-700"
          >
            Dashboard
          </Link>
          <Link
            to="/orders"
            className="block px-4 py-2 rounded hover:bg-blue-700"
          >
            Create Ticket
          </Link>
          <Link
            to="/invoices"
            className="block px-4 py-2 rounded hover:bg-blue-700"
          >
            Ticket List
          </Link>
        </nav>

        <div className="p-4 border-t border-blue-700">
          {/* 5. Converted Logout into a clickable link-button that executes your auth cleanup */}
          <a
            href="/login"
            onClick={handleLogoutClick}
            className="w-full block bg-red-600 py-2 rounded-xl text-center hover:bg-red-700"
          >
            Logout
          </a>
        </div>
      </aside>
    </>
  );
}

export default Navbar;
