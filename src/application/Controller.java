package application;

import java.io.File;

import com.sun.javafx.scene.paint.GradientUtils.Parser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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
    }
	
	@FXML
	private void choixMap(ActionEvent Evt) throws Exception {
		textAreaMatrice.clear();
		File rep = new File(System.getProperty("user.dir"), "map\\");
		File fichier = new File(rep, (String) choiceBoxMap.getValue());
		String[] informationMatrice;
		LectureFichier lecture = new LectureFichier();
		informationMatrice = lecture.lectureInfoFichier(fichier);
		int[][] matrice = lecture.LectureMapFichier(fichier, Integer.parseInt(informationMatrice[5]), Integer.parseInt(informationMatrice[6])); 
		lecture.ajoutPoint(matrice, lecture.getDepart(), lecture.getArrive());
		lecture.affichageMap(matrice, textAreaMatrice);
	}
	
	@FXML
	private void actionRafraichir(ActionEvent Evt) {
		LectureFichier lecture = new LectureFichier();
		lecture.lectureListMap(choiceBoxMap);
	}
	
	@FXML
	private void actionResoudre(ActionEvent Evt) {
		//TODO : CODE DE RESOLUTION DU LABY
	}
}
