package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.interfaces.ItemUpdater;

public class GoodWineUpdater implements ItemUpdater {
    public void update(Item item) {
        increaseQuality(item, 1);
        item.sellIn--;
    }

    protected void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }
}
