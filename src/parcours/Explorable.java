package parcours;



import structuresLineaires.Liste;

public interface Explorable<E> {

	

	/**
	 * 
	 * @param e
	 * @return la liste des �tapes suivantes, que l'on sp�cifie � l'impl�mentation
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
	 * @return true si e est l'�tape d'arriv�e, sp�cifique � l'impl�mentation
	 */
	public  boolean estArrive(E e);



}
