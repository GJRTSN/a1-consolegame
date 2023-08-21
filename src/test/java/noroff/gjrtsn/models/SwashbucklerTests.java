package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwashbucklerTests {
    @Test
    public void swashbucklerCreationTest() {

        // Create new hero
        Hero swashbuckler = new Swashbuckler("Baltazar");

        // Get hero attributes
        int s = swashbuckler.getTotalAttributes().getStrength();
        int d = swashbuckler.getTotalAttributes().getDexterity();
        int i = swashbuckler.getTotalAttributes().getIntelligence();
        int l = swashbuckler.getLevel();
        String name = swashbuckler.getName();

        // Setting the Swashbuckler name, level and starting attributes as expected results
        String expected = "Baltazar is at level 1, their attributes are: Strength = 2, Dexterity = 6, Intelligence = 1";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);


    }

    @Test
    public void swashbucklerLevelUpTest() {

        // Create new hero
        Hero swashbuckler = new Swashbuckler("Sparrow");

        // Trigger the level-up
        swashbuckler.levelUp();

        // Get hero attributes after level-up
        int s = swashbuckler.getTotalAttributes().getStrength();
        int d = swashbuckler.getTotalAttributes().getDexterity();
        int i = swashbuckler.getTotalAttributes().getIntelligence();
        int l = swashbuckler.getLevel();
        String name = swashbuckler.getName();

        // Setting the Swashbuckler name, new level and starting attributes (2, 6, 1) + 1x level-up gain (1, 4, 1) as expected results
        String expected = "Sparrow is at level 2, their attributes are: Strength = 3, Dexterity = 10, Intelligence = 2";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);


    }

}





