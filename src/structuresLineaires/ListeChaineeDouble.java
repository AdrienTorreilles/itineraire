package structuresLineaires;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListeChaineeDouble<E> extends ListeAbstraite<E> {

	protected int lg;
	protected NoeudDouble<E> tete, queue;
	
	
	public int longueur() {
		
		return lg;
	}

	@Override
	public E ieme(int r) throws RangInvalideException {
		if(r<1|| r>lg) throw new RangInvalideException();
		NoeudDouble<E> n = tete;
		
		for( int i = 1; i<r ; i++) n=n.noeudSuivant();
		return n.valeur();
	}

	@Override
	public void supprimer(int r) throws RangInvalideException {
		if(r<1|| r>lg) throw new RangInvalideException();
		if(lg==1) tete = queue = null;
		else
			if ( r==1 )
				tete=tete.noeudSuivant();
			else 
				if(r==lg) {
					queue=queue.noeudPrecedent();
					queue.noeudSuivant(null);
				}
				else {
					NoeudDouble<E> q= tete, p= null;
					for(int i=1; i<r; i++) {
						p=q;
						q=q.noeudSuivant();
					}
					q.noeudSuivant().noeudPrecedent(p);
					p.noeudSuivant(q.noeudSuivant());
				}
		lg--;
	}

	@Override
	public void ajouter(int r, E e) throws RangInvalideException {
		if(r<1||r>lg+1) throw new RangInvalideException();
		NoeudDouble<E> n = new NoeudDouble<E>(e);
		if(lg==0)
			tete=queue=n;
		else
			if (r==1) {
				tete.noeudPrecedent(n);
				n.noeudSuivant(tete);
				tete=n;
			}
			else
				if(r==lg + 1) {
					queue.noeudSuivant(n);
					n.noeudPrecedent(queue);
					queue=n;
				}
				else {
					NoeudDouble<E> p=null, q=tete;
					for(int i=1; i<r; i++) {
						p=q;
						q=q.noeudSuivant();
						
					}
					p.noeudSuivant(n);
					n.noeudPrecedent(p);
					n.noeudSuivant(q);
					q.noeudPrecedent(n);
				}
		lg++;
		
	}

	public Iterator<E> iterator() {
		return new ListeEnumeration();
	}
	private class ListeEnumeration implements Iterator<E>{

		private NoeudDouble<E> courant;
		
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
