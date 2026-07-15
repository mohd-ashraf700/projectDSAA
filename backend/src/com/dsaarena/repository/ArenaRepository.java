package com.dsaarena.repository;

import com.dsaarena.model.Arena;

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
                "Easy",
                200,
                400,
                0,
                3,
                10,
                25,
                5);
        arenas.put(101 , bronzeArena);

        Arena silverArena = new Arena(102,
                "Silver Arena",
                "Easy - Medium",
                550,
                1000,
                200,
                5,
                15,
                40,
                10);
        arenas.put(102 , silverArena);

        Arena goldArena = new Arena(103,
                "Gold Arena",
                "Medium",
                1100,
                2000,
                500,
                5,
                18,
                60,
                15);
        arenas.put(103 , goldArena);

        Arena platinumArena = new Arena(104,
                "Platinum Arena",
                "Medium - Hard",
                2600,
                5000,
                1000,
                5,
                20,
                90,
                25);
        arenas.put(104 , platinumArena);

        Arena diamondArena = new Arena(105,
                "Diamond Arena",
                "Hard",
                11000,
                20000,
                1800,
                10,
                25,
                130,
                40);
        arenas.put(105 , diamondArena);

        Arena masterArena = new Arena(106,
                "Master Arena",
                "Advanced",
                26000,
                50000,
                2800,
                10,
                30,
                180,
                60);
        arenas.put(106 , masterArena);
    }
    public Arena getArenaById(int arenaId){
        return arenas.get(arenaId);
    }
    public List<Arena> getAllArenas(){
        return new ArrayList<>(arenas.values());
    }
}
