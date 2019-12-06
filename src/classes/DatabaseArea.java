package classes;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DatabaseArea extends JPanel {

	private JList<String> databasesList;
	
	public DatabaseArea() {
		
		/*Initiate the panel*/
		initPanel();
		
		/*Initiate the list*/
		initJList();
		
		/*Pack everything together*/
		packing();
		
	}
	
	private void initPanel() {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Databases area"));
		
	}
	
	private void initJList() {
		
		databasesList = new JList<String>();
		databasesList.setSelectedIndex(-1);
		
	}
	
	private void packing() {
		
		add(databasesList,BorderLayout.CENTER);
		
	}
	
}
