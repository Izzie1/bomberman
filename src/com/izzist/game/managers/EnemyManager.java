package com.izzist.game.managers;

import com.izzist.game.entity.Enemy.Doll;
import com.izzist.game.entity.Enemy.Enemy;
import com.izzist.game.entity.Enemy.Minvo;


import java.awt.*;
import java.util.ArrayList;

public class EnemyManager {
    public static ArrayList<Enemy> enemies=new ArrayList<>();

    public EnemyManager() {

    }


    public void render(Graphics2D g2D){
        for (Enemy e : enemies) {
            e.render(g2D);
        }
    }

    public void update(){
        for (Enemy e : enemies) {
            e.update();
        }
        removeEnemies();
    }

    public void removeEnemies() {
        for (int i = enemies.size() - 1; i >= 0; i--) {
            if (!enemies.get(i).getIsAlive() && enemies.get(i).getDead_animation().playOnce()) {
                if(enemies.get(i)instanceof Doll){
                    enemies.add(new Minvo(enemies.get(i).getPosition(),32));
                }
                enemies.remove(i);
            }
        }
    }
}
