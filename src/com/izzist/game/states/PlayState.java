package com.izzist.game.states;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Enemy.Balloom;
import com.izzist.game.entity.Player;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class PlayState extends GameState {
    public Player player;
    private MapLoader m;
    public Balloom balloom;
    public List<Bomb> bombs = new ArrayList<>();

    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        player = new Player(new Vector2D(32, 32), 32);
        m = new MapLoader();
        m.readMap();
        balloom = new Balloom(new Vector2D(64, 32), 32);
    }

    @Override
    public void update() {
        player.update();
        balloom.update();
    }

    @Override
    public void input(KeyHandler key) {
        player.input(key);

    }

    @Override
    public void render(Graphics2D g2D) {
        m.render(g2D);
        player.render(g2D);
        balloom.render(g2D);
    }
}
