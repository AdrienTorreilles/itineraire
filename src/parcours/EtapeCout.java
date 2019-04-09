package gestionAlgorithme;

public class EtapeCout<E>  extends Etape<E>{

	private double cout;
	final double longueur=1;
	
	public EtapeCout(E element, Etape<E> precedent) {
		
		
		super(element, precedent);
	}
}
