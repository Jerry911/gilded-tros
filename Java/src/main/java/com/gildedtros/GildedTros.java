package com.gildedtros;

import com.gildedtros.interfaces.ItemUpdater;
import com.gildedtros.updater.BackstagePassUpdater;
import com.gildedtros.updater.GoodWineUpdater;
import com.gildedtros.updater.LegendaryItemUpdater;
import com.gildedtros.updater.NormalItemUpdater;
import com.gildedtros.updater.SmellyItemUpdater;

import java.util.HashMap;
import java.util.Map;

class GildedTros {
    Item[] items;
    private static final Map<String, ItemUpdater> ITEM_UPDATERS = new HashMap<>();

    static {
        ITEM_UPDATERS.put("Ugly Variable Names", new SmellyItemUpdater());
        ITEM_UPDATERS.put("Long Methods", new SmellyItemUpdater());
        ITEM_UPDATERS.put("Duplicate Code", new SmellyItemUpdater());
        ITEM_UPDATERS.put("B-DAWG Keychain", new LegendaryItemUpdater());
        ITEM_UPDATERS.put("Good Wine", new GoodWineUpdater());
        ITEM_UPDATERS.put("Backstage passes for Re:Factor", new BackstagePassUpdater());
        ITEM_UPDATERS.put("Backstage passes for HAXX", new BackstagePassUpdater());
    }

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