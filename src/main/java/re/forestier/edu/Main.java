package re.forestier.edu;

import re.forestier.edu.rpg.Affichage;
import re.forestier.edu.rpg.Adventurer;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Adventurer c = new Adventurer("CERRA","Abdelali",300,new ArrayList<>());
        System.out.println(Affichage.afficherJoueur(c));
        System.out.println(Affichage.afficherJoueurMarkdown(c));



    }
}