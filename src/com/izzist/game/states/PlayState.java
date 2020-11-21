package com.izzist.game.states;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.entity.Enemy.Balloom;
import com.izzist.game.entity.Player;
import com.izzist.game.managers.BombManager;
import com.izzist.game.managers.MapManager;
import com.izzist.game.managers.PlayerManager;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;


import java.awt.Graphics2D;
import java.util.ArrayList;

public class PlayState extends GameState {
    private MapManager mapManager;
    private PlayerManager playerManager;
    private BombManager bombManager;
    private ArrayList<Flame> flames = new ArrayList<>();


    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        playerManager = new PlayerManager();
        mapManager = new MapManager();
        bombManager = new BombManager();
    }

    @Override
    public void update() {
        playerManager.getPLayer(0).update();
        mapManager.getMap(0).update();
    }

    @Override
    public void input(KeyHandler key) {
        playerManager.getPLayer(0).input(key);
    }

    @Override
    public void render(Graphics2D g2D) {
        mapManager.getMap(0).render(g2D);
        playerManager.getPLayer(0).render(g2D);
    }
}
