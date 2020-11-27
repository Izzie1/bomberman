package com.izzist.game.map.tiles;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class TileBrick extends Tile {
    private Animation animation;
    private boolean isBreak = false;
    private Animation animation1;


    public TileBrick(Vector2D position, int size) {
        super(position, size);

        animation = new Animation();
        animation1 = new Animation();
        switch (MapLoader.level){
            case 1:
                this.sprite = new Sprite(MapLoader.mapSprite[0], 16, 16);
                break;
            case 2:
                this.sprite = new Sprite(MapLoader.mapSprite[2], 16, 16);
                break;
        }


        animation.setFrames(sprite.getSpriteArray2(0));
        animation.setDelay(8);
        animation1.setFrames(sprite.getSpriteArray2(1));
        animation1.setDelay(8);
    }

    @Override
    public void render(Graphics2D g2D) {
        if (!isBreak) {
            g2D.drawImage(animation.getImage(), (int) position.x, (int) position.y, size, size, null);
        } else {
            g2D.drawImage(animation1.getImage(), (int) position.x, (int) position.y, size, size, null);
        }
    }

    public void update() {
        if (!isBreak) {
            animation.update();
        } else {
            rectangle=new Rectangle();
            animation1.update();
        }
    }

    public boolean isBreak() {
        return isBreak;
    }

    public void setBreak(boolean a) {
        isBreak = a;
    }

    public Animation getAnimation1() {
        return animation1;
    }
}
