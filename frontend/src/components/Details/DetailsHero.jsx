import heroImg from "../../assets/DetailsHeroimg.png";
import "./DetailsHero.css";

function DetailsHero(){
    return(
        <>
        <section className="details-hero">
            <div className="details-hero-content">
                <h1>Understand DSA Arena</h1>
                <p>
                    Learn how DSA Arena works, from matchmaking and competitive
                    battles to ratings, coins, rewards, and arena progression.
                </p>

                <h4>Scroll down to understand the rules & working</h4>
            </div>

            <div className="details-hero-image">
                <img src={heroImg} alt="DSA Arena coding battle" />
            </div>
        </section>
        </>
    );
}

export default DetailsHero;