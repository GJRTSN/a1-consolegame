package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.ArmorType;
import noroff.gjrtsn.enumerators.Slot;
import noroff.gjrtsn.exceptions.InvalidArmorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroAttributeTests {

    @Test
    public void noArmorAttributeTest() {

        // Create new hero
        Hero archer = new Archer("Ellison");

        // Get attributes from hero
        HeroAttribute totalAttributes = archer.getTotalAttributes();

        // Archer's base attributes (1, 7, 1)
        String expectedAttributes = "Strength: 1, Dexterity: 7, Intelligence: 1";
        String actualAttributes = "Strength: " + totalAttributes.getStrength() + ", Dexterity: " + totalAttributes.getDexterity() + ", Intelligence: " + totalAttributes.getIntelligence();

        assertEquals(expectedAttributes, actualAttributes);
    }


    @Test
    public void oneArmorAttributeTest() throws InvalidArmorException {

        // Create new hero
        Hero archer = new Archer("Ellison");

        // Set attributes for first armor
        HeroAttribute leatherAttributes = new HeroAttribute(5, 2, 0);
        // Create armor
        Armor leatherArmor = new Armor("Used leather armor", 1, Slot.BODY, ArmorType.LEATHER, leatherAttributes);

        // Equip hero with armor
        archer.equipArmor(leatherArmor);

        // Get hero attributes after equip
        HeroAttribute totalAttributes = archer.getTotalAttributes();

        // Archer's default attributes (1,7,1) + leatherArmor (5,2,0) = (6,9,1)
        String expectedAttributes = "Strength: 6, Dexterity: 9, Intelligence: 1";
        String actualAttributes = "Strength: " + totalAttributes.getStrength() + ", Dexterity: " + totalAttributes.getDexterity() + ", Intelligence: " + totalAttributes.getIntelligence();

        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    public void twoArmorAttributeTest() throws InvalidArmorException {

        // Create new hero
        Hero archer = new Archer("Ellison");

        // Set attributes for first armor
        HeroAttribute leatherAttributes = new HeroAttribute(5, 2, 0);
        // Create first armor
        Armor leatherArmor = new Armor("Used leather armor", 1, Slot.BODY, ArmorType.LEATHER, leatherAttributes);

        // Set attributes for second armor
        HeroAttribute helmetAttributes = new HeroAttribute(18, 1, 1);
        // Create second armor
        Armor leatherHelmet = new Armor("Worn leather helmet", 1, Slot.HEAD, ArmorType.LEATHER, helmetAttributes);

        // Equip both armors
        archer.equipArmor(leatherArmor);
        archer.equipArmor(leatherHelmet);

        // Get hero attributes after equipping 2 slots with armor
        HeroAttribute totalAttributes = archer.getTotalAttributes();

        // Archer's default attributes (1,7,1) + Armor (5,2,0) + Helmet (18,1,1) = (24,10,2)
        String expectedAttributes = "Strength: 24, Dexterity: 10, Intelligence: 2";
        String actualAttributes = "Strength: " + totalAttributes.getStrength() + ", Dexterity: " + totalAttributes.getDexterity() + ", Intelligence: " + totalAttributes.getIntelligence();

        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    public void replacedArmorAttributeTest() throws InvalidArmorException {

        // Create new hero
        Hero archer = new Archer("Ellison");

        // Set attributes for first armor
        HeroAttribute leatherAttributes = new HeroAttribute(5, 2, 0);
        // Create first armor
        Armor leatherArmor = new Armor("Used leather armor", 1, Slot.BODY, ArmorType.LEATHER, leatherAttributes);

        // Set attributes for second armor
        HeroAttribute mailAttributes = new HeroAttribute(2, 5, 1);
        // Create second armor
        Armor mailArmor = new Armor("New Mail", 1, Slot.BODY, ArmorType.MAIL, mailAttributes);

        // Equip first armor
        archer.equipArmor(leatherArmor);
        // Replace first armor in same slot
        archer.equipArmor(mailArmor);

        // Get hero attributes after replacing armor
        HeroAttribute totalAttributes = archer.getTotalAttributes();

        // Archer's default attributes (1,7,1) + New Mail (2,5,1) = (3,12,2)
        String expectedAttributes = "Strength: 3, Dexterity: 12, Intelligence: 2";
        String actualAttributes = "Strength: " + totalAttributes.getStrength() + ", Dexterity: " + totalAttributes.getDexterity() + ", Intelligence: " + totalAttributes.getIntelligence();

        assertEquals(expectedAttributes, actualAttributes);
    }
}