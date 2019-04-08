package structuresLineaires;

public abstract class ListeAbstraite<E> implements Liste<E>{
	final E elementDeTete() { return ieme(1);}
	final E elementDeQueue() { return ieme(longueur());}
	final void ajouterEnTete(E e) { ajouter(1,e);}
	final void ajouterEnQueue(E e) { ajouter(longueur()+1,e);}
	final void supprimerEnTete() { supprimer(1);}
	final void supprimerEnQueue() { supprimer(longueur());}

	
	

}
