package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.Slot;

public abstract class Item {

    // Name of item being equipped by hero
    private String name;

    // Required level for hero to equip item (int because level will only be whole numbers)
    private int requiredLevel;

    //Slot where item is equipped
    private Slot slot;


    // GETTER and SETTER for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    // GETTER and SETTER for required level
    public int getRequiredLevel() {
        return requiredLevel;
    }
    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }


    // GETTER and SETTER for slot
    public Slot getSlot() {
        return slot;
    }
    public void setSlot(Slot slot) {
        this.slot = slot;
    }


    // Constructor for initializing an Item
    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }
}
