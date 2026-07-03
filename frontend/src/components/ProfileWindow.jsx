import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../App";

function ProfileWindow({ role }) {
  const [showProfile, setShowProfile] = useState(false);
  const { logout } = useAuth();
  const navigate = useNavigate();

  const handleLogout = (e) => {
    e.preventDefault();
    logout();
    navigate("/login");
  };

  return (
    <div className="relative">
      <button
        onClick={() => setShowProfile(!showProfile)}
        className="flex items-center space-x-2 focus:outline-none"
      >
        <img
          src="https://placehold.co"
          alt="Profile"
          className="w-10 h-10 rounded-full border"
        />
        <span className="text-gray-600">{role || "Client"}</span>
      </button>

      {/* Profile Dropdown */}
      {showProfile && (
        <div className="absolute right-0 mt-2 w-48 bg-white rounded shadow-lg border">
          <div className="p-4 border-b">
            <p className="font-semibold">anant</p>
            <p className="text-sm text-gray-500">{role || "Client"}</p>
          </div>
          <a href="/profile" className="block px-4 py-2 hover:bg-gray-100">
            View Profile
          </a>
          <a href="/settings" className="block px-4 py-2 hover:bg-gray-100">
            Settings
          </a>
          <a
            href="/login"
            onClick={handleLogout}
            className="block px-4 py-2 text-red-600 hover:bg-gray-100"
          >
            Logout
          </a>
        </div>
      )}
    </div>
  );
}

export default ProfileWindow;
