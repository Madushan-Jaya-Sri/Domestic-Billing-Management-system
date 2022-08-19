

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database.DataBaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class LoginInterface extends JFrame {

	private JPanel contentPane;
	public JTextField txtUsername;

	private JPasswordField txtPassword;
	
	private JTextField textEnName;
	private JTextField textEnPass;
	
	private Connection conn;
	
	

	public LoginInterface() {
		Initialize();
		conn= DataBaseConnection.connection();
		

	}
	public void Initialize() {
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 601, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(63, 67, 0, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter name           :");
		lblEnterName.setBounds(10, 11, 223, 26);
		lblEnterName.setForeground(Color.YELLOW);
		lblEnterName.setFont(new Font("Verdana", Font.BOLD, 20));
		panel.add(lblEnterName);
		
		JLabel lblEnterAPassword = new JLabel("Enter a password :");
		lblEnterAPassword.setForeground(Color.YELLOW);
		lblEnterAPassword.setFont(new Font("Verdana", Font.BOLD, 20));
		lblEnterAPassword.setBounds(10, 61, 223, 26);
		panel.add(lblEnterAPassword);
		

		
		textEnName = new JTextField();
		textEnName.setBounds(245, 18, 142, 20);
		panel.add(textEnName);
		textEnName.setColumns(10);
		
		
		
		textEnPass = new JTextField();
		textEnPass.setColumns(10);
		textEnPass.setBounds(243, 68, 144, 20);
		panel.add(textEnPass);
		
		JLabel lblLoginSc = new JLabel("Login successful...");
		lblLoginSc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoginSc.setBackground(Color.BLACK);
		lblLoginSc.setBounds(425, 430, 0, 25);
		contentPane.add(lblLoginSc);
		lblLoginSc.setForeground(Color.RED);
		
		JCheckBox checkBoxPass = new JCheckBox("");
		checkBoxPass.setBounds(240, 228, 21, 20);
		contentPane.add(checkBoxPass);
		checkBoxPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxPass.isSelected()) {
					txtPassword.setEchoChar((char) 0);
				}
				else {
					txtPassword.setEchoChar('*');
				}
			}
		});
		

		
		Timer panelRight = new Timer (5,new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				
				if(panel.getWidth() != 0) {
					panel.setBounds(panel.getX(), panel.getY(), panel.getWidth()-10, panel.getHeight());
					}
				else {
					((Timer)e.getSource()).stop();
				}
			}
				
		});

		
		Timer panelLeft = new Timer (5,new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
				if(panel.getWidth() !=430) {
					panel.setBounds(panel.getX(), panel.getY(), panel.getWidth()+10, panel.getHeight());
				}
				else {
					((Timer)e.getSource()).stop();
			     }
			}
			
		});
		
		
		
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		String userName =textEnName.getText();
		String passWord =textEnPass.getText();
		
			if(!userName.isEmpty()) {
			if(!passWord.isEmpty()) {
			if(!checkUsername(userName)) {
							
				try {
			
						PreparedStatement ps = conn.prepareStatement("insert into userlogin(user_name,password) values(?,?)");
						ps.setString(1, userName);
						ps.setString(2, passWord);
						
						int result= ps.executeUpdate();
						
						
						if (result==1) {
							JOptionPane.showMessageDialog(null,"Successfully registered!"," ",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null,"Registration failed!!","error",JOptionPane.ERROR_MESSAGE);
						}
					}
				
					
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
				
				}
				else {
					JOptionPane.showMessageDialog(null,"User name already exists!","error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Insert password","error",JOptionPane.ERROR_MESSAGE);
			}
		}
			else {
		JOptionPane.showMessageDialog(null,"Insert username","error",JOptionPane.ERROR_MESSAGE);
			}
			
		
		
		
		panelRight.start();
		textEnName.setText("");
		textEnPass.setText("");
		
			}
		});
		
		
		btnOK.setBounds(97, 129, 89, 23);
		panel.add(btnOK);
		
		
		JButton btnSignUp = new JButton("SignUp");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLeft.start();
				
			}
		});
		btnSignUp.setBounds(265, 342, 89, 23);
		contentPane.add(btnSignUp);
		
			
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try {
							
							String userName =txtUsername.getText();

							String passWord =txtPassword.getText();
							
							PreparedStatement ps = conn.prepareStatement("select Id,user_name,password from userlogin where user_name=? and password=?");
							ps.setString(1,userName);
							ps.setString(2,passWord);
							
							
							ResultSet rt= ps.executeQuery();
							if(rt.next()==false) {
								JOptionPane.showMessageDialog(null,"Please input valid details","Invalid login",JOptionPane.ERROR_MESSAGE);
							}
							else {
								int id_ = rt.getInt("Id");
								
								 
								//System.out.println(id_);
								Dashboard  frame = new Dashboard(id_);
								frame.setLocationRelativeTo(null);
								frame.show();
								dispose();
					
								
								
								//String Password=rt.getString(2);
								txtUsername.setText("");
								txtPassword.setText("");
							}
						}
						
						
						
						 catch (SQLException | ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

					}
		});
		
		
		btnLogin.setBounds(162, 280, 89, 23);
		contentPane.add(btnLogin);
		
		
		JLabel lblShowPass = new JLabel("showpassword");
		lblShowPass.setForeground(new Color(255, 255, 0));
		lblShowPass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblShowPass.setIcon(null);
		lblShowPass.setBounds(266, 228, 88, 20);
		contentPane.add(lblShowPass);
		
		
		JLabel lblCreateAcc = new JLabel("Haven't an account? ");
		lblCreateAcc.setBounds(63, 336, 206, 31);
		lblCreateAcc.setForeground(new Color(0, 255, 255));
		lblCreateAcc.setFont(new Font("Ubuntu Mono", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(lblCreateAcc);
		
		JLabel lblPassword = new JLabel("Password    :");
		lblPassword.setBounds(63, 187, 156, 44);
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 20));
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(240, 148, 136, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		String userName =txtUsername.getText();
		
		JLabel lblUsername = new JLabel("User name   :");
		lblUsername.setBounds(63, 132, 156, 44);
		lblUsername.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUsername.setForeground(new Color(255, 255, 0));
		contentPane.add(lblUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(240, 203, 136, 20);
		contentPane.add(txtPassword);
		
		JLabel lblBack = new JLabel("");
		lblBack.setForeground(Color.WHITE);
		lblBack.setBackground(Color.WHITE);
		lblBack.setBounds(0, 0, 585, 466);
		lblBack.setIcon(new ImageIcon("Images\\loginlabel.png"));
		contentPane.add(lblBack);
		
	
	
		
		
	}


	public boolean checkUsername(String username) {
		
		PreparedStatement ps;
		ResultSet rs;
		boolean checkUser =false;
		String query = "SELECT * FROM userlogin WHERE user_name=?";
		
		try {
			ps=DataBaseConnection.connection().prepareStatement(query);
			ps.setString(1, username);
			
			rs =ps.executeQuery();
			if(rs.next()) {
				checkUser =true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkUser;
		
	}

}

