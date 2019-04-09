package gestionAlgorithme;

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
}
