package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwashbucklerTests {
    @Test
    public void swashbucklerCreationTest() {
        // Testing for the name we set, the default starting level, and the correct attributes
        Hero swashbuckler = new Swashbuckler("Baltazar");
        assertEquals("Baltazar", swashbuckler.getName());
        assertEquals(1, swashbuckler.getLevel());

        // Setting the Swashbuckler starting attributes as expected results
        assertEquals(2, swashbuckler.getTotalAttributes().getStrength());
        assertEquals(6, swashbuckler.getTotalAttributes().getDexterity());
        assertEquals(1, swashbuckler.getTotalAttributes().getIntelligence());
    }

    @Test
    public void swashbucklerLevelUpTest() {
        Hero swashbuckler = new Swashbuckler("Sparrow");

        // Getting the Swashbuckler's starting attributes
        int startingStrength = swashbuckler.getTotalAttributes().getStrength();
        int startingDexterity = swashbuckler.getTotalAttributes().getDexterity();
        int startingIntelligence = swashbuckler.getTotalAttributes().getIntelligence();

        // Trigger the level up
        swashbuckler.levelUp();

        // Expecting the Swashbuckler to be at level 2 after levelUp
        assertEquals(2, swashbuckler.getLevel());

        // Expecting the attributes to increase by correct amounts for the Swashbuckler hero at levelUp
        assertEquals(startingStrength + 1, swashbuckler.getTotalAttributes().getStrength());
        assertEquals(startingDexterity + 4, swashbuckler.getTotalAttributes().getDexterity());
        assertEquals(startingIntelligence + 1, swashbuckler.getTotalAttributes().getIntelligence());
    }

}





