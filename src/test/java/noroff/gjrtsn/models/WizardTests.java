package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WizardTests {
    @Test
    public void wizardCreationTest() {

        // Create new hero
        Hero wizard = new Wizard("Severus");

        // Get hero attributes
        int s = wizard.getTotalAttributes().getStrength();
        int d = wizard.getTotalAttributes().getDexterity();
        int i = wizard.getTotalAttributes().getIntelligence();
        int l = wizard.getLevel();
        String name = wizard.getName();

        // Setting the Wizard name, level and starting attributes as expected results
        String expected = "Severus is at level 1, their attributes are: Strength = 1, Dexterity = 1, Intelligence = 8";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);
    }

    @Test
    public void wizardLevelUpTest() {

        // Create new hero
        Hero wizard = new Wizard("Dumbledore");

        // Trigger the level-up
        wizard.levelUp();

        // Get hero attributes after level-up
        int s = wizard.getTotalAttributes().getStrength();
        int d = wizard.getTotalAttributes().getDexterity();
        int i = wizard.getTotalAttributes().getIntelligence();
        int l = wizard.getLevel();
        String name = wizard.getName();

        // Setting the Wizard name, new level and starting attributes (1, 1, 8) + 1x level-up gain (1, 1, 5) as expected results
        String expected = "Dumbledore is at level 2, their attributes are: Strength = 2, Dexterity = 2, Intelligence = 13";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);
    }
}







