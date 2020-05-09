package FinalProject;
import java.util.*;
import java.io.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		createBombGrid();
		createCountGrid();
	}

	public Grid(int rows, int columns) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = 25;
		this.bombGrid = new boolean [this.numRows][this.numColumns];
		this.countGrid = new int [this.numRows][this.numColumns];
		createBombGrid();
		createCountGrid();
	}

	public  Grid(int rows, int columns, int bombs) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = bombs;
		this.bombGrid = new boolean [this.numRows][this.numColumns];
		this.countGrid = new int [this.numRows][this.numColumns];
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

	public static void main(String[] args) {
		final int numToWin = 0;
		final int numFlags = -1;
		final int lost = 0;
		//final boolean replay = true;
		final int numWins = 0;

		Grid bombGrid = new Grid(20,20,40);
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("Minesweeper");
		gameFrame.setSize(bombGrid.getNumRows() * 60, bombGrid.getNumColumns() * 60);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);

		JTextField gameText = new JTextField();
		
		for (int i = 0; i < bombGrid.getNumRows(); i++) {
			for (int j = 0; j < bombGrid.getNumColumns(); j++) {
				JButton buttonLabel = new JButton();
				buttonLabel.setBounds(i * 50, j * 50, 50, 50);
				buttonLabel.setVisible(true);
				if (i == bombGrid.getNumRows() || j == bombGrid.getNumColumns()) {
					buttonLabel.setVisible(false);
				}
				gameFrame.add(buttonLabel);
				gameFrame.setLayout(null);
				buttonLabel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ImageIcon littleRedFlag = new ImageIcon("redflag.png");
						JButton flag = new JButton(littleRedFlag);
						flag.setIcon(littleRedFlag);
						flag.setBounds(buttonLabel.getLocation().x, buttonLabel.getLocation().y, 50, 50);
						flag.setVisible(true);
						if (lost == 0) {
							gameFrame.add(flag);
							buttonLabel.setVisible(false);
						}
						numFlags++;
						System.out.println("Number of mines identified: " + numFlags + "/" + bombGrid.getNumBombs());
						if (lost == 0) {
							flag.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									flag.setVisible(false);
									JButton dig = new JButton();
									dig.setBounds(buttonLabel.getLocation().x, buttonLabel.getLocation().y, 50, 50);
									dig.setVisible(true);
									gameFrame.add(dig);
									if (bombGrid.isBombAtLocation((int) (buttonLabel.getLocation().y / 50), (int) (buttonLabel.getLocation().x / 50))) {
										dig.setText("Bomb");
										dig.setVisible(true);
										dig.setBackground(Color.RED);
										dig.setOpaque(true);
										JFrame mainFrame = new JFrame("Java Swing Examples");
										mainFrame.setSize(400,400);
										JFrame frame;
										frame = new JFrame();
										int input = JOptionPane.showOptionDialog(null, "Game Over. Would you like to play again?", "Game Over", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
										if(input == JOptionPane.OK_OPTION){
											gameFrame.setVisible(false);
										}
									} 
									else {
										numFlags--;
										dig.setText(Integer.toString(bombGrid.getCountAtLocation((int) (buttonLabel.getLocation().y / 50), (int) (buttonLabel.getLocation().x / 50))));
										dig.setBackground(Color.GREEN);
										dig.setOpaque(true);
										System.out.println("NumToWin = " + numToWin);
										if (numToWin == bombGrid.getNumColumns() * bombGrid.getNumRows() - bombGrid.getNumBombs()) {
											JFrame mainFrame = new JFrame("Java Swing Examples");
											mainFrame.setSize(400,400);
											JFrame frame;
											frame = new JFrame();
											int input = JOptionPane.showOptionDialog(null, "You won! Would you like to play again?", "Game Over", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
											if(input == JOptionPane.OK_OPTION){
												gameFrame.setVisible(false);
											}
											numWins++;
										}
									}
								}
							}
							);
						}
					}
				}
				);
			}
		}
		gameFrame.setVisible(true);

	}

}

