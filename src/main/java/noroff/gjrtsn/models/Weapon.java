package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.Slot;
import noroff.gjrtsn.enumerators.WeaponType;

public class Weapon extends Item{

    // Declaring the type of weapon
    private WeaponType weaponType;
    // Declaring damage that weapon does
    private int weaponDamage;


    // GETTER and SETTER for type of weapon
    public WeaponType getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    // GETTER and SETTER for damage value
    public int getWeaponDamage() {
        return weaponDamage;
    }
    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }


    public Weapon(String name, int requiredLevel, WeaponType weaponType, int weaponDamage) {

        // Calling parent constructor
        super(name, requiredLevel, Slot.WEAPON);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

}
