package structuresLineaires;

public class NoeudDouble<E> extends LienDouble<E> {

	protected E valeur;
	public NoeudDouble(E e) { valeur = e;}
	public NoeudDouble(E e, NoeudDouble<E> p, NoeudDouble<E> s) {
		valeur=e;
		precedent(p);
		suivant(s);
	}
	public E valeur() { return valeur;}
	public void changerValeur(E e) { valeur = e;}
	public NoeudDouble<E> noeudSuivant() { return (NoeudDouble<E>) suivant();}
	public void noeudSuivant(NoeudDouble<E> s) {suivant(s);}
	public NoeudDouble<E> noeudPrecedent() { return (NoeudDouble<E>) precedent();}
	public void noeudPrecedent(NoeudDouble<E> p) {precedent(p);}
	
}
 