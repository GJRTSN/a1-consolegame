package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WizardTests {
    @Test
    public void wizardCreationTest() {
        // Testing for the name we set, the default starting level, and the correct attributes
        Hero wizard = new Wizard("Severus");
        assertEquals("Severus", wizard.getName());
        assertEquals(1, wizard.getLevel());

        // Setting the Wizard starting attributes as expected results
        assertEquals(1, wizard.getTotalAttributes().getStrength());
        assertEquals(1, wizard.getTotalAttributes().getDexterity());
        assertEquals(8, wizard.getTotalAttributes().getIntelligence());
    }

    @Test
    public void wizardLevelUpTest() {
        Hero wizard = new Wizard("Dumbledore");

        // Getting the Wizard's starting attributes
        int startingStrength = wizard.getTotalAttributes().getStrength();
        int startingDexterity = wizard.getTotalAttributes().getDexterity();
        int startingIntelligence = wizard.getTotalAttributes().getIntelligence();

        // Trigger the level up
        wizard.levelUp();

        // Expecting the Wizard to be at level 2 after levelUp
        assertEquals(2, wizard.getLevel());

        // Expecting the attributes to increase by correct amounts for the Wizard hero at levelUp
        assertEquals(startingStrength + 1, wizard.getTotalAttributes().getStrength());
        assertEquals(startingDexterity + 1, wizard.getTotalAttributes().getDexterity());
        assertEquals(startingIntelligence + 5, wizard.getTotalAttributes().getIntelligence());
    }
}







