package com.izzist.game.managers;

import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.entity.Enemy.Balloom;
import com.izzist.game.entity.Enemy.Doll;
import com.izzist.game.entity.Enemy.Enemy;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class EnemyManager {
    public static ArrayList<Enemy> enemies=new ArrayList<>();

    public EnemyManager() {

    }

    public static Enemy getEnemy(int x, int y) {
        Enemy temp = null;
        for (Enemy e : enemies) {
            if ((int)e.getPosition().x/32 == x && (int)e.getPosition().y/32 == y) {
                temp = e;
            }
        }
        return temp;
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
                    enemies.add(new Balloom(enemies.get(i).getPosition(),32));
                }
                enemies.remove(i);
            }
        }
    }
}
