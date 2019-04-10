package parcours;



import structuresLineaires.Liste;

public interface Explorable<E> {


	/**
	 * 
	 * @param e
	 * @return la liste des �tapes suivantes
	 */
	public  Liste<E> etapesSuivantes(E e);

	/**
	 * 
	 * @return l'�tape initiale
	 */
	public   E etapeInit();

	
	/**
	 * 
	 * @param e
	 * @return true si e est l'�tape d'arriv�e
	 */
	public  boolean estArrive(E e);



}
