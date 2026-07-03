import { useState } from "react";

function Register() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-100">
      <div className="bg-white p-8 shadow-xl rounded-3xl w-96">
        <h2 className="text-2xl font-bold text-center mb-3">Register</h2>
        <form>
          <input
            type="text"
            placeholder="Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            className="border rounded-xl w-full mb-4 px-3 py-2 focus:outline-none focus:shadow-2xl focus:ring focus:border-indigo-500"
          />
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="border rounded-xl w-full mb-4 px-3 py-2 focus:outline-none focus:shadow-2xl focus:ring focus:border-indigo-500"
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="border rounded-xl w-full mb-4 px-3 py-2 focus:outline-none focus:shadow-2xl focus:ring focus:border-indigo-500"
          />
          
          <button type="submit" className="w-full bg-green-600 text-white p-2  mx-auto">Register</button>
        
        </form>
        <p className="mt-4 text-sm text-center"> 
            Already have an account? <a href="/login" className="text-green-600">Login</a> 
        </p>
      </div>
    </div>
  );
}

export default Register;
