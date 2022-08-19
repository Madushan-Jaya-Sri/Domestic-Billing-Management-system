
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Chart.Analysis;
import Database.ElectricityBill;
import Database.Telephone;
import Database.WaterBill;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;






public class Dashboard extends JFrame {
	
//	public static void main(String[] args) {
//	
//	  
//		
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run()
//			{
//				try {
//					Dashboard frame = new Dashboard(1);
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//	}



	private JPanel contentPane;
	public static JLabel lblRed;
	public static JLabel lblGreen;
	
	
	
	public static JPanel AlertPanelE;
	public static JPanel AlertPanelW;
	public static JPanel AlertPanelT;
	public static JPanel WarningPanelW;
	public static JPanel WarningPanelT;
	public static JPanel WarningPanelE;
	
	public static JLabel lblMonthE;
	public static JLabel lblMonthW;
	public static JLabel lblMonthT;
	public static JLabel lblDateE;
	public static JLabel lblDateW;
	public static JLabel lblDateT;
	



	
	
	public Dashboard (int userId) throws ParseException, SQLException {
		

		
		
		
		setTitle("Billing Management System(Domestic purpose only)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1185,750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblRed = new JLabel("");
		
		lblRed.setBounds(320, 138, 57, 57);
		lblRed.setIcon(new ImageIcon("Images\\cross.png"));
		panel.add(lblRed);
		lblRed.setVisible(false);
		

		
		lblGreen = new JLabel("");
		lblGreen.setBounds(306, 138, 57, 57);
		lblGreen.setIcon(new ImageIcon("Images\\okbtn.png"));
		panel.add(lblGreen);
		lblGreen.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("      Status");
		lblNewLabel_2.setForeground(new Color(255, 51, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(59, 138, 251, 57);
		panel.add(lblNewLabel_2);
		
		JPanel satusPanel = new JPanel();
		satusPanel.setBackground(new Color(0, 0, 51));
		satusPanel.setBounds(444, 105, 720, 600);
		panel.add(satusPanel);
		satusPanel.setLayout(null);
		
		WarningPanelE = new JPanel();
		WarningPanelE.setLayout(null);
		WarningPanelE.setForeground(Color.BLACK);
		WarningPanelE.setBackground(new Color(30, 144, 255));
		WarningPanelE.setBounds(10, 9, 0, 155);
		satusPanel.add(WarningPanelE);
		
		JLabel lblWarningE_2 = new JLabel("HURRY UP!...");
		lblWarningE_2.setForeground(new Color(0, 0, 139));
		lblWarningE_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWarningE_2.setBounds(176, 11, 349, 61);
		WarningPanelE.add(lblWarningE_2);
		
		JLabel lblNewLabel_3_4_2 = new JLabel("");
		lblNewLabel_3_4_2.setIcon(new ImageIcon("Images\\warningYellow.png"));
		lblNewLabel_3_4_2.setBounds(48, 29, 100, 100);
		WarningPanelE.add(lblNewLabel_3_4_2);
		
		JLabel lblMonthsGone_2 = new JLabel("2 months gone since your last Electricity bill");
		lblMonthsGone_2.setForeground(new Color(128, 0, 0));
		lblMonthsGone_2.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		lblMonthsGone_2.setBounds(186, 66, 476, 61);
		WarningPanelE.add(lblMonthsGone_2);
		
		WarningPanelW = new JPanel();
		WarningPanelW.setLayout(null);
		WarningPanelW.setForeground(Color.BLACK);
		WarningPanelW.setBackground(new Color(30, 144, 255));
		WarningPanelW.setBounds(10, 207, 0, 155);
		satusPanel.add(WarningPanelW);
		
		JLabel lblWarningE = new JLabel("HURRY UP!...");
		lblWarningE.setForeground(new Color(0, 0, 139));
		lblWarningE.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWarningE.setBounds(176, 11, 349, 61);
		WarningPanelW.add(lblWarningE);
		
		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon("Images\\warningYellow.png"));
		lblNewLabel_3_4.setBounds(48, 29, 100, 100);
		WarningPanelW.add(lblNewLabel_3_4);
		
		JLabel lblMonthsGone = new JLabel("2 months gone since your last Water bill");
		lblMonthsGone.setForeground(new Color(128, 0, 0));
		lblMonthsGone.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		lblMonthsGone.setBounds(186, 66, 476, 61);
		WarningPanelW.add(lblMonthsGone);
		
		WarningPanelT = new JPanel();
		WarningPanelT.setLayout(null);
		WarningPanelT.setForeground(Color.BLACK);
		WarningPanelT.setBackground(new Color(30, 144, 255));
		WarningPanelT.setBounds(10, 390, 0, 155);
		satusPanel.add(WarningPanelT);
		
		JLabel lblWarningE_1 = new JLabel("HURRY UP!...");
		lblWarningE_1.setForeground(new Color(0, 0, 139));
		lblWarningE_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWarningE_1.setBounds(176, 11, 349, 61);
		WarningPanelT.add(lblWarningE_1);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("");
		lblNewLabel_3_4_1.setIcon(new ImageIcon("Images\\warningYellow.png"));
		lblNewLabel_3_4_1.setBounds(48, 29, 100, 100);
		WarningPanelT.add(lblNewLabel_3_4_1);
		
		JLabel lblMonthsGone_3 = new JLabel("2 months gone since your last Telephone bill");
		lblMonthsGone_3.setForeground(new Color(128, 0, 0));
		lblMonthsGone_3.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 20));
		lblMonthsGone_3.setBounds(186, 66, 476, 61);
		WarningPanelT.add(lblMonthsGone_3);
		
		AlertPanelT = new JPanel();
		AlertPanelT.setLayout(null);
		AlertPanelT.setForeground(Color.BLACK);
		AlertPanelT.setBackground(new Color(188, 143, 143));
		AlertPanelT.setBounds(10, 390, 0, 155);
		satusPanel.add(AlertPanelT);
		
		JLabel lblYourTelephoneConnection = new JLabel("YOUR TELEPHONE CONNECTION");
		lblYourTelephoneConnection.setForeground(new Color(0, 0, 139));
		lblYourTelephoneConnection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblYourTelephoneConnection.setBounds(176, 11, 349, 61);
		AlertPanelT.add(lblYourTelephoneConnection);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon("Images\\warning1.png"));
		lblNewLabel_3_3.setBounds(48, 29, 100, 100);
		AlertPanelT.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("");
		lblNewLabel_3_2_2.setIcon(new ImageIcon("Images\\warning1.png"));
		lblNewLabel_3_2_2.setBounds(554, 29, 100, 100);
		AlertPanelT.add(lblNewLabel_3_2_2);
		
