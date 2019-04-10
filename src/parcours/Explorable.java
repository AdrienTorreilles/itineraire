package parcours;



import structuresLineaires.Liste;

public interface Explorable<E> {

	

	/**
	 * 
	 * @param e
	 * @return la liste des étapes suivantes, que l'on spécifie à l'implémentation
	 */
	public  Liste<E> etapesSuivantes(E e);

	/**
	 * 
	 * @return l'étape initiale
	 */
	public   E etapeInit();

	
	/**
	 * 
	 * @param e
	 * @return true si e est l'étape d'arrivée, spécifique à l'implémentation
	 */
	public  boolean estArrive(E e);



}
