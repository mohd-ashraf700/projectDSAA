package main.java.dsaarena.repository;

import main.java.dsaarena.enums.Difficulty;
import main.java.dsaarena.model.Arena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArenaRepository {
    private Map<Integer , Arena> arenas;
    public ArenaRepository(){
        arenas = new HashMap<>();
        initializeArenas();
    }

    private void initializeArenas(){
        Arena bronzeArena = new Arena(101,
                "Bronze Arena",
                Difficulty.EASY,
                200,
                0,
                3,
                10,
                25,
                5,
                0);
        arenas.put(101 , bronzeArena);

        Arena silverArena = new Arena(102,
                "Silver Arena",
                Difficulty.EASY_MEDIUM,
                550,
                200,
                5,
                15,
                40,
                10,
                            100);
        arenas.put(102 , silverArena);

        Arena goldArena = new Arena(103,
                "Gold Arena",
                Difficulty.MEDIUM,
                1100,
                500,
                5,
                18,
                60,
                15,
                            200);
        arenas.put(103 , goldArena);

        Arena platinumArena = new Arena(104,
                "Platinum Arena",
                Difficulty.MEDIUM_HARD,
                2600,
                1000,
                5,
                20,
                90,
                25 ,
                200);
        arenas.put(104 , platinumArena);

        Arena diamondArena = new Arena(105,
                "Diamond Arena",
                Difficulty.HARD,
                11000,
                1800,
                10,
                25,
                130,
                40,
                        2000);
        arenas.put(105 , diamondArena);

        Arena masterArena = new Arena(106,
                "Master Arena",
                Difficulty.ADVANCED,
                26000,
                2800,
                10,
                30,
                180,
                60,
                        2000);
        arenas.put(106 , masterArena);
    }
    public Arena getArenaById(int arenaId){
        return arenas.get(arenaId);
    }
    public List<Arena> getAllArenas(){
        return new ArrayList<>(arenas.values());
    }
}
