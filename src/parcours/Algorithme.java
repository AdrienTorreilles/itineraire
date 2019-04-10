package parcours;

import java.util.HashSet;


import structuresLineaires.FileChainee;
import structuresLineaires.Liste;
import structuresLineaires.ListeChainee;
import structuresLineaires.ListeTableau;

public class Algorithme {

	public static <T extends Explorable<E>,E> Liste<E> parcoursLargeur(T explorable) {
		FileChainee<Etape<E>> file = new FileChainee<>();
		boolean fin =false;
		HashSet<E> marque= new HashSet<>();
		ListeChainee<E> parcours = new ListeChainee<>();
		ListeChainee<Etape<E>> etapes= new ListeChainee<Etape<E>>();
		E debut = explorable.etapeInit();
		marque.add(debut);
		Etape<E> etape = new Etape<E>(debut, null);
		System.out.println(etapes.longueur());
		etapes.ajouter(1,etape);
		file.enfiler(etape);

		while (!file.estVide() && !fin) {
			etape = file.premier();
			file.defiler();

			if(explorable.estArrive(etape.element())) fin = true;
			if(!fin) {
				Liste<E> etapesSuivantes = explorable.etapesSuivantes(etape.element());
				if(etapesSuivantes.longueur()!=0) {
					for(E unSuivant : etapesSuivantes) {

						Etape<E> suivante = new Etape<>(unSuivant,etape);

						if(!marque.contains(unSuivant)) {

							marque.add(unSuivant);
							etapes.ajouter(1, suivante);
							file.enfiler(suivante);
						}
					}

				}
			}

		}
		if(fin){
			parcours.ajouter(1, etape.element());
			while( etape.precedent()!=null ) {
				etape = etape.precedent();
				if(etape !=null) {
				
					parcours.ajouter(1, etape.element());
				}
			}


		}

		return parcours;

	}

	public static <T extends Explorable<E>,E> Liste<E> parcoursAstar(T explorable) {
		return null;
	}
	/*public static <E extends Explorable<? super E>,T> void parcoursLargeurArbre(E explorable) {
		FileChainee<ArbreQuaternaireChaine<T>> file = new FileChainee<ArbreQuaternaireChaine<T>>();
		boolean fin =false;
		Liste<T> parcours = new ListeTableau<T>();
		Liste<ArbreQuaternaireChaine<T>> etapes= new ListeTableau<ArbreQuaternaireChaine<T>>();
		T debut = explorable.etapeInit();
		ArbreQuaternaireChaine<T> etape = new ArbreQuaternaireChaine<T>(debut);
		etapes.ajouter(0, etape);
		file.enfiler(etape);
		while (!file.estVide() && !fin) {
			etape = file.premier();
			file.defiler();

			if(explorable.estArrive(etape.racine())) fin = true;
			if(!fin) {
				Liste<T> etapesSuivantes = explorable.etapesSuivantes(etape.racine());
				if(etapesSuivantes.longueur()!=0) {
					for(T unSuivant : etapesSuivantes) {

						if(marque.add(unSuivant)) {

							Etape suivante = new Etape(unSuivant,etape);
							etapes.ajouter(0, suivante);
							file.enfiler(suivante);
						}
					}

				}
			}

		}
		if(fin){
			parcours.ajouter(0, etape.element());
			while( etape.precedent()!=null ) {
				etape = etape.precedent();
				if(etape !=null) {
					parcours.ajouter(0, etape.element());
				}
			}


		}*/





}
