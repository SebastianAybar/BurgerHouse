package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class IndividualBurger extends JPanel {
	private int individualBurger_counter = 0;
	private DefaultTableModel individualBurger_priceList;
	private DefaultTableModel individualBurger_orderList;
	private DefaultTableModel individualBurger_selection_list;
	private JTable individualBurger_orderList_JTable;
	private static final DecimalFormat df = new DecimalFormat("0.00",  new DecimalFormatSymbols(Locale.US));
	
	JPanel individualBurger;
	JLabel sb_TitleLabel;
	JPanel individualBurger_TitlePanel;
	JLabel individualBurger_Title;
	JScrollPane zutaten_priceList_ScrollPane;
	private JTextField sumIndividualBurger_txtField;
	JSpinner individualBurger_spinner;
	
	public IndividualBurger(BH_GUI_Frame bh_GUI_Frame, ArrayList<Zutat> zutaten) {
		individualBurger_Init(zutaten);
		setSize((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight());
//		setSize(1280,720);
		setLayout(null);		

		individualBurger.setLayout(null);
//		individualBurger.setBounds(0, 0, 1280, 720);
		individualBurger.setBounds(0, 0, (int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight());
		add(individualBurger);
		
		sb_TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sb_TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));;
		
		individualBurger_TitlePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		individualBurger_TitlePanel.setBounds(216, 11, 1054, 138);
		individualBurger.add(individualBurger_TitlePanel);
		individualBurger_TitlePanel.setLayout(null);
		
		individualBurger_Title.setHorizontalAlignment(SwingConstants.CENTER);
		individualBurger_Title.setFont(new Font("Tahoma", Font.PLAIN, 37));
		individualBurger_Title.setBounds(10, 11, 1034, 116);
		individualBurger_TitlePanel.add(individualBurger_Title);
		
		
		
		JPanel individualBurger_OrderList_Panel = new JPanel();
		individualBurger_OrderList_Panel.setLayout(null);
		individualBurger_OrderList_Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		individualBurger_OrderList_Panel.setBackground(Color.WHITE);
		individualBurger_OrderList_Panel.setBounds(871, 160, 399, 518);
		individualBurger.add(individualBurger_OrderList_Panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 399, 463);
		individualBurger_OrderList_Panel.add(scrollPane);
		
		scrollPane.setViewportView(individualBurger_orderList_JTable);
		
		
		JButton deleteOrder_individualBurger_orderList = new JButton("Delete from Order");
		deleteOrder_individualBurger_orderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(individualBurger_orderList_JTable.getSelectedRow() != -1) {
					individualBurger_orderList.removeRow(individualBurger_orderList_JTable.getSelectedRow());
					BigDecimal totalPrice = new BigDecimal(0);
					for(int orderCount = 0; orderCount < individualBurger_orderList.getRowCount(); orderCount++) {
						totalPrice = totalPrice.add((BigDecimal)individualBurger_orderList.getValueAt(orderCount, 2));
					}
					sumIndividualBurger_txtField.setText(df.format(totalPrice));
				}
			}
		});
		deleteOrder_individualBurger_orderList.setBounds(0, 459, 124, 59);
		individualBurger_OrderList_Panel.add(deleteOrder_individualBurger_orderList);
		
		JButton placeOrder_individualBurger_OrderList = new JButton("Place Order");
		placeOrder_individualBurger_OrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
				bh_GUI_Frame.getCostumerMenu().updateOrderList(bh_GUI_Frame);				
			}
		});
		placeOrder_individualBurger_OrderList.setBounds(119, 459, 124, 59);
		individualBurger_OrderList_Panel.add(placeOrder_individualBurger_OrderList);
		
		sumIndividualBurger_txtField = new JTextField();
		sumIndividualBurger_txtField.setEditable(false);
		sumIndividualBurger_txtField.setBounds(253, 474, 136, 33);
		individualBurger_OrderList_Panel.add(sumIndividualBurger_txtField);
		sumIndividualBurger_txtField.setColumns(10);
		
		
		zutaten_priceList_ScrollPane.setBounds(10, 44, 227, 222);
//		individualBurger.add(zutaten_priceList_ScrollPane);
		JTable priceList_JTable = new JTable(individualBurger_priceList);
		priceList_JTable.getColumnModel().getColumn(2).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		priceList_JTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
				if(click.getClickCount() == 2) {
					if (individualBurger_selection_list.getRowCount() > 17) {
						JOptionPane.showMessageDialog(placeOrder_individualBurger_OrderList, "More than 17 Layer! Can't keep the Structural integrity");						
					} else {
						individualBurger_selection_list.addRow(new Object[] {individualBurger_priceList.getValueAt(priceList_JTable.getSelectedRow(), 1),
																			individualBurger_priceList.getValueAt(priceList_JTable.getSelectedRow(), 2)});						
					}
					if(individualBurger_selection_list.getRowCount() > 0) {
						individualBurger_spinner.setValue(1);
					}
				}
			}
		});
		priceList_JTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		priceList_JTable.setDefaultEditor(Object.class, null);
		zutaten_priceList_ScrollPane.setViewportView(priceList_JTable);
		
		JScrollPane individualBurger_selection_ScrollPane = new JScrollPane();
		individualBurger_selection_ScrollPane.setBounds(12, 44, 225, 220);
		JTable individualBurger_selection_JTable = new JTable(individualBurger_selection_list);
		individualBurger_selection_JTable.getColumnModel().getColumn(1).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
