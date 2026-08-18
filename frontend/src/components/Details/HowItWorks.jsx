import "./HowItWorks.css";
import { howItWorks } from "../../data/data";
export function HowItWorks(){
    return (
        <>
            <div className="working">
                <h1>How Does DSA Arena Work?</h1>

                <ol>
                    {howItWorks.map((item , index) =>
                    <li key={index}>
                        <h4>{item.heading}</h4>
                        <p>{item.description}</p>
                    </li>
                    )}
                </ol>
            </div>
        </>
    );
}