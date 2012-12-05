import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener
{

	/**
	 * @param args
	 */
	private JPanel	mySudokuBoard;
	private JPanel	myMainPanel;
	private JPanel myButtonsPanel;
	private JButton mySolveButton;
	private JTextField[][] myInputFields;
	
	Controller myController;

	public View(Controller controller)
	{
		myController = controller;
		
		
		myMainPanel = new JPanel();
		myMainPanel.setLayout(new BoxLayout(myMainPanel, BoxLayout.Y_AXIS));
		mySudokuBoard = new JPanel(new GridLayout(9, 9));
		myInputFields = new JTextField[9][9];
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				myInputFields[i][j] = new JTextField();
				myInputFields[i][j].setPreferredSize(new Dimension(30, 30));
				mySudokuBoard.add(myInputFields[i][j]);
			}
		}
		myButtonsPanel = new JPanel();
		myButtonsPanel.setLayout(new BoxLayout(myButtonsPanel, BoxLayout.X_AXIS));
		mySolveButton = new JButton("Solve");
		mySolveButton.setHorizontalAlignment((int) Component.CENTER_ALIGNMENT);
		mySolveButton.addActionListener(this);
		myButtonsPanel.add(mySolveButton);

		myMainPanel.add(mySudokuBoard);
		myMainPanel.add(myButtonsPanel);
		this.getContentPane().add(myMainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.GRAY);
		this.setVisible(true);
	}
	
	

	public int getValues(int x, int y)
	{
		if((myInputFields[x][y].getText()).length() == 1)
		{
			return Integer.parseInt(myInputFields[x][y].getText());
		}
		return 0;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == mySolveButton)
		{
			myController.startSolving();
		}
	}
}