//		individualBurger_selection_ScrollPane.add();
		
		JPanel upDeleteDown_Panel = new JPanel();
		upDeleteDown_Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		upDeleteDown_Panel.setBounds(524, 160, 82, 260);
		individualBurger.add(upDeleteDown_Panel);
		upDeleteDown_Panel.setLayout(new GridLayout(3, 0, 0, 0));
		
		JButton individualBurger_selectionUp_btn = new JButton("Up");
		individualBurger_selectionUp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(individualBurger_selection_JTable.getSelectedRow() > 0) {					
					individualBurger_selection_list.moveRow(individualBurger_selection_JTable.getSelectedRow(), individualBurger_selection_JTable.getSelectedRow(), individualBurger_selection_JTable.getSelectedRow()-1);
					individualBurger_selection_JTable.setRowSelectionInterval(individualBurger_selection_JTable.getSelectedRow(), individualBurger_selection_JTable.getSelectedRow()-1);
				}
			}
		});
		upDeleteDown_Panel.add(individualBurger_selectionUp_btn);
		
		JButton individualBurger_selectionDelete_btn = new JButton("Delete");
		individualBurger_selectionDelete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(individualBurger_selection_JTable.getSelectedRow() != -1 ) {
				individualBurger_selection_list.removeRow(individualBurger_selection_JTable.getSelectedRow());
				}
				if(individualBurger_selection_list.getRowCount() < 1) {
					individualBurger_spinner.setValue(0);
				}				
			}
		});
		upDeleteDown_Panel.add(individualBurger_selectionDelete_btn);
		
		JButton individualBurger_selectionDown_btn = new JButton("Down");
		individualBurger_selectionDown_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(individualBurger_selection_JTable.getSelectedRow() < individualBurger_selection_list.getRowCount()-1) {
					
					individualBurger_selection_list.moveRow(individualBurger_selection_JTable.getSelectedRow(), individualBurger_selection_JTable.getSelectedRow(), individualBurger_selection_JTable.getSelectedRow()+1);
					individualBurger_selection_JTable.setRowSelectionInterval(individualBurger_selection_JTable.getSelectedRow(), individualBurger_selection_JTable.getSelectedRow()+1);
					
				}
			}
		});
		upDeleteDown_Panel.add(individualBurger_selectionDown_btn);
		
		JButton back_CostumerMenu = new JButton("Back");
		back_CostumerMenu.setIcon(new ImageIcon("image\\previous_1.png"));
		back_CostumerMenu.setBounds(10, 11, 201, 138);
		individualBurger.add(back_CostumerMenu);
		back_CostumerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
				bh_GUI_Frame.getCostumerMenu().updateOrderList(bh_GUI_Frame);
			}
		});
		
		JPanel individualBurger_priceList_Panel = new JPanel();
		individualBurger_priceList_Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		individualBurger_priceList_Panel.setBounds(10, 160, 247, 302);
		individualBurger.add(individualBurger_priceList_Panel);
		individualBurger_priceList_Panel.setLayout(null);
		individualBurger_priceList_Panel.add(zutaten_priceList_ScrollPane);
		
		JLabel lblNewLabel = new JLabel("Ingredient Price List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 227, 22);
		individualBurger_priceList_Panel.add(lblNewLabel);
		
		JButton individualBurger_addSelection_Button = new JButton("Add ingredient");
		individualBurger_addSelection_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (individualBurger_selection_list.getRowCount() > 17) {
					JOptionPane.showMessageDialog(placeOrder_individualBurger_OrderList, "More than 17 Layer! Can't keep the Structural integrity");						
				} else if((priceList_JTable.getSelectedRow() == -1)){
					//no ingredient selected
				} else {
					individualBurger_selection_list.addRow(new Object[] {individualBurger_priceList.getValueAt(priceList_JTable.getSelectedRow(), 1),
							individualBurger_priceList.getValueAt(priceList_JTable.getSelectedRow(), 2)});
				}
				if(individualBurger_selection_list.getRowCount() > 0) {
					individualBurger_spinner.setValue(1);
				}
			}
		});
		individualBurger_addSelection_Button.setBounds(10, 269, 227, 22);
		individualBurger_priceList_Panel.add(individualBurger_addSelection_Button);
		
		JPanel individualBurger_selection_Panel = new JPanel();
		individualBurger_selection_Panel.setLayout(null);
		individualBurger_selection_Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		individualBurger_selection_Panel.setBounds(267, 160, 247, 302);
		individualBurger.add(individualBurger_selection_Panel);
		individualBurger_selection_Panel.add(individualBurger_selection_ScrollPane);
		individualBurger_selection_ScrollPane.setViewportView(individualBurger_selection_JTable);
		
		JLabel selected_IndividualBurger = new JLabel("Ingredient Price List");
		selected_IndividualBurger.setHorizontalAlignment(SwingConstants.CENTER);
		selected_IndividualBurger.setBounds(10, 11, 227, 22);
		individualBurger_selection_Panel.add(selected_IndividualBurger);
		
		JButton individualBurger_addToOrder_Button = new JButton("Add to Order");
		individualBurger_addToOrder_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(individualBurger_selection_list.getRowCount() > 0 && (int) individualBurger_spinner.getValue() > 0) {
					BigDecimal price = new BigDecimal(0);
					BigDecimal fee = new BigDecimal(2);
					for (int individualBurgerCount = 0; individualBurgerCount < individualBurger_selection_list.getRowCount(); individualBurgerCount++) {
						price = price.add((BigDecimal)individualBurger_selection_list.getValueAt(individualBurgerCount, 1));
					}
					price = price.add(fee).multiply(BigDecimal.valueOf((int)individualBurger_spinner.getValue()));
					individualBurger_orderList.addRow(new Object[] {"individual Burger " + (++individualBurger_counter), (int) individualBurger_spinner.getValue(), price});
					
					individualBurger_selection_list.setRowCount(0);					
				} else {
					individualBurger_selection_list.setRowCount(0);
				}
				BigDecimal totalPrice = new BigDecimal(0);
				for(int orderCount = 0; orderCount < individualBurger_orderList.getRowCount(); orderCount++) {
					totalPrice = totalPrice.add((BigDecimal)individualBurger_orderList.getValueAt(orderCount, 2));
				}
				sumIndividualBurger_txtField.setText(df.format(totalPrice));
				individualBurger_spinner.setValue(0);
			}
		});
		individualBurger_addToOrder_Button.setBounds(10, 269, 191, 22);
		individualBurger_selection_Panel.add(individualBurger_addToOrder_Button);
		individualBurger_selection_JTable.setBounds(10, 78, 223, 0);
		individualBurger_selection_JTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		individualBurger_selection_JTable.setDefaultEditor(Object.class, null);		
		individualBurger_spinner.setBounds(207, 270, 30, 20);
		individualBurger_selection_Panel.add(individualBurger_spinner);
				
		
		
		JLabel individualBurger_BG = new JLabel("");