		JLabel lblIsAboutTo_2 = new JLabel("IS ABOUT TO BE TERMINATED");
		lblIsAboutTo_2.setForeground(Color.GREEN);
		lblIsAboutTo_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblIsAboutTo_2.setBounds(199, 68, 316, 61);
		AlertPanelT.add(lblIsAboutTo_2);
		
		AlertPanelW = new JPanel();
		AlertPanelW.setLayout(null);
		AlertPanelW.setForeground(Color.BLACK);
		AlertPanelW.setBackground(new Color(188, 143, 143));
		AlertPanelW.setBounds(10, 207, 0, 155);
		satusPanel.add(AlertPanelW);
		
		JLabel lblYourWaterConnection = new JLabel("YOUR WATER CONNECTION");
		lblYourWaterConnection.setForeground(new Color(0, 0, 139));
		lblYourWaterConnection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblYourWaterConnection.setBounds(207, 11, 296, 61);
		AlertPanelW.add(lblYourWaterConnection);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("Images\\warning1.png"));
		lblNewLabel_3_1.setBounds(48, 29, 100, 100);
		AlertPanelW.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		lblNewLabel_3_2_1.setIcon(new ImageIcon("Images\\warning1.png"));
		lblNewLabel_3_2_1.setBounds(554, 29, 100, 100);
		AlertPanelW.add(lblNewLabel_3_2_1);
		
		JLabel lblIsAboutTo_1 = new JLabel("IS ABOUT TO BE TERMINATED");
		lblIsAboutTo_1.setForeground(Color.GREEN);
		lblIsAboutTo_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblIsAboutTo_1.setBounds(203, 68, 316, 61);
		AlertPanelW.add(lblIsAboutTo_1);
		
		AlertPanelE = new JPanel();
		AlertPanelE.setForeground(new Color(0, 0, 0));
		AlertPanelE.setBackground(new Color(188, 143, 143));

		AlertPanelE.setBounds(10, 28, 0, 155);
		satusPanel.add(AlertPanelE);
		AlertPanelE.setLayout(null);
		
		JLabel lblAlert = new JLabel("YOUR ELECTRICITY CONNECTION");
		lblAlert.setForeground(new Color(0, 0, 139));
		lblAlert.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAlert.setBounds(176, 11, 349, 61);
		AlertPanelE.add(lblAlert);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("Images\\warning1.png"));
		lblNewLabel_3.setBounds(48, 29, 100, 100);
		AlertPanelE.add(lblNewLabel_3);
		
		JLabel lblIsAboutTo = new JLabel("IS ABOUT TO BE TERMINATED");
		lblIsAboutTo.setForeground(new Color(0, 255, 0));
		lblIsAboutTo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblIsAboutTo.setBounds(209, 66, 316, 61);
		AlertPanelE.add(lblIsAboutTo);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon("Images\\warning1.png"));
		lblNewLabel_3_2.setBounds(554, 29, 100, 100);
		AlertPanelE.add(lblNewLabel_3_2);
		
		JLabel lblAlertE3 = new JLabel(" DAYS ");
		lblAlertE3.setBounds(572, 43, 72, 41);
		lblAlertE3.setForeground(Color.YELLOW);
		lblAlertE3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		satusPanel.add(lblAlertE3);
		
		lblMonthE = new JLabel("--");
		
		lblMonthE.setForeground(new Color(51, 204, 0));
		lblMonthE.setBounds(191, 30, 59, 58);
		lblMonthE.setFont(new Font("Tahoma", Font.BOLD, 35));
		satusPanel.add(lblMonthE);
		
		//slblMonths.setText(checkElectricityBillStatus());
		
		JLabel lblDaysSinceYour = new JLabel("SINCE YOUR LAST");
		lblDaysSinceYour.setBounds(112, 123, 196, 41);
		lblDaysSinceYour.setForeground(Color.YELLOW);
		lblDaysSinceYour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		satusPanel.add(lblDaysSinceYour);
		
		JLabel lblBillPayment = new JLabel("BILL PAYMENT !");
		lblBillPayment.setBounds(509, 123, 196, 41);
		lblBillPayment.setForeground(Color.YELLOW);
		lblBillPayment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		satusPanel.add(lblBillPayment);
		
		JLabel lblElectricity = new JLabel("ELECTRICITY");
		lblElectricity.setBounds(318, 121, 181, 41);
		lblElectricity.setForeground(new Color(255, 51, 204));
		lblElectricity.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		satusPanel.add(lblElectricity);
		
		lblDateE = new JLabel("--");
	
		lblDateE.setForeground(new Color(102, 204, 0));
		lblDateE.setBounds(473, 30, 59, 58);
		lblDateE.setFont(new Font("Tahoma", Font.BOLD, 35));
		satusPanel.add(lblDateE);
		
		JLabel lblAlertE1 = new JLabel("IT HAS GONE");
		lblAlertE1.setBounds(20, 43, 149, 41);
		lblAlertE1.setForeground(Color.YELLOW);
		lblAlertE1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		satusPanel.add(lblAlertE1);
		
		JLabel lblAlertE2 = new JLabel("MONTHS and");
		lblAlertE2.setBounds(290, 43, 149, 41);
		lblAlertE2.setForeground(Color.YELLOW);
		lblAlertE2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		satusPanel.add(lblAlertE2);
		
		JLabel lblAlertE1_1 = new JLabel("IT HAS GONE");
		lblAlertE1_1.setForeground(Color.YELLOW);
		lblAlertE1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAlertE1_1.setBounds(20, 207, 149, 41);
		satusPanel.add(lblAlertE1_1);
		
		lblMonthW = new JLabel("--");
		lblMonthW.setForeground(new Color(51, 204, 0));
		lblMonthW.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblMonthW.setBounds(191, 194, 59, 58);
		satusPanel.add(lblMonthW);
		
		JLabel lblAlertE2_1 = new JLabel("MONTHS and");
		lblAlertE2_1.setForeground(Color.YELLOW);
		lblAlertE2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAlertE2_1.setBounds(290, 207, 149, 41);
		satusPanel.add(lblAlertE2_1);
		
		lblDateW = new JLabel("--");
		lblDateW.setForeground(new Color(102, 204, 0));
		lblDateW.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblDateW.setBounds(473, 194, 59, 58);
		satusPanel.add(lblDateW);
		
		JLabel lblAlertE3_1 = new JLabel(" DAYS ");
		lblAlertE3_1.setForeground(Color.YELLOW);
		lblAlertE3_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAlertE3_1.setBounds(572, 207, 72, 41);
		satusPanel.add(lblAlertE3_1);
		
		JLabel lblBillPayment_1 = new JLabel("BILL PAYMENT !");
		lblBillPayment_1.setForeground(Color.YELLOW);
		lblBillPayment_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblBillPayment_1.setBounds(509, 287, 196, 41);
		satusPanel.add(lblBillPayment_1);
		
		JLabel lblWater = new JLabel("WATER");
		lblWater.setForeground(new Color(255, 51, 204));
		lblWater.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblWater.setBounds(318, 285, 181, 41);
		satusPanel.add(lblWater);
		
		JLabel lblDaysSinceYour_1 = new JLabel("SINCE YOUR LAST");
		lblDaysSinceYour_1.setForeground(Color.YELLOW);
		lblDaysSinceYour_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblDaysSinceYour_1.setBounds(112, 287, 196, 41);
		satusPanel.add(lblDaysSinceYour_1);
		
		JLabel lblAlertE1_2 = new JLabel("IT HAS GONE");
		lblAlertE1_2.setForeground(Color.YELLOW);
		lblAlertE1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAlertE1_2.setBounds(20, 390, 149, 41);
		satusPanel.add(lblAlertE1_2);
		
		lblMonthT = new JLabel("--");
		lblMonthT.setForeground(new Color(51, 204, 0));
		lblMonthT.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblMonthT.setBounds(191, 377, 59, 58);
		satusPanel.add(lblMonthT);
		
		JLabel lblAlertE2_2 = new JLabel("MONTHS and");
		lblAlertE2_2.setForeground(Color.YELLOW);
		lblAlertE2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAlertE2_2.setBounds(290, 390, 149, 41);
		satusPanel.add(lblAlertE2_2);
		
		lblDateT = new JLabel("--");
		lblDateT.setForeground(new Color(102, 204, 0));
		lblDateT.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblDateT.setBounds(473, 377, 59, 58);
		satusPanel.add(lblDateT);
		
		JLabel lblAlertE3_2 = new JLabel(" DAYS ");
		lblAlertE3_2.setForeground(Color.YELLOW);
		lblAlertE3_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAlertE3_2.setBounds(572, 390, 72, 41);
		satusPanel.add(lblAlertE3_2);
		
		JLabel lblBillPayment_2 = new JLabel("BILL PAYMENT !");
		lblBillPayment_2.setForeground(Color.YELLOW);
		lblBillPayment_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblBillPayment_2.setBounds(509, 470, 196, 41);
		satusPanel.add(lblBillPayment_2);
		
		JLabel lblTelephone = new JLabel("TELEPHONE");
		lblTelephone.setForeground(new Color(255, 51, 204));
		lblTelephone.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblTelephone.setBounds(318, 468, 181, 41);
		satusPanel.add(lblTelephone);
		
		JLabel lblDaysSinceYour_2 = new JLabel("SINCE YOUR LAST");
		lblDaysSinceYour_2.setForeground(Color.YELLOW);
		lblDaysSinceYour_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblDaysSinceYour_2.setBounds(112, 470, 196, 41);
		satusPanel.add(lblDaysSinceYour_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(139, 0, 0));
		panel_2.setBounds(20, 192, 685, 4);
		satusPanel.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(139, 0, 0));
		panel_2_1.setBounds(25, 375, 685, 4);
		satusPanel.add(panel_2_1);
		
		
		JLabel lblLogSuc = new JLabel("Login successful....");
		lblLogSuc.setBounds(829, 30, 0, 25);
		lblLogSuc.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblLogSuc.setForeground(new Color(255, 255, 0));
		panel.add(lblLogSuc);
		
		Timer labelRight = new Timer (100,new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				
				if(lblLogSuc.getWidth() != 0) {
					lblLogSuc.setBounds(lblLogSuc.getX(), lblLogSuc.getY(), lblLogSuc.getWidth()-5, lblLogSuc.getHeight());
					}
				else {
					((Timer)e.getSource()).stop();
				}
			}
				
		});
		
		
		Timer labelLeft = new Timer (30,new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
		
				if(lblLogSuc.getWidth() !=160) {
					lblLogSuc.setBounds(lblLogSuc.getX(), lblLogSuc.getY(), lblLogSuc.getWidth()+5, lblLogSuc.getHeight());
					}
				else {
					((Timer)e.getSource()).stop();
				}
			}
	
		});	
		
		Timer statuspanelUp = new Timer (100,new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				
				if(satusPanel.getHeight() != 0) {
					satusPanel.setBounds(satusPanel.getX(), satusPanel.getY(), satusPanel.getWidth(), satusPanel.getHeight()-5);
					}
				else {
					((Timer)e.getSource()).stop();
				}
			}
				
		});
		
		
		Timer statuspanelDown = new Timer (30,new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
		
				if(satusPanel.getHeight() !=580) {
					satusPanel.setBounds(satusPanel.getX(), satusPanel.getY(), satusPanel.getWidth(), satusPanel.getHeight()+5);
					}
				else {
					((Timer)e.getSource()).stop();
				}
			}
	
		});
		
		
		

		labelLeft.start();
		
		labelRight.start();
		



		Status status = new Status(0);
		status.checkElectricityBillStatus(userId);
		status.checkWaterBillStatus(userId);
		status.checkTelephoneBillStatus(userId);
		
