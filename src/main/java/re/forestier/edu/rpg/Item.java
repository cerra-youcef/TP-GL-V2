package re.forestier.edu.rpg;

/**
 * Classe représentant un objet dans le jeu.
 * Chaque objet a un nom, une description, un poids et une valeur.
 */
public class Item {
    // Nom de l'objet
    private String name;

    // Description de l'objet
    private String description;

    // Poids de l'objet (peut influencer la capacité de transport du joueur)
    private double weight;

    // Valeur monétaire de l'objet
    private int value;

    /**
     * Constructeur de la classe Item.
     *
     * @param name        Nom de l'objet.
     * @param description Description de l'objet.
     * @param weight      Poids de l'objet.
     * @param value       Valeur monétaire de l'objet.
     */
    public Item(String name, String description, double weight, int value) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Retourne le nom de l'objet.
     *
     * @return Le nom de l'objet.
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le poids de l'objet.
     *
     * @return Le poids de l'objet.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Retourne la valeur monétaire de l'objet.
     *
     * @return La valeur de l'objet.
     */
    public int getValue() {
        return value;
    }
}
