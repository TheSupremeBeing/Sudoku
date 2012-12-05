import java.util.ArrayList;

public class Puzzle
{

	/**
	 * @param args
	 */
	int[][]		myBoard;
	Helper[][]	myHorizontalValues;
	Helper[][]	myVerticalValues;
	Helper[][]	myBoxValues;
	Helper[][]	myPossibleValues;

	public static void main(String[] args)
	{
		new Puzzle();
	}

	public Puzzle()
	{
		myBoard = new int[9][9];
		myHorizontalValues = new Helper[9][9];
		myVerticalValues = new Helper[9][9];
		myBoxValues = new Helper[9][9];
		myPossibleValues = new Helper[9][9];

		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				myPossibleValues[i][j] = new Helper(uglyNums());
			}
		}

		myBoard[0][5] = 8;
		myBoard[0][6] = 7;
		myBoard[0][7] = 2;
		myBoard[1][2] = 7;
		myBoard[1][8] = 9;
		myBoard[2][3] = 4;
		myBoard[2][4] = 9;
		myBoard[2][6] = 8;
		myBoard[2][8] = 5;
		myBoard[3][5] = 9;
		myBoard[3][6] = 5;
		myBoard[3][8] = 6;
		myBoard[4][0] = 5;
		myBoard[4][2] = 1;
		myBoard[4][3] = 7;
		myBoard[4][5] = 6;
		myBoard[4][6] = 3;
		myBoard[4][8] = 8;
		myBoard[5][0] = 4;
		myBoard[5][2] = 9;
		myBoard[5][3] = 8;
		myBoard[6][0] = 1;
		myBoard[6][2] = 8;
		myBoard[6][4] = 3;
		myBoard[6][5] = 2;
		myBoard[7][0] = 9;
		myBoard[7][6] = 2;
		myBoard[8][1] = 3;
		myBoard[8][2] = 2;
		myBoard[8][3] = 5;

		printBox();

		solvePuzzle();
	}

	public void solvePuzzle()
	{
		int count = 0;
		while (count <= 10)
		{
			count++;
			for (int i = 0; i < 9; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (myBoard[i][j] == 0)
					{
						ArrayList<Integer> possible = new ArrayList<Integer>();

						myHorizontalValues[i][j] = new Helper(
								getHorizontalInts(i));
						myVerticalValues[i][j] = new Helper(getVerticalInts(j));
						myBoxValues[i][j] = new Helper(getBoxValues(i, j));

						if (myHorizontalValues[i][j].getLength() == 1)
						{
							myBoard[i][j] = myHorizontalValues[i][j]
									.getArrayList().get(0);
							myHorizontalValues[i][j].removeFirst();
						}

						if (myVerticalValues[i][j].getLength() == 1)
						{
							myBoard[i][j] = myVerticalValues[i][j]
									.getArrayList().get(0);
							myVerticalValues[i][j].removeFirst();
						}

						if (myBoxValues[i][j].getLength() == 1)
						{
							myBoard[i][j] = myBoxValues[i][j].getArrayList()
									.get(0);
							myBoxValues[i][j].removeFirst();
						}

						for (int z = 1; z <= 9; z++)
						{
							int occurence = 0;
							occurence += (myHorizontalValues[i][j]
									.getArrayList().contains(new Integer(z))) ? 1
									: 0;
							occurence += (myVerticalValues[i][j].getArrayList()
									.contains(new Integer(z))) ? 1 : 0;
							occurence += (myBoxValues[i][j].getArrayList()
									.contains(new Integer(z))) ? 1 : 0;
							if (occurence == 3)
							{
								possible.add(new Integer(z));
							}
						}
						myPossibleValues[i][j] = new Helper(possible);
						if (myPossibleValues[i][j].getLength() == 1)
						{
							myBoard[i][j] = myPossibleValues[i][j]
									.getArrayList().get(0);

							myPossibleValues[i][j].removeFirst();
						}
						possible = smartCheck(i, j);
						if(possible.size() == 1)
						{
							myBoard[i][j] = possible.get(0);
						}
					} 
					else
					{
						ArrayList<Integer> possible = new ArrayList<Integer>();
						myPossibleValues[i][j] = new Helper(possible);
					}
					
					System.out.println("X: " + i + " Y: " + j + " Possible: "
							+ myPossibleValues[i][j].getArrayList());
				}
			}

			System.out.println();

			printBox();
		}
	}
	
	public void smartCheckBox(int i, int value)
	{
		int occurence = 0;
		int savX -1;
		int savY;
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						savX = j;
						savY = i;
						occurence++;
					}
				}
			}
			if(occurence == 1)
			{
				myBoard[savX][savY] = value;
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
		if (i == 1)
		{
			for(int j = 0; j <=2 ; j++)
			{
				for(int k = 0; k <=2; k++)
				{
					if(myPossibleValues[j][k].getArrayList().contains(new Integer(value)))
					{
						occurence++;
					}
				}
			}
		}
	}

	public void loadGrid(int x, int y, int value)
	{
		myBoard[x][y] = value;
	}

	public void printBox()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				System.out.print(myBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean checkFullBoard()
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (myBoard[i][j] == 0)
				{
					return false;
				}
			}
		}
		return true;
	}

	public ArrayList<Integer> getHorizontalInts(int row)
	{
		ArrayList<Integer> possNums = loadNums();
		for (int i = 0; i < 9; i++)
		{
			if (0 != myBoard[row][i])
			{
				possNums.remove(new Integer(myBoard[row][i]));
			}
		}
		return possNums;
	}

	public ArrayList<Integer> smartCheckHorizontal(int row, int col)
	{
		ArrayList<Integer> possNums = myPossibleValues[row][col].getArrayList();
		for (int i = 0; i < 9; i++)
		{
			if (i != col)
			{
				ArrayList<Integer> otherNums = myPossibleValues[row][i]
						.getArrayList();
				possNums.removeAll(otherNums);
			}
		}
		return possNums;
	}

	public ArrayList<Integer> smartCheckVertical(int row, int col)
	{
		ArrayList<Integer> possNums = myPossibleValues[row][col].getArrayList();
		for (int i = 0; i < 9; i++)
		{
			if (i != row)
			{
				ArrayList<Integer> otherNums = myPossibleValues[i][col]
						.getArrayList();
				possNums.removeAll(otherNums);
			}
		}
		return possNums;
	}

	public ArrayList<Integer> getVerticalInts(int col)
	{
		ArrayList<Integer> possNums = loadNums();
		for (int i = 0; i < 9; i++)
		{
			if (0 != myBoard[i][col])
			{
				possNums.remove(new Integer(myBoard[i][col]));
			}
		}
		return possNums;
	}

	

	public ArrayList<Integer> loadNums()
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++)
		{
			nums.add(i);
		}
		return nums;
	}

	public ArrayList<Integer> uglyNums()
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++)
		{
			nums.add(-1);
		}
		return nums;
	}
}
