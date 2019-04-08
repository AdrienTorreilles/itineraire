package structuresLineaires;

public class PileTableau<E> extends ListeTableau<E> implements Pile<E> {

	public PileTableau() {
		this(MAXELEM);
	}

	public PileTableau(int maxelem) {
		super(maxelem);

	}

	public boolean estVide() {
		return longueur() == 0;
	}

	public E sommet() throws PileVideException {
		if(estVide()) throw new PileVideException();
		return elementDeQueue();
	}

	public void depiler() throws PileVideException {
		if(estVide()) throw new PileVideException();
		supprimerEnQueue();
	}

	@Override
	public void empiler(E e) {
		if(estPleine()) throw new PilePleineException();
		ajouterEnQueue(e);
	}
}
