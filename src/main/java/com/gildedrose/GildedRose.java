package com.gildedrose;

class GildedRose {
    Item[] items;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured Mana Cake";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    
    private static final int qualiteMax = 50;
    private static final int qualiteMin = 0;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
    	for (int i = 0; i < items.length; i++) {
    		switch(items[i].name) {
    		  case AGED_BRIE:
    			items[i].sellIn -= 1;
  				
  			increaseDecreaseQuality(items[i],1);
  			if (items[i].sellIn < 0) {
  				increaseDecreaseQuality(items[i],1);
  			}
    		    break;
    		  case BACKSTAGE:
    			items[i].sellIn -= 1;
					
    			increaseDecreaseQuality(items[i],1);
			if (items[i].sellIn < 11) {
				increaseDecreaseQuality(items[i],1);
                	}

                	if (items[i].sellIn < 6) {
                    		increaseDecreaseQuality(items[i],1);
                	}
						
			if (items[i].sellIn < 0) {
				items[i].quality = 0;
			}
				
    		    break;
    		  case CONJURED:
    			items[i].sellIn -= 1;
    			
			increaseDecreaseQuality(items[i],-2);
			if (items[i].sellIn < 0) {
				increaseDecreaseQuality(items[i],-2);
			}
      		    break;
    		  case SULFURAS:
      		    // Aucune action
      		    break;
    		  default:
    			items[i].sellIn -= 1;
    			
			increaseDecreaseQuality(items[i],-1);
			if (items[i].sellIn < 0) {
				increaseDecreaseQuality(items[i],-1);
			}
    		}
        }
    }
    
    public void increaseDecreaseQuality(Item item, int value) {
    	item.quality = Math.min(Math.max((item.quality + value), qualiteMin), qualiteMax);
    }
}
