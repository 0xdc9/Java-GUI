package latihan_gui_tufa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class view implements ActionListener{
	JFrame frame;
	connect esqiel;
	JPanel tabel, button_backpanel;
	JButton button_back;
	JTable out_toparse;
	DefaultTableModel parsed_table;
	JScrollPane scrollpane;
	//jtable(defaulttablemodel) -> scrollpane 
	view(){
		// declare panel
		tabel = new JPanel();
		button_backpanel = new JPanel();
		// declare button
		String get_username ="", get_email="", get_password="", get_auth="";
		button_back = new JButton("Back");
		
		// declare table & default table model
		out_toparse = new JTable();
		scrollpane = new JScrollPane(out_toparse);
		parsed_table = new DefaultTableModel(new String[] {"username", "email", "password", "auth_type"}, 0);
		
		//getting sql
		String queri = "select * from tufa;";
		esqiel = new connect();
		try {
			esqiel.st = esqiel.con.createStatement();
			esqiel.rs = esqiel.st.executeQuery(queri);
			while(esqiel.rs.next()) {
				get_username = esqiel.rs.getString(1);
				get_email=esqiel.rs.getString(2);
				get_password=esqiel.rs.getString(3);
				get_auth=esqiel.rs.getString(4);
				parsed_table.addRow(new Object[] {get_username, get_email, get_password, get_auth});
			}
			esqiel.con.close();
		}catch(Exception e) {
			System.out.println("sql lu error(view)");
		}
		//getting sql done
		
		//table 
		out_toparse.setModel(parsed_table);
		tabel.setLayout(new BoxLayout(tabel, BoxLayout.PAGE_AXIS));
		tabel.add(scrollpane);
		tabel.add(button_back, BorderLayout.CENTER);
		Main.frame.add(tabel);
		
		button_back.addActionListener(this);
		scrollpane.setSize(30,30);
		Main.frame.setSize(400,400);
		Main.frame.setVisible(true);
		
		
	}// view class
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("stat " + e.getActionCommand());
		Main.frame.remove(tabel);
		Main.frame.repaint();
		Main.frame.add(Menu.menupanel);
	}

}
