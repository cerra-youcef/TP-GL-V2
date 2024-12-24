package re.forestier.edu.rpg;

// Importation des classes nécessaires
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe représentant un aventurier, qui hérite de la classe Player.
 */
public class Adventurer extends player {

    /**
     * Constructeur de la classe Adventurer.
     *
     * @param playerName  Nom du joueur.
     * @param avatarName  Nom de l'avatar.
     * @param money       Montant initial d'argent.
     * @param inventory   Inventaire contenant les objets du joueur.
     */
    public Adventurer(String playerName, String avatarName, int money, ArrayList<Item> inventory) {
        super(playerName, avatarName, "ADVENTURER", money, inventory);
    }

    /**
     * Initialisation des capacités de base pour un aventurier.
     *
     * @return Un HashMap contenant les valeurs de base pour les capacités :
     *         ATK (Attaque), DEF (Défense), INT (Intelligence).
     */
    @Override
    protected HashMap<String, Integer> initializeAbilities() {
        HashMap<String, Integer> abilities = new HashMap<>();
        abilities.put("ATK", 3); // Attaque de base : 3
        abilities.put("DEF", 1); // Défense de base : 1
        abilities.put("INT", 1); // Intelligence de base : 1
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
                abilities.put("INT", 1);
                break;
            case 2:
                abilities.put("ATK", 2);
                abilities.put("DEF", 1);
                abilities.put("INT", 2);
                break;
            case 3:
                abilities.put("ATK", 3);
                abilities.put("DEF", 2);
                abilities.put("INT", 2);
                break;
            case 4:
                abilities.put("ATK", 4);
                abilities.put("DEF", 2);
                abilities.put("INT", 3);
                break;
            case 5:
                abilities.put("ATK", 5);
                abilities.put("DEF", 3);
                abilities.put("INT", 4);
                break;
            default:
                break;
        }
        return abilities;
    }

    /**
     * Méthode pour récupérer des points de vie.
     * - Si les points de vie actuels sont inférieurs à la moitié des points de vie max,
     *   l'aventurier récupère 2 points.
     * - Si le niveau est inférieur à 3, une pénalité d'un point est appliquée.
     */
    @Override
    public void recoverHealth() {
        if (currenthealthpoints < healthpoints / 2) {
            currenthealthpoints += 2; // Récupération de 2 points de vie.
            if (retrieveLevel() < 3) {
                currenthealthpoints -= 1; // Pénalité pour les niveaux inférieurs à 3.
            }
        }
    }
}
