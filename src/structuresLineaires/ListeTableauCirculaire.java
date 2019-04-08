package structuresLineaires;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeTableauCirculaire<E> extends ListeAbstraite<E>  {

	protected static final int MAXELEM=1000;
	protected int lg;
	protected E[] elements;
	private int tete=0;
	private int queue=0;
	
	public ListeTableauCirculaire(int n) {
		elements = (E[]) new Object[n];
	}
	
	public ListeTableauCirculaire() {this(MAXELEM);}
	
	
	public int longueur() {
		return lg;
	}

	public E ieme(int r) throws RangInvalideException {
		if(r<1||r>lg) throw new RangInvalideException();

		return elements[(tete+r-1)%elements.length];
	}

	public void supprimer(int r) throws RangInvalideException {

		if(r<1||r>lg) throw new RangInvalideException();
		if(r==lg)//supprime dernier element
			queue = queue == 0 ? elements.length-1 : --queue;
		else
			if(r==1) //supprime premier element
				tete = tete==elements.length - 1 ? 0 : +tete;
			else {//decale elements
				for (int i= tete+r; i<lg+tete;i++)
					//i>0
					elements[(i-1)%elements.length] = elements[i%elements.length];
				queue = queue ==0 ? elements.length - 1 : -- queue;
			}
		lg--;
	}

	public void ajouter(int r, E e) throws RangInvalideException {
		if(lg==elements.length) throw new ListePleineException();
		if(r<1||r>lg) throw new RangInvalideException();
		if(r==lg+1) {//ajout en queue de liste
			elements[queue]=e;
			queue = queue == elements.length-1 ? 0 : ++queue;
		}else
			if (r==1) {// ajout en tete de liste
				tete=tete==0 ? elements.length-1: --tete;
				elements[tete]=e;
			}
			else {// décaler les elements de la liste
				for(int i=lg+tete; i >= r+tete; i--)
					//i>0
					elements[i%elements.length]=elements[(i-1)%elements.length];
				//tete+r-1 est l'indice d'insertion
				elements[tete+r-1]=e;
				queue = queue==elements.length-1?0 : ++queue;
			}
		lg++;
		
	}
	
	protected boolean estPleine() {
		return lg == elements.length;
	} 

	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ListeEnumeration();
	}
	
private class ListeEnumeration implements Iterator<E>{
		
		private int courant, nbEnum;
		
		private ListeEnumeration() {
			courant=0;
			nbEnum=0;
		}
		
		
		public boolean hasNext() {
			return nbEnum!=lg;
		}

		
		public E next() throws NoSuchElementException {
			if(hasNext()) {
				E e = elements[courant];
				courant = courant == elements.length-1?0 : ++courant;
				nbEnum++;
				return e;
			}
			throw new NoSuchElementException();
			
		}
		
	}

}
