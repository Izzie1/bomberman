package com.izzist.game.states;

import com.izzist.game.GamePanel;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.AudioPlayer;
import com.izzist.game.ultility.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * man hinh khi game thang.
 */
public class VictoryState extends GameState {
    private int select = 1;
    private BufferedImage playAgain ;
    private BufferedImage quit;
    public VictoryState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bgMusic = new AudioPlayer("/sound/victory.mp3");
        playAgain = Sprite.select;
        quit = Sprite.deSelect;
        bgMusic.play();
    }

    @Override
    public void update() {

    }

    @Override
    public void input(KeyHandler key) {
        key.up.tick();
        key.down.tick();
        key.enter.tick();
        if (key.up.clicked && select < 1) {
            select++;
            playAgain = Sprite.select;
            quit = Sprite.deSelect;
        }

        if (key.down.clicked && select > 0) {
            select--;
            playAgain = Sprite.deSelect;
            quit = Sprite.select;
        }

        if (key.enter.clicked && select == 1) {
            bgMusic.stop();
            gameStateManager.pop(GameStateManager.VICTORY);
            gameStateManager.add(GameStateManager.MENU);
        } else if (key.enter.clicked && select == 0) {
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(Sprite.victory, 0, 0, GamePanel.width, GamePanel.height, null);
        g2D.drawImage(Sprite.selectImg,GamePanel.width/2+100,GamePanel.height/2,null);
        g2D.drawImage(Sprite.deSelectImg,GamePanel.width/2+100,GamePanel.height/2+98,null);
        g2D.drawImage(playAgain,GamePanel.width/2+100,GamePanel.height/2+35,null);
        g2D.drawImage(quit,GamePanel.width/2+100,GamePanel.height/2+98+35,null);
    }
}
