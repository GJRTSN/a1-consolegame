package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.Slot;
import noroff.gjrtsn.enumerators.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTests {

    @Test
    public void weaponCreationTest() {

        // Creating a new weapon
        Weapon hatchet = new Weapon("Common Hatchet", 1, WeaponType.HATCHET, 2);

        // Expecting the name we set
        assertEquals("Common Hatchet", hatchet.getName());

        // Expecting the required level we set
        assertEquals(1, hatchet.getRequiredLevel());

        // Expecting the correct slot
        assertEquals(Slot.WEAPON, hatchet.getSlot());

        // Expecting the weapon type we set
        assertEquals(WeaponType.HATCHET, hatchet.getWeaponType());

        // Expecting the weapon damage we set
        assertEquals(2, hatchet.getWeaponDamage());

    }

}