import ProfileWindow from "./ProfileWIndow";

function TopBar({ role }) {
    return ( 
    <header className="bg-white shadow p-4 flex justify-between items-center relative">
          <h1 className="text-xl font-semibold">{ role } Dashboard</h1>
          <ProfileWindow role={ role }/>  
        </header>
    );
}

export default TopBar;