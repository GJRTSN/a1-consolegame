package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarbarianTests {
       @Test
        public void barbarianCreationTest() {

        // Create new hero
        Hero barbarian = new Barbarian("Arminius");

        // Get hero attributes
        int s = barbarian.getTotalAttributes().getStrength();
        int d = barbarian.getTotalAttributes().getDexterity();
        int i = barbarian.getTotalAttributes().getIntelligence();
        int l = barbarian.getLevel();
        String name = barbarian.getName();

        // Setting the Barbarian name, level and starting attributes as expected results
        String expected = "Arminius is at level 1, their attributes are: Strength = 5, Dexterity = 2, Intelligence = 1";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);
    }

    @Test
    public void barbarianLevelUpTest() {

        // Create new hero
        Hero barbarian = new Barbarian("Attila");

        // Trigger the level-up
        barbarian.levelUp();

        // Get hero attributes after level-up
        int s = barbarian.getTotalAttributes().getStrength();
        int d = barbarian.getTotalAttributes().getDexterity();
        int i = barbarian.getTotalAttributes().getIntelligence();
        int l = barbarian.getLevel();
        String name = barbarian.getName();

        // Setting the Barbarian name, new level and starting attributes (5, 2, 1) + 1x level-up gain (3, 2, 1) as expected results
        String expected = "Attila is at level 2, their attributes are: Strength = 8, Dexterity = 4, Intelligence = 2";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);
    }

}





