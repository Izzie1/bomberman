package com.izzist.game.map.tiles;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.EnemyManager;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class TilePortal extends Tile {
    private boolean isActive = false;
    private Animation animation;

    public TilePortal(Vector2D position, int size) {
        super(position, size);
        this.sprite = new Sprite("assets/Portal_99_114.png", 99, 114);
        animation = new Animation();
        animation.setFrames(sprite.getSpriteArray2(0));
        animation.setDelay(10);
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(animation.getImage(), (int) position.x, (int) position.y, size, size, null);
        g2D.drawRect((int) position.x, (int) position.y, size, size);
    }

    public void update() {
        if(EnemyManager.enemies.size() == 0){
            isActive = true;
            animation.update();
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
}
