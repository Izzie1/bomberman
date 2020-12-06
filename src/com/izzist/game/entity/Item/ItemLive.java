package com.izzist.game.entity.Item;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class ItemLive extends Item {
    public ItemLive(Vector2D position) {
        this.position = position;
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(Sprite.live, (int) (position.x) + 2, (int) (position.y) + 2, 20, 20, null);
    }

    @Override
    public void update() {
    }
}
