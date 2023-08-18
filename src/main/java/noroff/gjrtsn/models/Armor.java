package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.Slot;
import noroff.gjrtsn.enumerators.ArmorType;

public class Armor extends Item{

    // Declaring type of armor
    private ArmorType armorType;
    // Declaring attributes that armor gives
    private HeroAttribute armorAttribute;


    // GETTER and SETTER for type of armor
    public ArmorType getArmorType() {
        return armorType;
    }
    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    // GETTER and SETTER for armor attributes
    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }
    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }


    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {

        // Calling parent constructor
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }


}
