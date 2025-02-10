package com.gildedtros;

import com.gildedtros.enums.ItemType;
import com.gildedtros.interfaces.ItemUpdater;
import com.gildedtros.updater.NormalItemUpdater;

import java.util.Map;

class GildedTros {
    Item[] items;
    private static final Map<String, ItemUpdater> ITEM_UPDATERS = ItemType.getItemUpdaters();

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = ITEM_UPDATERS.getOrDefault(item.name, new NormalItemUpdater());
            updater.update(item);
        }
    }
}