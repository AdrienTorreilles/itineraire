package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import parcours.Algorithme;
import parcours.MatriceChar;
import parcours.Position;
import structuresLineaires.Liste;
import structuresLineaires.ListeChainee;

public class Controller {

	@FXML
	Label labelTemps = new Label();

	@FXML
	Label labelEtape = new Label();

	@FXML
	Button buttonMap = new Button();

	@FXML
	Button buttonResoudre = new Button();

	@FXML
	ChoiceBox choiceBoxMap = new ChoiceBox<Object>();

	@FXML
	ChoiceBox choiceBoxAlgo = new ChoiceBox<Object>();

	@FXML
	TextArea textAreaMatrice = new TextArea();

	@FXML
	public void initialize() {
		LectureFichier lecture = new LectureFichier();
		lecture.lectureListMap(choiceBoxMap);
		choiceBoxAlgo.getItems().add("Parcours");
		choiceBoxAlgo.getItems().add("Etoiles");
		choiceBoxMap.setValue(choiceBoxMap.getItems().get(0));
		choiceBoxAlgo.setValue(choiceBoxAlgo.getItems().get(0));
	}

	/**
	 * Action qui s'execute au changement du choix de labyrinthe
	 */
	@FXML
	private void choixMap(ActionEvent Evt) throws Exception {
		textAreaMatrice.clear();
		File rep = new File(System.getProperty("user.dir"), "map\\");
		File fichier = new File(rep, (String) choiceBoxMap.getValue());
		String[] informationMatrice;
		LectureFichier lecture = new LectureFichier();
		informationMatrice = lecture.lectureInfoFichier(fichier);
		char[][] matrice = lecture.LectureMapFichier(fichier, Integer.parseInt(informationMatrice[5]),
				Integer.parseInt(informationMatrice[6]));
		lecture.ajoutPoint(matrice, lecture.getDepart(), lecture.getArrive());
		lecture.affichageMap(matrice, textAreaMatrice);
	}

	/**
	 * S'execute a l'appuie du bouton "Rafraichir"
	 */
	@FXML
	private void actionRafraichir(ActionEvent Evt) {
		LectureFichier lecture = new LectureFichier();
		lecture.lectureListMap(choiceBoxMap);
	}

	/**
	 * Action qu'execute le bouton "Résoudre"
	 */
	@FXML
	private void actionResoudre(ActionEvent Evt) throws NumberFormatException, Exception {
		textAreaMatrice.clear();
		File rep = new File(System.getProperty("user.dir"), "map\\");
		File fichier = new File(rep, (String) choiceBoxMap.getValue());
		String[] informationMatrice;
		LectureFichier lecture = new LectureFichier();
		informationMatrice = lecture.lectureInfoFichier(fichier);
		char[][] matrice = lecture.LectureMapFichier(fichier, Integer.parseInt(informationMatrice[5]),
				Integer.parseInt(informationMatrice[6]));
		lecture.ajoutPoint(matrice, lecture.getDepart(), lecture.getArrive());
		// Matrice a resoudre
		// doit renvoyer une liste de position "chemin"
		
		MatriceChar labyrinthe = new MatriceChar(matrice, lecture.getDepart(), lecture.getArrive(), Integer.parseInt(informationMatrice[5]),
				Integer.parseInt(informationMatrice[6]));
		Liste<Position> parcours = new ListeChainee<Position>();
		parcours = Algorithme.parcoursLargeur(labyrinthe);

		labyrinthe.ajouterParcours(parcours);
		lecture.affichageMap(labyrinthe.getMatriceChar(), textAreaMatrice);
	}

}
