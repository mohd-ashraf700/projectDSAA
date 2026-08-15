
function HowToPlay({step , heading , description}){
    return(
        <>
        <section className="how-to-play">
            <div className="steps-grid">
               <h2>Step 0{step}</h2> <h3> {heading} </h3>
                <p> {description} </p>
            </div>
        </section>
        </>
    );
}

export default HowToPlay;