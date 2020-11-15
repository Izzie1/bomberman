package com.izzist.game.entity.Enemy;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

public class Baloom extends Enemy{
    public Baloom(Vector2D position, int size) {
        super(position, size);
    }

    public Baloom(Sprite sprite, Vector2D position, int size) {
        super(sprite, position, size);
    }
}
