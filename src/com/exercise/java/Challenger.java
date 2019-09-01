package com.exercise.java;

import java.util.ArrayList;
import java.util.List;

public class Challenger extends Mode{


    public void attaque() {
        //Initialisations des instances
        Menu obj = new Menu();
        List<String> list = new ArrayList();
        String sP = "0" ; String sE;
        int  m = 3; int a = 0; int i;int j;

        //Création combinaison EA
        sE = obj.generateCode(1000,9999);
        System.out.println("Bienvenu dans le mode challenger! ");

        //Boucle paramétre le nombre de tentative via la var "m"
        for (  i = 0 ; i <= m  ; i ++ ) {
            sP = obj.define();
            if (sP.equals(sE)){System.out.println("Bravo c est Gagné la solution etait " +sE+ " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire
            break;
            }else {
            //Méthode pour comparer les deux combinaisons
            obj.compare(sP, sE);
            list = obj.compare(sP, sE);//ArrayList pour stocker les indications "-=+"

             System.out.println("Mode Dev L'EA a choisie : "+sE);
             System.out.print("Proposition : "+sP+" -> Réponse : ");
            //Boucle for pour afficher comninaison sous format --> "-=+"
            for (  j = 0 ; j < list.size() ; j ++ ) {System.out.print(list.get(j));}
            System.out.println("\n");
                if (i == m){System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");}

            }
        }
        //Envoie au menu final
         a = obj.endMenu();
        if (a==1)obj.attaque(); //Condition pour relancer même mode
    }
}
