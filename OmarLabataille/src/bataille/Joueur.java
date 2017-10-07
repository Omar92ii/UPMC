package bataille;

import java.util.ArrayList;

public class Joueur {

	
	private int score;
	
	private ArrayList<Carte> paquetJoueur;
	
	private String nom;

	
	public Joueur(String Nom)
	{
		this.score = 0;
		this.paquetJoueur = new ArrayList<Carte>();
		this.nom = Nom;
	}
	
	
	public int getScore()
	{
		return this.score;
	}
	
	
	public String getNom()
	{
		return this.nom;
	}
	
	
	public ArrayList<Carte> getCarte()
	{
		return this.paquetJoueur;
	}

	
	public void tireUneCarte(Carte carte)
	{
		this.paquetJoueur.remove(carte);
	}
	

	public void ajouteUneCarte(Carte carte) 
	{
		this.paquetJoueur.add(carte);
	}
	
	public void gagner() 
	{
		this.score++;
	}
	
}
