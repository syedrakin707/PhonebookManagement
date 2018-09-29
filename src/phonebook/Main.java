package phonebook;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Main extends JFrame implements WindowListener,ActionListener  {

	private JLabel header;
	private JLabel number;
	private JLabel name;
	private JLabel address;
	private JLabel email;
	
	private JTextField num;
	private JTextField n;
	private JTextField add;
	private JTextField mail;
	
	private JLabel newnumber;
	private JLabel newname;
	private JLabel newaddress;
	private JLabel newemail;
	
	private JTextField regnumber;
	private JTextField regname;
	private JTextField regaddress;
	private JTextField regemail;
	
	private JPanel addnumber;
	private JLabel adder;
	
	private JButton search;
	private JFrame error;
	
	private JLabel sim;
	private JTextField operator;
	
	private JButton showTable;
	
	private JTable table;
	
	private JScrollPane scroll;
	
	public JButton delete;
	
	private static PhoneBookInfo[] memory = new PhoneBookInfo[100];
	private static int count = 0;
	private JButton inclusion;
	
	
	
	private JFrame tableframe;
	public static void main (String [] args) {
		String thisLine = null;
		String arb[] = new String[50];
	    int i=0;
	    FileReader fr = null;
	    BufferedReader br = null;
	      try {
	         // open input stream test.txt for reading purpose.
	    	 fr = new FileReader("phonebook.txt");
	         br = new BufferedReader(fr);
	         while ((thisLine = br.readLine()) != null) {
	            System.out.println(thisLine);
	            arb[i] = thisLine;
	            i++;
	            count++;
	         }
	         br.close();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      PhoneBookInfo[] pbi = new PhoneBookInfo[i];
			for(i=0; i< pbi.length;i++) {
			    pbi[i] = new PhoneBookInfo();
			}
			for(int j=0; j<memory.length;j++) {
				memory[j] = new PhoneBookInfo();
			}
			for (i=0;i<pbi.length;i++) {
				int index1 = arb[i].indexOf('|');
				pbi[i].setNumber(arb[i].substring(0, index1));
				memory[i].setNumber(arb[i].substring(0, index1));
				
				int index2 = index1 + 1;
				int index3 = arb[i].indexOf('|', index2);
				pbi[i].setName((arb[i].substring(index2, index3)));
				memory[i].setName((arb[i].substring(index2, index3)));
				
				int index4 = index3 + 1;
				int index5 = arb[i].indexOf('|', index4);
				pbi[i].setAddress(arb[i].substring(index4, index5));
				memory[i].setAddress(arb[i].substring(index4, index5));
				
				int index6 = index5 + 1;
				pbi[i].setEmail(arb[i].substring(index6, arb[i].length()));
				memory[i].setEmail(arb[i].substring(index6, arb[i].length()));
				
				System.out.println(pbi[i].getNumber());
			}
			
			Main m = new Main("Phonebook Management System", pbi);
			m.setSize(1300,500);
	        m.setVisible(true);
	}
	
	public Main(String title, PhoneBookInfo[] pbi) {
		super(title);
    	setLayout(null);
    	addWindowListener(this);
    	
    	try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("phone.jpg")))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	header = new JLabel("Phonebook Management", SwingConstants.CENTER);
    	
    	header.setBackground(Color.GREEN);
		header.setOpaque(true);
		add(header);
		header.setAlignmentX(CENTER_ALIGNMENT);
		header.setBounds(350,0,500,50);
		header.setFont(new Font("Arial", Font.PLAIN, 36));
		
		number = new JLabel("Phone Number");
		name = new JLabel("Name");
		address = new JLabel("Address");
		email = new JLabel("Email");
		
		number.setForeground(Color.WHITE);
		name.setForeground(Color.WHITE);
		address.setForeground(Color.WHITE);
		email.setForeground(Color.WHITE);
		
		num = new JTextField();
		n = new JTextField();
		add = new JTextField();
		mail = new JTextField();
		
		
		search = new JButton("Search");
		
		
		add(number); add(name); add(address); add(email);
		add(num); add(n); add(add); add(mail);
		add(search);
		
		addnumber = new JPanel();
		newnumber = new JLabel("Phone Number");
		newname = new JLabel("Name");
		newaddress = new JLabel("Address");
		newemail = new JLabel("Email");
		adder = new JLabel("Add Number");
		
		regnumber = new JTextField("");
		regname = new JTextField("");
		regaddress = new JTextField("");
		regemail = new JTextField("");
		
		inclusion = new JButton("Add");
		
		showTable = new JButton("Show Data In Table");
		addnumber.setLayout(null);
		add(addnumber);
		addnumber.add(newnumber);
		addnumber.add(newname);
		addnumber.add(newaddress);
		addnumber.add(newemail);
		addnumber.add(adder);
		
		addnumber.add(regnumber);
		addnumber.add(regname);
		addnumber.add(regaddress);
		addnumber.add(regemail);
		
		addnumber.add(inclusion);
		number.setBounds(200, 100, 300, 20);
		name.setBounds(200, 150, 300, 20);
		address.setBounds(200, 175, 300, 20);
		email.setBounds(200, 200, 300, 20);
		
		
		num.setBounds(300, 100, 300, 20);
		n.setBounds(300, 150, 300, 20);
		add.setBounds(300, 175, 300, 20);
		mail.setBounds(300, 200, 300, 20);
		
		
		addnumber.setBounds(900, 50, 300, 300);
		adder.setAlignmentX(CENTER_ALIGNMENT);
		adder.setBounds(120,0,100,30);
		newnumber.setBounds(20,60,100,20);
		newname.setBounds(20,90,100,20);
		newaddress.setBounds(20,120,100,20);
		newemail.setBounds(20,150,100,20);
		
		regnumber.setBounds(120,60,100,20);
		regname.setBounds(120,90,100,20);
		regaddress.setBounds(120,120,100,20);
		regemail.setBounds(120,150,100,20);
		
		search.setBounds(640,100,100,20);
		search.setBackground(Color.BLACK);
		search.setForeground(Color.WHITE);
		search.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		inclusion.setBounds(120,180,100,20);
		inclusion.setBackground(Color.BLACK);
		inclusion.setForeground(Color.WHITE);
		inclusion.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		add(showTable);
		
		showTable.setBounds(300,300,175,20);
		showTable.setBackground(Color.BLACK);
		showTable.setForeground(Color.YELLOW);
		showTable.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				for (int i=0;i<count;i++) {
					if (num.getText().equals(memory[i].getNumber())) {
						n.setText(memory[i].getName());
						add.setText(memory[i].getAddress());
						mail.setText(memory[i].getEmail());
						found = true;
						break;
					}
					else if (num.getText().length()!=11) {
						JOptionPane.showMessageDialog(error, "Number not valid", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}
					
				}
				if (!found){
					JOptionPane.showMessageDialog(error, "Number not found", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (num.getText().substring(0, 3).contains("016") && found) {
					
					sim = new JLabel("Airtel Number");
					sim.setForeground(Color.WHITE);
					add(sim);
					sim.setBounds(300, 230, 300, 20);
				} else if (num.getText().substring(0,3).contains("017") && found) {
					sim = new JLabel("Grameenphone Number");
					sim.setForeground(Color.WHITE);
					add(sim);
					sim.setBounds(300, 230, 300, 20);
				} else if (num.getText().substring(0,3).contains("018") && found) {
					sim = new JLabel("Robi Number");
					sim.setForeground(Color.WHITE);
					add(sim);
					sim.setBounds(300, 230, 300, 20);
				} else if (num.getText().substring(0,3).contains("019") && found) {
					sim = new JLabel("Banglalink Number");
					sim.setForeground(Color.WHITE);
					add(sim);
					sim.setBounds(300, 230, 300, 20);
				} else if (num.getText().substring(0,3).contains("015") && found) {
					sim = new JLabel("Teletalk Number");
					sim.setForeground(Color.WHITE);
					add(sim);
					sim.setBounds(300, 230, 300, 20);
				}
			}
		});
		
		inclusion.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				memory[count].setNumber(regnumber.getText());
				memory[count].setName(regname.getText());
				memory[count].setAddress(regaddress.getText());
				memory[count].setEmail(regemail.getText());
				regnumber.setText("");
				regname.setText("");
				regaddress.setText("");
				regemail.setText("");
				count++;
			}
		});
		
		showTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableframe = new JFrame("Table Data");
				tableframe.setLayout(null);
				tableframe.setSize(800,500);
				tableframe.setVisible(true);
				DefaultTableModel m = new DefaultTableModel(memory.length, 4){
		    		String s[] = {"Phone Number", "Name", "Address", "Email"};
		    		public String getColumnName(int index){
		    			return s[index];
		    		}
		    	};
		    	table = new JTable(m);
		    	scroll = new JScrollPane();
		    	scroll.getViewport().add(table);
		    	tableframe.add(scroll);
		    	scroll.setBounds(25, 25, 600, 400);
		    	
		    	for (int k=0;k<count;k++) {
		    		table.setValueAt(memory[k].getNumber(), k, 0);
		    		table.setValueAt(memory[k].getName(), k, 1);
		    		table.setValueAt((memory[k].getAddress()), k, 2);
		    		table.setValueAt(memory[k].getEmail(), k, 3);
		    	}
		    	delete = new JButton("Delete");
		    	tableframe.add(delete);
		    	delete.setBounds(675,25,100,20);
				delete.setBackground(Color.DARK_GRAY);
				delete.setForeground(Color.CYAN);
				delete.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				
				ListSelectionModel lsm = table.getSelectionModel();
		    	delete.addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    			if (!lsm.isSelectionEmpty()) {
		    				int selectedRow = lsm.getMinSelectionIndex();
		    				String chosen = (String) table.getValueAt(selectedRow, 0);
		    				for (int l=0;memory[l].getNumber().isEmpty() == false;l++) {
		    					if (memory[l].getNumber().equals(chosen)) {
		    						while (memory[l].getNumber().isEmpty() == false) {
		    							memory[l].setNumber(memory[l+1].getNumber());
		    							memory[l].setName(memory[l+1].getName());
		    							memory[l].setAddress(memory[l+1].getAddress());
		    							memory[l].setEmail(memory[l+1].getEmail());
		    							l++;
		    						}
		    					}
		    				}
		    				
		    			}
		    			for (int k=0;k<count;k++) {
				    		table.setValueAt(memory[k].getNumber(), k, 0);
				    		table.setValueAt(memory[k].getName(), k, 1);
				    		table.setValueAt((memory[k].getAddress()), k, 2);
				    		table.setValueAt(memory[k].getEmail(), k, 3);
				    	}
		    		}
		    	});
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		dispose();
        System.exit(0);
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
