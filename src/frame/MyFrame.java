package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;

import panels.DatabaseArea;
import panels.QueryArea;
import panels.TableArea;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{

	private final int HEIGHT = 720;
	private final int WIDTH = 1280;
	
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
		
		setSize(WIDTH,HEIGHT);
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
	
	public void addToTable(String element) {
		tbArea.addElement(element);
	}
	
	public void clearTableList() {
		tbArea.clearList();
	}
	
	public String getQuery() {
		return queryArea.getQuery();
	}
	
	public void setResult(String result) {
		queryArea.setQueryResult(result);
	}
	
	public void addExecuteQueryButtonListener(ActionListener al) {
		queryArea.addExecuteButtonListener(al);
	}
	
	public void addListClickListener(MouseAdapter ma) {
		dbArea.addDatabaseClickListener(ma);
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