//		individualBurger_BG.setBounds(0, 0, 1280, 720);
		individualBurger_BG.setBounds(0, 0, (int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
		individualBurger.add(individualBurger_BG);
		
		ImageIcon im = (new ImageIcon(((new ImageIcon(
				"image\\fast-food-cola-french-fries-burger-art.jpg").getImage()
	            .getScaledInstance((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight(),
	                    java.awt.Image.SCALE_SMOOTH)))));
		individualBurger_BG.setIcon(im);
		
	}
	
	private void individualBurger_Init(ArrayList<Zutat> zutaten) {
		individualBurger_priceList = new DefaultTableModel();
		individualBurger_priceList.addColumn("id");
		individualBurger_priceList.addColumn("Ingredient");
		individualBurger_priceList.addColumn("Price");
		for (Zutat zutat : zutaten) {
			individualBurger_priceList.addRow(new Object[] {zutat.getId(),zutat.getName(),zutat.getPrice()});
		}
		
		individualBurger_orderList = new DefaultTableModel();
		individualBurger_orderList.addColumn("Item Name");
		individualBurger_orderList.addColumn("Quantity");
		individualBurger_orderList.addColumn("Price");
		
		individualBurger_selection_list = new DefaultTableModel();
		individualBurger_selection_list.addColumn("Item Name");
		individualBurger_selection_list.addColumn("Price");
		
		individualBurger_orderList_JTable = new JTable(individualBurger_orderList);
		individualBurger_orderList_JTable.getColumnModel().getColumn(2).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		individualBurger_orderList_JTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		individualBurger_orderList_JTable.setDefaultEditor(Object.class, null);		
		
		individualBurger_spinner = new JSpinner();
		individualBurger = new JPanel();
		sb_TitleLabel = new JLabel("Welcome to the Burger House");
		individualBurger_TitlePanel = new JPanel();
		individualBurger_TitlePanel.setBackground(new Color(255, 99, 71));
		individualBurger_Title = new JLabel("Individual Burger");
		individualBurger_Title.setBackground(new Color(255, 99, 71));
		zutaten_priceList_ScrollPane = new JScrollPane();
	}
	
	
	public DefaultTableModel getIndividualBurger_OrderList() {
		return this.individualBurger_orderList;
		
	}
	
	public void updateIndividualBurger_TextField(BigDecimal totalPrice) {
		sumIndividualBurger_txtField.setText(df.format(totalPrice));
	}
	
	public void resetIdividualBurger() {
		individualBurger_orderList.setRowCount(0);
		individualBurger_selection_list.setRowCount(0);
		sumIndividualBurger_txtField.setText("");
	}
}
