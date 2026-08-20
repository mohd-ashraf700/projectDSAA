import { RatingSystemData } from "../../data/data";
import "./RatingSystem.css";
export default function RatingSystem(){
    return (
        <>
        <div className="rating">
            <h1>Rating System</h1>
        {
            RatingSystemData.map((item , index) => {
                return(
                    <div key={index} className="rating-subheadings">
                    <h3>{item.number} : {item.heading}</h3>
                    <p>{item.description}</p>

                </div>
                )})
        }
        
        </div>
        </>
    );
}