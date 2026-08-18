import "./ResultEvaluation.css";
import { resultEvaluationCondition } from "../../data/data.js";

export function ResultEvaluation(){
    return (
        <>
            <div className="result-evaluation">
                <h1>How is the Result Evaluated?</h1>
                <p>Once a match is completed, the system evaluates the final outcome based on the submissions made by both players during the coding phase. Several conditions are considered, such as whether a solution was accepted, submission time, number of wrong submissions, and passed test cases. These conditions are evaluated in a specific order to determine the winner or declare the match a draw.</p>
                <div className="result-grid">
                {resultEvaluationCondition.map((item , index) =>(
                    <div className="result-card" key={index}>
                        <h4>{item.Condition} : {item.heading}</h4>
                        <p>{item.description}</p>
                    </div>
                ))}
                </div>
            </div>
        </>
    );
}