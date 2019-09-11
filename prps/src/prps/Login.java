package prps;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import up5.CameraNode;
import up5.CatalogFrame;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Choice;
import javax.swing.JCheckBox;

public class Login {

	private JFrame frame;
	private JTextField Login_field;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel role_label = new JLabel("Role");
		role_label.setBounds(39, 38, 61, 16);
		frame.getContentPane().add(role_label);
		
		JLabel login_label = new JLabel("Login");
		login_label.setBounds(39, 78, 61, 16);
		frame.getContentPane().add(login_label);
		
		JLabel password_label = new JLabel("Password");
		password_label.setBounds(39, 119, 61, 16);
		frame.getContentPane().add(password_label);
		
		Login_field = new JTextField();
		Login_field.setBounds(154, 73, 245, 26);
		frame.getContentPane().add(Login_field);
		Login_field.setColumns(10);
		
		JButton login_button = new JButton("Log in");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password=passwordField.getText();
				String username=Login_field.getText();
				if(password.contains("11111") && username.contains("Evgenia"))
				{
					passwordField.setText(null);
					Login_field.setText(null);

					 CatalogFrame mainClass = new CatalogFrame();
					 CatalogFrame.main(null);
					 mainClass.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				     mainClass.setVisible(true);
				     
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid login or password", "Login Error", JOptionPane.ERROR_MESSAGE);
					passwordField.setText(null);
					Login_field.setText(null);
					
				}
				 
			}
		});
		login_button.setBounds(79, 228, 117, 29);
		frame.getContentPane().add(login_button);
		
		JButton cancel_button = new JButton("Cancel");
		cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Cancel");
				if(JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Login", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		cancel_button.setBounds(250, 228, 117, 29);
		frame.getContentPane().add(cancel_button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 114, 245, 26);
		frame.getContentPane().add(passwordField);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Client M.");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sells M.");
		chckbxNewCheckBox.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			if (chckbxNewCheckBox.isSelected())
			{
				chckbxNewCheckBox_1.setEnabled(false);
			}
		}
			
		});
		
		chckbxNewCheckBox_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox_1.isSelected())
				{
					chckbxNewCheckBox.setEnabled(false);
				}
			}
				
			});
		
		chckbxNewCheckBox.setBounds(156, 34, 110, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		
		chckbxNewCheckBox_1.setBounds(285, 34, 104, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
	}
}
