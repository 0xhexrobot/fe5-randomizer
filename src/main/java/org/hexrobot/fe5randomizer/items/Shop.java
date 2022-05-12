package org.hexrobot.fe5randomizer.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.util.GenericDiff;

public enum Shop {
    BATTLE_PREPS(0X29D6B, "Battle Preps"),
    CH1_VENDOR(0X18FD5D, "Ch1 Vendor"),
    CH2_VENDOR(0X18FB27, "Ch2 Vendor"),
    CH3_VENDOR(0X18F65D, "Ch3 Vendor"),
    CH6_VENDOR(0X18E663, "Ch6 Vendor"),
    CH6_ARMORY(0X18E675, "Ch6 Armory"),
    CH7_VENDOR(0X18E21A, "Ch7 Vendor"),
    CH8_VENDOR(0X18DE8B, "Ch8 Vendor"),
    CH8_ARMORY(0X18DE79, "Ch8 Armory"),
    CH9_VENDOR(0X18D841, "Ch9 Vendor"),
    CH9_ARMORY(0X18D82F, "Ch9 Armory"),
    CH10_VENDOR(0X18D4F8, "Ch10 Vendor"),
    CH10_ARMORY(0X18D4E6, "Ch10 Armory"),
    CH12_VENDOR(0X18CA23, "Ch12 Vendor"),
    CH14_VENDOR(0X18BFBE, "Ch14 Vendor"),
    CH14_ARMORY(0X18BFAC, "Ch14 Armory"),
    CH15_VENDOR(0X18B6EE, "Ch15 Vendor"),
    CH17A_VENDOR(0X18AE24, "Ch17A Vendor"),
    CH17A_ARMORY(0X18AE36, "Ch17A Armory"),
    CH17B_VENDOR(0X18A6EA, "Ch17B Vendor"),
    CH17B_ARMORY(0X18A6D8, "Ch17B Armory"),
    CH20_VENDOR(0X18988B, "Ch20 Vendor"),
    CH21_VENDOR(0X189184, "Ch21 Vendor"),
    CH21_ARMORY(0X189172, "Ch21 Armory"),
    CH22_VENDOR(0X188852, "Ch22 Vendor"),
    CH22_ARMORY(0X188840, "Ch22 Armory"),
    CH24_SECRET(0XCF7A3, "Ch24 Secret");
    
    private int offset;
    private String name;
    private List<Item> items = new ArrayList<Item>();
    private Map<String, Object> oldValues = new HashMap<>();
    
    private Shop(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public int getOffset() {
        return offset;
    }
    
    public String getName() {
        return name;
    }
    
    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
    
    public void setItems(List<Item> items) {
        if(!oldValues.containsKey("items") && !this.items.equals(items)) {
            oldValues.put("items", this.items);
        }
        
        this.items = items;
    }
    
    private ArrayList<Item> getOldItems() {
    	ArrayList<Item> oldItems = new ArrayList<>();
    	List<?> items = (List<?>)oldValues.get("items");
    	
    	for(Object item: items) {
    		if(item instanceof Item) {
    			oldItems.add((Item)item);
    		}
    	}
    	
    	return oldItems;
    }
    
    public ArrayList<GenericDiff<Item>> getComparedItems() {
    	ArrayList<GenericDiff<Item>> compItems = new ArrayList<>();
    	
    	if(oldValues.containsKey("items")) {
    		ArrayList<Item> newItems = (ArrayList<Item>) getItems();
    		ArrayList<Item> oldItems = getOldItems();
    		
    		while(!newItems.isEmpty()) {
    			Item newItem = newItems.remove(0);
    			
    			if(oldItems.contains(newItem)) {
    				compItems.add(new GenericDiff<Item>(newItem, 0));
    				oldItems.remove(newItem);
    			} else {
    				compItems.add(new GenericDiff<Item>(newItem, 1));
    			}
    		}
    		
    		while(!oldItems.isEmpty()) {
    			Item oldItem = oldItems.remove(0);
    			compItems.add(new GenericDiff<Item>(oldItem, -1));
    		}
    	} else {
    		for(Item item : items) {
    			compItems.add(new GenericDiff<Item>(item, 0));
    		}
    	}
    	
    	return compItems;
    }
    
    public boolean isModified() {
        return !oldValues.isEmpty();
    }
    
    public static void initializeShops(Rom rom) {      
        final int ITEM_SEP = 2;
        final int SHOP_ITEM_COUNT = 5;
        
        for(Shop shop : values()) {
            for(int i = 0; i < SHOP_ITEM_COUNT; i++) {
                int itemOffset = rom.getValueAt(shop.offset + ITEM_SEP * i);
                
                if(itemOffset == 0) {
                    break;
                }
                
                Item item = Item.findById(itemOffset - 1);
                shop.items.add(item);
            }
        }
    }
    
    public static void writeShops(Rom rom) {
        final int ITEM_SEP = 2;
        final int SHOP_ITEM_COUNT = 5;
        
        for(Shop shop : values()) {
            for(int i = 0; i < SHOP_ITEM_COUNT; i++) {
                int itemOffset = 0;
                
                if(i < shop.items.size()) {
                    itemOffset = shop.items.get(i).getOffset() + 1;
                }
                
                rom.setValueAt(shop.offset + ITEM_SEP * i, itemOffset);
            }
        }
    }
    
    private void reset() {
        if(oldValues.containsKey("items")) {
            List<?> result = (List<?>)oldValues.get("items");
            List<Item> items = new ArrayList<>();
            
            for (Object object : result) {
                if (object instanceof Item) {
                    items.add((Item) object);
                }
            }
            
            this.items = items;
        }
                
        oldValues.clear();
    }
    
    public static void resetShops() {
        for(Shop shop : values()) {
            shop.reset();
        }
    }
    
    public Map<String, Object> getOldValues() {
        return oldValues;
    }
    
    @Override
    public String toString() {
        String text = String.format("[Shop] %s Items:\n", name);
        
        for(Item item : items) {
            text += item.getName() + "\n";
        }
        
        return text;
    }
}
