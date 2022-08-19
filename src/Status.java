import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Database.DataBaseConnection;

public class Status extends JFrame{
	
	public static String month;
	private Connection con;
	private Statement stmt =null;
		
	
	Component ApanelE= Dashboard.AlertPanelE;
	Component ApanelW= Dashboard.AlertPanelW;
	Component ApanelT= Dashboard.AlertPanelT;
	
	Component WpanelW= Dashboard.WarningPanelW;
	Component WpanelT= Dashboard.WarningPanelT;
	Component WpanelE= Dashboard.WarningPanelE;
	Date thisDate = new Date();
	
	

	
public Status(int user_i) throws ParseException, SQLException {
		
		con= DataBaseConnection.connection();
	
				
	}

	
	Timer WarningPanelELeft = new Timer (10,new ActionListener() {
		
	public void actionPerformed(ActionEvent e) {
			
			
			if(WpanelE.getWidth() != 700) {
				WpanelE.setBounds(WpanelE.getX(), WpanelE.getY(), WpanelE.getWidth()+5, WpanelE.getHeight());
				}
			else {
				((Timer)e.getSource()).stop();
			}
		}
			
	});
	
	Timer AlertPanelELeft = new Timer (10,new ActionListener() {

		public void actionPerformed(ActionEvent e) {
	
			if(ApanelE.getWidth() !=700) {
				ApanelE.setBounds(ApanelE.getX(), ApanelE.getY(), ApanelE.getWidth()+5, ApanelE.getHeight());
				}
			else {
				((Timer)e.getSource()).stop();
			}
		}

	});
	

	Timer WarningPanelWLeft = new Timer (10,new ActionListener() {
		
	public void actionPerformed(ActionEvent e) {
			
			
			if(WpanelW.getWidth() != 700) {
				WpanelW.setBounds(WpanelW.getX(), WpanelW.getY(), WpanelW.getWidth()+5, WpanelW.getHeight());
				}
			else {
				((Timer)e.getSource()).stop();
			}
		}
			
	});
	
	
	Timer AlertPanelWLeft = new Timer (10,new ActionListener() {

		public void actionPerformed(ActionEvent e) {
	
			if(ApanelW.getWidth() !=700) {
				ApanelW.setBounds(ApanelW.getX(), ApanelW.getY(), ApanelW.getWidth()+5, ApanelW.getHeight());
				}
			else {
				((Timer)e.getSource()).stop();
			}
		}

	});
	
