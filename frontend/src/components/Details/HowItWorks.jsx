import "./HowItWorks.css";
import { howItWorks } from "../../data/data";
export function HowItWorks(){
    return (
        <>
            <div className="working">
                <h1>How Does DSA Arena Work?</h1>

                    {howItWorks.map((item , index) =>
                    <div className="grid" key={index}>
                        <h4>{item.step} : {item.heading}</h4>
                        <p>{item.description}</p>
                    </div>
                    )};

            </div>
        </>
    );
}