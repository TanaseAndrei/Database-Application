package classes;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueryArea extends JPanel{

	private JTextArea queryArea;
	private JTextArea resultArea;
	
	private JScrollPane queryScroll;
	private JScrollPane resultScroll;
	
	private JButton executeButton;
	
	public QueryArea() {
		
		/*Initiate the panel*/
		initPanel();
		
		/*Initiate the query area*/
		initQueryArea();
		
		/*Init the result area*/
		initResultArea();
		
		/*Init the execute button*/
		initExecuteButton();
		
		/*Pack everything together*/
		packing();
		
	}
	
	private void initPanel() {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Query area"));
		
	}
	
	
	private void initQueryArea() {
		
		queryArea = new JTextArea(25,75);
		
		/*Increase the size of font in queryArea*/
		Font font = queryArea.getFont();
		float fontSize = font.getSize() + 5;
		queryArea.setFont(font.deriveFont(fontSize));
		
		/*Instantiate a scroll on that query area*/
		queryScroll = new JScrollPane(queryArea);
		
	}
	
	private void initResultArea() {
		
		resultArea = new JTextArea();
		
		/*Increase the size of font in resultArea*/
		Font font = resultArea.getFont();
		float fontSize = font.getSize() + 5;
		resultArea.setFont(font.deriveFont(fontSize));
		
		/*Insantiate a scroll on that scroll area*/
		resultScroll = new JScrollPane(resultArea);
		
	}
	
	private void initExecuteButton() {
		
		executeButton = new JButton("Execute query");
		
	}
	
	private void packing() {
		
		add(queryScroll,BorderLayout.NORTH);
		add(resultScroll,BorderLayout.CENTER);
		add(executeButton,BorderLayout.SOUTH);
		
	}
	
}
