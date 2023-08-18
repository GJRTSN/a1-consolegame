package noroff.gjrtsn.models;

public class HeroAttribute {

    // Declaring strength attribute
    private int strength;
    // Declaring dexterity attribute
    private int dexterity;
    // Declaring intelligence attribute
    private int intelligence;


    // GETTER and SETTER for strength attribute
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // GETTER and SETTER for dexterity attribute
    public int getDexterity() {
        return dexterity;
    }
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    // GETTER and SETTER for intelligence attribute
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    // Constructor for initializing hero attributes
    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public HeroAttribute add(HeroAttribute other) {
        return new HeroAttribute(
                this.strength + other.strength,
                this.dexterity + other.dexterity,
                this.intelligence + other.intelligence
        );
    }
}
