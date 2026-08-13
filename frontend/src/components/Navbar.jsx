import logo from "../assets/gemini-svg.svg";
import "./Navbar.css";

function Navbar() {
  return (
    <nav>

      <div className="arena-navbar">
        <div className="logo-section">
            <img className="logo" src={logo} alt="dsaArena" />
        </div>
        <div className="links-section">
            <a href="#">Home</a>
            <a href="#">Arenas</a>
            <a href="#">Details</a>
            <a href="#">Contact</a>
        </div>
        <div className="input-button-section">
            <input type="text" placeholder="Search" />
            <button>Login</button>
            <button>Register</button>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;