package latihan_gui_tufa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu implements  ActionListener{
	JMenu menuom, profile; 
	public static JMenuBar menubar, menuprofile;
	JMenuItem add,view,delete,update, logout, exit;
	public static JPanel menupanel, menupanelprof;
	JLabel welcoming_admin;
	Menu(){
		// declare menu panel
		menupanel = new JPanel();
		menupanelprof = new JPanel();
		
		//declare menu
		 menuom = new JMenu("Menu");
		 profile = new JMenu("Profile");
		 menubar = new JMenuBar();
		 menuprofile = new JMenuBar();
		 
		 // menu item
		 logout =  new JMenuItem("Log out");
		 exit = new JMenuItem("Exit");
		 add = new JMenuItem("Add user");
		 view = new JMenuItem("View user");
		 delete = new JMenuItem("Delete user");
		 update = new JMenuItem("Update user");
		 
		 //add item to menu
		 menuom.add(add);
		 menuom.add(view);
		 menuom.add(delete);
		 menuom.add(update);
	 
		 profile.add(logout);
		 profile.add(exit);
		 
		 //add menu to menubar
		 menubar.add(menuom);
		 menubar.add(profile);
		 //assemble ui
		 
		 menupanel.setLayout(new BorderLayout());
		 menupanel.add(menubar, BorderLayout.PAGE_START);
//		 menupanel.add(menuprofile, BorderLayout.NORTH);
			
//		menupanelprof.setLayout(new BorderLayout());
//		menupanelprof.add(menuprofile, BorderLayout.NORTH);
//		Main.frame.add(menupanelprof);
		 
		Main.frame.add(menupanel);
		 
		 logout.addActionListener(this);
		 exit.addActionListener(this);
		 add.addActionListener(this);
		 view.addActionListener(this);
		 delete.addActionListener(this);
		 update.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println("menu kepilih " + e.getActionCommand());
		switch(command) {
		case "Add user":
			Main.frame.remove(menupanel);
			Main.frame.repaint();
			new add();
			break;
			
		case "View user":
			Main.frame.remove(menupanel);
			Main.frame.repaint();
			new view();
			break;
			
		case "Log out":
			Main.frame.remove(menupanel);
			Main.frame.repaint();
			new Main();
			break;
		
		case "Delete user":
			Main.frame.remove(menupanel);
			Main.frame.repaint();
			new delete();
			break;
		
		case "Exit":
			System.exit(0);
			break;
		
		}
	}

}
