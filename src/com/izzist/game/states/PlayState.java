package com.izzist.game.states;



import com.izzist.game.Entity.Player;
import com.izzist.game.Game;
import com.izzist.game.map.World;

import java.awt.*;

public class PlayState extends GameState {
    private Player player;
    private World world;

    public PlayState(Game game) {
        super(game);
        player=new Player(32,32,32,32,this.game);
        world = new World("res/Level1.txt",this.game);

    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
}
