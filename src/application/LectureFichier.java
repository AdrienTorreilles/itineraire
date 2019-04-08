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

	
	/**
	 * Permet de retourner une matrice de int a 2 dimensions d'un fichier texte Lu
	 * 
	 * 
	 */
	public char[][] LectureMapFichier(File fichier, int x, int y) throws Exception {

		char[][] matrice = new char[x][y];

		int matriceX = 0; 
		int matriceY = 0;
		int nbLignes = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
			int caract = 2; // Il se peut qu'il n'est pas de caracteres dans un fichier donc on met une valeur par defaut
			while (caract != -1) {
				caract = br.read();
				if (nbLignes <= 3) {
					// Passe les 4 lignes d'information du fichier (Nom / depart / arriver / taille)
					if ((char) caract == '\n') {
						nbLignes += 1;
						caract = br.read();
					}
				} else {
					//traite les caracteres lu
					if (Character.isWhitespace(caract)) {
						if ((char) caract == '\r') {
							//premier caractere qui permet le retour a la ligne mais qu'on doit ignorer
							System.out.print("");
						} else if ((char) caract == '\n') {
							//retour a la ligne
							System.out.print((char) caract);
							matriceX = 0;
							matriceY++;
						} else {
							System.out.print(" "); // pour l'affichage du franchissable
							matrice[matriceY][matriceX] = '1';
							matriceX++;
						}
					} else {
						System.out.print("X"); // pour l'affichage  des murs
						matrice[matriceY][matriceX] = 'X';
						matriceX++;
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

	/**
	 * Affiche une matrice de int a 2 dimensions dans un TextArea
	 */
	public void affichageMap(char[][] matrice, TextArea textArea) throws Exception {

		System.out.println();
		for (char[] x : matrice) {
			for (char y : x) {
				System.out.print(y + " ");
				if (y == 'X') {
					textArea.setText(textArea.getText() + "X");
				} else if (y == '1'){
					textArea.setText(textArea.getText() + " ");
				} else {
					if (y == 'D') {
						textArea.setText(textArea.getText() + "D");
					} else if (y == 'A'){
						textArea.setText(textArea.getText() + "A");
					} else {
						textArea.setText(textArea.getText() + y);
					}
					
				}
			}
			System.out.println();
			textArea.setText(textArea.getText() + "\n");
		}

	}
	
	/**
	 * Affiche une matrice de int a 2 dimensions dans la console
	 */
	public void affichageMapConsole(char[][] matrice) throws Exception {

		System.out.println();
		for (char[] x1 : matrice) {
			for (char y1 : x1) {
				System.out.print(y1 + " ");
			}
			System.out.println();
		}

	}


	/**
	 * Permet de lire les 4 lignes d'information d'un fichier labyrinthe
	 */
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

	/**
	 * Ajoute le nom des fichiers texte se situant dans le dossier map du projet dans une ChoiceBox
	 */
	public void lectureListMap(ChoiceBox choiceBox) {
		choiceBox.getItems().clear();
		File dossier = new File(System.getProperty("user.dir"), "map\\");
		File[] listeDeFichiers = dossier.listFiles();

		for (int i = 0; i < listeDeFichiers.length; i++) {
			if (listeDeFichiers[i].isFile()) {
				choiceBox.getItems().add(listeDeFichiers[i].getName());
			}
		}
		choiceBox.setValue(choiceBox.getItems().get(0));
	}

	/**
	 * Ajoute le depart et l'arrive dans une matrice
	 */
	public void ajoutPoint(char[][] matrice, Position depart, Position arrive) {
		matrice[depart.getX()][depart.getY()] = 'D';
		matrice[arrive.getX()][arrive.getY()] = 'A';
	}

	/**
	 * Ajoute le chemin de possition dans une matrice
	 */
	public void ajoutChemin(char[][] matrice, Position[] chemin) {

		for (int i = 0; i < chemin.length; i++) {
			matrice[chemin[i].getX()][chemin[i].getY()] = '0';
		}
	}

	/**
	 * Tests unitaires
	 */
	public static void main(String[] args) {
		File rep = new File(System.getProperty("user.dir"), "map\\");
		File fichier = new File(rep, "map.txt");
		Position depart = new Position(1, 1);
		Position arrive = new Position(1, 18);
		try {
			LectureFichier lecture = new LectureFichier();
			// lecture.lectureMap();
			// lecture.lectureInfoFichier(fichier);
			char[][] matriceTest = lecture.LectureMapFichier(fichier, 40, 80);
			Position[] matriceChemin = new Position[10];
			for (int i = 0; i<10; i++) {
				matriceChemin[i] = new Position(1, i);
			}
			lecture.ajoutChemin(matriceTest, matriceChemin);
			lecture.affichageMapConsole(matriceTest);
			
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