	Timer WarningPanelTLeft = new Timer (10,new ActionListener() {
		
	public void actionPerformed(ActionEvent e) {
			
			
			if(WpanelT.getWidth() != 700) {
				WpanelT.setBounds(WpanelT.getX(), WpanelT.getY(), WpanelT.getWidth()+5, WpanelT.getHeight());
				}
			else {
				((Timer)e.getSource()).stop();
			}
		}
			
	});
	
	
	Timer AlertPanelTLeft = new Timer (10,new ActionListener() {

		public void actionPerformed(ActionEvent e) {
	
			if(ApanelT.getWidth() !=700) {
				ApanelT.setBounds(ApanelT.getX(), ApanelT.getY(), ApanelT.getWidth()+5, ApanelT.getHeight());
				}
			else {
				((Timer)e.getSource()).stop();
			}
		}

	});	
	
	
	void checkElectricityBillStatus(int user_id) throws SQLException {
	
		
		
		stmt  = con.createStatement();
		
		String query = "SELECT max(Bill_Date) FROM `electricity` WHERE electricity.id= '"+user_id+"'";
		ResultSet re = stmt.executeQuery(query);
		try {
			while(re.next())
			{
			     Object lastDate= re.getObject(1);
			    		
			
			     java.util.Date utilDate = new java.util.Date(((Date) lastDate).getTime());
			    
			
				 long date= (long) utilDate.getDate(); 
			

		
			


			long date_now = thisDate.getDate();
			int cc =thisDate.getMonth()-utilDate.getMonth();
			
			if(cc==0) {
				 long  diff= date_now-date;
				 
				 Dashboard.lblDateE.setText(Integer.toString((int) diff));
				 Dashboard.lblMonthE.setText(Integer.toString(cc));
				 
				 Dashboard.lblRed.setVisible(false);
				 Dashboard.lblGreen.setVisible(true);
				 
				
				
			}
			if(cc==1) {
				if (date_now<date) {
					
					 long  diff= date_now+30-date;
					 
					 Dashboard.lblDateE.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthE.setText(Integer.toString(cc-1));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
				
					 
				}
				else {
					 long  diff= date_now-date;
					 Dashboard.lblDateE.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthE.setText(Integer.toString(cc));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
					
				}
				
			}
			else if(cc==2) {
				if (date_now<date) {
					
					 long  diff= date_now+30-date;
					 Dashboard.lblDateE.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthE.setText(Integer.toString(cc-1));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
					 
				
					 
				}
				else {
					
					 WarningPanelELeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
				
				}
			}
			else if(cc==3) {
				if (date_now<date) {
					
		
					 WarningPanelELeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
					 
				}
				else {
					
					 AlertPanelELeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
				}

			}
			else if(cc>3) {
				

				AlertPanelELeft.start();
				Dashboard.lblRed.setVisible(true);
				Dashboard.lblGreen.setVisible(false);
			}
		}

			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"You have no previous electricity bill records!"," ",JOptionPane.INFORMATION_MESSAGE);
			
		}
			}
	
	void checkWaterBillStatus(int user_id) throws SQLException {
		
		
		
		stmt  = con.createStatement();
		
		String query = "SELECT max(Bill_Date) FROM `water` WHERE water.id= '"+user_id+"'";
		ResultSet re = stmt.executeQuery(query);
		try {
			while(re.next())
			{
			     Object lastDate= re.getObject(1);
			    		
			
			     java.util.Date utilDate = new java.util.Date(((Date) lastDate).getTime());
			     System.out.println(utilDate);
			
				 long date= (long) utilDate.getDate(); 
			     System.out.println(date);

		
			


			long date_now = thisDate.getDate();
			int cc =thisDate.getMonth()-utilDate.getMonth();
			

			if(cc==0) {
				 long  diff= date_now-date;
				 Dashboard.lblDateW.setText(Integer.toString((int) diff));
				 Dashboard.lblMonthW.setText(Integer.toString(cc));
				 
				 Dashboard.lblRed.setVisible(false);
				 Dashboard.lblGreen.setVisible(true);
				 
				 
				
			}
			if(cc==1) {
				if (date_now<date) {
					
					 long  diff= date_now+30-date;
					 Dashboard.lblDateW.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthW.setText(Integer.toString(cc-1));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
					 

				 
				}
				else {
					 long  diff= date_now-date;
					 Dashboard.lblDateW.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthW.setText(Integer.toString(cc));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
					 

				}
				
			}
			else if(cc==2) {
				if (date_now<date) {
					
					 long  diff= date_now+30-date;
					 Dashboard.lblDateW.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthW.setText(Integer.toString(cc-1));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);

					 
				}
				else {

					 WarningPanelWLeft.start();
					 
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
				}
				
			}
			else if(cc==3) {
				if (date_now<date) {
				

					 WarningPanelWLeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
					 
				}
				else {

					 AlertPanelWLeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
				}

			}
			else if(cc>3) {
				
				AlertPanelWLeft.start();
				Dashboard.lblRed.setVisible(true);
				Dashboard.lblGreen.setVisible(false);
			}
		}

		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"You have no previous Water bill records!"," ",JOptionPane.INFORMATION_MESSAGE);
		}
		
			}
	
	void checkTelephoneBillStatus(int user_id) throws SQLException {
	
		
		
		stmt  = con.createStatement();
		
		String query = "SELECT max(Bill_Date) FROM `telephone` WHERE telephone.id= '"+user_id+"'";
		ResultSet re = stmt.executeQuery(query);
		try {
			while(re.next())
			{
			     Object lastDate= re.getObject(1);
			    		
			
			     java.util.Date utilDate = new java.util.Date(((Date) lastDate).getTime());
			
			
				 long date= (long) utilDate.getDate(); 
			

		
			

			
			long date_now = thisDate.getDate();
			//System.out.println(date_now);
			int cc =thisDate.getMonth()-utilDate.getMonth();
			
			if(cc==0) {
				
				 long  diff= date_now-date;
				 Dashboard.lblDateT.setText(Integer.toString((int) diff));
				 Dashboard.lblMonthT.setText(Integer.toString(cc));
				 
				 Dashboard.lblRed.setVisible(false);
				 Dashboard.lblGreen.setVisible(true);
				 

				
			}
			if(cc==1) {
				if (date_now<date) {
					
					 long  diff= date_now+30-date;
					 Dashboard.lblDateT.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthT.setText(Integer.toString(cc-1));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
					 

					 
				}
				else {
					 long  diff= date_now-date;
					 Dashboard.lblDateW.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthW.setText(Integer.toString(cc));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
					 

				}
				
			}
			else if(cc==2) {
				if (date_now<date) {
					
					 long  diff= date_now+30-date;
					 Dashboard.lblDateT.setText(Integer.toString((int) diff));
					 Dashboard.lblMonthT.setText(Integer.toString(cc-1));
					 
					 Dashboard.lblRed.setVisible(false);
					 Dashboard.lblGreen.setVisible(true);
					 

					 
				}
				else {

					 WarningPanelTLeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
				}
			}
			else if(cc==3) {
				if (date_now<date) {

					 WarningPanelTLeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
					 
				}
				else {
					
					 AlertPanelTLeft.start();
					 Dashboard.lblRed.setVisible(true);
					 Dashboard.lblGreen.setVisible(false);
				}

			}
			else if(cc>3) {
			

				AlertPanelTLeft.start();
				Dashboard.lblRed.setVisible(true);
				 Dashboard.lblGreen.setVisible(false);
			}
		}

		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"You have no previous Telephone bill records!"," ",JOptionPane.INFORMATION_MESSAGE);
			
		}
			}

}
