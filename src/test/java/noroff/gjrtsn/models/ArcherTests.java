package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTests {
    @Test
    public void archerCreationTest() {
        // Testing for the name we set, the default starting level, and the correct attributes
        Hero archer = new Archer("Kim");
        assertEquals("Kim", archer.getName());
        assertEquals(1, archer.getLevel());

        // Setting the Archer starting attributes as expected results
        assertEquals(1, archer.getTotalAttributes().getStrength());
        assertEquals(7, archer.getTotalAttributes().getDexterity());
        assertEquals(1, archer.getTotalAttributes().getIntelligence());
    }

    @Test
    public void archerLevelUpTest() {
        Hero archer = new Archer("Ferguson");

        // Getting the Archer's starting attributes
        int startingStrength = archer.getTotalAttributes().getStrength();
        int startingDexterity = archer.getTotalAttributes().getDexterity();
        int startingIntelligence = archer.getTotalAttributes().getIntelligence();

        // Trigger the level up
        archer.levelUp();

        // Expecting the Archer to be at level 2 after levelUp
        assertEquals(2, archer.getLevel());

        // Expecting the attributes to increase by correct amounts for the Archer hero at levelUp
        assertEquals(startingStrength + 1, archer.getTotalAttributes().getStrength());
        assertEquals(startingDexterity + 5, archer.getTotalAttributes().getDexterity());
        assertEquals(startingIntelligence + 1, archer.getTotalAttributes().getIntelligence());
    }
}







