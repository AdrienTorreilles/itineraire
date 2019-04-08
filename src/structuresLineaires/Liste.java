package structuresLineaires;

public interface Liste<E> extends Iterable<E> {
	
	public int longueur();
	public E ieme(int r) throws RangInvalideException;
	public void supprimer(int r) throws RangInvalideException;
	public void ajouter(int r, E e ) throws RangInvalideException;
	

}