;
		
		JButton btnNewButton_4_1 = new JButton("Analysis");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Analysis chart = new Analysis();
//				chart.NewscreenChart(userId);
			}
		});
		btnNewButton_4_1.setBounds(59, 632, 318, 57);
		btnNewButton_4_1.setForeground(new Color(153, 255, 255));
		btnNewButton_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4_1.setFont(new Font("Quicksand", Font.BOLD, 40));
		btnNewButton_4_1.setBackground(new Color(0, 0, 51));
		panel.add(btnNewButton_4_1);
		
		JButton tbnShowTelephone = new JButton("Telephone Bill");
		tbnShowTelephone.setBounds(59, 503, 318, 57);
		tbnShowTelephone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Telephone frame = new Telephone(userId);
				frame.setVisible(true);
			}
		});
		tbnShowTelephone.setForeground(new Color(153, 255, 255));
		tbnShowTelephone.setHorizontalAlignment(SwingConstants.LEFT);
		tbnShowTelephone.setFont(new Font("Quicksand", Font.BOLD, 40));
		tbnShowTelephone.setBackground(new Color(0, 0, 51));
		panel.add(tbnShowTelephone);
		
		JButton btnShowWater = new JButton("Water Bill");
		btnShowWater.setBounds(59, 370, 318, 57);
		btnShowWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WaterBill frame = new WaterBill(userId);
				frame.setVisible(true);
			}
		});
		btnShowWater.setForeground(new Color(153, 255, 255));
		btnShowWater.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowWater.setFont(new Font("Quicksand", Font.BOLD, 40));
		btnShowWater.setBackground(new Color(0, 0, 51));
		panel.add(btnShowWater);
		
		JButton btnShowElectriciy = new JButton("Electricity Bill");
		btnShowElectriciy.setBounds(59, 239, 318, 57);
		btnShowElectriciy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ElectricityBill frame = new ElectricityBill(userId);
				frame.setVisible(true);
				
			}
		});
		btnShowElectriciy.setForeground(new Color(153, 255, 255));
		btnShowElectriciy.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowElectriciy.setFont(new Font("Quicksand", Font.BOLD, 40));
		btnShowElectriciy.setBackground(new Color(0, 0, 51));
		panel.add(btnShowElectriciy);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(420, 113, 4, 609);
		panel_1.setBackground(new Color(0, 204, 255));
		panel.add(panel_1);
		
		JLabel lblProfile = new JLabel("");
		lblProfile.setBounds(1092, 0, 93, 97);
		lblProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginInterface frame = new LoginInterface();
				frame.show();
				dispose();
			}
		});
		lblProfile.setToolTipText("logout");
		lblProfile.setIcon(new ImageIcon("Images\\profile1.png"));
		panel.add(lblProfile);
		
		JLabel lblNewLabel_1 = new JLabel("\r\nDashboard\r\n");
		lblNewLabel_1.setBounds(20, 30, 186, 57);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Playball", Font.BOLD, 30));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1185, 750);
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setIcon(new ImageIcon("Images\\bg_dash.png"));
		panel.add(lblNewLabel);
		
		statuspanelDown.start();
		
		

		


		

	}
}
