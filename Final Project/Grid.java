//package FinalProject;
import java.util.*;
import java.io.*;
import java.util.Random;

public class Grid {
	private boolean [ ][ ] bombGrid ;
	private int [ ][ ] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;

	public Grid() {
		this.numRows = 10;
		this.numColumns = 10;
		this.numBombs = 25;
		this.bombGrid = new boolean [this.numRows][this.numColumns];
		this.countGrid = new int [this.numRows][this.numColumns];
		//createBombGrid();
		//createCountGrid();
	}

	public Grid(int rows, int columns) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = 25;
		this.bombGrid = new boolean [this.numRows][this.numColumns];
		this.countGrid = new int [this.numRows][this.numColumns];
		//createBombGrid();
		//createCountGrid();
	}

	public  Grid(int rows, int columns, int bombs) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = bombs;
		this.bombGrid = new boolean [this.numRows][this.numColumns];
		this.countGrid = new int [this.numRows][this.numColumns];
		//createBombGrid();
		//createCountGrid();
	}

	public int getNumRows() {
		return this.numRows;
	}

	public int getNumColumns() {
		return this.numColumns;
	}

	public int getNumBombs() {
		return this.numBombs;
	}

	public boolean[][] getBombGrid() {
		boolean[][] copy = new boolean[numRows][numColumns];
		for (int i = 0; i < numRows; i++) {
			System.arraycopy(bombGrid[i], 0, copy[i], 0, bombGrid[i].length);
		}
		return copy;
	}

	public int[][] getCountGrid() {
		int[][] copy = new int[numRows][numColumns];
		for (int i = 0; i < numRows; i++) {
			System.arraycopy(countGrid[i], 0, copy[i], 0, countGrid[i].length);
		}
		return copy;
	}

	public boolean isBombAtLocation(int row, int column) {
		if (bombGrid[row][column] == true) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	
	//surroundingBombs = surroundingBombs + 1;

	public int getCountAtLocation(int row, int column) {
		int surroundingBombs = 0;
		boolean checkBombs = true;
		while(checkBombs == true) {
			if(isBombAtLocation(row, column) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if(column < (this.numColumns - 1) && isBombAtLocation(row, column + 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if(column > 0 && isBombAtLocation(row, column - 1) == true) {
				surroundingBombs = surroundingBombs + 1;			}
			if(row < (this.numRows - 1) && isBombAtLocation(row + 1, column) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if(row < (this.numRows - 1) && column < (this.numColumns - 1) && isBombAtLocation(row + 1, column + 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if(row < (this.numRows - 1) && column > 0 && isBombAtLocation(row + 1, column - 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if(row > 0 && isBombAtLocation(row - 1, column) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if(row > 0 && column < (this.numColumns - 1) && isBombAtLocation(row - 1, column + 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if(row > 0 && column > 0 && isBombAtLocation(row - 1, column - 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			checkBombs = false;
		}
		return surroundingBombs;
	}

	private void createBombGrid() {
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {
				bombGrid[i][j] = false;
			}
		}
		for(int i = 0; i < numBombs; i++) {
			int randomRow = (int) (Math.random() * numRows);
			int randomColumn = (int) (Math.random() * numColumns);
			if(bombGrid[randomRow][randomColumn] == true) {
				i = i - 1;
			}
			else {
				bombGrid[randomRow][randomColumn] = true;
			}
		}
	}


	private void createCountGrid() {
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {
				countGrid[i][j] = getCountAtLocation(i, j);
			}
		}
	}
}
