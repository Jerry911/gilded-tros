package com.gildedtros;

import com.gildedtros.interfaces.ItemUpdater;
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
    }

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            ItemUpdater updater = ITEM_UPDATERS.get(item.name);

            if (updater != null) {
                updater.update(item);
            } else {
                if (!items[i].name.equals("Good Wine")
                        && !items[i].name.equals("Backstage passes for Re:Factor")
                        && !items[i].name.equals("Backstage passes for HAXX")) {
                    if (items[i].quality > 0) {
                        if (!items[i].name.equals("B-DAWG Keychain")) {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;

                        if (items[i].name.equals("Backstage passes for Re:Factor") || items[i].name.equals("Backstage passes for HAXX")) {
                            if (items[i].sellIn < 11) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }

                            if (items[i].sellIn < 6) {
                                if (items[i].quality < 50) {
                                    items[i].quality = items[i].quality + 1;
                                }
                            }
                        }
                    }
                }

                if (!items[i].name.equals("B-DAWG Keychain")) {
                    items[i].sellIn = items[i].sellIn - 1;
                }

                if (items[i].sellIn < 0) {
                    if (!items[i].name.equals("Good Wine")) {
                        if (!items[i].name.equals("Backstage passes for Re:Factor") && !items[i].name.equals("Backstage passes for HAXX")) {
                            if (items[i].quality > 0) {
                                if (!items[i].name.equals("B-DAWG Keychain")) {
                                    items[i].quality = items[i].quality - 1;
                                }
                            }
                        } else {
                            items[i].quality = items[i].quality - items[i].quality;
                        }
                    } else {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }
        }
    }
}