package com.exercise.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Deffenseur extends Mode {
    int max = 9999;
    int min = 1000;
    List<String> lC = new ArrayList();

    public void defender() {
        //Initialisations des instances
        Deffenseur obj = new Deffenseur();
        Menu obj1 = new Menu();

        String sP = "";
        String sE;
        int m = 20;
        int a = 0;
        int i;
        System.out.println("Bienvenu dans le mode Déffenseur! ");
        //Définition combinaison utilisateur
        sP = obj.define();
        sE = obj.generateCode(min, max);
        //Boucle paramétre le nombre de tentative via la var "m"
        for (i = 0; i <= m; i++) {

            if (sE.equals(sP)) {
                System.out.println("GAME OVER l'EA a trouver la solution  " + sP + " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire de l'EA
                break;
            } else {

                System.out.print("Proposition : " + sE + " -> Réponse : ");
                //Méthode pour comparer les deux combinaisons
                obj.compare(sE, sP);
                sE = obj.generateNew(sE, sP);


                System.out.println("\n");
                if (i == m) {
                    System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");
                }

            }
        }
        //Envoie au menu final
        a = obj1.endMenu();
        if (a == 1) obj.defender(); //Condition pour relancer même mode

    }

    public String generateNew(String sE, String sP) {
        Deffenseur obj = new Deffenseur();
        List<String> lC = new ArrayList();
        List<Integer> lE = new ArrayList();
        String newResponse = "";
        //   List<String> lC = new ArrayList();


        //Deux boucles pour convertir chaque caractères des args en int.
        for (int i = 0; i < sE.length(); i++) {
            for (int i2 = 0; i < sP.length(); i++) {

                int p = Character.getNumericValue(sP.charAt(i));
                int e = Character.getNumericValue(sE.charAt(i));
                // System.out.print(e);
                //Conditions pour comparer et définir l'indication à retourner
                if (p < e) {

                   // lC.add(Integer.toString(e - 1));

                       lC.add(obj.generateCode(1,(e-1)));

                }
                if (p > e) {
                   // lC.add(Integer.toString(e + 1));

                      lC.add(obj.generateCode((e+1),9));

                }
                if (p == e) {
                   // lC.add(Integer.toString(e));


                       lC.add(obj.generateCode(e,e));


                }
            }
        }

        for (int j = 0; j < lC.size(); j++) {
            newResponse += lC.get(j);
       //     System.out.println(lE);
       //     System.out.println(lC);
        }
        //retour Arraylist
        return newResponse;
    }


}
