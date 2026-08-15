import heroImg from "../assets/hero-section-image.png";
import FeatureCard from "./FeatureCard";
import "./FeatureCard.css";
import "./Hero.css";
import ArenaCard from "./ArenaCard";
import "./ArenaCard.css";
import HowToPlay from "./HowToPlay";
import "./HowToPlay.css";

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
                <button className="hero-explore-arena">Explore Arenas</button>
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

        <div className="explore-arenas-heading"><h1>Explore Arenas</h1></div>
        <div className="exlore-arenas-line1"><p>Explore different arenas designed for various skill levels, compete against real players, solve challenging DSA problems, earn rewards, and climb the competitive rankings.</p></div>

        <section className="arena-details-grid">
            <ArenaCard
                arenaName="Bronze Arena"
                difficulty="EASY"
                entryFee={200}
                minRating={0}
                readingTime={3}
                codingTime={10}
                winRating={25}
            />

            <ArenaCard
                arenaName="Silver Arena"
                difficulty="EASY-MEDIUM"
                entryFee={550}
                minRating={200}
                readingTime={5}
                codingTime={15}
                winRating={40}
            />

            <ArenaCard
                arenaName="Gold Arena"
                difficulty="MEDIUM"
                entryFee={1100}
                minRating={500}
                readingTime={5}
                codingTime={18}
                winRating={60}
            />

            <ArenaCard
                arenaName="Platinum Arena"
                difficulty="MEDIUM-HARD"
                entryFee={2600}
                minRating={1000}
                readingTime={5}
                codingTime={20}
                winRating={90}
            />

            <ArenaCard
                arenaName="Diamond Arena"
                difficulty="HARD"
                entryFee={11000}
                minRating={1800}
                readingTime={10}
                codingTime={25}
                winRating={130}
            />

            <ArenaCard
                arenaName="Master Arena"
                difficulty="ADVANCED"
                entryFee={26000}
                minRating={2800}
                readingTime={10}
                codingTime={30}
                winRating={180}
            />
        </section>
        
        <div className="how-to-play-heading">
            <h1>How To Play</h1>
        </div>
        <section className="how-to-play-grid">

            <HowToPlay step={1}
                heading="Choose Arena" 
                description="Choose an arena that matches your skill level and rating, then pay the required entry fee to join the competition." />

            <HowToPlay step={2}
                heading="Battle & Solve" 
                description="Get matched with a suitable opponent, receive a DSA problem, and solve it within the given time limit while competing head-to-head." />

            <HowToPlay step={3}
                heading="Win & Climb"
                description="Win the match, earn rating and rewards, improve your rank, and progress through higher arenas as you become a stronger DSA competitor."
            />

        </section>
        </>
    )
}

export default Hero;