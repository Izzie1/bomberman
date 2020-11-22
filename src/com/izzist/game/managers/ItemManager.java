package com.izzist.game.managers;

import com.izzist.game.entity.Item.Item;
import com.izzist.game.map.tiles.Tile;
import com.izzist.game.map.tiles.TileBrick;

import java.util.ArrayList;

public class ItemManager {
    public static ArrayList<Item> items = new ArrayList<>();


    public static Item getItem(int x, int y) {
        Item temp = null;
        for (Item b : items) {
            if ((int)b.getPosition().x/32 == x && (int)b.getPosition().y/32 == y) {
                temp = b;
            }
        }
        return temp;
    }
}
