package structuresLineaires;

public class PileChainee<E> extends ListeChainee<E> implements Pile<E> {
	
	public PileChainee() {
		super();
	}


	
	public boolean estVide() {
		return longueur()==0;
	}

	@Override
	public E sommet() throws PileVideException {
		if(estVide()) throw new PileVideException();
		return elementDeTete();
	}

	@Override
	public void depiler() throws PileVideException {
		if(estVide()) throw new PileVideException();
		supprimerEnTete();
		
	}

	@Override
	public void empiler(E e) {
		ajouterEnTete(e);
	}

}
