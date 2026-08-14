import heroImg from "../assets/hero-section-image.png";
import FeatureCard from "./FeatureCard";
import "./FeatureCard.css";
import "./Hero.css";
function Hero(){
    return(
        <>
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

        <div className="features-heading"><h1>Why DSA Arena</h1></div>
        <div className="features-line">
            <p>
                Practice is just the beginning. DSA Arena turns problem solving into
                competition, where you challenge real opponents, sharpen your skills,
                climb the rankings, earn rewards, and prove what you can do.
            </p>
        </div>
        <section className="features-grid">
            <FeatureCard title="Competitive Arenas"
                description="Compete in skill-based DSA arenas, solve problems under time limits, earn rewards, and improve your rating and skills through challenging battles." ></FeatureCard>
        
        

            <FeatureCard title="Real-Time Battles"
                description="Practice diverse DSA problems, sharpen your problem-solving abilities, improve coding efficiency, and continuously develop your programming skills." ></FeatureCard>
       

            <FeatureCard title="Rating & Ranking"
                description="Track your performance, earn rating points through victories, climb the leaderboard, and compete with players to achieve higher ranks." ></FeatureCard>
       

            <FeatureCard title="Coins & Rewards"
                description="Earn coins by winning battles, complete challenges, and unlock rewarding opportunities as you progress through competitive DSA arenas." ></FeatureCard>
        </section>
        
        </>
    )
}

export default Hero;