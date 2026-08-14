import "./FeatureCard.css";

function FeatureCard({title , description}){
    return(
        <>
        <div className="feature-card">
            <h2>{title}</h2>
            <p>{description}</p>
            <button className="feature-explore">Explore More</button>
        </div>
        
        </>
    );
}

export default FeatureCard;