package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.ArmorType;
import noroff.gjrtsn.enumerators.Slot;
import noroff.gjrtsn.enumerators.WeaponType;
import noroff.gjrtsn.exceptions.InvalidArmorException;
import noroff.gjrtsn.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeroClassTests {

    @Test
    public void heroWeaponEquippingTest() throws InvalidWeaponException {

        // Creating a hero to equip a weapon
        Hero barbarian = new Barbarian("Genseric");

        // Creating a weapon for the hero to equip
        Weapon mace = new Weapon("Common Mace", 1, WeaponType.MACE, 1);

        // Trigger the equipping
        barbarian.equipWeapon(mace);

        // Expect that the equipped weapon is the mace that's created
        assertEquals(mace, barbarian.getEquippedWeapon());
    }

    @Test
    public void heroWeaponEquippingLevelFailTest() {

        // Creating a hero to equip the weapon
        Hero barbarian = new Barbarian("Genseric");

        // Creating a weapon for the hero to fail to equip duo to level requirement
        Weapon sword = new Weapon("Excalibur", 100, WeaponType.SWORD, 9001);

        // Expect that InvalidWeaponException is thrown when we try to equip the weapon
        assertThrows(InvalidWeaponException.class, () -> {
            // Trigger the equipping
            barbarian.equipWeapon(sword);
        });
    }

    @Test
    public void heroWeaponEquippingTypeFailTest() {

        // Creating a hero to equip the weapon
        Hero barbarian = new Barbarian("Genseric");

        // Creating a weapon for the hero to fail to equip due to invalid weapon type
        Weapon wand = new Weapon("Hollywand", 1, WeaponType.WAND, 1);

        // Expect that InvalidWeaponException is thrown when we try to equip the weapon
        assertThrows(InvalidWeaponException.class, () -> {
            // Trigger the equipping
            barbarian.equipWeapon(wand);
        });
    }

    @Test
    public void heroArmorEquippingTest() throws InvalidArmorException {

        // Creating a hero to equip a weapon
        Hero archer = new Archer("Ellison");

        // Create attributes for our new armor
        HeroAttribute armorAttributes = new HeroAttribute(2, 0, 0);

        // Creating armor for the hero to fail to equip due to invalid weapon type
        Armor mail = new Armor("Rusty Mail", 1, Slot.BODY, ArmorType.MAIL, armorAttributes);

        // Trigger the equipping
        archer.equipArmor(mail);

        // Expect that the equipped weapon is the mace that's created
        assertEquals(mail, archer.getEquippedArmor(Slot.BODY));
    }

    @Test
    public void heroArmorEquippingLevelFailTest() {

        // Creating a hero to equip the armor
        Hero archer = new Archer("Ellison");

        // Creating armor for the hero with correct type, but fail to equip due to level requirement
        HeroAttribute armorAttributes = new HeroAttribute(2, 0, 0);
        Armor leather = new Armor("Leather Face Shield", 100, Slot.HEAD, ArmorType.LEATHER, armorAttributes);

        // Expect that InvalidArmorException is thrown when we try to equip the armor
        assertThrows(InvalidArmorException.class, () -> {
            // Trigger the equipping
            archer.equipArmor(leather);
        });
    }

    @Test
    public void heroArmorEquippingTypeFailTest() {

        // Creating a hero to equip the armor
        Hero archer = new Archer("Ellison");

        // Creating armor for the hero to fail to equip due to invalid armor type
        HeroAttribute armorAttributes = new HeroAttribute(2, 0, 0);
        Armor plate = new Armor("European Plate", 1, Slot.BODY, ArmorType.PLATE, armorAttributes);

        // Expect that InvalidArmorException is thrown when we try to equip the armor
        assertThrows(InvalidArmorException.class, () -> {
            // Trigger the equipping
            archer.equipArmor(plate);
        });
    }






}
