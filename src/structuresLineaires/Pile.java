package structuresLineaires;

public interface Pile<E> {
	
	public boolean estVide();
	public E sommet() throws PileVideException;
	public void depiler() throws PileVideException;
	public void empiler(E e);
	

}
