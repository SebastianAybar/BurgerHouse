package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class SetTable extends JPanel {
	// variable
	private Dimension dim;
	private int tableNr;
	// SetTable
	private JPanel setTable;
	// SetTablePanel
	private JPanel setTablePanel;
	private JLabel tableNr_Label;
	private JTextField setTable_textField;
	private JButton btnSetTable1;
	private JButton btnSetTable2;
	private JButton btnSetTable3;
	private JButton btnSetTable4;
	private JButton btnSetTable5;
	private JButton btnSetTable6;
	private JButton btnSetTable7;
	private JButton btnSetTable8;
	private JButton btnSetTable9;
	private JButton btnSetTableAssign;
	private JButton btnSetTable0;
	private JButton btnSetTableDelete;
	// SetTableTitle
	private JPanel setTableTitle_Panel;
	private JLabel setTableTitle_Label;
	
	private JLabel setTable_BG;

	public SetTable(BH_GUI_Frame bh_GUI_Frame) {
		setTable_init();	
		// Laptop 1280,720
		setSize((int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
		setTable.setBounds(0,0,(int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
//		setSize(1280,720);

		setTablePanel.setLayout(null);
		
		setTablePanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setTablePanel.setBounds(444, 195, 391, 330);
		setTable.add(setTablePanel);
			
		tableNr_Label.setBounds(10, 9, 137, 14);
		setTablePanel.add(tableNr_Label);
		

		setTable_textField.setText("Please Enter Table Number");
		setTable_textField.setEditable(false);
		setTable_textField.setColumns(10);
		setTable_textField.setBackground(Color.WHITE);
		setTable_textField.setBounds(157, 6, 168, 20);
		setTablePanel.add(setTable_textField);
		
		btnSetTable1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "1");
			}
		});
		btnSetTable1.setBounds(10, 198, 112, 42);
		setTablePanel.add(btnSetTable1);
		
		btnSetTable2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "2");				
			}
		});
		btnSetTable2.setBounds(132, 198, 112, 42);
		setTablePanel.add(btnSetTable2);
		
		btnSetTable3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "3");
			}
		});
		btnSetTable3.setBounds(254, 198, 112, 42);
		setTablePanel.add(btnSetTable3);
		
		btnSetTable4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "4");
			}
		});
		btnSetTable4.setBounds(10, 145, 112, 42);
		setTablePanel.add(btnSetTable4);
		
		btnSetTable5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "5");
			}
		});
		btnSetTable5.setBounds(132, 145, 112, 42);
		setTablePanel.add(btnSetTable5);
		
		btnSetTable6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "6");
			}
		});
		btnSetTable6.setBounds(254, 145, 112, 42);
		setTablePanel.add(btnSetTable6);
		
		btnSetTable7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "7");
			}
		});
		btnSetTable7.setBounds(10, 92, 112, 42);
		setTablePanel.add(btnSetTable7);
		
		btnSetTable8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "8");
			}
		});
		btnSetTable8.setBounds(132, 92, 112, 42);
		setTablePanel.add(btnSetTable8);
		
		btnSetTable9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "9");
			}
		});
		btnSetTable9.setBounds(254, 92, 112, 42);
		setTablePanel.add(btnSetTable9);
		
		btnSetTableAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				else {
					tableNr = Integer.parseInt(setTable_textField.getText());
					if(tableNr == 0) {
						JOptionPane.showMessageDialog(btnSetTableAssign, "Invalid Table");
					}
					else{
						tableNr = Integer.parseInt(setTable_textField.getText());
						setTable_textField.setText("");
						bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
						bh_GUI_Frame.getCostumerMenu().setAssignedTableNr(tableNr);
						
					}
				}
				
			} catch (Exception e2) {
				System.out.println(e2);
				JOptionPane.showMessageDialog(btnSetTableAssign, "Enter Number");
			}
			}
		});
		btnSetTableAssign.setBounds(10, 276, 112, 23);
		setTablePanel.add(btnSetTableAssign);
		
		btnSetTable0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
					setTable_textField.setText("");
				}
				setTable_textField.setText(setTable_textField.getText() + "0");
			}
		});
		btnSetTable0.setBounds(132, 257, 112, 42);
		setTablePanel.add(btnSetTable0);
		
		btnSetTableDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(setTable_textField.getText().equalsIgnoreCase("Please Enter Table Number")) {
						setTable_textField.setText("");
					} else {
						setTable_textField.setText(setTable_textField.getText().substring(0,setTable_textField.getText().length()-1));
					}
				} catch (Exception e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(btnSetTableDelete, "No Number Assigned");
				}
			}
		});
		btnSetTableDelete.setBounds(254, 276, 112, 23);
		setTablePanel.add(btnSetTableDelete);

		setTableTitle_Panel.setLayout(null);
		setTableTitle_Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setTableTitle_Panel.setBounds(318, 58, 643, 109);
		setTable.add(setTableTitle_Panel);
		
		setTableTitle_Label.setHorizontalAlignment(SwingConstants.CENTER);
		setTableTitle_Label.setFont(new Font("Tahoma", Font.PLAIN, 37));
		setTableTitle_Label.setBounds(10, 11, 623, 87);
		setTableTitle_Panel.add(setTableTitle_Label);
		
//		setTable_BG.setIcon(new ImageIcon("image\\fast-food-cola-french-fries-burger-art.jpg"));
//		setTable_BG.setBounds(0, 0, 1280, 720);
		setTable_BG.setBounds(0, 0,(int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight());

		//
		ImageIcon im = (new ImageIcon(((new ImageIcon(
				"image\\fast-food-cola-french-fries-burger-art.jpg").getImage()
	            .getScaledInstance((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight(),
	                    java.awt.Image.SCALE_SMOOTH)))));
		setTable_BG.setIcon(im);
		//
		
		setTable.add(setTable_BG);
	}


	private void setTable_init() {
		setTable = new JPanel();
		setTable.setLayout(null);
		add(setTable);
		
		setTablePanel = new JPanel();
		tableNr_Label = new JLabel("Please Assign Table");
		setTable_textField = new JTextField();
		
		btnSetTable1 = new JButton("1");
		btnSetTable2 = new JButton("2");
		btnSetTable3 = new JButton("3");
		btnSetTable4 = new JButton("4");
		btnSetTable5 = new JButton("5");
		btnSetTable6 = new JButton("6");
		btnSetTable7 = new JButton("7");
		btnSetTable8 = new JButton("8");
		btnSetTable9 = new JButton("9");
		btnSetTableAssign = new JButton("Assign");
		btnSetTable0 = new JButton("0");
		btnSetTableDelete = new JButton("Delete");
		
		setTableTitle_Panel = new JPanel();
		setTableTitle_Panel.setBackground(Color.GREEN);
		setTableTitle_Label = new JLabel("Please Assign a Table Nr");
		
		setTable_BG = new JLabel("");
	
		setLayout(null);
		tableNr = 0;
	}
	
	public int getTableNr() {
		return tableNr;
	}
	
	public void setTableNr(int sendTableNr) {
		tableNr = sendTableNr;
		setTable_textField.setText("Please Enter Table Number");		
	}
	
	public Dimension getDimension() {
		return dim;
	}
	
	public void resetSetTable() {
		tableNr = 0;
	}
}
