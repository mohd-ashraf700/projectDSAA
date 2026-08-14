import logo from "../assets/gemini-svg.svg";
import "./Navbar.css";

function Navbar() {
  return (
    <nav>

      <div className="arena-navbar">
        <div className="logo-section">
            <a href="#"><img className="logo" src={logo} alt="dsaArena" /></a>
        </div>
        <div className="links-section">
            <a href="#">Home</a>
            <a href="#">Arenas</a>
            <a href="#">Details</a>
            <a href="#">Contact</a>
        </div>
        <div className="input-button-section">
            <input type="text" placeholder="Search" />
            <button className="login">Login</button>
            <button className="register">Register</button>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;