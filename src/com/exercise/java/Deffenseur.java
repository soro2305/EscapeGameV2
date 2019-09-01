package com.exercise.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Deffenseur extends Challenger {
    ////  static int max = 9999;
   ////   static int min = 1000;

        public void defender() {
                //Initialisations des instances
                Menu obj = new Menu();
                List<String> lC = new ArrayList();
                List<String> lP = new ArrayList();
                String sP = "";
                String sE;
                int m = 3;
                int a = 0;
                int i;



                System.out.println("Bienvenu dans le mode Déffenseur! ");
                //Définition combinaison utilisateur
                sP = obj.define();
                //Boucle paramétre le nombre de tentative via la var "m"
                for (i = 0; i <= m; i++) {

                        sE = obj.generateCode(1000, 9999);
                        if (sE.equals(sP)) {
                                System.out.println("GAME OVER l'EA a trouver la solution  " + sP + " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire de l'EA
                                break;
                        } else {

                                System.out.print("Proposition : " + sE + " -> Réponse : ");
                                //Méthode pour comparer les deux combinaisons
                                obj.compare(sE, sP);
                               // lC = obj.compare(sE, sP);//ArrayList pour stocker les indications "-=+"

                                //  System.out.println("Mode Dev L'EA a choisie : "+sP);
                              //  System.out.print("Proposition : " + sE + " -> Réponse : ");

                                //Boucle for pour afficher comninaison sous format --> "-=+"
                            //    for (int j = 0; j < lC.size(); j++) {
                            //            System.out.print(lC.get(j));
                           //     }
                                System.out.println("\n");
                                if (i == m) {
                                        System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");
                                }

                        }
                }
                //Envoie au menu final
                a = obj.endMenu();
                if (a == 1) obj.defender(); //Condition pour relancer même mode


        }



                @Override
                public List<String> compare(String sE, String sP) {
                        //Creation de l ArrayList qui vas contenir les réponses
                        Deffenseur obj = new Deffenseur();
                        List<String> lP = new ArrayList();
                        List<String> lE = new ArrayList();
                        List<String> lC = new ArrayList();


                        //Deux boucles pour convertir chaque caractères des args en int.
                        for (int i = 0; i < sE.length(); i++) {
                                for (int i2 = 0; i < sP.length(); i++) {

                                        int p = Character.getNumericValue(sP.charAt(i));
                                        int e = Character.getNumericValue(sE.charAt(i));
                                        //Conditions pour comparer et définir l'indication à retourner
                                        if (p < e) {
                                                System.out.print("-");
                                                lC.add(Integer.toString((e-p)));                   // // obj.generateCode(1,e));
                                        }
                                        if (p > e) {
                                                System.out.print("+");
                                        }       lC.add(Integer.toString((e-p)));                    // obj.generateCode(e,9));
                                        if (p == e) {
                                                 System.out.print("=");
                                                 lC.add(Integer.toString(e));                    // obj.generateCode(e,e));
                                        }
                                }
                        }
                          System.out.println(lC);

                        //   System.out.println(sP);
                        //  System.out.println(sE);
                        //retour Arraylist
                        return lC;
                }

        }
