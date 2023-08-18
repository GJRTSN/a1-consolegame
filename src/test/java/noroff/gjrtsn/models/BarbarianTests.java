package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarbarianTests {
    @Test
    public void barbarianCreationTest() {
        // Testing for the name we set, the default starting level, and the correct attributes
        Hero barbarian = new Barbarian("Arminius");
        assertEquals("Arminius", barbarian.getName());
        assertEquals(1, barbarian.getLevel());

        // Setting the Barbarian starting attributes as expected results
        assertEquals(5, barbarian.getTotalAttributes().getStrength());
        assertEquals(2, barbarian.getTotalAttributes().getDexterity());
        assertEquals(1, barbarian.getTotalAttributes().getIntelligence());
    }

    @Test
    public void barbarianLevelUpTest() {
        Hero barbarian = new Barbarian("Attila");

        // Getting the Barbarian's starting attributes
        int startingStrength = barbarian.getTotalAttributes().getStrength();
        int startingDexterity = barbarian.getTotalAttributes().getDexterity();
        int startingIntelligence = barbarian.getTotalAttributes().getIntelligence();

        // Trigger the level up
        barbarian.levelUp();

        // Expecting the Barbarian to be at level 2 after levelUp
        assertEquals(2, barbarian.getLevel());

        // Expecting the attributes to increase by correct amounts for the Barbarian hero at levelUp
        assertEquals(startingStrength + 3, barbarian.getTotalAttributes().getStrength());
        assertEquals(startingDexterity + 2, barbarian.getTotalAttributes().getDexterity());
        assertEquals(startingIntelligence + 1, barbarian.getTotalAttributes().getIntelligence());
    }

}





