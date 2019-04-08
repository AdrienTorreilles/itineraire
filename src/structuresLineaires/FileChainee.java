package structuresLineaires;

public class FileChainee<E> extends ListeChaineeDouble<E> implements File<E> {

	
	public FileChainee() {
		super();
	}
	
	
	public boolean estVide() {
		return longueur()==0;
	}

	
	public E premier() throws FileVideException {
		if(estVide()) throw new FileVideException();
		return elementDeTete();
	}

	public void defiler() throws FileVideException {
		if(estVide()) throw new FileVideException();
		supprimerEnTete();
		
		
	}

	
	public void enfiler(E e) {
		ajouterEnQueue(e);
		
	}

}
