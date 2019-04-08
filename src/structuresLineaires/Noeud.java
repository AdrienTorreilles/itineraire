package structuresLineaires;

public class Noeud<E> extends Lien<E> {
	
	private E valeur;
	public Noeud(E v) { valeur = v;}
	public E valeur() { return valeur;}
	public void changerValeur(E v) { valeur = v; }
	public Noeud<E> noeudSuivant(){
		
		return (Noeud<E>) suivant();
	}
	
	public void noeudSuivant(Noeud<E> n) {
		suivant(n);
	}

}
