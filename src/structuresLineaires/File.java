package structuresLineaires;

public interface File<E> {
	public boolean estVide();
	public E premier() throws FileVideException;
	public void defiler() throws FileVideException;
	public void enfiler(E e) ;

}
