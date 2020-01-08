package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class TableArea extends JPanel {

	private JList<String> tbArea;
	private DefaultListModel<String> defaultModel;
	private JScrollPane scroll = new JScrollPane();
	
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
		
		defaultModel = new DefaultListModel<String>();
		tbArea = new JList<String>(defaultModel);
		tbArea.setSelectedIndex(-1);
		scroll.setViewportView(tbArea);
		
	}
	
	public void addElement(String element) {
		
		defaultModel.addElement(element);
		
	}
	
	public void clearList() {
		
		defaultModel.clear();
		
	}
	
private void packing() {
		
		add(scroll,BorderLayout.CENTER);
		
	}
	
}
