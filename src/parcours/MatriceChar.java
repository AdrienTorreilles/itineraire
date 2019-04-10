package parcours;

import parcours.Position;
import structuresLineaires.Liste;
import structuresLineaires.ListeChainee;
import structuresLineaires.ListeTableau;

public class MatriceChar implements Explorable<Position> {

	public Position debut;
	public Position fin;
	//private Liste<Position> murs;
	public char mur = 'M';
	public char[][] matriceChar;
	public int nblignes, nbcolonnes;

	public MatriceChar(int nblignes, int nbcolonnes, Position debut, Position fin) {
		this.nblignes = nblignes;
		this.nbcolonnes = nbcolonnes;
		this.debut = debut;
		this.fin = fin;
		this.matriceChar = new char[nblignes][nbcolonnes];

		for (int i = 0; i < getNblignes(); i++) {
			for (int j = 0; j < getNbcolonnes(); j++) {
				matriceChar[i][j] = ' ';
			}

		}
		matriceChar[debut.getX()][debut.getY()] = 'D';
		matriceChar[fin.getX()][fin.getY()] = 'A';

	}

	public MatriceChar() {

	}

	public MatriceChar(char[][] matrice, Position debut, Position fin , int nblignes, int nbcolonnes) {
		this.matriceChar = matrice;
		this.debut = debut;
		this.fin = fin;
		this.nblignes = nblignes;
		this.nbcolonnes = nbcolonnes;
	}

	public void creerMurs(Liste<Position> murs) {

		for (Position item : murs) {
			if (isOut(item))
				throw new OutOfMatriceException();
			matriceChar[item.getX()][item.getY()] = mur;
		}
	}

	public void ajouterParcours(Liste<Position> parcours) {
		for (Position item : parcours) {
			if (isOut(item))
				throw new OutOfMatriceException();
			if (estVide(item))
				matriceChar[item.getX()][item.getY()] = '1';
		}
	}

	public char getMur() {
		return mur;
	}

	public void setMur(char mur) {
		this.mur = mur;
	}

	public boolean isOut(Position position) {
		if (position.getX() < 0 || position.getX() > nblignes - 1 || position.getY() < 0
				|| position.getY() > nbcolonnes - 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean estMur(Position p) {

		if (matriceChar[p.getX()][p.getY()] == mur)
			return true;
		else
			return false;

	}

	public boolean estVide(Position p) {

		if (matriceChar[p.getX()][p.getY()] == ' ')
			return true;
		else
			return false;

	}

	public void ajouterElement(Position p, char c) {

		this.matriceChar[p.getX()][p.getY()] = c;

	}

	public void supprimerElement(Position p) {
		this.matriceChar[p.getX()][p.getY()] = ' ';
	}

	public int getNblignes() {
		return nblignes;
	}

	public void setNblignes(int nblignes) {
		this.nblignes = nblignes;
	}

	public int getNbcolonnes() {
		return nbcolonnes;
	}

	public void setNbcolonnes(int nbcolonnes) {
		this.nbcolonnes = nbcolonnes;
	}

	@Override
	public Liste<Position> etapesSuivantes(Position position) {

		Liste<Position> etapesSuivantes = new ListeChainee<>();
		Position p;
		

		p= new Position(position.getX()+1,position.getY());
		if(!(isOut(p))){
			if(!(estMur(p))) etapesSuivantes.ajouter(1,p);
		}
		p=new Position(position.getX(),position.getY()+1);
		if(!(isOut(p))){
			if(!(estMur(p))) etapesSuivantes.ajouter(1,p);
		}
		
		p=new Position(position.getX()-1,position.getY());

		if(!(isOut(p))){
			if(!(estMur(p))) etapesSuivantes.ajouter(1,p);
		}
		
		p=new Position(position.getX(),position.getY()-1);
		if(!(isOut(p))){
			if(!(estMur(p))) etapesSuivantes.ajouter(1,p);
		}
		 p=null;
		return etapesSuivantes;
	}

	@Override
	public Position etapeInit() {
		// TODO Auto-generated method stub
		return this.debut;
	}

	@Override
	public boolean estArrive(Position position) {
		if (position.getX() == fin.getX() && position.getY() == fin.getY())
			return true;
		else
			return false;

	}

	public void afficher() {

		for (int i = 0; i < nblignes; i++) {
			String s = "=";
			String t = "|";
			for (int j = 0; j < nbcolonnes; j++) {
				t = t + matriceChar[i][j] + "|";
				s = s + "==";
			}
			System.out.println(t);
			System.out.println(s);
		}
	}

	public Position getDebut() {
		return debut;
	}

	public void setDebut(Position debut) {
		this.debut = debut;
	}

	public Position getFin() {
		return fin;
	}

	public void setFin(Position fin) {
		this.fin = fin;
	}

	public char[][] getMatriceChar() {
		return matriceChar;
	}

	public void setMatriceChar(char[][] matriceChar) {
		this.matriceChar = matriceChar;
	}

}
