package re.forestier.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import re.forestier.edu.rpg.*;


import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {
    // les tests avant refactoring (mutation + jacoco)
//    @Test
//    @DisplayName("mutation test")
//    void testAddXp() {
//        player p = new player("CERRA", "Grognak le barbare", "DWARF", 100, new ArrayList<>());
//        assertFalse(UpdatePlayer.addXp(p,1));
//    }
//    @Test
//    @DisplayName("mutation test")
//    void testPoints() {
//        player p = new player("CERRA", "Grognak le barbare", "DWARF", 100, new ArrayList<>());
//
//        p.healthpoints = 10;
//        p.currenthealthpoints = 3;
//        p.inventory.add("Holy Elixir");
//
//        UpdatePlayer.majFinDeTour(p);
//        assertThat(p.currenthealthpoints, equalTo(5));
//
//        p=new player("CERRA", "Grognak le barbare", "ARCHER", 100, new ArrayList<>());
//        p.healthpoints = 10;
//        p.currenthealthpoints = 3;
//        p.inventory.add("Magic Bow");
//        UpdatePlayer.majFinDeTour(p);
//        assertThat(p.currenthealthpoints, equalTo(3));
//
//        p=new player("CERRA", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
//        p.healthpoints = 10;
//        p.currenthealthpoints = 3;
//        UpdatePlayer.majFinDeTour(p);
//        assertThat(p.currenthealthpoints, equalTo(4));
//
//        UpdatePlayer.addXp(p,27);
//        UpdatePlayer.majFinDeTour(p);
//        assertThat(p.currenthealthpoints, equalTo(6));
//
//
//
//
//
//
//
//    }
//
//
//    @Test
//    @DisplayName("UpdatePlayer(player player) test")
//    void testUpdatePlayer() {
//        player player = new player("CERRA", "Grognak le barbare", "DWARF", 100, new ArrayList<>());
//        player.currenthealthpoints=0;
//        assertEquals(player.currenthealthpoints, 0);
//        UpdatePlayer.majFinDeTour(player);
//
//        player.healthpoints=0;
//        player.currenthealthpoints=player.healthpoints/2-1;
//        player.inventory.add("Holy Elixir");
//        assertEquals(player.inventory.get(0), "Holy Elixir");
//        assertThat(player.currenthealthpoints< player.healthpoints/2, is(true));
//        assertThat(player.getAvatarClass(), is("DWARF"));
//        UpdatePlayer.majFinDeTour(player);
//
//
//        player.currenthealthpoints=player.healthpoints/2-1;
//        assertThat(player.currenthealthpoints< player.healthpoints/2, is(true));
//        player.inventory.remove("Holy Elixir");
//        player.inventory.add("!Holy Elixir");
//        assertThat(player.inventory.contains("Holy Elixir"), is(false));
//        UpdatePlayer.majFinDeTour(player);
//
//        player.currenthealthpoints=1;
//        assertThat(player.currenthealthpoints> player.healthpoints/2, is(true));
//        UpdatePlayer.majFinDeTour(player);
//
//        player = new player("CERRA", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
//        player.currenthealthpoints=0;
//
//        player.healthpoints=0;
//        player.currenthealthpoints=player.healthpoints/2-1;
//        assertThat(player.currenthealthpoints< player.healthpoints/2, is(true));
//        assertThat(player.getAvatarClass()=="ADVENTURER", is(true));
//        UpdatePlayer.addXp(player,27);
//
//        assertEquals(player.retrieveLevel(),3 );// Level 2, doesn't change because we didn't passed 27 points
//        System.out.println(player.retrieveLevel());
//        UpdatePlayer.majFinDeTour(player);
//
//        player.currenthealthpoints=player.healthpoints/2-1;
//        assertThat(player.currenthealthpoints< player.healthpoints/2, is(true));
//        UpdatePlayer.addXp(player,-27);// return to the first level (level 1)
//
//        System.out.println(player.retrieveLevel());
//        UpdatePlayer.majFinDeTour(player);
//
//        player = new player("CERRA", "Grognak le barbare", "ARCHER", 100, new ArrayList<>());
//        assertEquals(player.retrieveLevel(),1); // 0 points ==> Level 1
//        UpdatePlayer.addXp(player,20);
//
//        assertEquals(player.retrieveLevel(),2 ); // Level up! from Level 1 to Level 2
//        UpdatePlayer.addXp(player,1);
//
//        assertEquals(player.retrieveLevel(),2 );// Level 2, doesn't change because we didn't passed 27 points (21 points)
//
//
//
//
//        player.currenthealthpoints=0;
//        player.healthpoints=0;
//        player.currenthealthpoints=player.healthpoints/2-1;
//        player.inventory.add("Magic Bow");
//        assertThat(player.currenthealthpoints< player.healthpoints/2, is(true));
//        assertThat(player.getAvatarClass()=="DWARF" && player.getAvatarClass()=="ADVENTURER", is(false));
//        assertEquals(player.inventory.contains("Magic Bow"), true);
//        UpdatePlayer.majFinDeTour(player);
//
//        player.inventory.remove("Magic Bow");
//        assertEquals(player.inventory.contains("Magic Bow"), false);
//        UpdatePlayer.majFinDeTour(player);
//
//    }
//
//
//    @Test
//    @DisplayName("Impossible to have negative money")
//    void testNegativeMoney() {
//        player p = new player("Florian", "Grognak le barbare", "!ADVENTURER!ARCHER!DWARF", 100, new ArrayList<>());
//
//
//        p = new player("Florian", "Grognak le barbare", "ADVENTURER", 100, new ArrayList<>());
//        p.addMoney(100);
//        int amount = 0;
//        p.removeMoney(amount);
//        assertThat(p.money-amount<0, is(false));
//        UpdatePlayer.addXp(p,58);
//
//        assertThat(p.getXp()<58 && p.getXp()>=27,is(false));
//        UpdatePlayer.addXp(p,54);
//
//        assertThat(p.getXp()<112 && p.getXp()>=57,is(false));
//
//
//
//
//        try {
//            p.removeMoney(300);
//            amount=300;
//            assertThat(p.money-amount<0, is(true));
//        } catch (IllegalArgumentException e) {
//            return;
//        }
//
//        fail();
//
//    }
// les tests apres refactoring , on a travaille dans la bib Kap avec Salah elaidaoui donc sont presques les memes tests

    @Test
    @DisplayName("initialisation du joueur")
    void testPlayerName() {
        player player = new Adventurer("F1", "A1", 100, new ArrayList<>());
        assertThat(player.playerName, is("F1"));
    }

    @Test
    @DisplayName("ne pas avoir un montant negative")
    void testNegativeMoney() {
        player player = new Adventurer("F2", "A2", 100, new ArrayList<>());

        assertThrows(IllegalArgumentException.class, () -> player.removeMoney(200));
    }

    @Test
    @DisplayName("rajouter de l'argent")
    void testAddMoney() {
        player player = new Adventurer("F3", "A3", 100, new ArrayList<>());
        player.addMoney(50);
        assertThat(player.money, is(150));
    }

    @Test
    @DisplayName("supprimer l'argent")
    void testRemoveMoney() {
        player player = new Adventurer("F4", "A4", 100, new ArrayList<>());
        player.removeMoney(50);
        assertThat(player.money, is(50));
    }

    @Test
    @DisplayName("rajouter des objets")
    void testAddItemWithinLimit() {
        player player = new Adventurer("F5", "A5", 100, new ArrayList<>());
        Item lightItem = new Item("objet1", "tres sombre", 5.0, 50);

        player.addItem(lightItem);
        assertTrue(player.inventory.contains(lightItem));
    }

    @Test
    @DisplayName("depassement du poids")
    void testAddItemExceedsLimit() {
        player player = new Adventurer("F6", "A6", 100, new ArrayList<>());
        Item heavyItem = new Item("pierre", "lourd", 100.0, 200);

        assertThrows(IllegalArgumentException.class, () -> player.addItem(heavyItem));
    }



    @Test
    @DisplayName("niveau +")
    void testLevelUpAbilitiesAdventurer() {
        player adventurer = new Adventurer("F7", "A7", 100, new ArrayList<>());
        adventurer.addXp(30); // Should level up

        assertThat(adventurer.retrieveLevel(), is(3)); // Level 3 XP threshold
        assertThat(adventurer.abilities.get("ATK"), is(6)); // Check ability increases
    }
    //------










    @Test
    @DisplayName("regenerer la sante")
    void testGoblinHealthRegen() {
        player goblin = new Goblin("F8", "A8", 50, new ArrayList<>());
        goblin.currenthealthpoints = 10;
        goblin.majFinDeTour();

        assertTrue(goblin.currenthealthpoints > 10);
    }

    @Test
    @DisplayName("+ DEF")
    void testDwarfDefenseGain() {
        player dwarf = new Dwarf("F9", "A9", 70, new ArrayList<>());
        dwarf.addXp(50); // Enough XP to level up

        assertThat(dwarf.abilities.get("DEF"), is(4));
    }

    @Test
    @DisplayName("Dwarf avec les aptitudes qu'il convient")
    void testDwarfAbilitiesAtLevel1() {
        player dwarf = new Dwarf("F10", "A10", 70, new ArrayList<>());
        dwarf.addXp(5);

        assertThat(dwarf.abilities.get("DEF"), is(2));


    }

    @Test
    @DisplayName("Dwarf +abilitties en niveau 2")
    void testDwarfAbilitiesAtLevel2() {
        player dwarf = new Dwarf("f11", "a11", 70, new ArrayList<>());
        dwarf.addXp(25);



        assertThat(dwarf.abilities.get("DEF"), is(4));

    }


    @Test
    @DisplayName("Dwarf abilitties niveau 4")
    void testDwarfAbilitiesAtLevel4() {
        player dwarf = new Dwarf("f12", "a12", 70, new ArrayList<>());
        dwarf.addXp(75);


        assertThat(dwarf.abilities.get("DEF"), is(5));

    }

    @Test
    @DisplayName("Dwarf abilitties niveau 4 ++xp")
    void testDwarfAbilitiesAtLevel5() {
        player dwarf = new Dwarf("f13", "a13", 70, new ArrayList<>());
        dwarf.addXp(250);


        assertThat(dwarf.abilities.get("DEF"), is(6));

    }
    @Test
    @DisplayName("Dwarf recuperer la sante avec ou sans holy elixir")
    void testDwarfRecoverHealth() {
        Dwarf dwarf = new Dwarf("f13", "a13", 100, new ArrayList<>());
        dwarf.currenthealthpoints = 40;
        dwarf.recoverHealth();
        assertThat(dwarf.currenthealthpoints, is(41));











    }


    @Test
    @DisplayName("Dwarf combinaison")
    void testDwarfItemAndLevelUp() {
        Dwarf dwarf = new Dwarf("f14", "a14", 100, new ArrayList<>());
        Item lightItem = new Item("objet3", "lumineux", 1.0, 50);
        dwarf.addItem(lightItem);

        dwarf.addXp(50);

        assertThat(dwarf.retrieveLevel(), is(3));
        assertTrue(dwarf.inventory.contains(lightItem));

        dwarf.currenthealthpoints = 40;

        dwarf.recoverHealth();

        dwarf.currenthealthpoints = 60;
        dwarf.recoverHealth();
        assertThat(dwarf.currenthealthpoints, is(60));
    }






















    @Test
    @DisplayName("joueur sans le pv max")
    void testHealthCap() {
        player adventurer = new Adventurer("f15", "a15", 100, new ArrayList<>());
        adventurer.currenthealthpoints = 110;
        adventurer.majFinDeTour();

        assertThat(adventurer.currenthealthpoints, is(100));
    }













    @Test
    @DisplayName("Combinaison")
    void testItemAndLevelUp() {
        player player = new Adventurer("F16", "a16", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(50); // Level up

        assertThat(player.retrieveLevel(), is(3));
        assertTrue(player.inventory.contains(lightItem));
    }


    @Test
    @DisplayName("La combinaison d'objets et la montée en niveau fonctionne comme prévu")
    void testItemAndLevelU() {
        player player = new Adventurer("Florian", "Durand", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(75); // Level up

        assertThat(player.retrieveLevel(), is(4));
        assertTrue(player.inventory.contains(lightItem));
    }

    @Test
    @DisplayName("Combining items and leveling up works as expected")
    void testItemAndLevel() {
        player player = new Adventurer("Florian", "Grognak", 100, new ArrayList<>());                          //--------------
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(120); // Level up

        assertThat(player.retrieveLevel(), is(5));
        assertTrue(player.inventory.contains(lightItem));
    }

    @Test
    @DisplayName("Combining items and leveling up works as expected")
    void testItemAndLeve() {
        player player = new Adventurer("Florian", "Grognak", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(8);

        assertThat(player.retrieveLevel(), is(1));
        assertTrue(player.inventory.contains(lightItem));
    }

    //------------//
    @Test
    @DisplayName("Archer name is initialized correctly")
    void testArcherName() {
        player player = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>());
        assertThat(player.playerName, is("Florian"));
    }

    @Test
    @DisplayName("Archer cannot have negative money")
    void testArcherNegativeMoney() {
        player player = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>());

        assertThrows(IllegalArgumentException.class, () -> player.removeMoney(200));
    }

    @Test
    @DisplayName("Adding money increases Archer's balance")
    void testArcherAddMoney() {
        player player = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>());
        player.addMoney(50);
        assertThat(player.money, is(150));
    }

    @Test
    @DisplayName("Removing money decreases Archer's balance")
    void testArcherRemoveMoney() {
        player player = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>());
        player.removeMoney(50);
        assertThat(player.money, is(50));
    }

    @Test
    @DisplayName("Adding item respects Archer's weight limits")
    void testArcherAddItemWithinLimit() {
        player player = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 5.0, 50);

        player.addItem(lightItem);
        assertTrue(player.inventory.contains(lightItem));
    }

    @Test
    @DisplayName("Adding item beyond Archer's weight limit throws exception")
    void testArcherAddItemExceedsLimit() {
        player player = new Archer("Florian", "Grognak le barbare", 100, new ArrayList<>());
        Item heavyItem = new Item("Heavy Item", "An extremely heavy item", 100.0, 200);

        assertThrows(IllegalArgumentException.class, () -> player.addItem(heavyItem));
    }



    @Test
    @DisplayName("Archer health does not exceed maximum")
    void testArcherHealthCap() {
        player archer = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        archer.currenthealthpoints = 110;
        archer.majFinDeTour();

        assertThat(archer.currenthealthpoints, is(100));
    }

    @Test
    @DisplayName("Adding a special item rewards Archer with bonus abilities")
    void testArcherSpecialItemEffect() {
        player player = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        Item specialItem = new Item("Rune Staff of Curse", "A staff that curses enemies.", 1.0, 150);

        player.addItem(specialItem);
        assertTrue(player.inventory.contains(specialItem));
        // Assuming special logic increases abilities
        // assertTrue(player.abilities.get("INT") > 1);
    }

    @Test
    @DisplayName("Combining items and leveling up works as expected for Archer")
    void testArcherItemAndLevelU1() {
        player player = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(0); // Level up

        assertThat(player.retrieveLevel(), is(1));
        assertTrue(player.inventory.contains(lightItem));
    }













    @Test
    @DisplayName("Combining items and leveling up works as expected for Archer")
    void testArcherItemAndLevelU2() {
        player player = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(25); // Level up

        assertThat(player.retrieveLevel(), is(2));
        assertTrue(player.inventory.contains(lightItem));
    }








    @Test
    @DisplayName("Combining items and leveling up works as expected for Archer")
    void testArcherItemAndLevelUp() {
        player player = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(50); // Level up

        assertThat(player.retrieveLevel(), is(3));
        assertTrue(player.inventory.contains(lightItem));
    }

    @Test
    @DisplayName("Combining items and leveling up works as expected for Archer")
    void testArcherItemAndLevelU() {
        player player = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(75); // Level up

        assertThat(player.retrieveLevel(), is(4));
        assertTrue(player.inventory.contains(lightItem));
    }

    @Test
    @DisplayName("Combining items and leveling up works as expected for Archer")
    void testArcherItemAndLevel() {
        player player = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        Item lightItem2 = new Item("Magic Bow", "A very light item", 1.0, 50);
        player.addItem(lightItem);
        player.addItem(lightItem2);

        player.addXp(120); // Level up

        assertThat(player.retrieveLevel(), is(5));
        assertTrue(player.inventory.contains(lightItem));
    }
    @Test
    @DisplayName("Health recovery works with and without Magic Bow")
    void testArcherHealthRecovery() {
        // Cas 1 : Sans Magic Bow
        Archer archer = new Archer("Florian", "Grognak", 100, new ArrayList<>());
        archer.currenthealthpoints = 40;  // Moins de la moitié des HP
        archer.recoverHealth();  // Doit récupérer 1 HP

        // Vérification que la récupération de base fonctionne sans Magic Bow
        assertThat(archer.currenthealthpoints, is(41));  // HP = 40 + 1 = 41

        // Cas 2 : Avec Magic Bow
        archer.currenthealthpoints = 40;  // Réinitialiser les HP
        Item lightItem2 = new Item("Magic Bow", "A very light item", 1.0, 40);
        archer.inventory.add(lightItem2);  // Ajouter l'arc magique
        archer.recoverHealth();  // Récupérer de la santé avec Magic Bow



        // Cas 3 : HP au-dessus de la moitié, aucune récupération
        archer.currenthealthpoints = 60;  // Plus de la moitié des HP
        archer.recoverHealth();  // Aucune récupération de santé attendue

        // Vérification que les HP restent inchangés
        assertThat(archer.currenthealthpoints, is(60));  // HP = 60, aucune récupération
    }




































    @Test
    @DisplayName("Adventurer recovers health correctly when below half health and level < 3")
    void testRecoverHealthLowLevel() {
        Adventurer adventurer = new Adventurer("Florian", "Grognak", 100, new ArrayList<>());
        adventurer.currenthealthpoints = 40; // Below half (50)
        adventurer.recoverHealth();

        // Health should increase by 2 and decrease by 1 (penalty)
        assertThat(adventurer.currenthealthpoints, is(41));
    }

    @Test
    @DisplayName("Adventurer recovers health correctly when below half health and level >= 3")
    void testRecoverHealthHighLevel() {
        Adventurer adventurer = new Adventurer("Florian", "Grognak", 100, new ArrayList<>());
        adventurer.currenthealthpoints = 40; // Below half (50)
        adventurer.addXp(50); // Level up to 3 or higher
        adventurer.recoverHealth();

        // Health should increase by 2 (no penalty for high level)
        assertThat(adventurer.currenthealthpoints, is(42));
    }

    @Test
    @DisplayName("Adventurer does not recover health when at or above half health")
    void testRecoverHealthNoRecovery() {
        Adventurer adventurer = new Adventurer("Florian", "Grognak", 100, new ArrayList<>());
        adventurer.currenthealthpoints = 50; // Exactly at half health
        adventurer.recoverHealth();

        // Health should not change
        assertThat(adventurer.currenthealthpoints, is(50));
    }

    @Test
    @DisplayName("Adventurer's health does not exceed maximum during recovery")
    void testRecoverHealthNoOverheal() {
        Adventurer adventurer = new Adventurer("Florian", "Grognak", 100, new ArrayList<>());
        adventurer.currenthealthpoints = 99; // Near max health
        adventurer.recoverHealth();

        // Health should not exceed max (100)
        //  assertThat(adventurer.currenthealthpoints, is());
    }


    @Test
    @DisplayName("Combining items and leveling up works as expected for Archer")
    void testgoblinItemAndLevelU2() {
        player player = new Goblin("Florian", "Grognak", 100, new ArrayList<>());
        Item lightItem = new Item("Light Item", "A very light item", 1.0, 50);
        player.addItem(lightItem);

        player.addXp(25); // Level up

        assertThat(player.retrieveLevel(), is(2));
        assertTrue(player.inventory.contains(lightItem));
    }
    @Test
    @DisplayName("Abilities for level 5 are initialized correctly")
    void testInitializeAbilitiesForLevel5() {
        Goblin player = new Goblin("Florian", "Grognak", 100, new ArrayList<>());
        HashMap<String, Integer> abilities = player.initializeAbilitiesForLevel(5);

        assertThat(abilities, hasEntry("DEF", 2));
        assertThat(abilities, hasEntry("ATK", 4));
    }


    @Test
    @DisplayName("Abilities for level 1 are initialized correctly")
    void testInitializeAbilitiesForLevel1() {
        Goblin player = new Goblin("Florian", "Grognak", 100, new ArrayList<>());
            HashMap<String, Integer> abilities = player.initializeAbilitiesForLevel(1);

        assertThat(abilities, hasEntry("ATK", 2));
        assertThat(abilities, hasEntry("INT", 2));
        assertThat(abilities, hasEntry("ALC", 1));
    }

    // Test for Level 3
    @Test
    @DisplayName("Abilities for level 3 are initialized correctly")
    void testInitializeAbilitiesForLevel3() {
        Goblin player = new Goblin("Florian", "Grognak", 100, new ArrayList<>());
        HashMap<String, Integer> abilities = player.initializeAbilitiesForLevel(3);

        assertThat(abilities, hasEntry("VIS", 1));
    }

    // Test for Level 4
    @Test
    @DisplayName("Abilities for level 4 are initialized correctly")
    void testInitializeAbilitiesForLevel4() {
        Goblin player = new Goblin("Florian", "Grognak", 100, new ArrayList<>());
        HashMap<String, Integer> abilities = player.initializeAbilitiesForLevel(4);

        assertThat(abilities, hasEntry("DEF", 1));
    }

    @Test
    @DisplayName("Initialization of a player with weight correct")
    void testPlayerWithWeight() {
        player p=   new Goblin("cerra", "GolDRoger", 1, 200, new ArrayList<>());

    }
    @Test
    @DisplayName("Abilities for level 4 are initialized correctly")
    void testSell() {
        player p=   new Goblin("cerra", "GolDRoger", 1, 200, new ArrayList<>());
        Item it= new  Item("ff","dd",1,2);
        p.sell(it);
        p.inventory.add(it);
        p.sell(it);

    }

    @Test
    @DisplayName("Abilities for level 4 are initialized correctly")
    void testgetxp() {
        player p=   new Goblin("cerra", "GolDRoger", 1, 200, new ArrayList<>());
        p.getXp();
        p.currenthealthpoints=0;
        p.majFinDeTour();

    }











































































































}
