package com.izzist.game.states;

import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.entity.Player;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.AudioPlayer;
import com.izzist.game.managers.BombManager;
import com.izzist.game.managers.EnemyManager;
import com.izzist.game.managers.TileManager;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayState extends GameState {
    private Animation cloud;
    private MapLoader map;
    public static Player player;
    private BombManager bombManager;
    public static List<Flame> flames = new ArrayList<>();
    private EnemyManager enemyManager;
    private int level = 1;

    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        cloud = new Animation();
        cloud.setFrames(Sprite.hud);
        cloud.setDelay(5);
        player = new Player(new Vector2D(0, 0), 32);
        map = new MapLoader("data/map/Level1.txt");
        bombManager = new BombManager();
        enemyManager = new EnemyManager();
        bgMusic = new AudioPlayer("/sound/KDA.mp3");
        bgMusic.play();
    }

    @Override
    public void update() {
        cloud.update();
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
        if (key.clear.clicked) {
            EnemyManager.enemies.clear();
            TileManager.tileBrickManager.clear();
        }
        key.cheat1.tick();
        if (key.cheat1.clicked) {
            player.setRespawnTime(10000000);
            player.setInvincible(true);
        }
        key.cheat2.tick();
        if (key.cheat2.clicked) {
            player.setRespawnTime(100);
            player.setInvincible(false);
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        map.render(g2D);
        bombManager.renderBomb(g2D);
        renderFlame(g2D);
        enemyManager.render(g2D);
        player.render(g2D);
        g2D.drawImage(cloud.getImage(), 0, 32 * 13, 32 * 31, 32 * 7, null);
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

    public void endGame() {
        if (player.getLives() == 0) {
            bgMusic.stop();
            gameStateManager.add(GameStateManager.GAMEOVER);
            gameStateManager.pop(GameStateManager.PLAY);
            map.clear();
            EnemyManager.enemies.clear();
        }
    }

    public void switchLevel() {
        if (map.portal.isActive() && player.getRectangle().intersects(map.portal.getRectangle())) {
            map.clear();
            bgMusic.stop();
            level++;
            switch (level) {
                case 2:
                    map = new MapLoader("data/map/Level2.txt");
                    bgMusic = new AudioPlayer("/sound/WARRIORS.mp3");
                    bgMusic.play();
                    break;
                case 3:
                    map = new MapLoader("data/map/Level3.txt");
                    bgMusic = new AudioPlayer("/sound/WTF.mp3");
                    bgMusic.play();
                    break;
                case 4:
                    map = new MapLoader("data/map/Level4.txt");
                    bgMusic = new AudioPlayer("/sound/BAAM.mp3");
                    bgMusic.play();
                    break;
                case 5:
                    gameStateManager.pop(GameStateManager.PLAY);
                    gameStateManager.add(GameStateManager.VICTORY);
            }
        }
    }

    public void hud(Graphics2D g2D) {
        switch (level) {
            case 1:
                g2D.drawImage(Sprite.level[0], 0, 32 * 13, 32 * 31, 32 * 7, null);
                break;
            case 2:
                g2D.drawImage(Sprite.level[1], 0, 32 * 13, 32 * 31, 32 * 7, null);
                break;
            case 3:
                g2D.drawImage(Sprite.level[2], 0, 32 * 13, 32 * 31, 32 * 7, null);
                break;
            case 4:
                g2D.drawImage(Sprite.level[3], 0, 32 * 13, 32 * 31, 32 * 7, null);
                break;
        }
    }

    public void lives(Graphics2D g2D) {
        for (int i = 0; i < player.getLives(); i++) {
            g2D.drawImage(Sprite.live, i * 32, 32 * 13, 32, 30, null);
        }
    }
}
