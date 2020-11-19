package com.izzist.game.states;



import com.izzist.game.Entity.Player;
import com.izzist.game.Game;

import java.awt.*;

public class PlayState extends GameState {
    private Player player;

    public PlayState(Game game) {
        super(game);
        player=new Player(32,32,32,32,this.game);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);

    }
}
