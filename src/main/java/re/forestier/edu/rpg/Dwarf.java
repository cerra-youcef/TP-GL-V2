package re.forestier.edu.rpg;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe représentant un nain (Dwarf), qui hérite de la classe Player.
 */
public class Dwarf extends player {

    /**
     * Constructeur de la classe Dwarf.
     *
     * @param playerName  Nom du joueur.
     * @param avatarName  Nom de l'avatar.
     * @param money       Montant initial d'argent.
     * @param inventory   Inventaire contenant les objets du joueur.
     */
    public Dwarf(String playerName, String avatarName, int money, ArrayList<Item> inventory) {
        super(playerName, avatarName, "DWARF", money, inventory);
    }

    /**
     * Initialisation des capacités de base pour un nain.
     *
     * @return Un HashMap contenant les capacités :
     *         ATK (Attaque), DEF (Défense), ALC (Alchimie, spécifique aux nains).
     */
    @Override
    protected HashMap<String, Integer> initializeAbilities() {
        HashMap<String, Integer> abilities = new HashMap<>();
        abilities.put("ATK", 4); // Attaque de base : 4
        abilities.put("DEF", 2); // Défense de base : 2
        abilities.put("ALC", 3); // Alchimie : 3 (spécial pour les nains)
        return abilities;
    }

    /**
     * Initialisation des capacités selon le niveau du joueur.
     *
     * @param level Niveau actuel du joueur.
     * @return Un HashMap contenant les capacités ajustées en fonction du niveau.
     */
    @Override
    protected HashMap<String, Integer> initializeAbilitiesForLevel(int level) {
        HashMap<String, Integer> abilities = new HashMap<>();
        // Assignation des capacités selon le niveau
        switch (level) {
            case 1:
                abilities.put("ATK", 1);
                abilities.put("DEF", 1);
                abilities.put("ALC", 1);
                break;
            case 2:
                abilities.put("ATK", 2);
                abilities.put("DEF", 2);
                abilities.put("ALC", 2);
                break;
            case 3:
                abilities.put("ATK", 3);
                abilities.put("DEF", 2);
                abilities.put("ALC", 3);
                break;
            case 4:
                abilities.put("ATK", 4);
                abilities.put("DEF", 3);
                abilities.put("ALC", 4);
                break;
            case 5:
                abilities.put("ATK", 5);
                abilities.put("DEF", 4);
                abilities.put("ALC", 5);
                break;
            default:
                break;
        }
        return abilities;
    }

    /**
     * Méthode pour récupérer des points de vie.
     * - Si les points de vie actuels sont inférieurs à la moitié des points de vie max :
     *   - Si l'inventaire contient "Holy Elixir", le nain récupère 1 point supplémentaire.
     *   - Récupération de base de 1 point pour un nain.
     */
    @Override
    public void recoverHealth() {
        if (currenthealthpoints < healthpoints / 2) {
            if (inventory.contains("Holy Elixir")) {
                currenthealthpoints += 1; // Récupération avec Holy Elixir
            }
            currenthealthpoints += 1; // Récupération de base
        }
    }

    // Méthodes spécifiques aux nains peuvent être ajoutées ici
}
