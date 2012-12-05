
public class Controller
{
	private Model myModel;
	private View myView;
	private Puzzle myPuzzle;
	public static void main(String[] args)
	{
		new Controller();
	}
	
	public Controller()
	{
		myView = new View(this);
	}
	
	public int loadHelper(int i, int j)
	{
		return myView.getValues(i, j);
	}
	public void startSolving()
	{
		myPuzzle = new Puzzle();
		for(int i = 0; i <9 ; i ++)
		{
			for(int j = 0; j < 9 ; j++)
			{
				int v = loadHelper(i, j);
				myPuzzle.loadGrid(i, j, v);
			}
		}
		myPuzzle.solvePuzzle();
	}
}
