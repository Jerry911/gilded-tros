package com.gildedtros.enums;

import com.gildedtros.interfaces.ItemUpdater;
import com.gildedtros.updater.BackstagePassUpdater;
import com.gildedtros.updater.GoodWineUpdater;
import com.gildedtros.updater.LegendaryItemUpdater;
import com.gildedtros.updater.NormalItemUpdater;
import com.gildedtros.updater.SmellyItemUpdater;

import java.util.HashMap;
import java.util.Map;


public enum ItemType {
    UGLY_VARIABLE_NAMES("Ugly Variable Names", new SmellyItemUpdater()),
    LONG_METHODS("Long Methods", new SmellyItemUpdater()),
    DUPLICATE_CODE("Duplicate Code", new SmellyItemUpdater()),
    B_DAWG_KEYCHAIN("B-DAWG Keychain", new LegendaryItemUpdater()),
    GOOD_WINE("Good Wine", new GoodWineUpdater()),
    BACKSTAGE_PASSES_REFACTOR("Backstage passes for Re:Factor", new BackstagePassUpdater()),
    BACKSTAGE_PASSES_HAXX("Backstage passes for HAXX", new BackstagePassUpdater());

    private final String itemName;
    private final ItemUpdater updater;

    ItemType(String itemName, ItemUpdater updater) {
        this.itemName = itemName;
        this.updater = updater;
    }

    public String getItemName() {
        return itemName;
    }

    public ItemUpdater getUpdater() {
        return updater;
    }

    public static Map<String, ItemUpdater> getItemUpdaters() {
        Map<String, ItemUpdater> map = new HashMap<>();
        for (ItemType type : values()) {
            map.put(type.getItemName(), type.getUpdater());
        }
        return map;
    }
}