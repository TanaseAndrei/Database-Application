package classes;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TableArea extends JPanel {

	private JList<String> tbArea;
	
	public TableArea() {
		
		/*Initiate the panel*/
		initPanel();
		
		/*Initiate the list*/
		initJList();
		
		/*Pack everything together*/
		packing();
		
	}
	
	private void initPanel() {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Table area"));
		setPreferredSize(new Dimension(330,100));
		
	}
	
	private void initJList() {
		
		tbArea = new JList<String>();
		
	}
	
	private void packing() {
		
		add(tbArea,BorderLayout.CENTER);
		
	}
	
}
