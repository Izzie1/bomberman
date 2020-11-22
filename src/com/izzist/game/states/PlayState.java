package com.izzist.game.states;

import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.managers.BombManager;
import com.izzist.game.managers.MapManager;
import com.izzist.game.managers.PlayerManager;
import com.izzist.game.ultility.KeyHandler;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayState extends GameState {
    private MapManager mapManager;
    private PlayerManager playerManager;
    private BombManager bombManager;
    public static List<Flame> flames = new ArrayList<>();


    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        playerManager = new PlayerManager();
        mapManager = new MapManager();
        bombManager = new BombManager();
    }

    @Override
    public void update() {
        playerManager.getPLayer(0).update();
        bombManager.update();
        updateFlame();
        removeFlame();
        mapManager.getMap(0).update();
    }

    @Override
    public void input(KeyHandler key) {
        playerManager.getPLayer(0).input(key);
    }

    @Override
    public void render(Graphics2D g2D) {
        mapManager.getMap(0).render(g2D);
        bombManager.renderBomb(g2D);
        renderFlame(g2D);
        playerManager.getPLayer(0).render(g2D);

    }

    public void renderFlame(Graphics2D g2D){
        for (Flame flame : flames) {
            flame.render(g2D);
        }
    }

    public void updateFlame(){
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

}
