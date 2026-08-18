import "./WhatIsDSAArena.css";
import { whatIsDSAArena } from "../../data/data.js";

export default function WhatIsDSAArena(){
    return(
        <>
            <div className="purpose">
                <div className="heading">
                    <h1>What is DSA Arena?</h1>
                </div>

                <div className="purpose-of-dsa-arena">
                    <ol>
                        <li><h3>Purpose of DSA Arena:</h3>
                    <p>DSA Arena is a multiplayer Data Structures and Algorithms practice and competitive coding platform where users can learn DSA concepts in an engaging and interactive way. It allows programmers to practice problems, compete against real opponents, improve their problem-solving skills, and progress through different competitive arenas.</p></li>

                    <li>
                        <h3>DSA Arena Provides:</h3>
                            <ul>
                               {whatIsDSAArena.map((item , index) => (
                                <li key={index} 
                                >
                                    <h4>{item.heading}</h4>
                                    <p>{item.description}</p>
                                </li>
                               ))}
                            </ul>
                    </li>
                    </ol>
                </div>


            </div>
        </>
    );
}