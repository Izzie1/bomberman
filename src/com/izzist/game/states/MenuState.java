package com.izzist.game.states;

import com.izzist.game.GamePanel;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.AudioPlayer;
import com.izzist.game.ultility.KeyHandler;

import java.awt.*;
import java.io.*;


public class MenuState extends GameState {
    private Animation animation;
    private Font font;
    private int select;
    private AudioPlayer bgMusic;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        select = 1;
        animation = new Animation();
        animation.setFrames(Sprite.beginning);
        animation.setDelay(10);
        try {
            InputStream file = new BufferedInputStream(new FileInputStream("data/font/bm.ttf"));
            font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, file));
        } catch (FontFormatException | IOException ignored) {
        }
        bgMusic = new AudioPlayer("/sound/2stepfromhell.wav");
        bgMusic.play();

    }

    @Override
    public void update() {
        animation.update();

    }

    @Override
    public void input(KeyHandler key) {
        key.up.tick();
        key.down.tick();
        if (key.up.clicked && select < 1) {
            select++;
        }

        if (key.down.clicked && select > 0) {
            select--;
        }

        key.enter.tick();
        if (key.enter.clicked && select == 1) {
            bgMusic.stop();
            gameStateManager.pop(GameStateManager.MENU);
            gameStateManager.add(GameStateManager.PLAY);
        } else if (key.enter.clicked && select == 0) {
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(Sprite.menu, 0, 0, GamePanel.width, GamePanel.height, null);
        g2D.drawImage(animation.getImage(), GamePanel.width / 2 - 100,
                GamePanel.height / 2 - 100, 200, 200, null);


        g2D.setFont(font);
        g2D.setColor(Color.YELLOW);
        if (select == 1) {
            g2D.drawString("start", GamePanel.width / 2 - 55, GamePanel.height / 2 - 15);
        } else {
            g2D.drawString("quit", GamePanel.width / 2 - 40, GamePanel.height / 2 - 15);
        }
    }

}
