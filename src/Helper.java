import java.util.ArrayList;


public class Helper
{
	ArrayList<Integer> myArrayList;
	public Helper(ArrayList<Integer> ints)
	{
		myArrayList = ints;
	}
	
	public int getLength()
	{
		return myArrayList.size();
	}
	
	public ArrayList<Integer> getArrayList()
	{
		return myArrayList;
	}
	
	public ArrayList<Integer> removeFirst()
	{
		myArrayList.remove(0);
		return myArrayList;
	}
}
