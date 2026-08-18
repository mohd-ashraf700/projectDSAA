export const whatIsDSAArena = [
    {
        heading : 'Interactive DSA Practice' ,
        description : 'Users can practice Data Structures and Algorithms problems and strengthen their problem-solving skills through continuous practice.'
    } ,
    {
        heading : 'Real-Time Competitive Battles' ,
        description : 'Users can compete head-to-head against other programmers by solving DSA problems within a fixed time limit.'
    } ,
    {
        heading : 'Skill-Based Arenas' ,
        description : 'Different arenas are designed for different skill levels, allowing users to compete against opponents with suitable ratings and gradually take on harder challenges.'
    } ,
    {
        heading : 'Rating & Ranking System' ,
        description : 'Players earn or lose rating based on their match performance and can climb through different ranks as they improve.'
    } ,
    {
        heading : 'Coins & Rewards' ,
        description : 'Players use coins to enter arenas and can earn rewards by winning competitive matches.'
    }  ,
    {
        heading : 'Competitive Progression' ,
        description : 'Players can progress from lower-level arenas to more challenging ones by improving their rating, skills, and competitive performance.'
    }
    
];


export const howItWorks = [
    {
        step : "Step 01" ,
        heading : 'Choose an Arena' ,
        description :'Players begin by selecting an arena that matches their current skill level and rating. Every arena has its own difficulty, entry fee, minimum rating requirement, reading time, coding time, and winning rating. Players should choose an arena carefully because higher-level arenas require better ratings and more coins.'
    } ,
    {
        step : "Step 02" ,
        heading : 'Check Eligibility' ,
        description :"Before entering matchmaking, the system checks whether the player is eligible for the selected arena. It verifies that the player exists, is not already waiting in another matchmaking queue, has the required minimum rating, and has enough coins to pay the arena's entry fee.if he is eligible then he automatically enter in the matchmaking"
    } ,
    {
        step : "Step 03" ,
        heading : 'Enter Matchmaking' ,
        description :'After passing all eligibility checks, the player is added to the matchmaking queue associated with the selected arena. Each arena maintains its own queue, allowing players to be matched within the appropriate competitive level instead of being placed into completely unrelated arenas.'
    } ,
    {
        step : "Step 04" ,
        heading : 'Find an Opponent' ,
        description :"The matchmaking system searches the selected arena's queue for another eligible player. The system gives players a limited waiting period to find an opponent. When a suitable opponent is found, both players are removed from the queue and a new match is created between them."
    } ,
    {
        step : "Step 05" ,
        heading : 'Match Created' ,
        description :"Once a suitable opponent is found, the matchmaking system removes both players from the queue and creates a new match. The match is assigned a unique match ID and stores important information such as both player IDs, arena ID, selected question, entry fee, and each player's rating at the start of the match."
    } ,
    {
        step : "Step 06" ,
        heading : 'Coin Deduction' ,
        description :"When a player successfully joins an arena, the required entry fee is deducted from their available coins before entering the matchmaking queue. This ensures that only players who can afford the selected arena can participate. The deducted coins are then considered part of the match's reward pool, from which the applicable platform fee is handled before the winner's reward is credited."
    } ,
    {
        step : "Step 07" ,
        heading : 'Reading Phase' ,
        description :'Every arena provides a fixed amount of reading time before coding begins. During this phase, both players can carefully read and understand the assigned DSA problem, its requirements, and constraints. The backend manages this phase using a timer and automatically moves the match forward when the reading time expires.'
    } ,
    {
        step : "Step 08" ,
        heading : 'Coding Phase' ,
        description :'After the reading phase ends, the match enters the live coding phase. Both players receive the same DSA problem and compete against each other while working within the coding time defined by their selected arena. The timer continues running until the coding period ends or the match reaches its completion condition.'
    } ,
    {
        step : "Step 09" ,
        heading : 'Submit the Solution' ,
        description :"Players can submit their solutions while the coding phase is active. Each submission is recorded by the system so that the match can track the player's attempts and their correctness. Incorrect submissions receive the predefined penalty, making accuracy important while solving the problem under competitive time pressure."
    } ,
    {
        step : "Step 10" ,
        heading : 'Determine the Result' ,
        description :"When the match reaches its completion condition, the system processes the players' submissions and determines the match outcome according to the defined rules. The winning player is recorded in the match, and the match status is changed from an active state to COMPLETED."
    } ,
    {
        step : "Step 11" ,
        heading : 'Update Rating and Coins' ,
        description :"After the match is completed, the result system updates the players' ratings and coins according to the arena's configuration. A winner receives the specified rating increase, while a loss results in the defined rating decrease. The entry fee, reward, and platform fee are also handled according to the match economy."
    } ,
    {
        step : "Step 12" ,
        heading : 'Update Rank and Progress' ,
        description :"The player's updated rating determines their competitive rank and eligibility for higher-level arenas. As players consistently win matches and improve their ratings, they can progress from lower-level arenas toward more challenging competitions, giving them a clear long-term progression path within DSA Arena."
    }  
]