package structuresLineaires;

import java.util.Iterator;
import java.util.NoSuchElementException;

public  class ListeTableau<E> extends ListeAbstraite<E> {

	protected static final int MAXELEM=1000;
	protected int lg;
	protected E[] elements;
	
	public ListeTableau(int n) {
		elements = (E[]) new Object[n];
	}
	
	public ListeTableau() {this(MAXELEM);}
	
	
	public int longueur() {
		return lg;
	}


	public E ieme(int r) throws RangInvalideException {

		if(r<1||r>lg) throw new RangInvalideException();
		return elements[r-1];
	}

	public void supprimer(int r) throws RangInvalideException {
		if(r<1||r>lg) throw new RangInvalideException();
		//décale les elements à "gauche"
		for (int i = r; i< lg; i++)
			elements[i-1]=elements[i];
		lg--;
	}

	
	public void ajouter(int r, E e) throws RangInvalideException {

		if (lg==elements.length) throw new ListePleineException();
		if(r<1||r>lg) throw new RangInvalideException();
		//décale les éléments à "droite"
		for(int i=lg; i>=lg; i--) 
			elements[i]=elements[i-1];
		elements[r-1]=e;
		lg++;

	}
	
	protected boolean estPleine() {
		return lg == elements.length;
	}
	

	public Iterator<E> iterator() {
		return new ListeEnumeration();
	}

	
	private class ListeEnumeration implements Iterator<E>{
		
		private int courant;
		
		private ListeEnumeration() {
			courant=0;
		}
		
		
		public boolean hasNext() {
			return courant!=lg;
		}

		
		public E next() throws NoSuchElementException {
			if(hasNext()) 
				return elements[courant++];
			throw new NoSuchElementException();
			
		}
		
		public void inverser() {
			for (int i = 0; i < longueur() ; i++) {
				
			}
		}
	}

}
