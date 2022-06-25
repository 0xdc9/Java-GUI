package latihan_gui_tufa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class add implements ActionListener{
	JLabel emailL, userL, passwordL, authL, notify;
	JTextField emailTXT, userTXT, authTXT;
	JPasswordField passTXT;
	JButton button_add, button_back;
	connect sql;
	JPanel pannelinput, panelbuttonn;
	
	add(){
		//declare labeling
		emailL = new JLabel("Email:  ");
		userL = new JLabel("Username: ");
		passwordL = new JLabel("Password: ");
		authL = new JLabel("Auth type: ");
		notify = new JLabel("");
		
		// declare textfield and pass field
		emailTXT = new JTextField();
		userTXT = new JTextField();
		passTXT = new JPasswordField();
		authTXT = new JTextField();
		
		// declare button
		button_add = new JButton("Add");
		button_back = new JButton("Back");
		
		//declare panel
		pannelinput = new JPanel();
		panelbuttonn = new JPanel();
		
		//assemble panel input
		pannelinput.setLayout(new BoxLayout(pannelinput, BoxLayout.PAGE_AXIS));
		pannelinput.add(emailL);
		pannelinput.add(emailTXT);
		pannelinput.add(userL);
		pannelinput.add(userTXT);
		pannelinput.add(passwordL);
		pannelinput.add(passTXT);
		pannelinput.add(authL);
		pannelinput.add(authTXT);
		pannelinput.add(notify);
		pannelinput.setSize(200,200);
		
		//assemble panel input + buttonn
		panelbuttonn.setLayout(new BorderLayout());
		panelbuttonn.add(pannelinput, BorderLayout.PAGE_START);
		panelbuttonn.add(button_add);
		panelbuttonn.add(button_back, BorderLayout.PAGE_END);
		button_add.addActionListener(this);
		button_back.addActionListener(this);
		Main.frame.add(panelbuttonn);
		Main.frame.setSize(400,400);
		Main.frame.setVisible(true);
	}
	
	
	
	
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String status = e.getActionCommand();
		System.out.println("add status: " + status);
		sql = new connect();
		String get_username = userTXT.getText();
		String get_email = emailTXT.getText();
		String get_pass = passTXT.getText();
		String get_authtype = authTXT.getText();		
		
		switch(status) {
		case "Add":
			//insert into tufa values('root','REDACTED@gmail.com','toor','off');
			String queri = "insert into tufa values(?, ?, ?, ?);";
			
			try {
				sql.ps = sql.con.prepareStatement(queri);
				sql.ps.setString(1, get_username);
				sql.ps.setString(2, get_email);
				sql.ps.setString(3, get_pass);
				sql.ps.setString(4, get_authtype);
				sql.ps.execute();
				sql.con.close();
				System.out.println("sql executed in class Add");
				
			}catch(Exception adderr) {
				System.out.println("sql lu error (add)");
			}
			notify.setText("added!");
			break;
		
		case "Back":
			Main.frame.remove(panelbuttonn);
			Main.frame.repaint();
			Main.frame.add(Menu.menupanel);
			break;
			
			
		}// switch
		
	}// action performed

}
