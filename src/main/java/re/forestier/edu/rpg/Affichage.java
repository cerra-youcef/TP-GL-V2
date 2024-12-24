package re.forestier.edu.rpg;

public class Affichage {

    /**
     * Méthode pour afficher les informations d'un joueur en texte brut.
     *
     * @param player Le joueur à afficher.
     * @return Chaîne de caractères représentant les informations du joueur.
     */
    public static String afficherJoueur(player player) {
        final String[] finalString = {"Joueur " + player.avatarName + " joué par " + player.playerName};
        finalString[0] += "\nNiveau : " + player.retrieveLevel() + " (XP totale : " + player.xp + ")";
        finalString[0] += "\n\nCapacités :";
        player.abilities.forEach((name, level) -> {
            finalString[0] += "\n   " + name + " : " + level;
        });
        finalString[0] += "\n\nInventaire :";
        player.inventory.forEach(item -> {
            finalString[0] += "\n   " + item.getName() + " (Poids : " + item.getWeight() + ", Valeur : " + item.getValue() + ")";
        });

        return finalString[0];
    }

    /**
     * Méthode pour afficher les informations d'un joueur au format Markdown.
     *
     * @param player Le joueur à afficher.
     * @return Chaîne de caractères en format Markdown représentant les informations du joueur.
     */
    public static String afficherJoueurMarkdown(player player) {
        StringBuilder markdown = new StringBuilder();
        markdown.append("# Joueur ").append(player.avatarName).append(" joué par ").append(player.playerName).append("\n");
        markdown.append("## Niveau : ").append(player.retrieveLevel()).append(" (XP totale : ").append(player.xp).append(")\n\n");

        markdown.append("**Capacités :**\n");
        player.abilities.forEach((name, level) -> {
            markdown.append("- ").append(name).append(" : ").append(level).append("\n");
        });

        markdown.append("\n**Inventaire :**\n");
        player.inventory.forEach(item -> {
            markdown.append("- ").append(item.getName())
                    .append(" (Poids : ").append(item.getWeight())
                    .append(", Valeur : ").append(item.getValue()).append(")\n");
        });

        return markdown.toString();
    }
}

