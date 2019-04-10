package parcours;

public class Etape<E> {

	E element;
	Etape<E> precedent;
	
	public Etape(E e, Etape<E> p) {
		this.element=e;
		this.precedent=p;
	}
	
	public E element() {
		return element;
	}
	
	public Etape<E> precedent(){
		return precedent;
	}
	
	/**
	 * renvoie vrai si les étapes sont égales
	 */
	@Override
	public boolean equals(Object e) {
		
		return element.equals(((Etape<E>) e).element());
		
	}
	
	/**
	 * renvoie l'id de marquage
	 */
	@Override
	public int hashCode() {
		
		return element.hashCode();
	}
}
