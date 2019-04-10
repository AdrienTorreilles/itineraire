package testPackage;

import parcours.Algorithme;
import parcours.MatriceChar;
import parcours.Position;
import structuresLineaires.Liste;
import structuresLineaires.ListeChainee;

public class TestAlgo {

	public static void main(String[] args) {

		
		Position debut = new Position(0,0);
		Position fin = new Position(4,4);
		
		MatriceChar matrice = new MatriceChar(5,5,debut,fin);
		
		
		// on crée un mur de position
		ListeChainee<Position> murs = new ListeChainee<>();
		
		murs.ajouterFinDeListe(new Position(1,2));
		murs.ajouterFinDeListe(new Position(1,1));
		murs.ajouterFinDeListe(new Position(1,3));
		murs.ajouterFinDeListe(new Position(1,4));
		
		matrice.creerMurs(murs);
		
		Liste<Position> parcours = new ListeChainee<Position>();
		
		parcours=Algorithme.parcoursLargeur(matrice);
		matrice.ajouterParcours(parcours);
		matrice.afficher();
		
	}

}
