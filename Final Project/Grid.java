//package FinalProject;

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
		this.bombGrid = new boolean [10][10];
		this.countGrid = new int [10][10];
		createBombGrid();
		createCountGrid();
	}

	public Grid(int rows, int columns) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = 25;
		this.bombGrid = new boolean [10][10];
		this.countGrid = new int [10][10];
		createBombGrid();
		createCountGrid();
	}

	public void Grid(int rows, int columns, int bombs) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = bombs;
		this.bombGrid = new boolean [10][10];
		this.countGrid = new int [10][10];
		createBombGrid();
		createCountGrid();
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
		return this.bombGrid;
	}

	public int[][] getCountGrid() {
		return this.countGrid;
	}

	public boolean isBombAtLocation(int row, int column) {
		if (bombGrid[row][column] == true) {
			return true;
		}
		else { 
			return false;
		}
	}

	public int getCountAtLocation(int row, int column) {
		int surroundingBombs = 0;
		if(row > 0 && column > 0 && row <= this.numRows && column <= numColumns) {
			if(isBombAtLocation(row, column) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row, column + 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row, column - 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row + 1, column) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row + 1, column + 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row + 1, column - 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row - 1, column) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row - 1, column + 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
			if (isBombAtLocation(row - 1, column - 1) == true) {
				surroundingBombs = surroundingBombs + 1;
			}
		}
		return surroundingBombs;
	}

	private void createBombGrid() {
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numColumns; j++){
				bombGrid[i][j] = false;
			}
		}
		for (int i = 0; i < numBombs; i++) {
            int random1 = (int) (Math.random() * 10);
            int random2 = (int) (Math.random() * 10);
            if (random1 < numRows && random2 < numColumns) {
                if (bombGrid[random1][random2]) {
                    i--;
                } else {
                    bombGrid[random1][random2] = true;
                }
            }
            else {
                i--;
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                System.out.print(bombGrid[i][j] + " ");
            }
            System.out.println();
        }
    }


	public void createCountGrid() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				countGrid[i][j] = getCountAtLocation(i, j);
				System.out.print(countGrid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
