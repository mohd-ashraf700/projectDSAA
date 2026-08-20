import DetailsHero from "./DetailsHero";
import WhatIsDSAArena from "./WhatIsDSAArena";
import { HowItWorks } from "./HowItWorks";
import { ResultEvaluation } from "./ResultEvaluation";
import RatingSystem  from "./RatingSystem";

function Details(){
    return(
        <>
        <DetailsHero></DetailsHero>

        <WhatIsDSAArena></WhatIsDSAArena>

        <HowItWorks></HowItWorks>

        <ResultEvaluation></ResultEvaluation>

        <RatingSystem></RatingSystem>
        </>
    );
}

export default Details;