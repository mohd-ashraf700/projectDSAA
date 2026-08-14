

function ArenaCard({arenaName , difficulty , entryFee , minRating , readingTime , codingTime , winRating}){
    return(
        <>
        <div className="arena-details">
            <h3>{arenaName}</h3>
            <ul>
                <li><h5>Difficulty:</h5> {difficulty}</li>
                <li><h5>Entry Fee:</h5> {entryFee} Coins</li>
                <li><h5>Minimum Rating:</h5> {minRating}</li>
                <li><h5>Reading Time:</h5> {readingTime} min</li>
                <li><h5>Coding Time:</h5> {codingTime} min</li>
                <li><h5>Win Rating:</h5> +{winRating}</li>
            </ul>
            <button className="enter-arena">Enter Arena</button>
        </div>
        </>
    );

}

export default ArenaCard;