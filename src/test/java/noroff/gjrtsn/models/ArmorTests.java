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
        Armor plateChest = new Armor("Common Plate Chest", 1, Slot.BODY, ArmorType.PLATE, armorAttributes);

        // Expecting the name we set
        assertEquals("Common Plate Chest", plateChest.getName());

        // Expecting the required level we set
        assertEquals(1, plateChest.getRequiredLevel());

        // Expecting the correct slot
        assertEquals(Slot.BODY, plateChest.getSlot());

        // Expecting the weapon type we set
        assertEquals(ArmorType.PLATE, plateChest.getArmorType());

        // Setting expectations for the armor attributes we set
        assertEquals(1, plateChest.getArmorAttribute().getStrength());
        assertEquals(0, plateChest.getArmorAttribute().getDexterity());
        assertEquals(0, plateChest.getArmorAttribute().getIntelligence());
    }

}