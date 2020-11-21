package com.izzist.game.managers;

import com.izzist.game.entity.Player;
import com.izzist.game.map.MapLoader;

import java.util.ArrayList;

public class PlayerManager {
    public static ArrayList<Player> players ;

    public PlayerManager(){
        players = new ArrayList<>();
    }

    public Player getPLayer(int index) {
        return players.get(index);
    }
}
