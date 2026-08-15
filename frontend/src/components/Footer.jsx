import footerLogo from "../assets/footerimg.png"

function Footer(){
    return (
        <>
        <div className="main-footer">
        <div className="most-left-section">
            <img src={footerLogo} alt="img" />
            <p className="spacing">
                Compete, solve, improve, and climb the ranks with DSA Arena.
            </p>
        </div>

        <div className="footer-links">
        <p>Quick Links</p>
        <ul>
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#">Arenas</a>
            </li>
            <li>
                <a href="#">Details</a>
            </li>
            <li>
                <a href="#">How to Play</a>
            </li>
        </ul>
        </div>

        <div className="footer-support">
                <p>Support</p>
        <ul>
            <li>
                <a href="#">About Us</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
            <li>
                <a href="#">FAQ</a>
            </li>
            <li>
                <a href="#">Rules</a>
            </li>
        </ul>
        </div>

        <div className="footer-connect">
            <p>Connect</p>
        <ul>
            <li>
                <a href="#">Github</a>
            </li>
            <li>
                <a href="#">LinkedIn</a>
            </li>
            <li>
                <a href="#">Instagram</a>
            </li>
            <li>
                <a href="#">Facebook</a>
            </li>
        </ul>
        </div>

        </div>

        <div className="copyright">
            <div className="copyrightLine">
                <p>© 2026 DSA Arena</p>
            </div>

            <div className="privacy-terms">
                <a href="#">Privacy</a>
                 <a href="#">Terms</a>
            </div>
        </div>


        </>
    );
}

export default Footer;