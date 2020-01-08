package panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueryArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/*TEXT COMPONENTS*/
	private JTextArea queryArea;
	private JTextArea resultArea;
	
	/*SCROLL COMPONENTS*/
	private JScrollPane queryScroll;
	private JScrollPane resultScroll;
	
	/*PANELS*/
	private JPanel queryPanel;
	private JPanel resultPanel;
	
	/*BUTTON COMPONENTS*/
	private JButton executeButton;
	
	public QueryArea() {
		
		/*Initiate the panel*/
		initPanel();
		
		/*Initiate the other panels*/
		initComponentPanels();
		
		/*Initiate the query area*/
		initQueryArea();
		
		/*Initiate the result area*/
		initResultArea();
		
		/*Initiate the fonts for the text areas*/
		initFont();
		
		/*Initiate the execute button*/
		initExecuteButton();
		
		/*Pack everything together*/
		packing();
		
	}

	/*
	 * Method that initiates the main panel
	 */
	private void initPanel() {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Query area"));
		
	}
	
	/*
	 * Method that initiates the other panels (query area has it's own panel for example)
	 */
	private void initComponentPanels() {
		
		queryPanel = new JPanel();
		queryPanel.setBorder(BorderFactory.createTitledBorder("Input area"));
		
		resultPanel = new JPanel();
		resultPanel.setBorder(BorderFactory.createTitledBorder("Output area"));
		
	}
	
	/*
	 * Method that initiates the query area
	 */
	private void initQueryArea() {
		
		queryArea = new JTextArea(20,68);
		/*Instantiate a scroll on that query area*/
		queryScroll = new JScrollPane(queryArea);
		
	}
	
	/*
	 * Method that initiates the result area
	 */
	private void initResultArea() {
		
		resultArea = new JTextArea(6,68);
		resultArea.setEditable(false);
		/*Increase the size of font in resultArea*/
		
		/*Instantiate a scroll on that scroll area*/
		resultScroll = new JScrollPane(resultArea);
		
	}
	
	/*
	 * Method that initiates the execute button
	 */
	private void initExecuteButton() {
		
		executeButton = new JButton("Execute query");
		
	}
	
	/*
	 * Method that initiates the font for the 2 text areas
	 */
	private void initFont() {
		
		Font font = queryArea.getFont();
		float fontSize = font.getSize() + 2f;
		queryArea.setFont(font.deriveFont(fontSize));
		
		font = resultArea.getFont();
		fontSize = font.getSize() + 2f;
		resultArea.setFont(font.deriveFont(fontSize));
		
	}
	
	/*
	 * Method that gets the input query
	 */
	public String getQuery() {
		
		return queryArea.getText();
		
	}
	
	/*
	 * Method that sets the result after executing the query
	 */
	public void setQueryResult(String result) {
		
		resultArea.setText(result);
		
	}

	/*
	 * Method that sets the action listener for the execute button
	 */
	public void addExecuteButtonListener(ActionListener al) {
		
		executeButton.addActionListener(al);
		
	}
	
	/*
	 * Method that packs the components together
	 */
	private void packing() {
		
		queryPanel.add(queryScroll);
		resultPanel.add(resultScroll);
		
		add(queryPanel,BorderLayout.NORTH);
		add(resultPanel,BorderLayout.CENTER);
		add(executeButton,BorderLayout.SOUTH);
		
	}
	
}
