package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.interfaces.ItemUpdater;

public class NormalItemUpdater implements ItemUpdater {
    public void update(Item item) {
        decreaseQuality(item, item.sellIn > 0 ? 1 : 2);
        item.sellIn--;
    }

    protected void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
