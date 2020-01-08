package panels;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.Populate;

@SuppressWarnings("serial")
public class DatabaseArea extends JPanel {

	private JList<String> databasesList;
	private DefaultListModel<String> defaultModel;
	
	public DatabaseArea() {
		
		/*Initiate the panel*/
		initPanel();
		
		/*Initiate the list*/
		initJList();
		
		/*Populate the JList with databases*/
		populate();
		
		/*Pack everything together*/
		packing();
		
	}
	
	/*
	 * Method that initiates the main panel
	 */
	private void initPanel() {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Databases area"));
		
	}
	
	/*
	 * Method that initiates the list
	 */
	private void initJList() {
		
		defaultModel = new DefaultListModel<String>();
		databasesList = new JList<String>(defaultModel);
		databasesList.setSelectedIndex(-1);
		
	}
	
	private void populate() {
		List<String> result = new Populate().populate("SELECT datname FROM pg_database WHERE datistemplate = false;");
		for(String iterator : result) {
			addElement(iterator);
		}
	}
	
	public void addDatabaseClickListener(MouseAdapter ma) {
		databasesList.addMouseListener(ma);
	}
	
	/*
	 * Method that adds elements to the list
	 */
	public void addElement(String element) {
		
		defaultModel.addElement(element);
		
	}
	
	/*
	 * Method that packs every component 
	 */
	private void packing() {
		
		add(databasesList,BorderLayout.CENTER);
		
	}
	
}
