package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JList;

import frame.MyFrame;
import model.Populate;
import model.Query;

public class Controller {

	private MyFrame frame;
	private Query query;

	public Controller(MyFrame frame, Query query) {
		
		this.frame = frame;
		this.query = query;
		this.frame.addExecuteQueryButtonListener(new ButtonListener());
		this.frame.addListClickListener(new DatabasesListListener());
		
	}

	/*
	 * ActionListener for execute button
	 */
	 class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String query = frame.getQuery();
			StringBuilder buildString = new StringBuilder();
			List<String> resultQuery = new Query().query(query);
			for(String iterator : resultQuery) {
				buildString.append(iterator);
				buildString.append('\n');
			}
			
			frame.setResult(buildString.toString());
			
		}
		
	}
	
	 /*
	  * 1. Se goleste lista cu tabele 
	  * 2. Se preia sursa de la care a pornit actiunea. Apasand pe un element din JList se da trigger la un action si se constituie un obiect MouseEvent.
	  * 3. Selectand un element, luam numele acelui element. 
	  * 4. Punem intr-o lista query rezultat.
	  * 5. Adaugam in lista cu tabele
	  */
	class DatabasesListListener extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent event){
			frame.clearTableList();
			
			JList dbList = (JList)event.getSource();
			String selected = dbList.getModel().getElementAt(dbList.getSelectedIndex()).toString();
			System.out.println(selected + " este selectat.");
			List<String> result = new Populate().getTables(selected); 
			
			for(String iterator : result) {
				frame.addToTable(iterator);
			}
			
		}
	}
	
	
}
