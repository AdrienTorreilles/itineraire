package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import parcours.Position;

public class LectureFichier {

	static Position depart;
	static Position arrive;

	public void LectureMapFichier(File fichier) throws Exception {

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
						} else {
							System.out.print(" "); // pour l'affichage
						}
					} else {
						System.out.print("X"); // pour l'affichage (char) caract
					}
				}

			}
		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) { //
			System.out.println(e.getMessage());
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
					depart = new Position(Integer.parseInt(coordonneesDepart[0]),
							Integer.parseInt(coordonneesDepart[1]));
					informationMatrice[1] = coordonneesDepart[0];
					informationMatrice[2] = coordonneesDepart[1];
					break;
				case 2:
					String[] coordonneesArrive = ligneLue.split("	");
					depart = new Position(Integer.parseInt(coordonneesArrive[0]),
							Integer.parseInt(coordonneesArrive[1]));
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
			System.out.println();
			System.out.print(informationMatrice[i] + "/");
		}
		return informationMatrice;
	}

	public static void main(String[] args) {
		File rep = new File(System.getProperty("user.dir"), "map\\");
		File fichier = new File(rep, "map5.txt");
		try {
			LectureFichier lecture = new LectureFichier();
			lecture.lectureInfoFichier(fichier);
			lecture.LectureMapFichier(fichier);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

	}

}
