package noroff.gjrtsn.models;

import noroff.gjrtsn.enumerators.ArmorType;
import noroff.gjrtsn.enumerators.WeaponType;

import java.util.List;


public class Barbarian extends Hero {

    public Barbarian(String name) {
        super(name);

        // Setting starting attributes for Barbarian
        this.attributes = new HeroAttribute(5, 2, 1);

        // Setting valid weapons for Barbarian
        this.validWeaponTypes = List.of(WeaponType.HATCHET, WeaponType.MACE, WeaponType.SWORD);

        // Setting valid armor types for Barbarian
        this.validArmorTypes = List.of(ArmorType.MAIL, ArmorType.PLATE);
    }

    @Override
    public void levelUp() {
        // Setting the specified gain in attributes on level up for Barbarian
        HeroAttribute levelUpAttributes = new HeroAttribute(3, 2, 1);

        // Increasing attributes according to Barbarian level up logic
        this.attributes = this.attributes.add(levelUpAttributes);

        // Increasing level
        this.level++;
    }


    @Override
    // GETTER for Barbarian's attribute which contributes to total damage
    protected int getDamagingAttribute() {
        return this.getTotalAttributes().getStrength();
    }


    @Override
    // Creating display for the hero's state
    public String heroDisplay() {
        StringBuilder hero = new StringBuilder();

        // Fields for name, hero and its level
        hero.append("Name: ").append(name).append("\n");
        hero.append("Class: ").append(this.getClass().getSimpleName()).append("\n");
        hero.append("Level: ").append(level).append("\n");

        // Getting total attributes for display
        HeroAttribute totalAttr = this.getTotalAttributes();
        hero.append("Total Strength: ").append(totalAttr.getStrength()).append("\n");
        hero.append("Total Dexterity: ").append(totalAttr.getDexterity()).append("\n");
        hero.append("Total Intelligence: ").append(totalAttr.getIntelligence()).append("\n");

        /// Displaying the calculated total damage for hero
        hero.append("Damage: ").append(this.calculateDamage()).append("\n");

        return hero.toString();
    }
}