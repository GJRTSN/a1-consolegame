package noroff.gjrtsn.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTests {
    @Test
    public void archerCreationTest() {

        // Create new hero
        Hero archer = new Archer("Kim");

        // Get hero attributes
        int s = archer.getTotalAttributes().getStrength();
        int d = archer.getTotalAttributes().getDexterity();
        int i = archer.getTotalAttributes().getIntelligence();
        int l = archer.getLevel();
        String name = archer.getName();

        // Setting the Archer name, level and starting attributes as expected results
        String expected = "Kim is at level 1, their attributes are: Strength = 1, Dexterity = 7, Intelligence = 1";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);
    }

    @Test
    public void archerLevelUpTest() {

        // Create new hero
        Hero archer = new Archer("Ferguson");

        // Trigger the level-up
        archer.levelUp();

        // Get hero attributes after level-up
        int s = archer.getTotalAttributes().getStrength();
        int d = archer.getTotalAttributes().getDexterity();
        int i = archer.getTotalAttributes().getIntelligence();
        int l = archer.getLevel();
        String name = archer.getName();

        // Setting the Archer name, new level and starting attributes (1, 7, 1) + 1x level-up gain (1, 5, 1) as expected results
        String expected = "Ferguson is at level 2, their attributes are: Strength = 2, Dexterity = 12, Intelligence = 2";
        String actual = String.format("%s is at level %d, their attributes are: Strength = %d, Dexterity = %d, Intelligence = %d",
                name, l, s, d, i);

        assertEquals(expected, actual);
    }
}







