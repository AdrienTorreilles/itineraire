package gestionAlgorithme;



import structuresLineaires.Liste;

public interface Explorable<E> {


	public  Liste<E> etapesSuivantes(E e);

	public   E etapeInit();

	public  boolean estArrive(E e);



}
