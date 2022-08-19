
import java.awt.EventQueue;

import javax.swing.JFrame;



public class Main extends JFrame {



	public static void main(String[] args) {
	
	  
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try {
					LoginInterface frame = new LoginInterface();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
