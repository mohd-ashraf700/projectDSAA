import heroImg from "../assets/hero-section-image.png";
import "./Hero.css";
function Hero(){
    return(
        <section className="hero">
            <div className="hero-content">
            <div className="hero-name">
                <h1>DSA ARENA</h1>
            </div>
            <div className="hero-line1">
                <h3 className="">Code. Compete. Conquer.</h3>
            </div>

            <div className="hero-line2">
                 <p>Challenge your DSA skills against other programmers.</p>
            </div>

            <div className="hero-buttons">
                <button className="hero-enter-arena">Enter Arena</button>
                <button className="hero-explore-arena">Explore Arena</button>
            </div>
            </div>

            <div className="hero-image">
                <img src={heroImg} alt="hero image" />
            </div>
        </section>
    )
}

export default Hero;