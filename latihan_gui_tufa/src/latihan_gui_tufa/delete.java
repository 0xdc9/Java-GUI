package latihan_gui_tufa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class delete implements ActionListener{
	JFrame frame;
	connect esqiel, esqiel_delete;
	JPanel tabel, button_backpanel;
	JButton button_back, button_delete;
	JTable out_toparse;
	JLabel notify;
	DefaultTableModel parsed_table;
	JScrollPane scrollpane;
	ListSelectionModel gettabval;
	
	String column_name ="", column_email="" , column_pass="", column_auth="";
	//jtable(defaulttablemodel) -> scrollpane 
	delete(){
		//declare label
		notify = new JLabel("");
		
		// declare panel
		tabel = new JPanel();
		button_backpanel = new JPanel();
		
		// declare button
		String get_username ="", get_email="", get_password="", get_auth="";
		button_back = new JButton("Back");
		button_delete = new JButton("Delete");
		
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
			System.out.println("sql lu error(delete)");
		}
		//getting sql done
		
		//table biar bisa di select
		out_toparse.setModel(parsed_table);
		gettabval =  out_toparse.getSelectionModel();
		gettabval.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				column_name = (String)out_toparse.getValueAt(out_toparse.getSelectedRow(), 0);//name
				column_email = (String)out_toparse.getValueAt(out_toparse.getSelectedRow(), 1);//email
				column_pass = (String)out_toparse.getValueAt(out_toparse.getSelectedRow(), 2);//pass
				column_auth = (String)out_toparse.getValueAt(out_toparse.getSelectedRow(), 3);//auth
				
			}
		});
		
		tabel.setLayout(new BoxLayout(tabel, BoxLayout.PAGE_AXIS));
		tabel.add(scrollpane);
		tabel.add(notify);
		tabel.add(button_back, BorderLayout.CENTER);
		tabel.add(button_delete, BorderLayout.SOUTH);
		Main.frame.add(tabel);
		//listener table
		
		
		button_back.addActionListener(this);
		button_delete.addActionListener(this);
		scrollpane.setSize(30,30);
		Main.frame.setSize(400,400);
		Main.frame.setVisible(true);
		
		
	}// view class
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		String selected = column_name;
		switch(command) {
		case "Back":
			System.out.println("stat " + e.getActionCommand());
			Main.frame.remove(tabel);
			Main.frame.repaint();
			Main.frame.add(Menu.menupanel);
			break;
		
		case "Delete":
			String queri_del="delete from tufa where username = ?;";
			esqiel_delete = new connect();
			try {
			esqiel_delete.ps = esqiel_delete.con.prepareStatement(queri_del);
			esqiel_delete.ps.setString(1, selected);
			esqiel_delete.ps.execute();
			esqiel_delete.con.close();
			notify.setText("deleted successfully");
			System.out.println("log item deleted: "+selected);
			
			// removing row
			// out_toparse = jtable & parsed_table = defaultmodeltabel
			int selected_row = out_toparse.getSelectedRow();
			System.out.println(selected_row);
			parsed_table.removeRow(selected_row);
			selected_row = 0;
			System.out.println("removing done");
			}catch(Exception delerr) {
				System.out.println("sql err at del class");
			}
			
			break;
		
	}//switch

} //performed
} // delete
