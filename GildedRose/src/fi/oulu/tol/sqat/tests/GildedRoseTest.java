package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	} 
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void agedBrieTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 10, 20));
		inn.oneDay();
		assertEquals("Failed quality for Aged Brie", 21, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setQuality(50);
		inn.oneDay();
		assertEquals("Failed quality for Aged Brie", 50, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setSellIn(0);
		inn.oneDay();
		assertEquals("Failed quality for Aged Brie", 50, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setQuality(0);
		inn.oneDay();
		assertEquals("Failed quality for Aged Brie", 2, inn.getItems().get(0).getQuality());
	}
	
	@Test
	public void sulfurasTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 10, 80));
		inn.oneDay();
		assertEquals("Failed quality for Sulfuras, Hand of Ragnaros", 80, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setSellIn(-1);
		inn.oneDay();
		assertEquals("Failed quality for Sulfuras, Hand of Ragnaros", 80, inn.getItems().get(0).getQuality());
		
	}
	
	@Test
	public void backstageTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49));
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 50, inn.getItems().get(0).getQuality());
		
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 50, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setQuality(0);
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 2, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setSellIn(5);
		inn.getItems().get(0).setQuality(49);
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 50, inn.getItems().get(0).getQuality());
		
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 50, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setQuality(0);
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 3, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setSellIn(0);
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 0, inn.getItems().get(0).getQuality());
	}
	
	@Test
	public void backstageMutantTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 21, inn.getItems().get(0).getQuality());
		inn.getItems().get(0).setSellIn(6);
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 23, inn.getItems().get(0).getQuality());
		inn.getItems().get(0).setSellIn(1);
		inn.oneDay();
		assertEquals("Failed quality for Backstage passes", 26, inn.getItems().get(0).getQuality());
		
	}
	
	@Test
	public void basicDrinkTest() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Basic drink", 0, 10));
		inn.oneDay();
		assertEquals("Failed quality for basic drink", 8, inn.getItems().get(0).getQuality());
		assertEquals("Failed SellIn for basic drink", -1, inn.getItems().get(0).getSellIn());
		
		inn.getItems().get(0).setQuality(-1);
		inn.oneDay();
		assertEquals("Failed quality for basic drink", -1, inn.getItems().get(0).getQuality());
		
		inn.getItems().get(0).setQuality(0);
		inn.oneDay();
		assertEquals("Failed quality for basic drink", 0, inn.getItems().get(0).getQuality());
	}
	
	@Test
	public void mainTest() {
		GildedRose.main(null);
	}
}
