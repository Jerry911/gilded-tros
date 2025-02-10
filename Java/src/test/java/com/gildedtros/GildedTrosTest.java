package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void normalItem_degradesQuality() {
        Item item = new Item("Normal Item", 10, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }

    @Test
    void normalItem_degradesTwiceAsFastAfterSellIn() {
        Item item = new Item("Normal Item", 0, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void qualityIsNeverNegative() {
        Item item = new Item("Normal Item", 5, 0);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void goodWine_increasesInQuality() {
        Item item = new Item("Good Wine", 10, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(21, item.quality);
    }

    @Test
    void qualityIsNeverMoreThanFifty() {
        Item item = new Item("Good Wine", 10, 50);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void legendaryItem_doesNotChange() {
        Item item = new Item("B-DAWG Keychain", 10, 80);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(10, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    void backstagePassesForReFactor_increaseInQuality() {
        Item item = new Item("Backstage passes for Re:Factor", 10, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void backstagePassesForReFactor_increaseBy2When6To10Days() {
        Item item = new Item("Backstage passes for Re:Factor", 8, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void backstagePassesForReFactor_increaseBy3When5DaysOrLess() {
        Item item = new Item("Backstage passes for Re:Factor", 5, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void backstagePassesForReFactor_qualityBecomes0WhenSellInIs0OrLess() {
        Item item = new Item("Backstage passes for Re:Factor", 0, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void backstagePasses_dropToZeroAfterEvent() {
        Item item = new Item("Backstage passes for Re:Factor", 0, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void backstagePassesForHAXX_increaseInQuality() {
        Item item = new Item("Backstage passes for HAXX", 10, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void backstagePassesForHAXX_increaseBy2When6To10Days() {
        Item item = new Item("Backstage passes for HAXX", 8, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(7, item.sellIn);
        assertEquals(22, item.quality);
    }

    @Test
    void backstagePassesForHAXX_increaseBy3When5DaysOrLess() {
        Item item = new Item("Backstage passes for HAXX", 5, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(4, item.sellIn);
        assertEquals(23, item.quality);
    }

    @Test
    void backstagePassesForHAXX_qualityBecomes0WhenSellInIs0OrLess() {
        Item item = new Item("Backstage passes for HAXX", 0, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void smellyItem_duplicateCode_degradesTwiceAsFast() {
        Item item = new Item("Duplicate Code", 10, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void smellyItem_longMethods_degradesTwiceAsFast() {
        Item item = new Item("Long Methods", 10, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    void smellyItem_uglyVariableNames_degradesTwiceAsFast() {
        Item item = new Item("Ugly Variable Names", 10, 20);
        GildedTros gildedTros = new GildedTros(new Item[]{item});

        gildedTros.updateQuality();

        assertEquals(9, item.sellIn);
        assertEquals(18, item.quality);
    }

}
