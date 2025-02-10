package com.gildedtros.updater;

import com.gildedtros.Item;

public class SmellyItemUpdater extends NormalItemUpdater {
    @Override
    public void update(Item item) {
        decreaseQuality(item, item.sellIn > 0 ? 2 : 4);
        item.sellIn--;
    }
}