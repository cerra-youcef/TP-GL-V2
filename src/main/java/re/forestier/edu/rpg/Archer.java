package re.forestier.edu.rpg;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe représentant un archer (Archer), qui hérite de la classe Player.
 * Les archers sont caractérisés par leur agilité et leur précision, avec
 * des capacités spécifiques qui évoluent au fil des niveaux.
 */
public class Archer extends player {

    /**
     * Constructeur pour créer un Archer.
     *
     * @param playerName  Nom du joueur.
     * @param avatarName  Nom de l'avatar.
     * @param money       Montant initial d'argent.
     * @param inventory   Liste des objets possédés par l'archer.
     */
    public Archer(String playerName, String avatarName, int money, ArrayList<Item> inventory) {
        super(playerName, avatarName, "ARCHER", money, inventory);
    }

    /**
     * Initialisation des capacités de base de l'archer.
     *
     * @return Un HashMap contenant les capacités de base :
     *         ATK (Attaque), DEF (Défense), AGI (Agilité).
     */
    @Override
    protected HashMap<String, Integer> initializeAbilities() {
        HashMap<String, Integer> abilities = new HashMap<>();
        abilities.put("ATK", 3); // Attaque modérée
        abilities.put("DEF", 1); // Défense faible
        abilities.put("AGI", 2); // Agilité élevée pour l'archer
        return abilities;
    }

    /**
     * Initialisation des capacités en fonction du niveau de l'archer.
     *
     * @param level Niveau actuel du joueur.
     * @return Un HashMap contenant les capacités ajustées en fonction du niveau.
     */
    @Override
    protected HashMap<String, Integer> initializeAbilitiesForLevel(int level) {
        HashMap<String, Integer> abilities = new HashMap<>();
        switch (level) {
            case 1:
                abilities.put("ATK", 1); // Début avec une attaque faible
                abilities.put("AGI", 1); // Agilité basique
                break;
            case 2:
                abilities.put("ATK", 2); // Amélioration de l'attaque
                abilities.put("AGI", 1); // Agilité reste stable
                break;
            case 3:
                abilities.put("ATK", 3);
                abilities.put("AGI", 2); // Gain en agilité
                break;
            case 4:
                abilities.put("ATK", 3);
                abilities.put("AGI", 3); // Agilité au maximum
                break;
            case 5:
                abilities.put("ATK", 4); // Attaque puissante au dernier niveau
                abilities.put("AGI", 4); // Agilité exceptionnelle
                break;
            default:
                break;
        }
        return abilities;
    }

    /**
     * Méthode pour récupérer des points de vie.
     * Si les points de vie actuels sont inférieurs à la moitié des points de vie max,
     * l'archer récupère un point de vie de base. Si un arc magique est présent dans
     * l'inventaire, un bonus de récupération est appliqué.
     */
    @Override
    public void recoverHealth() {
        if (currenthealthpoints < healthpoints / 2) {
            currenthealthpoints += 1; // Récupération basique

            // Bonus de récupération si l'archer possède un "Magic Bow"
            if (inventory.contains("Magic Bow")) {
                currenthealthpoints += currenthealthpoints / 8 - 1;
            }
        }
    }

    // Méthodes spécifiques aux archers peuvent être ajoutées ici
}
