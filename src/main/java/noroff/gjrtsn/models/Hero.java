package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.ArmorType;
import noroff.gjrtsn.enumerators.Slot;
import noroff.gjrtsn.enumerators.WeaponType;
import noroff.gjrtsn.exceptions.InvalidArmorException;
import noroff.gjrtsn.exceptions.InvalidWeaponException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {
    // Name for the hero
    protected String name;

    // Current level for the hero
    protected int level;

    // Starting attributes for hero
    protected HeroAttribute attributes;

    // Weapon equipped by hero
    protected Weapon equippedWeapon;

    // Armor quipped by hero
    protected Map<Slot, Armor> equippedArmor;

    // Allowed weapon types for hero
    protected List<WeaponType> validWeaponTypes;

    // Allowed armor types for hero
    protected List<ArmorType> validArmorTypes;

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        // Setting temporary attribute levels
        this.attributes = new HeroAttribute(1, 1, 1);
        this.equippedArmor = new HashMap<>();
        // Initialize each slot with null values / empty slots
        for (Slot slot : Slot.values()) {
            equippedArmor.put(slot, null);
        }
    }

    // Method for leveling up, overridden in subclasses
    public abstract void levelUp();


    public void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        // Check if the hero is allowed to equip the weapon
       if (!validWeaponTypes.contains(weapon.getWeaponType())) {
           throw new InvalidWeaponException("You cannot equip this weapon!");
          }
        // Check if the hero is at high enough level to equip the weapon
        if (this.level < weapon.getRequiredLevel()) {
            throw new InvalidWeaponException("You need to level up before equipping this weapon!");
        }
        // Equipping weapon if both requirements are met
        this.equippedWeapon = weapon;
    }

    public void equipArmor(Armor armor) throws InvalidArmorException {
        // Check if the hero is allowed to equip the armor
        if (!validArmorTypes.contains(armor.getArmorType())) {
            throw new InvalidArmorException("You cannot equip this armor!");
        }
        // Check if the hero is at high enough level to equip the armor
        if (this.level < armor.getRequiredLevel()) {
            throw new InvalidArmorException("You need to level up before equipping this armor!");
        }
        // Equipping armor if both requirements are met
        equippedArmor.put(armor.getSlot(), armor);
    }

    // Method for calculating total hero attributes
    public HeroAttribute getTotalAttributes() {
        HeroAttribute total = new HeroAttribute(
                this.attributes.getStrength(),
                this.attributes.getDexterity(),
                this.attributes.getIntelligence()
        );

        for (Armor armor : equippedArmor.values()) {
            if (armor != null) { // Checking if the armor slot is not null
                total = total.add(armor.getArmorAttribute());
            }
        }
        return total;
    }

    // Method for getting hero damage attribute, overridden in subclasses
    protected abstract int getDamagingAttribute();


    // Calculating a hero's total damage
    public double calculateDamage() {
        int weaponDamage = (equippedWeapon != null) ? equippedWeapon.getWeaponDamage() : 1;
        int damagingAttribute = getDamagingAttribute();
        return weaponDamage * (1 + (double)damagingAttribute/100);
    }

    // Creating display for the hero's state
    public String heroDisplay() {
        StringBuilder hero = new StringBuilder();

        // Fields for name, hero and its level
        hero.append("Name: ").append(name).append("\n");
        hero.append("Class: ").append(this.getClass().getSimpleName()).append("\n");
        hero.append("Level: ").append(level).append("\n");

        // Getting total attributes for display
        HeroAttribute totalAttr = getTotalAttributes();
        hero.append("Total Strength: ").append(totalAttr.getStrength()).append("\n");
        hero.append("Total Dexterity: ").append(totalAttr.getDexterity()).append("\n");
        hero.append("Total Intelligence: ").append(totalAttr.getIntelligence()).append("\n");

        /// Displaying the calculated total damage for hero
        hero.append("Damage: ").append(calculateDamage()).append("\n");

        return hero.toString();
    }

    // GETTER for the hero name that is set upon creation
    public String getName() {
        return name;
    }

    // GETTER for the hero level
    public int getLevel() {
        return level;
    }

    // GETTER for equipped weapon
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    // GETTER for equipped armor
    public Armor getEquippedArmor(Slot slot) {
        return equippedArmor.get(slot);
    }
}

