package Database;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class WaterBill extends JFrame {

	
	private JPanel contentPane;
	private JTable view;
	
	Connection con =null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private JTextField txtBillDate;
	private JTextField textUnits;
	private JTextField txtAmount;
	private int user_id;
	private JScrollPane scrollPane;
	
	


	public WaterBill(int userId) {
		user_id = userId;
		
		addComponents();
		
		con= DataBaseConnection.connection();
		showRecord();
	}
	

	public void addComponents() {
		
		
		
		setBounds(100, 100, 716, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblAddDetails = new JLabel("Add your new bill details");
		lblAddDetails.setBounds(168, 373, 486, 61);
		lblAddDetails.setVisible(true);
		
		
		
		view = new JTable();
		view.setBounds(1, 26, 590, 0);
		view.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		view.setSelectionForeground(new Color(102, 0, 0));
		view.setGridColor(new Color(0, 255, 51));
		view.setRowMargin(10);
		view.setRowHeight(35);
		view.setForeground(new Color(102, 204, 255));
		view.setBackground(new Color(0, 0, 0));
		view.setFont(new Font("Segoe UI Emoji", Font.BOLD | Font.ITALIC, 15));
		view.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bill_date", "Units", "Amount"
			}
		));
		view.getColumnModel().getColumn(0).setResizable(false);
		view.getColumnModel().getColumn(1).setResizable(false);
		contentPane.add(view);
		
		
		lblAddDetails.setForeground(Color.MAGENTA);
		lblAddDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblAddDetails.setIcon(new ImageIcon("Images\\addbtn.png"));
		contentPane.add(lblAddDetails);
		
		
		
		JPanel panelDetail = new JPanel();
		panelDetail.setBounds(96, 310, 546, 0);
		panelDetail.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		panelDetail.setBackground(new Color(0, 102, 102));
		panelDetail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(panelDetail);
		
		Timer dpanelDown = new Timer (5,new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				
				if(panelDetail.getHeight() != 0) {
					panelDetail.setBounds(panelDetail.getX(), panelDetail.getY(), panelDetail.getWidth(), panelDetail.getHeight()-10);
					}
				else {
					((Timer)e.getSource()).stop();
				}
			}
				
		});

		
		Timer dpanelUp = new Timer (5,new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				if(panelDetail.getHeight() !=160) {
					panelDetail.setBounds(panelDetail.getX(), panelDetail.getY(), panelDetail.getWidth(), panelDetail.getHeight()+10);
				}
				else {
					((Timer)e.getSource()).stop();
			     }
			}
			
		});
		
		lblAddDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAddDetails.setVisible(false);
				dpanelUp.start();
				
			}
		});
		panelDetail.setLayout(null);
		
		JLabel lblAddDate = new JLabel("Bill Date");
		lblAddDate.setBounds(10, 11, 118, 27);
		lblAddDate.setForeground(new Color(51, 255, 0));
		lblAddDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelDetail.add(lblAddDate);
		
		JLabel lblUnits = new JLabel("Units");
		lblUnits.setBounds(10, 56, 118, 27);
		lblUnits.setForeground(new Color(51, 255, 0));
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelDetail.add(lblUnits);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(10, 102, 118, 27);
		lblAmount.setForeground(new Color(51, 255, 0));
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelDetail.add(lblAmount);
		
		txtBillDate = new JTextField();
		txtBillDate.setBounds(139, 15, 180, 27);
		panelDetail.add(txtBillDate);
		txtBillDate.setColumns(10);
		
		textUnits = new JTextField();
		textUnits.setBounds(139, 60, 180, 27);
		textUnits.setColumns(10);
		panelDetail.add(textUnits);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(139, 106, 180, 27);
		txtAmount.setColumns(10);
		panelDetail.add(txtAmount);
		
		JButton btnAddDetails = new JButton("ADD");
		btnAddDetails.setBounds(354, 44, 89, 23);
		btnAddDetails.addMouseListener(new MouseAdapter() {
			

		public String mnth;

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				try {
					
					int units =Integer.parseInt(textUnits.getText());
					Double amount =Double.parseDouble(txtAmount.getText());
					
					@SuppressWarnings("deprecation")
					long date = Date.parse(txtBillDate.getText());
					java.sql.Date bDate =new java.sql.Date(date);
					
					Date thisDate = new Date(date);
					 long year= (long) thisDate.getYear(); 
					// java.sql.Year byear =new java.sql.Year(year);
					 long month= (long) bDate.getMonth(); 
					if(month==0) {
						 mnth = "January";
					}
					else if(month==1) {
						 mnth = "February";
					}
					else if(month==2) {
						 mnth = "March";
					}
					else if(month==3) {
						 mnth = "April";
					}
					else if(month==4) {
						 mnth = "May";
					}
					else if(month==5) {
						 mnth = "June";
					}
					else if(month==6) {
						 mnth = "July";
					}
					else if(month==7) {
						 mnth = "August";
					}
					else if(month==8) {
						 mnth = "September";
					}
					else if(month==9) {
						 mnth = "October";
					}
					else if(month==10) {
						 mnth = "November";
					}
					else if(month==11) {
						 mnth = "December";
					}
					
					
					
					PreparedStatement ps = con.prepareStatement("insert into water(id,Year,Month,Bill_Date, Units, Amount) values(?,?,?,?,?,?)");
					ps.setInt(1, user_id);
					
					ps.setInt(2,(int) year+1900);
					ps.setString(3,mnth);
					
					ps.setDate(4, bDate);
					ps.setInt(5, units);
					ps.setDouble(6, amount);
					int result= ps.executeUpdate();
					
					
					if (result==1) {
						JOptionPane.showMessageDialog(null,"Successfully added!"," ",JOptionPane.INFORMATION_MESSAGE);
						dpanelDown.start();
					}
					else {
						JOptionPane.showMessageDialog(null,"Registration failed!!","error",JOptionPane.ERROR_MESSAGE);
					}
				}
					
				 				
						
						 catch (SQLException e1) {
							 JOptionPane.showMessageDialog(null,"Input all values","error",JOptionPane.ERROR_MESSAGE);
						 }

				
						lblAddDetails.setVisible(true);
				dpanelDown.start();
			}
				
				
			
		});
		panelDetail.add(btnAddDetails);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(354, 87, 89, 23);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String date,units,amount;
				 
				date = txtBillDate.getText();
				 units = textUnits.getText();
				 amount = txtAmount.getText();
				 
				 try {
					 pst = con.prepareStatement("UPDATE water set Units = ?, Amount = ? where Bill_date=?");
					 pst.setString(1, units);
					 pst.setString(2, amount);
					 pst.setString(3, date);
					 int result= pst.executeUpdate();
					 JOptionPane.showMessageDialog(null,"Record Updatted.......");
					 dpanelDown.start();
					
					 
				 }
				 catch(Exception ex) {
					 
				 }

					
			}
			
		});
		panelDetail.add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblAddDetails.setVisible(true);
				dpanelDown.start();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("Images\\arrowUp.png"));
		lblNewLabel_1.setBounds(490, 102, 45, 30);
		panelDetail.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Water Bill History");
		lblNewLabel.setBounds(202, 2, 282, 30);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.YELLOW);
		contentPane.add(lblNewLabel);
		

		JButton btnOk_1 = new JButton("Online Payment");
		btnOk_1.setBounds(442, 35, 212, 23);
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					URI uri = new URI("https://ebis.waterboard.lk/smartzone/English/OnlinePayments"
							+ "");
					java.awt.Desktop.getDesktop().browse(uri);
			
					
				} catch (URISyntaxException |IOException e1) {
					
			} 
			}
		});
		btnOk_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnOk_1);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBounds(240, 32, 86, 20);
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
							showRecord();			
					}
					
					private void showRecord() {
						
						try {
							String year = textYear.getText();
							String month = textMonth.getText();
							
							
							if(!year.isEmpty() && !month.isEmpty()) {
								
								scrollPane.setVisible(true);
								panelUp.start();
							    stmt = con.createStatement();
						
							String query = "SELECT Bill_date, Units, Amount FROM `water`  WHERE water.Year= '"+year+"' and water.Month = '"+month+"' and water.id='"+user_id+"'";
							ResultSet re = stmt.executeQuery(query);
							lblAddDetails.setVisible(false);
							
							
							view.setModel(DbUtils.resultSetToTableModel(re));
							}
							else {
								JOptionPane.showMessageDialog(null,"please enter bill date","need bill date",JOptionPane.ERROR_MESSAGE);
							}
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
					}
				});
		btnsearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnsearch.setVisible(true);
				dpanelUp.start();
				
			}
		});
		
		textYear = new JTextField();
		textYear.setToolTipText("year");
		textYear.setBounds(50, 32, 86, 20);
		textYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String year = textYear.getText();
					
					pst = con.prepareStatement("select Bill_date, Units, Amount from water where Year = ? id = ?");
					pst.setString(1, year);
					pst.setInt(2, user_id);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
						String date1 = rs.getString(1);
						String units = rs.getString(2);
						String amount = rs.getString(3);
						
						txtBillDate.setText(date1);
						textUnits.setText(units);
						txtAmount.setText(amount);
					}
					
				}
				catch(Exception ex) {
					
				}
			}
		});
		
		textMonth = new JTextField();
		textMonth.setToolTipText("month");
		textMonth.setBounds(144, 32, 86, 20);
		textMonth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String month = textMonth.getText();
					
					pst = con.prepareStatement("select Bill_date, Units, Amount from water where Month = ? and id = ?");
					pst.setString(1, month);
					pst.setInt(2, user_id);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
						String date1 = rs.getString(1);
						String units = rs.getString(2);
						String amount = rs.getString(3);
						
						txtBillDate.setText(date1);
						textUnits.setText(units);
						txtAmount.setText(amount);
					}
					
				}
				catch(Exception ex) {
					
				}
			}
		});
		textMonth.setColumns(10);
		contentPane.add(textMonth);
		contentPane.add(textYear);
		textYear.setColumns(10);
		
		btnsearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnsearch);
		
		JLabel lblBack = new JLabel("");
		lblBack.setBounds(38, 343, 32, 32);
		lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
			}
		});
		lblBack.setIcon(new ImageIcon("Images\\back (1).png"));
		contentPane.add(lblBack);
		contentPane.setLayout(null);
		
		scrollPane =new JScrollPane(view);
		scrollPane.setBounds(62, 80, 592, 200);
		contentPane.add(scrollPane);
    	scrollPane.setVisible(false);
		
		JLabel lblBackg = new JLabel("");
		lblBackg.setBounds(0, 0, 700, 477);
		lblBackg.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblBackg.setIcon(new ImageIcon("Images\\WaterBg.png"));
		contentPane.add(lblBackg);
	

		
		
	}
	public void showRecord() {
		
		try {
			
			
			scrollPane.setVisible(true);
			panelUp.start();
			stmt = con.createStatement();
			System.out.println(user_id);
			String query = "SELECT Bill_date,Units, Amount FROM water where id='" + user_id + "'";
			ResultSet re = stmt.executeQuery(query);
			
			
			view.setModel(DbUtils.resultSetToTableModel(re));
			

			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	Timer panelDown = new Timer (5,new ActionListener() {
		
	public void actionPerformed(ActionEvent e) {
			
			
			if(scrollPane.getHeight() != 0) {
				scrollPane.setBounds(scrollPane.getX(), scrollPane.getY(), scrollPane.getWidth(), scrollPane.getHeight()-10);
				}
			else {
				((Timer)e.getSource()).stop();
			}
		}
			
	});

	
	Timer panelUp = new Timer (5,new ActionListener() {
		
	public void actionPerformed(ActionEvent e) {
			
			if(scrollPane.getHeight() !=200) {
				scrollPane.setBounds(scrollPane.getX(), scrollPane.getY(), scrollPane.getWidth(), scrollPane.getHeight()+10);
			}
			else {
				((Timer)e.getSource()).stop();
		     }
		}
		
	});
	private JTextField textYear;
	private JTextField textMonth;
}