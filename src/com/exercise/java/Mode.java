package com.exercise.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Mode {
    //Initialisation des instances
    Random r = new Random();
    Scanner input = new Scanner(System.in);
    int m = 4;
    public List<String> compare(String sE, String sP) {
        //Creation de l ArrayList qui vas contenir les réponses
        List<String> lC = new ArrayList();
        //Deux boucles pour convertir chaque caractères des args en int.
        for (int i = 0; i < sE.length(); i++) {
            for (int i2 = 0; i < sP.length(); i++) {
                int b = Character.getNumericValue(sP.charAt(i));
                int a = Character.getNumericValue(sE.charAt(i));
                //Conditions pour comparer et définir l'indication à retourner
                if (a < b) {
                    lC.add("+");
                }
                if (a > b) {
                    lC.add("-");
                }
                if (a == b) {
                    lC.add("=");
                }
              }
           }
     //   System.out.println(sP);
      //  System.out.println(sE);
          //retour Arraylist
          return lC;
          }

    //Méthode qui génère un code aléatoire
    public String generateCode( int min, int max){
       int a = r.nextInt((max - min) + 1) + min; //Classe Random utiliser pour définir les bornes max min de la combinaison
       String c = Integer.toString(a); //Conversion de la combi en string
        System.out.println(c);
       return c; //Retour combinaison
       }

    //Méthode qui permet à l'utilisateur d'entré une combinaison
    public String define () {
      System.out.println("Veuillez définir votre combinaison");
      return  input.nextLine();// Retourne saisie du Scanner
    }

    public void Startmenu(){

    }

    public void Endmenu(){

    }

        }
