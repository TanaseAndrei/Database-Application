package classes;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{

	private static final int WIDTH = 720;
	private static final int HEIGHT = 1280;
	
	private QueryArea queryArea;
	private DatabaseArea dbArea;
	private TableArea tbArea;
	
	public MyFrame(String title) {
		
		super(title);
		
		/*Initiate the frame*/
		initFrame();
		
		/*Initiate the panels*/
		initPanels();
		
		/*Pack everything together and make the frame visible*/
		packing();
		setVisible(true);
		
	}
	
	private void initFrame() {
		
		setSize(HEIGHT,WIDTH);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	private void initPanels() {
		
		queryArea = new QueryArea();
		dbArea = new DatabaseArea();
		tbArea = new TableArea();
		
	}
	
	/*
	 * tbArea has a setPreferredSize to force the panel to extends as much as you want
	 */
	private void packing() {
		
		add(queryArea, BorderLayout.WEST);
		add(dbArea, BorderLayout.CENTER);
		add(tbArea, BorderLayout.EAST);
		
	}
	
}
