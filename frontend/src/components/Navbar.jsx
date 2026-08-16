import logo from "../assets/dsaArenaLogo.png";
import "./Navbar.css";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav>

      <div className="arena-navbar">
        <div className="logo-section">
           <Link to="/"><img className="logo" src={logo} alt="dsaArena" /></Link>
        </div>
        <div className="links-section">
            <Link to="/">Home</Link>
            <a href="#">Arenas</a>
            <Link to="/details">Details</Link>
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