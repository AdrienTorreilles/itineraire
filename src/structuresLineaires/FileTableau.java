package structuresLineaires;

public class FileTableau<E> extends ListeTableauCirculaire<E> implements File<E> {

	public FileTableau() {
		super();
	}
	
	public FileTableau(int n) {
		super(n);
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

	@Override
	public void enfiler(E e) {
		if(estVide()) throw new FileVideException();
		ajouterEnQueue(e);
	}
	
	

}
