package com.izzist.game.entity.Enemy;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class Balloom extends Enemy{

    public Balloom(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        this.sprite = new Sprite("font/Balloom2.png",16,16);
        animation=new Animation();
        setAnimation(0, sprite.getSpriteArray2(2), 30);
    }

    public void animate(){

    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
    }

    @Override
    public void update() {
        animation.update();
    }
}
