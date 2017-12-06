package cz.uhk.pro2.spyhunter.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import cz.uhk.pro2.spyhunter.model.GameBoard;
import cz.uhk.pro2.spyhunter.model.NonRoadTile;
import cz.uhk.pro2.spyhunter.model.RoadTile;
import cz.uhk.pro2.spyhunter.model.Tile;

public class CsvGameBoardLoader {
	public GameBoard loadGameBoard() { // pravym surrounds try catch
		try (BufferedReader reader = new BufferedReader(new FileReader("gameboard.csv"))) {
			// precteme prvni radek s rozmery pole
			String[] line = reader.readLine().split(",");

			int rows = Integer.valueOf(line[0]);
			int cols = Integer.valueOf(line[1]);
			Tile[][] tiles = new Tile[rows][cols];
			// musime to vzit od spoda nahoru kruvi vykreslovani
			// do matice ukladame data "vzhuru nohama"
			for (int i = rows - 1; i >= 0; i--) {
				line = reader.readLine().split(",");
				for (int j = 0; j < cols; j++) {
					// aby se nestalo, kdyby to pole bylo mensi(excel to zkrati), jinak nejdriv
					// vyhodnoti prvni a kdyz neni pravda tak se podminkou za && uz nezaubira
					// kdyz tam neni X, tak je silnice
					if (line.length > j && line[j].equals("X")) {
						// trava
						tiles[i][j] = new NonRoadTile();
					}else if(line[j].equals("B"))
					{
						tiles[i][j] = new NonRoadTile(1);
					}
					
					
					
					else {
						// silnice
						tiles[i][j] = new RoadTile();
					}
				}
			}
			return new GameBoard(tiles);

		} catch (FileNotFoundException e) {
			throw new GameBoardLoadingException(e);
		} catch (IOException e) {
			throw new GameBoardLoadingException(e);
		}

	}

}
