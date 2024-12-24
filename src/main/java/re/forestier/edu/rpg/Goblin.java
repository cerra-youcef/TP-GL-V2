package re.forestier.edu.rpg;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe représentant un gobelin (Goblin), qui hérite de la classe Player.
 * Les gobelins sont des créatures rapides et intelligentes, avec des capacités
 * spécifiques liées à leur faible défense et à leurs talents en alchimie.
 */
public class Goblin extends player {

    /**
     * Constructeur principal pour créer un Goblin.
     *
     * @param playerName  Nom du joueur.
     * @param avatarName  Nom de l'avatar.
     * @param money       Montant initial d'argent.
     * @param inventory   Liste des objets possédés par le gobelin.
     */
    public Goblin(String playerName, String avatarName, int money, ArrayList<Item> inventory) {
        super(playerName, avatarName, "GOBLIN", money, inventory);
    }

    /**
     * Constructeur surchargé pour créer un Goblin avec un poids spécifique.
     *
     * @param playerName  Nom du joueur.
     * @param avatarName  Nom de l'avatar.
     * @param money       Montant initial d'argent.
     * @param weight      Poids initial du gobelin.
     * @param inventory   Liste des objets possédés par le gobelin.
     */
    public Goblin(String playerName, String avatarName, int money, double weight, ArrayList<Item> inventory) {
        super(playerName, avatarName, "GOBLIN", money, weight, inventory);
    }

    /**
     * Initialisation des capacités de base du gobelin.
     *
     * @return Un HashMap contenant les capacités de base :
     *         ATK (Attaque), DEF (Défense), INT (Intelligence), ALC (Alchimie).
     */
    @Override
    protected HashMap<String, Integer> initializeAbilities() {
        HashMap<String, Integer> abilities = new HashMap<>();
        abilities.put("ATK", 2); // Attaque modérée
        abilities.put("DEF", 0); // Défense faible
        abilities.put("INT", 2); // Intelligence élevée
        abilities.put("ALC", 1); // Talent en alchimie
        return abilities;
    }

    /**
     * Initialisation des capacités en fonction du niveau du gobelin.
     *
     * @param level Niveau actuel du joueur.
     * @return Un HashMap contenant les capacités ajustées en fonction du niveau.
     */
    @Override
    public HashMap<String, Integer> initializeAbilitiesForLevel(int level) {
        HashMap<String, Integer> abilities = new HashMap<>();
        // Définition des capacités selon le niveau
        switch (level) {
            case 1:
                abilities.put("ATK", 2);
                abilities.put("INT", 2);
                abilities.put("ALC", 1);
                break;
            case 2:
                abilities.put("ATK", 3);
                abilities.put("ALC", 4); // Amélioration notable en alchimie
                break;
            case 3:
                abilities.put("VIS", 1); // Ajout d'une capacité liée à la vision (hypothétique)
                break;
            case 4:
                abilities.put("DEF", 1); // Légère amélioration en défense
                break;
            case 5:
                abilities.put("DEF", 2);
                abilities.put("ATK", 4); // Amélioration significative en attaque
                break;
            default:
                break;
        }
        return abilities;
    }

    /**
     * Méthode pour récupérer des points de vie.
     * Si les points de vie actuels sont inférieurs à la moitié des points de vie max,
     * le gobelin récupère 1 point de vie.
     */
    @Override
    protected void recoverHealth() {
        if (currenthealthpoints < healthpoints / 2) {
            currenthealthpoints += 1; // Récupération de base pour le gobelin
        }
    }

    // Méthodes spécifiques aux gobelins peuvent être ajoutées ici
}
