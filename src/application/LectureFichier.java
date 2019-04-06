package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import parcours.Position;

public class LectureFichier {

	private static Position depart;
	private static Position arrive;

	public int[][] LectureMapFichier(File fichier, int x, int y) throws Exception {

		int[][] matrice = new int[x][y];

		int nbx = 0;
		int nby = 0;
		int nbLignes = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
			int caract = 2;
			while (caract != -1) {
				caract = br.read();
				if (nbLignes <= 3) {
					if ((char) caract == '\n') {
						nbLignes += 1;
						caract = br.read();
					}
				} else {
					if (Character.isWhitespace(caract)) {
						if ((char) caract == '\r') {
							System.out.print("");
						} else if ((char) caract == '\n') {
							System.out.print((char) caract);
							nbx = 0;
							nby++;
						} else {
							System.out.print(" "); // pour l'affichage
							matrice[nby][nbx] = 0;
							nbx++;
						}
					} else {
						System.out.print("X"); // pour l'affichage (char) caract
						matrice[nby][nbx] = -1;
						nbx++;
					}
				}

			}

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) { //
			System.out.println(e.getMessage());
		}
		return matrice;

	}

	public void affichageMap(int[][] matrice, TextArea textArea) throws Exception {

		for (int[] x1 : matrice) {
			for (int y1 : x1) {
				System.out.print(y1 + " ");
				textArea.setText(textArea.getText() + y1);
			}
			System.out.println();
			textArea.setText(textArea.getText() + "\n");
		}

	}

	public String[] lectureInfoFichier(File fichier) {

		int nbLignes = 0;
		String[] informationMatrice = new String[7];

		try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
			String ligneLue = br.readLine();

			while (nbLignes <= 3) {
				switch (nbLignes) {
				case 0:
					informationMatrice[0] = ligneLue;
					break;
				case 1:
					String[] coordonneesDepart = ligneLue.split("	");
					setDepart(new Position(Integer.parseInt(coordonneesDepart[0]),
							Integer.parseInt(coordonneesDepart[1])));
					informationMatrice[1] = coordonneesDepart[0];
					informationMatrice[2] = coordonneesDepart[1];
					break;
				case 2:
					String[] coordonneesArrive = ligneLue.split("	");
					setArrive(new Position(Integer.parseInt(coordonneesArrive[0]),
							Integer.parseInt(coordonneesArrive[1])));
					informationMatrice[3] = coordonneesArrive[0];
					informationMatrice[4] = coordonneesArrive[1];
					break;
				case 3:
					String[] tailleMatrice = ligneLue.split("	");
					informationMatrice[5] = tailleMatrice[0];
					informationMatrice[6] = tailleMatrice[1];
					break;
				}
				nbLignes++;
				ligneLue = br.readLine();
			}

		} catch (FileNotFoundException e) { // normalement le fichier existe

			System.out.println(e.getMessage());
		} catch (IOException e) { //
			System.out.println(e.getMessage());
		}
		System.out.println();
		for (int i = 0; i < 7; i++) {
			System.out.println(informationMatrice[i] + "/");
		}
		return informationMatrice;
	}

	public void lectureListMap(ChoiceBox choiceBox) {
		choiceBox.getItems().clear();
		File dossier = new File(System.getProperty("user.dir"), "map\\");
		File[] listeDeFichiers = dossier.listFiles();

		for (int i = 0; i < listeDeFichiers.length; i++) {
			if (listeDeFichiers[i].isFile()) {
				choiceBox.getItems().add(listeDeFichiers[i].getName());
				// System.out.println(listeDeFichiers[i].getName());
			}
		}
	}
	
	public void ajoutPoint(int[][] matrice, Position depart, Position arrive) {
		matrice[depart.getX()][depart.getY()] = 9;
		matrice[arrive.getX()][arrive.getY()] = 8;
	}

	public static void main(String[] args) {
		File rep = new File(System.getProperty("user.dir"), "map\\");
		File fichier = new File(rep, "map.txt");
		Position depart = new Position(1, 1);
		Position arrive = new Position(1, 18);
		try {
			LectureFichier lecture = new LectureFichier();
			// lecture.lectureMap();
			// lecture.lectureInfoFichier(fichier);
			lecture.LectureMapFichier(fichier, 40, 80);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}

	public Position getDepart() {
		return depart;
	}

	public static void setDepart(Position depart) {
		LectureFichier.depart = depart;
	}

	public Position getArrive() {
		return arrive;
	}

	public static void setArrive(Position arrive) {
		LectureFichier.arrive = arrive;
	}

}
