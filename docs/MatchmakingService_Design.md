--------------------###------------------------
Complete End-to-End DSA Arena Match Flow



USER
|
↓
Find Match
|
↓
Eligibility Check
|
↓
Join Arena Queue
|
↓
Individual Timer Start
|
↓
Perfect Match Available?
|
↓
Best Opponent Search
|
↓
Rating Range Expand if Needed
|
↓
Opponent Found
|
↓
Coin Re-check
|
↓
Remove From Queue
|
↓
Deduct Coins
|
↓
Verify Pot
|
↓
Create Match
|
↓
Game Start
|
↓
QuestionService
|
↓
Question Selection
|
↓
Avoid Recently Used
|
↓
Assign Question
|
↓
Coding Starts








---###---
USER MATCH REQUEST FLOW

                User clicks "Find Match"
                         |
                         ↓
              MatchmakingService receives request
                         |
                         ↓
                 Eligibility Check
                         |
        ---------------------------------
        |               |               |
        ↓               ↓               ↓
Arena Valid?     User Valid?     User Already Playing?
|               |               |
Yes             Yes             No
|               |               |
---------------------------------
|
↓
Rating >= Arena Minimum?
|
----------------------
|                    |
Yes                   No
|                    |
↓                    ↓
Coin Check             Reject Request
|
↓
Coins >= Entry Fee?
|
----------------
|              |
Yes             No
|              |
↓              ↓
Queue Join       Reject Request


---###---
QUEUE JOIN FLOW

User Eligible
|
↓
Create Queue Entry
|
↓
Add Player into Arena Specific Queue

Example:

Bronze Queue
--------------
Ashraf 1500
Ali    1498


Gold Queue
--------------
Rahul 2000


      |
      ↓
Start Individual Timer




----------------------###----------------------
Instant Perfect Match Flow

Player joins Queue
|
↓
Search Existing Players
|
↓
Calculate Rating Difference
|
↓
Difference = Perfect Match?
|
   -----------------
|               |
Yes              No
|               |
↓               ↓
Instant Match   Continue Waiting


-----------------###-------------------
Timer Complete Matchmaking Flow

Player Timer Completed
|
↓
Scan Same Arena Queue
|
↓
Calculate Rating Difference

Player A = 1500


Opponent 1 = 1490
Difference = 10


Opponent 2 = 1502
Difference = 2


Opponent 3 = 1700
Difference = 200


          |
          ↓
Keep Minimum Difference
|
↓
Select Best Opponent


---------------###-----------------
Rating Range Expansion Flow


Find Closest Rating Opponent

          |
          ↓

Opponent Found?
|
-------------
|           |
Yes          No
|           |
↓           ↓

Match       Increase Search Range

                 |
                 ↓

          Opponent Found?
                 |
            -------------
            |           |
           Yes          No
            |           |
            ↓           ↓

        Match     Same Arena Any Eligible Player



-----------------###--------------------
Opponent Found ke baad Flow
Best Opponent Found

          |
          ↓

Coin Re-validation

(Both Players)


          |
          ↓

Coins Enough?
|
---------
|       |
Yes      No
|       |
↓       ↓

Continue   Cancel Match
           



-------------------###------------------------
Queue Removal + Coin Deduction Flow



Opponent Found

        |
        ↓

Coin Check

        |
        ↓

Remove Both Players From Queue

        |
        ↓

Deduct Entry Fee

Player 1 -100
Player 2 -100

        |
        ↓

Verify Pot

Expected:
100 + 100 = 200

        |
        ↓

Pot Correct?
|
----------
|        |
Yes       No
|        |
↓        ↓

Create    Refund Coins
Match     and Cancel






--------------------###---------------------
Match Creation Flow



Coins Successfully Deducted

          |
          ↓

Create Match Object


Fields:

matchId
player1Id
player2Id
arenaId
questionId(null initially)
status
startTime


          |
          ↓

Match Created Successfully




-------------------###--------------------
Cancel Matchmaking Flow


Case 1: Opponent nahi mila


Searching State

       |
       ↓

User clicks Cancel

       |
       ↓

Remove Queue Entry

       |
       ↓

Stop Timer

       |
       ↓

Done


Case 2: Opponent mil gaya


Opponent Found

       |
       ↓

Cancel Button Removed

       |
       ↓

Match Pipeline Starts

       |
       ↓

No Manual Cancel Allowed