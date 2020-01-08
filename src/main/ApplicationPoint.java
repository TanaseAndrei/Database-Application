package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.Controller;
import frame.MyFrame;
import model.Query;

public class ApplicationPoint {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				MyFrame frame = new MyFrame("Application");
				Query query = new Query();
				
				@SuppressWarnings("unused")
				Controller controller = new Controller(frame,query);
				
			}
		});

	}

}
