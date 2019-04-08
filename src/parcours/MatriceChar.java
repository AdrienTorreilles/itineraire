package parcours;

import structuresLineaires.Liste;
import structuresLineaires.ListeChainee;
import structuresLineaires.ListeTableau;


public class MatriceChar implements Explorable<Position> {

	public Position debut;
	public Position fin;
	public char[][] matriceChar;
	public int nblignes,nbcolonnes;

	public MatriceChar(int nblignes, int nbcolonnes, Position debut, Position fin) {
		this.nblignes=nblignes;
		this.nbcolonnes=nbcolonnes;
		this.debut=debut;
		this.fin=fin;
		this.matriceChar = new char[nblignes][nbcolonnes];
		
		for(int i =0; i<getNblignes();i++){
			for( int j =0; j<getNbcolonnes(); j++){
				matriceChar[i][j]=' ';
			}
			
			
		}
		matriceChar[debut.getX()][debut.getY()]='D';
		matriceChar[fin.getX()][fin.getY()]='A';
		
	}

	public MatriceChar() {
		

	}

	public void ajouterElement(Position p, char c) {

		this.matriceChar[p.getX()][p.getY()]=c;

	}

	public void SupprimerElement(Position p) {
		this.matriceChar[p.getX()][p.getY()]=' ';
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
	public  Liste<Position> etapesSuivantes(Position position) {

		Liste<Position> etapesSuivantes= new ListeChainee<>();

		
		etapesSuivantes.ajouter(1,new Position(position.getX()+1,position.getY(),position.getPrecedente()));
		etapesSuivantes.ajouter(1,new Position(position.getX(),position.getY()+1,position.getPrecedente()));
		etapesSuivantes.ajouter(1,new Position(position.getX()-1,position.getY(),position.getPrecedente()));
		etapesSuivantes.ajouter(1,new Position(position.getX(),position.getY()-1,position.getPrecedente()));
		for(int i=1; i<etapesSuivantes.longueur()+1; i++){
			if(etapesSuivantes.ieme(i).getX()==position.getX()&&etapesSuivantes.ieme(i).getY()==position.getY()){
		etapesSuivantes.supprimer(i);
			}
		
		}
		return etapesSuivantes;
	}

	@Override
	public  Position etapeInit() {
		// TODO Auto-generated method stub
		return  this.debut;
	}

	@Override
	public  boolean estArrive(Position position) {
		if(position.getX()==fin.getX()&&position.getY()==fin.getY()) return true;
		else return false;

	}












}
