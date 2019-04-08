package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import parcours.Position;

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
		// Matrice a resoudre
		// doit renvoyer une liste de position "chemin"

		Position[] chemin = new Position[12];
		chemin[0] = new Position(2,1);
		chemin[1] = new Position(3,1);
		chemin[2] = new Position(3,2);
		chemin[3] = new Position(3,3);
		chemin[4] = new Position(3,4);
		chemin[5] = new Position(2,4);
		chemin[6] = new Position(2,5);
		chemin[7] = new Position(1,5);
		chemin[8] = new Position(1,6);
		chemin[9] = new Position(1,7);
		chemin[10] = new Position(1,8);
		chemin[11] = new Position(2,8);

		lecture.ajoutPoint(matrice, lecture.getDepart(), lecture.getArrive());
		lecture.ajoutChemin(matrice, chemin);
		lecture.affichageMap(matrice, textAreaMatrice);
	}

}
