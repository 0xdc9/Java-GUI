package latihan_gui_tufa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	// main = login admin
	// menu = pilihan button & menu
		// add
		// delete
		// view
		// update
		
	// declare disini
	public static JFrame frame;
	public static JPanel mainpanel, panel, paneltesting;
	public static JTextField inputuser;
	public static JPasswordField inputpass;
	public static JLabel welcome, user, pass, alert, label_testing;
	public static JButton buttonlogin;
	
	Main(){
		//testing disini broski
		label_testing = new JLabel("testing123");
		paneltesting = new JPanel();
		paneltesting.add(label_testing);
		//bikin button
		buttonlogin = new JButton("Login");
		
		//bikin label
		welcome = new JLabel("Welcome to LATIHAN GUI UAS");
		user = new JLabel("Username: ");
		pass = new JLabel("Password: ");
		alert = new JLabel("");
		
		//declare text & pass
		inputuser = new JTextField();
		inputpass = new JPasswordField();
		// assemble
		frame = new JFrame("LATIHAN WOI");
		panel = new JPanel();
		mainpanel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(welcome);
		panel.add(user);
		panel.add(inputuser);
		panel.add(pass);
		panel.add(inputpass);
		panel.add(alert);
		

		
		mainpanel.add(buttonlogin, BorderLayout.SOUTH);
		
		buttonlogin.addActionListener(this);
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.add(mainpanel, BorderLayout.SOUTH);
		//frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
		
		
		
	}

	
	
public static void main(String[] args) {
	new Main();
	}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String passget = inputpass.getText();
	String userget = inputuser.getText();
	String command = e.getActionCommand();
	System.out.println("triggered " + command);
	System.out.println("username: " + userget);
	System.out.println("password: " + passget);
	
	if (passget.equals("admin")){
		alert.setText("bener");
		frame.remove(mainpanel);
		frame.remove(panel);
		frame.repaint();
		System.out.println("testing done");
		new Menu();
		
	}
	else {
		alert.setText("salah");
	}
}
}
