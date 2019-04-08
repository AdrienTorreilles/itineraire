package structuresLineaires;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeChainee<E> extends ListeAbstraite<E>{

	protected int lg;
	protected Noeud<E> tete;
	@Override
	
	
	
	public int longueur() {
		
		return lg;
	}

	@Override
	public E ieme(int r) throws RangInvalideException {
		if(r<1|| r>lg) 
			throw new RangInvalideException();
		Noeud<E> n = tete;
		for (int i=1; i<r; i++) n=n.noeudSuivant();
		
		return n.valeur();
	}

	@Override
	public void supprimer(int r) throws RangInvalideException {
		if(r<1|| r>lg) 
			throw new RangInvalideException();
		if(r==1) // suppression en tete de liste
			tete=tete.noeudSuivant();
		else {// en general 
			Noeud<E> p= null, q=tete;
			for (int i=1; i<r; i++) {
				p=q;// predecesseur de q
				q=q.noeudSuivant();
				}
			p.noeudSuivant(q.noeudSuivant());
			}
		lg--;
			
		
		
	}
	public void ajouter(int r, E e) throws RangInvalideException {
		if(r<1 || r>lg+1) throw new RangInvalideException();
		Noeud<E> n = new Noeud<E>(e);
		
		if(r==1) { // ajout en tete de liste
			
			n.noeudSuivant(tete);
			tete=n;
			
		}else { //en general
			Noeud<E> p=null;
			Noeud<E> q= tete;
			
			for (int i=1; i<r; i++) {
				p=q;
				q=q.noeudSuivant();
			}
			
			p.noeudSuivant(n);
			n.noeudSuivant(q);
			
			
		}
		lg++;
		
	}
	
	public void ajouterFinDeListe(E e) {
		this.ajouter(longueur() + 1,e);
	}

	public Iterator<E> iterator() {
		return new ListeEnumeration();
	}
	private class ListeEnumeration implements Iterator<E>{

		private Noeud<E> courant;
		
		private ListeEnumeration() {
			courant = tete;
		}
		public boolean hasNext() {
			return courant!=null;
		}

		
		public E next() throws NoSuchElementException {
			if(hasNext()) {
				E e = courant.valeur();
				courant = courant.noeudSuivant();
				return e;
			}
			throw new NoSuchElementException();
		}
		
		
	}



}
 