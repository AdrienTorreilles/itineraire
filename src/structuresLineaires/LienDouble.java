package structuresLineaires;

public class LienDouble<T> extends Lien<T> {

	protected Lien<T> precedent;
	protected Lien<T> precedent() {return precedent;}
	protected void precedent(Lien<T> p) { precedent = p;}
}
