package com.gildedtros.updater;

import com.gildedtros.Item;
import com.gildedtros.interfaces.ItemUpdater;

public class LegendaryItemUpdater implements ItemUpdater {
    public void update(Item item) {
        // Legendary items do not decrease in Quality or SellIn
    }
}
