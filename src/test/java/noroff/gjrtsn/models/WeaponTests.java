package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.ArmorType;
import noroff.gjrtsn.enumerators.Slot;
import noroff.gjrtsn.enumerators.WeaponType;
import noroff.gjrtsn.exceptions.InvalidArmorException;
import noroff.gjrtsn.exceptions.InvalidWeaponException;
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

    @Test
    public void noWeaponDamageTest() {

        // Creating hero to test for damage
        Hero archer = new Archer("Cpt. Lennox");

        // Total hero damage = WeaponDamage * (1 + DamagingAttribute/100)

        // WeaponDamage = 1 if no weapon)
        double weaponDamage = 1;

        // Archer's damaging attribute is Dexterity which is 7 by default
        double damagingAttribute = 7;

        // Calculating what the damage should be in this scenario (with no weapon)
        double expectedDamage = weaponDamage * (1 + damagingAttribute/100);

        assertEquals(expectedDamage, archer.calculateDamage());
    }

    @Test
    public void weaponDamageTest() throws InvalidWeaponException {

        // Creating hero to test for damage
        Hero archer = new Archer("Cpt. Lennox");

        // Create weapon for hero to equip
        Weapon bow = new Weapon("Snowpiercer", 1, WeaponType.BOW, 7);

        // Equipping hero with weapon
        archer.equipWeapon(bow);

        // get weaponDamage we set for Bow
        double weaponDamage = bow.getWeaponDamage();

        // Archer's damaging attribute is Dexterity which is 7 by default
        double damagingAttribute = 7;

        // Calculating what the damage should be in this scenario (with no weapon)
        double expectedDamage = weaponDamage * (1 + damagingAttribute/100);

        assertEquals(expectedDamage, archer.calculateDamage());
    }

    @Test
    public void weaponReplacedDamageTest() throws InvalidWeaponException {

        // Creating hero to test for damage
        Hero barbarian = new Barbarian("Dave");

        // Create weapon for hero to equip
        Weapon mace = new Weapon("Sharp stick", 1, WeaponType.MACE, 4);

        // Create 2nd weapon for hero to replace 1st weapon with
        Weapon sword = new Weapon("Danger blade", 1, WeaponType.SWORD, 12);

        // Equipping hero with weapon
        barbarian.equipWeapon(mace);

        // Replacing first weapon
        barbarian.equipWeapon(sword);

        // get weaponDamage from 2nd weapon
        double weaponDamage = sword.getWeaponDamage();

        // Barbarian's damaging attribute is Strength which is 5 by default
        double damagingAttribute = 5;

        // Calculating what the damage should be in this scenario (with replaced weapon)
        double expectedDamage = weaponDamage * (1 + damagingAttribute/100);

        assertEquals(expectedDamage, barbarian.calculateDamage());
    }

    @Test
    public void fullyEquippedDamageTest() throws InvalidArmorException, InvalidWeaponException {
        // Creating hero to test for damage
        Hero barbarian = new Barbarian("Dave");

        // Create weapon for hero to equip
        Weapon hatchet = new Weapon("Dinnertime", 1, WeaponType.HATCHET, 18);

        // Set attributes for upcoming armor
        HeroAttribute armorAttributes = new HeroAttribute(15, 1, 0);

        //Create armor for hero to equip
        Armor plate = new Armor("1st gen iPad",1, Slot.BODY, ArmorType.PLATE, armorAttributes);

        // Equipping weapon and armor
        barbarian.equipWeapon(hatchet);
        barbarian.equipArmor(plate);

        // get weaponDamage from second weapon
        double weaponDamage = hatchet.getWeaponDamage();

        // Barbarian's damaging attribute is Strength which is 5 by default, and the armor brings 15 more
        double damagingAttribute = 5 + armorAttributes.getStrength();

        // Calculating what the damage should be in this scenario (with weapon and armor)
        double expectedDamage = weaponDamage * (1 + damagingAttribute/100);

        assertEquals(expectedDamage, barbarian.calculateDamage());
    }


}