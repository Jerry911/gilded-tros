package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.interfaces.ItemUpdater;

public class BackstagePassUpdater implements ItemUpdater {
    public void update(Item item) {
        if (item.sellIn > 10) {
            increaseQuality(item, 1);
        } else if (item.sellIn > 5) {
            increaseQuality(item, 2);
        } else if (item.sellIn > 0) {
            increaseQuality(item, 3);
        } else {
            item.quality = 0;
        }
        item.sellIn--;
    }

    protected void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }
}