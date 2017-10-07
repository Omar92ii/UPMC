
// Copyright 2017 Pierre Talbot (IRCAM)



// Licensed under the Apache License, Version 2.0 (the "License");

// you may not use this file except in compliance with the License.

// You may obtain a copy of the License at



//     http://www.apache.org/licenses/LICENSE-2.0



// Unless required by applicable law or agreed to in writing, software

// distributed under the License is distributed on an "AS IS" BASIS,

// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

// See the License for the specific language governing permissions and

// limitations under the License.




package bataille;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bataille {

	public static void main(String[] args) {
		
		 System.out.println("Bonjour , bienvenue dans le jeu de la bataille.");
		
		System.out.println("Tapez sur 1 pour commencer une nouvelle partie .");
		  System.out.println("Tapez sur 2 pour quitter");
		  	Scanner sc = new Scanner(System.in);
		  int menu =0;
		  menu=sc.nextInt();
		switch (menu){
		   case 1:
		   System.out.println("Que le meilleur gagne ! Mais surtout que la chance soit avec toi ;) ");
		   break;
		   default:
		   case 2:
			    System.out.println("En espérant vous revoir bientôt.");
			 sc.nextLine();
			 int code =0;
			 System.exit(code);
			  break;
			
		
		  
		}
		
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Veuillez saisir votre prénom Joueur 1 :");
		String str = sc2.nextLine();
		System.out.println("Votre nom est  : " + str);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Veuillez saisir votre prénom Joueur 2 :");
		String str1 = sc1.nextLine();
		System.out.println("Votre nom est  : " + str1);
		Joueur joueur1 = new Joueur(str);
		Joueur joueur2 = new Joueur(str1);
		
		
		
		
		ArrayList<Carte> paquet = new ArrayList<Carte>();
		
		for(int i = 0 ; i < Carte.tabCouleur.length ; i++) {
			for(int j = 0 ; j < Carte.tabValeur.length; j++) {
				Carte carte = new Carte(Carte.tabCouleur[i], Carte.tabValeur[j]);
				paquet.add(carte);				
			}
		}
		

		Collections.shuffle(paquet);
		
	
		for(int k = 0 ; k < paquet.size(); k = k + 2) {
			joueur1.ajouteUneCarte(paquet.get(k));
			joueur2.ajouteUneCarte(paquet.get(k+1));
		}
		
		
		while(joueur1.getCarte().size() != 0 && joueur2.getCarte().size() != 0) {
			
		
			Carte carteJ1 = joueur1.getCarte().get(0);
			joueur1.tireUneCarte(carteJ1);
			
			Carte carteJ2 = joueur2.getCarte().get(0);
			joueur2.tireUneCarte(carteJ2);
			
			
			if(carteJ1.comparateur(carteJ2) == 1) {
				System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
				joueur1.ajouteUneCarte(carteJ1);
				joueur1.ajouteUneCarte(carteJ2);
				joueur1.gagner();
				System.out.println(joueur1.getNom() + " gagné ! Score : " + joueur1.getScore());
				System.out.println(joueur2.getNom() + " perdu ! Score : " + joueur2.getScore());
			}
			
			
			else if(carteJ1.comparateur(carteJ2) == 0) {
				System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
				joueur2.ajouteUneCarte(carteJ2);
				joueur2.ajouteUneCarte(carteJ1);
				joueur2.gagner();
				System.out.println(joueur1.getNom() + " perdu ! Score : " + joueur1.getScore());
				System.out.println(joueur2.getNom() + " gagné ! Score : " + joueur2.getScore());
			}
			
			else {
				System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
				System.out.println("** Egalité ! ");
				
				
				if(joueur1.getCarte().size() >= 2 && joueur2.getCarte().size() >= 2) {
					
					Carte carte1 = joueur1.getCarte().get(0);
					Carte carte2 = joueur1.getCarte().get(1);
					joueur1.tireUneCarte(carte1);
					joueur1.tireUneCarte(carte2);
					
					Carte carte3 = joueur2.getCarte().get(0);
					Carte carte4 = joueur2.getCarte().get(1);
					joueur2.tireUneCarte(carte3);
					joueur2.tireUneCarte(carte4);
				
					
					if(carte2.comparateur(carte4) == 1) {
						System.out.println(carte2.toString() + " contre " + carte4.toString());
						
						joueur1.ajouteUneCarte(carteJ1);
						joueur1.ajouteUneCarte(carteJ2);
						joueur1.ajouteUneCarte(carte1);
						joueur1.ajouteUneCarte(carte2);
						joueur1.ajouteUneCarte(carte3);
						joueur1.ajouteUneCarte(carte4);
						joueur1.gagner();
						System.out.println(joueur1.getNom() + " gagné ! Score : " + joueur1.getScore());
						System.out.println(joueur2.getNom() + " perdu ! Score : " + joueur2.getScore());
					}
					
					
					else if(carte2.comparateur(carte4) == 0) {
						System.out.println(carte2.toString() + " contre " + carte4.toString());
						
						joueur2.ajouteUneCarte(carteJ1);
						joueur2.ajouteUneCarte(carteJ2);
						joueur2.ajouteUneCarte(carte1);
						joueur2.ajouteUneCarte(carte2);
						joueur2.ajouteUneCarte(carte3);
						joueur2.ajouteUneCarte(carte4);
						joueur2.gagner();
						System.out.println(joueur2.getNom() + " gagné ! Score : " + joueur2.getScore());
						System.out.println(joueur1.getNom() + " perdu ! Score : " + joueur1.getScore());
					}
				}
				else {
					System.out.println("Impossible de jouer l'égalité !");
					if(joueur1.getCarte().size() < 2) {
						joueur2.gagner();
						System.out.println(joueur1.getNom() + " perdu ! Score : " + joueur1.getScore());
						System.out.println(joueur2.getNom() + " gagné ! Score : " + joueur2.getScore());
					}
					else if(joueur2.getCarte().size() < 2) {
						joueur1.gagner();
						System.out.println(joueur1.getNom() + " gagné ! Score : " + joueur1.getScore());
						System.out.println(joueur2.getNom() + " perdu ! Score : " + joueur2.getScore());
					}
				}
			}
			System.out.println();
		}
		
		
		if(joueur1.getScore() > joueur2.getScore()) 
			System.out.println(joueur1.getNom() + " remporte la partie ! ");
		else if(joueur2.getScore() > joueur1.getScore()) 
			System.out.println(joueur2.getNom() + " remporte la partie  ! ");
		else
			System.out.println("Egalité ! ");
	}

	}
	
	
