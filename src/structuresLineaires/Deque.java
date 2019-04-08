package structuresLineaires;

public interface Deque<E> {

	public enum Sens {
		gauche,
		droite;
	}
	public boolean estVide();
	public E extremite(Sens sens) throws DequeVideException;
	public void dedequer(Sens sens) throws DequeVideException;
	public void endequer(E e, Sens sens);
}
