package structuresLineaires;

public class DequeChainee<E> extends ListeChaineeDouble<E> implements Deque<E> {
	
	public DequeChainee() {
		super();
	}

	public boolean estVide() {
		return longueur()==0;
	}

	public E extremite(Sens sens) throws DequeVideException {
		if(estVide()) throw new DequeVideException();
		
		return  sens == Sens.gauche ? elementDeQueue():elementDeTete();
	}

	public void dedequer(Sens sens) throws DequeVideException {
		if(estVide()) throw new DequeVideException();
		if(sens == Sens.gauche) supprimerEnQueue();
		else // sens== Sens.droite
			supprimerEnTete();
		

		
	}

	public void endequer(E e, Sens sens) {
		if(sens == Sens.gauche)ajouterEnQueue(e);
		else// sens==Sens.droite
			ajouterEnTete(e);
	}

}
