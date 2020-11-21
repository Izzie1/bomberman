package com.izzist.game.managers;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Player;

import java.util.ArrayList;

public class BombManager {

    public static ArrayList<Bomb> bombs;

    public BombManager(){
        bombs = new ArrayList<>();
        for(Player p: PlayerManager.players){
            bombs.addAll(p.getBombs());
        }
    }
}
