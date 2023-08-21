package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.ArmorType;
import noroff.gjrtsn.enumerators.Slot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmorTests {

    @Test
    public void armorCreationTest() {
        // Setting the armor attributes
        HeroAttribute armorAttributes = new HeroAttribute(1, 0, 0);

        // Creating a new Armor with the set attributes
        Armor plate = new Armor("Common Plate Chest", 1, Slot.BODY, ArmorType.PLATE, armorAttributes);

        String name = plate.getName();
        String slot = String.valueOf(plate.getSlot());
        String type = String.valueOf(plate.getArmorType());
        int reqlvl = plate.getRequiredLevel();
        int s = plate.getArmorAttribute().getStrength();
        int d = plate.getArmorAttribute().getDexterity();
        int i = plate.getArmorAttribute().getIntelligence();

        // Expecting the armor to have the  attributes set
        String expected = "The Common Plate Chest requires level 1, is made of PLATE, is put on BODY, and gives: Strength = 1, Dexterity = 0, Intelligence = 0";
        String actual = "The " + name + " requires level " + reqlvl + ", is made of " + type + ", is put on " + slot + ", and gives: " + "Strength = " + s + ", Dexterity = " + d + ", Intelligence = " + i;

        assertEquals(expected, actual);
    }
}