package re.forestier.edu.rpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Classe abstraite Player représentant un joueur générique dans le jeu.
 * Les classes spécifiques comme Dwarf, Goblin, ou Archer hériteront de cette classe.
 */
public abstract class player {
    public String playerName;
    public String avatarName;
    private String avatarClass; // Classe du joueur (ex: DWARF, GOBLIN, etc.)

    public Integer money;
    private Float __real_money__; // Variable non utilisée, peut-être pour une future fonctionnalité ?

    public int level;
    public int healthpoints;
    public int currenthealthpoints;
    public int xp;

    protected double maxWeight; // Poids maximal transportable par le joueur
    protected double currentWeight; // Poids actuel dans l'inventaire

    public HashMap<String, Integer> abilities; // Capacités spécifiques au joueur
    public ArrayList<Item> inventory; // Liste des objets détenus par le joueur

    // Constructeur avec poids maximal personnalisé
    public player(String playerName, String avatarName, String avatarClass, int money, double maxWeight, ArrayList<Item> inventory) {
        this.playerName = playerName;
        this.avatarName = avatarName;
        this.avatarClass = avatarClass;
        this.money = money;
        this.inventory = inventory;
        this.level = 1; // Début au niveau 1
        this.xp = 0; // Pas d'XP au départ
        this.abilities = initializeAbilities();
        this.currenthealthpoints = 100;
        this.healthpoints = 100;
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    // Constructeur avec poids maximal par défaut (50)
    public player(String playerName, String avatarName, String avatarClass, int money, ArrayList<Item> inventory) {
        this(playerName, avatarName, avatarClass, money, 50.0, inventory);
    }

    // Méthode pour retirer de l'argent
    public void removeMoney(int amount) throws IllegalArgumentException {
        if (money - amount < 0) {
            throw new IllegalArgumentException("Player can't have a negative money!");
        }
        money -= amount;
    }

    // Méthode pour ajouter un objet à l'inventaire
    public void addItem(Item item) throws IllegalArgumentException {
        if (currentWeight + item.getWeight() > maxWeight) {
            throw new IllegalArgumentException("Cannot add item: weight limit exceeded!");
        }
        inventory.add(item);
        currentWeight += item.getWeight();
    }

    // Méthode pour vendre un objet
    public Boolean sell(Item item) throws IllegalArgumentException {
        if (inventory.contains(item)) {
            inventory.remove(item);
            addMoney(item.getValue());
            return true;
        }
        return false;
    }

    // Méthode pour ajouter de l'argent
    public void addMoney(int amount) {
        money += Math.max(amount, 0); // Évite les valeurs négatives
    }

    // Méthode abstraite pour initialiser les capacités (implémentée dans les sous-classes)
    protected abstract HashMap<String, Integer> initializeAbilities();

    // Ajouter de l'XP et vérifier si le joueur monte de niveau
    public void addXp(int xp) {
        this.xp += xp;

        // Calcul du niveau
        int newLevel = retrieveLevel();
        if (newLevel > level) {
            level = newLevel;
            gainAbility(); // Gagner des capacités
            gainItem(); // Recevoir un objet
        }
    }

    // Méthode pour ajouter un objet aléatoire lors de la montée de niveau
    private void gainItem() {
        Item[] objectList = {
                new Item("Phantom Cloak", "A cloak that grants invisibility for a short time.", 0.7, 150),
                new Item("Thunder Gauntlet", "A gauntlet that delivers electrifying punches.", 1.2, 200),
                new Item("Crystal Amulet", "An amulet that boosts magical abilities.", 0.4, 120),
                new Item("Shadow Blade", "A dagger that strikes silently and swiftly.", 0.8, 180),
                new Item("Phoenix Feather", "A rare feather that revives the bearer once.", 0.3, 300),
                new Item("Tome of Wisdom", "An ancient book that increases intelligence.", 1.0, 250),
                new Item("Dragon Scale Shield", "A shield forged from dragon scales, offers great protection.", 2.5, 400),
                new Item("Boots of Swiftness", "Magical boots that enhance speed and agility.", 1.0, 150),
                new Item("Orb of Fire", "A mystical orb that shoots fireballs at enemies.", 1.5, 220),
                new Item("Elixir of Vitality", "A powerful elixir that fully restores health.", 0.6, 250)
        };

        Random random = new Random();
        addItem(objectList[random.nextInt(objectList.length)]);
    }

    // Méthode pour gagner des capacités en montant de niveau
    protected void gainAbility() {
        HashMap<String, Integer> newAbilities = initializeAbilitiesForLevel(level);
        newAbilities.forEach((ability, value) ->
                abilities.merge(ability, value, Integer::sum) // Ajoute les nouvelles valeurs aux anciennes
        );
    }

    // Méthode abstraite pour initialiser les capacités en fonction du niveau
    protected abstract HashMap<String, Integer> initializeAbilitiesForLevel(int level);

    // Calculer le niveau en fonction de l'XP
    public int retrieveLevel() {
        if (xp < 10) return 1;
        if (xp < 27) return 2;
        if (xp < 57) return 3;
        if (xp < 111) return 4;
        return 5;
    }

    // Getter pour XP
    public int getXp() {
        return this.xp;
    }

    // Mise à jour des stats en fin de tour
    public void majFinDeTour() {
        if (currenthealthpoints <= 0) {
            System.out.println("Le joueur est KO !");
            return;
        }

        // Appelle la méthode de récupération spécifique à la sous-classe
        recoverHealth();

        // Limite les points de santé au maximum
        if (currenthealthpoints > healthpoints) {
            currenthealthpoints = healthpoints;
        }
    }

    // Méthode abstraite pour la récupération de santé (implémentée dans les sous-classes)
    protected abstract void recoverHealth();
}
