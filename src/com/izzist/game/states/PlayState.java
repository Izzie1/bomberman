package com.izzist.game.states;

import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.entity.Player;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.BombManager;
import com.izzist.game.managers.EnemyManager;
import com.izzist.game.managers.Sound;
import com.izzist.game.managers.TileManager;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayState extends GameState {
    private MapLoader map;
    public static Player player;
    private BombManager bombManager;
    public static List<Flame> flames = new ArrayList<>();
    private EnemyManager enemyManager;
    private int level = 1;

    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        player = new Player(new Vector2D(0, 0), 32);
        map = new MapLoader("data/map/Level1.txt");
        bombManager = new BombManager();
        enemyManager = new EnemyManager();
    }

    @Override
    public void update() {
        player.update();
        bombManager.update();
        updateFlame();
        removeFlame();
        map.update();
        enemyManager.update();
        switchLevel();
        endGame();
    }

    @Override
    public void input(KeyHandler key) {
        player.input(key);
        key.clear.tick();
        if(key.clear.clicked){
            EnemyManager.enemies.clear();
            TileManager.tileBrickManager.clear();
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        map.render(g2D);
        bombManager.renderBomb(g2D);
        renderFlame(g2D);
        enemyManager.render(g2D);
        player.render(g2D);
        g2D.drawImage(Sprite.hud,0,32*13,32*31,32*7,null);
        hud(g2D);
        lives(g2D);
    }

    public void renderFlame(Graphics2D g2D) {
        for (Flame flame : flames) {
            flame.render(g2D);
        }
    }

    public void updateFlame() {
        for (Flame flame : flames) {
            flame.update();
        }
    }

    public void removeFlame() {
        for (int i = flames.size() - 1; i >= 0; i--) {
            if (flames.get(i).getIsExploded()) {
                flames.remove(i);
            }
        }
    }

    public void endGame(){
        if(player.getLives()==0){
            gameStateManager.add(GameStateManager.GAMEOVER);
            gameStateManager.pop(GameStateManager.PLAY);
            map.clear();
            EnemyManager.enemies.clear();
        }
    }

    public void switchLevel() {
        if (map.portal.isActive() && player.getRectangle().intersects(map.portal.getRectangle())) {
            map.clear();
            level++;
            switch (level) {
                case 1:
                    map = new MapLoader("data/map/Level1.txt");
                    break;
                case 2:
                    map = new MapLoader("data/map/Level2.txt");
                    break;
                case 3:
                    map = new MapLoader("data/map/Level3.txt");
                    break;
                case 4:
                    map = new MapLoader("data/map/Level4.txt");
                    break;
                case 5:
                    gameStateManager.pop(GameStateManager.PLAY);
                    gameStateManager.add(GameStateManager.VICTORY);
            }
        }
    }

    public void hud(Graphics2D g2D){
        switch (level){
            case 1:
                g2D.drawImage(Sprite.level[0],0,32*13,32*31,32*7,null);
                break;
            case 2:
                g2D.drawImage(Sprite.level[1],0,32*13,32*31,32*7,null);
                break;
            case 3:
                g2D.drawImage(Sprite.level[2],0,32*13,32*31,32*7,null);
                break;
            case 4:
                g2D.drawImage(Sprite.level[3],0,32*13,32*31,32*7,null);
                break;
        }
    }

    public void lives(Graphics2D g2D){
        switch (player.getLives()) {
            case 1:
                g2D.drawImage(Sprite.live,0,32*13,32,30,null);
                break;
            case 2:
                g2D.drawImage(Sprite.live,0,32*13,32,30,null);
                g2D.drawImage(Sprite.live,32,32*13,32,30,null);
                break;
            case 3:
                g2D.drawImage(Sprite.live,0,32*13,32,30,null);
                g2D.drawImage(Sprite.live,32,32*13,32,30,null);
                g2D.drawImage(Sprite.live,64,32*13,32,30,null);
                break;
        }
    }
}
