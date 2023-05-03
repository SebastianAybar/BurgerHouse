package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class CostumerMenu extends JPanel {
	//variable
	private static final DecimalFormat df = new DecimalFormat("0.00",  new DecimalFormatSymbols(Locale.US));
	private DefaultTableModel completeOrderList;
	private Boolean invoice = false;
	// costumerMenu
	private JPanel costumerMenu;
	// costumerMenuTitle_Panel
	private JPanel costumerMenuTitle_Panel;
	private JLabel costumerMenu_tableNr_Label;
	private JLabel costumerMenu_welcome_Label;
	// orderList_Panel
	private JPanel orderList_Panel;
	private JScrollPane orderList_scrollPane;
	private JTable completeOrderList_Table;
	private JTextField orderList_textField;
	private JButton deleteOrder_OrderList;
	private JButton placeOrder_OrderList;
	// selection_Panel
	private JPanel selection_Panel;
	private JLabel selectMenu_Label;
	private JButton standardBurger_Button;
	private JButton inndividualBurger_Button;
	private JButton drinks_Button;
	private JButton sideDish_Button;
	
	private JButton releaseTable_Button;
	
	private JLabel costumerMenu_BG;
	
	public CostumerMenu(BH_GUI_Frame bh_GUI_Frame) throws SQLException{
		costumerMenu_Init();
		
//		setSize(1280,720);
		setSize((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight());
		setLayout(null);
		
		costumerMenu.setLayout(null);
//		costumerMenu.setBounds(0, 0, 1280, 720);
		costumerMenu.setBounds(0, 0, (int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight());
		add(costumerMenu);
		// costumerMenuTitle_Panel
		costumerMenuTitle_Panel.setLayout(null);
		costumerMenuTitle_Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		costumerMenuTitle_Panel.setBounds(216, 11, 1054, 138);
		costumerMenuTitle_Panel.setBackground(new Color(255, 99, 71));
		costumerMenu.add(costumerMenuTitle_Panel);		
		
		costumerMenu_tableNr_Label.setBounds(10, 106, 103, 21);
		costumerMenuTitle_Panel.add(costumerMenu_tableNr_Label);
		
		costumerMenu_welcome_Label.setHorizontalAlignment(SwingConstants.CENTER);
		costumerMenu_welcome_Label.setFont(new Font("Tahoma", Font.PLAIN, 37));
		costumerMenu_welcome_Label.setBounds(10, 11, 1034, 116);
		costumerMenuTitle_Panel.add(costumerMenu_welcome_Label);
		// orderList_Panel
		orderList_Panel.setLayout(null);
		orderList_Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		orderList_Panel.setBackground(new Color(255, 255, 153));
		orderList_Panel.setBounds(836, 160, 434, 518);
		costumerMenu.add(orderList_Panel);
		
		orderList_scrollPane.setBounds(10, 11, 414, 437);
		orderList_Panel.add(orderList_scrollPane);
		
		completeOrderList_Table.setDefaultEditor(Object.class, null);
		completeOrderList_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
		orderList_scrollPane.setViewportView(completeOrderList_Table);
		
		deleteOrder_OrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (invoice) {
					JOptionPane.showMessageDialog(placeOrder_OrderList, "Invoice Created, please ask employee for help :)");
				} else {
					if(completeOrderList_Table.getSelectedRow() != -1) {
						int standardBurger_Row = bh_GUI_Frame.getStandardBurger().getStandardBurger_OrderList().getRowCount();
						int individualBurger_Row = bh_GUI_Frame.getIndividualBurger().getIndividualBurger_OrderList().getRowCount();
						int drinks_Row = bh_GUI_Frame.getDrinks().getDrinks_OrderList().getRowCount();
						int sideDishes_Row = bh_GUI_Frame.getSideDishes().getSideDishes_OrderList().getRowCount();
						int completeOrderList_Row = completeOrderList_Table.getRowCount();
						int selected = completeOrderList_Table.getSelectedRow();
						
						if (selected < standardBurger_Row) {
							bh_GUI_Frame.getStandardBurger().getStandardBurger_OrderList().removeRow(completeOrderList_Table.getSelectedRow());
							updateOrderList(bh_GUI_Frame);
						} else if(selected < standardBurger_Row+individualBurger_Row) {
							bh_GUI_Frame.getIndividualBurger().getIndividualBurger_OrderList().removeRow(completeOrderList_Row-standardBurger_Row-1);
							updateOrderList(bh_GUI_Frame);
						} else if(selected < standardBurger_Row+individualBurger_Row+drinks_Row) {
							bh_GUI_Frame.getDrinks().getDrinks_OrderList().removeRow(completeOrderList_Row-standardBurger_Row-individualBurger_Row-1);
							updateOrderList(bh_GUI_Frame);
						} else if(selected < standardBurger_Row+individualBurger_Row+drinks_Row+sideDishes_Row) {
							bh_GUI_Frame.getSideDishes().getSideDishes_OrderList().removeRow(completeOrderList_Row-standardBurger_Row-individualBurger_Row-drinks_Row-1);
							updateOrderList(bh_GUI_Frame);
						}
						
					}					
				}				
			}
		});
		deleteOrder_OrderList.setBounds(10, 459, 135, 48);
		orderList_Panel.add(deleteOrder_OrderList);
		
		placeOrder_OrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!invoice) {
					if(completeOrderList.getRowCount() > 0) {
						ConnectDB db = new ConnectDB();
						try {
							db.insertInvoice(completeOrderList, bh_GUI_Frame.getSetTable().getTableNr(), new BigDecimal(orderList_textField.getText()));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(costumerMenu_BG, "Invoice Created");
						invoice = true;
					} else {
						JOptionPane.showMessageDialog(costumerMenu_BG, "Order List is Empty!");
					}
				} else {
					JOptionPane.showMessageDialog(costumerMenu_BG, "Invoice already generated");
				}
			}
		});
		placeOrder_OrderList.setBounds(155, 459, 135, 48);
		orderList_Panel.add(placeOrder_OrderList);
		
		
		orderList_textField.setBounds(300, 459, 124, 48);
//		orderList_textField.setde
		orderList_Panel.add(orderList_textField);
		orderList_textField.setColumns(10);
		// selectionPanel		
		selection_Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		selection_Panel.setBounds(10, 160, 201, 518);
		costumerMenu.add(selection_Panel);
		selection_Panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		
		selectMenu_Label.setVerticalTextPosition(SwingConstants.BOTTOM);
		selectMenu_Label.setOpaque(true);
		selectMenu_Label.setHorizontalTextPosition(SwingConstants.CENTER);
		selectMenu_Label.setHorizontalAlignment(SwingConstants.CENTER);
		selectMenu_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		selectMenu_Label.setBackground(new Color(255, 99, 71));
		selection_Panel.add(selectMenu_Label);
		
		standardBurger_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (invoice) {
					JOptionPane.showMessageDialog(placeOrder_OrderList, "Invoice Created, please ask employee for help :)");
				} else {
					bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Standard Burger");					
				}
			}
		});		
		standardBurger_Button.setVerticalTextPosition(SwingConstants.BOTTOM);
		standardBurger_Button.setHorizontalTextPosition(SwingConstants.CENTER);
		selection_Panel.add(standardBurger_Button);
		
		inndividualBurger_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (invoice) {
					JOptionPane.showMessageDialog(placeOrder_OrderList, "Invoice Created, please ask employee for help :)");
				} else {
					bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Individual Burger");
				}
			}
		});
		inndividualBurger_Button.setVerticalTextPosition(SwingConstants.BOTTOM);
		inndividualBurger_Button.setHorizontalTextPosition(SwingConstants.CENTER);
		selection_Panel.add(inndividualBurger_Button);
		
		drinks_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (invoice) {
					JOptionPane.showMessageDialog(placeOrder_OrderList, "Invoice Created, please ask employee for help :)");
				} else {
					bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Drinks");	
				}
			}
		});
		drinks_Button.setVerticalTextPosition(SwingConstants.BOTTOM);
		drinks_Button.setHorizontalTextPosition(SwingConstants.CENTER);
		selection_Panel.add(drinks_Button);
		
		sideDish_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (invoice) {
					JOptionPane.showMessageDialog(placeOrder_OrderList, "Invoice Created, please ask employee for help :)");
				} else {
					bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Side Dishes");	
				}
			}
		});
		sideDish_Button.setVerticalTextPosition(SwingConstants.BOTTOM);
		sideDish_Button.setHorizontalTextPosition(SwingConstants.CENTER);
		selection_Panel.add(sideDish_Button);
		
		
		releaseTable_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Release Pin");
			}
		});
		releaseTable_Button.setBounds(10, 11, 201, 138);
		costumerMenu.add(releaseTable_Button);
		// background
		costumerMenu_BG.setIcon(new ImageIcon("image\\fast-food-cola-french-fries-burger-art.jpg"));
		costumerMenu_BG.setBounds(0, 0, (int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight());
//		costumerMenu_BG.setBounds(0, 0, 1280, 720);
		costumerMenu.add(costumerMenu_BG);
		
		ImageIcon im = (new ImageIcon(((new ImageIcon(
				"image\\fast-food-cola-french-fries-burger-art.jpg").getImage()
	            .getScaledInstance((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight(),
	                    java.awt.Image.SCALE_SMOOTH)))));
		costumerMenu_BG.setIcon(im);
	}
	
	private void costumerMenu_Init() {
		costumerMenu = new JPanel();
		// costumerMenuTitle_Panel
		costumerMenuTitle_Panel = new JPanel();
		costumerMenu_welcome_Label = new JLabel("Welcome to the Burger House");
		costumerMenu_tableNr_Label = new JLabel("Table Nr: 0");
		// orderList_Panel
		orderList_Panel = new JPanel();
		orderList_scrollPane = new JScrollPane();
		
		completeOrderList = new DefaultTableModel();
		completeOrderList_Table = new JTable(completeOrderList);
		completeOrderList.addColumn("Nr");
		completeOrderList.addColumn("Item Name");
		completeOrderList.addColumn("Quantity");
		completeOrderList.addColumn("Price");		
		completeOrderList_Table.getColumnModel().getColumn(3).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		
		deleteOrder_OrderList = new JButton("Delete from Order");
		placeOrder_OrderList = new JButton("Place Order");
		orderList_textField = new JTextField();
		orderList_textField.setEditable(false);
		// selection_Panel
		selection_Panel = new JPanel();
		selection_Panel.setBackground(new Color(255, 255, 153));
		selectMenu_Label = new JLabel("Select a Menu");
		standardBurger_Button = new JButton("Standard Burger");
		standardBurger_Button.setIcon(new ImageIcon("image\\burger.png"));
		standardBurger_Button.setBackground(Color.WHITE);
		inndividualBurger_Button = new JButton("Inidivual Burger");
		inndividualBurger_Button.setIcon(new ImageIcon("image\\individualBurger.png"));
		inndividualBurger_Button.setBackground(Color.WHITE);
		drinks_Button = new JButton("Drinks");
		drinks_Button.setIcon(new ImageIcon("image\\soft-drink.png"));
		drinks_Button.setBackground(Color.WHITE);
		sideDish_Button = new JButton("Side Dish");
		sideDish_Button.setIcon(new ImageIcon("image\\fried-potatoes (1).png"));
		sideDish_Button.setBackground(Color.WHITE);
		
		releaseTable_Button = new JButton("Release Table");
		releaseTable_Button.setIcon(new ImageIcon("image\\previous_1.png"));
		
		costumerMenu_BG = new JLabel("");
	}

	public void setAssignedTableNr(int tableNr) {
		costumerMenu_tableNr_Label.setText("Table Nr: "+ tableNr);			
	}
	
	public void cleanAllOrderList(BH_GUI_Frame bh_GUI_Frame) {
		bh_GUI_Frame.getSetTable().resetSetTable();
		bh_GUI_Frame.getStandardBurger().resetStandardBurger();
		bh_GUI_Frame.getIndividualBurger().resetIdividualBurger();
		bh_GUI_Frame.getDrinks().resetDrinks();
		bh_GUI_Frame.getSideDishes().resetSideDish();
		resetCostumerMenu();
	}
	
	public void updateOrderList(BH_GUI_Frame bh_GUI_Frame) {		
		completeOrderList.setRowCount(0);
		int standardBurgerCount = bh_GUI_Frame.getStandardBurger().getStandardBurger_OrderList().getRowCount();
		BigDecimal standardBurgerTotalPrice = new BigDecimal(0);
		for(int i = 0; i < standardBurgerCount ; i++) {
			completeOrderList.addRow(new Object[] {
					i+1,bh_GUI_Frame.getStandardBurger().getStandardBurger_OrderList().getValueAt(i, 0),
					bh_GUI_Frame.getStandardBurger().getStandardBurger_OrderList().getValueAt(i, 1),
					bh_GUI_Frame.getStandardBurger().getStandardBurger_OrderList().getValueAt(i, 2)});
			standardBurgerTotalPrice = standardBurgerTotalPrice.add((BigDecimal)bh_GUI_Frame.getStandardBurger().getStandardBurger_OrderList().getValueAt(i, 2));
		}
		if(standardBurgerCount > 0) {
			bh_GUI_Frame.getStandardBurger().updateStandardBurger_TextField(standardBurgerTotalPrice);	
		}
		
		BigDecimal individualBurgerTotalPrice = new BigDecimal(0);
		int individualBurgerCount = bh_GUI_Frame.getIndividualBurger().getIndividualBurger_OrderList().getRowCount();
		for(int i = 0; i < individualBurgerCount ; i++) {
			completeOrderList.addRow(new Object[] {
					completeOrderList.getRowCount()+1,
					bh_GUI_Frame.getIndividualBurger().getIndividualBurger_OrderList().getValueAt(i, 0),
					bh_GUI_Frame.getIndividualBurger().getIndividualBurger_OrderList().getValueAt(i, 1),
					bh_GUI_Frame.getIndividualBurger().getIndividualBurger_OrderList().getValueAt(i, 2)});
			individualBurgerTotalPrice = individualBurgerTotalPrice.add((BigDecimal)bh_GUI_Frame.getIndividualBurger().getIndividualBurger_OrderList().getValueAt(i, 2));
		}
		if(individualBurgerCount > 0) {
			bh_GUI_Frame.getIndividualBurger().updateIndividualBurger_TextField(individualBurgerTotalPrice);
		}
		
		BigDecimal drinkTotalPrice = new BigDecimal(0);
		int drinksCount = bh_GUI_Frame.getDrinks().getDrinks_OrderList().getRowCount();
		for(int i = 0; i < drinksCount ; i++) {
			completeOrderList.addRow(new Object[] {
					completeOrderList.getRowCount()+1,
					bh_GUI_Frame.getDrinks().getDrinks_OrderList().getValueAt(i, 0),
					bh_GUI_Frame.getDrinks().getDrinks_OrderList().getValueAt(i, 1),
					bh_GUI_Frame.getDrinks().getDrinks_OrderList().getValueAt(i, 2)});				
			drinkTotalPrice = drinkTotalPrice.add((BigDecimal)bh_GUI_Frame.getDrinks().getDrinks_OrderList().getValueAt(i, 2));
		}
		if(drinksCount > 0) {
			bh_GUI_Frame.getDrinks().updateDrinks_TextField(drinkTotalPrice);
		}
		
		BigDecimal sideDishTotalPrice = new BigDecimal(0);
		int sideDishesCount = bh_GUI_Frame.getSideDishes().getSideDishes_OrderList().getRowCount();
		for(int i = 0; i < sideDishesCount ; i++) {
			completeOrderList.addRow(new Object[] {
					completeOrderList.getRowCount()+1,
					bh_GUI_Frame.getSideDishes().getSideDishes_OrderList().getValueAt(i, 0),
					bh_GUI_Frame.getSideDishes().getSideDishes_OrderList().getValueAt(i, 1),
					bh_GUI_Frame.getSideDishes().getSideDishes_OrderList().getValueAt(i, 2)});
			sideDishTotalPrice = sideDishTotalPrice.add((BigDecimal)bh_GUI_Frame.getSideDishes().getSideDishes_OrderList().getValueAt(i, 2));
		}
		if(sideDishesCount > 0) {
			bh_GUI_Frame.getSideDishes().updateSideDish_TextField(sideDishTotalPrice);
		}
		
		BigDecimal totalPrice = new BigDecimal(0);
		for(int completeOrderCount = 0; completeOrderCount < completeOrderList.getRowCount(); completeOrderCount++) {
			totalPrice = totalPrice.add((BigDecimal) completeOrderList.getValueAt(completeOrderCount, 3));
		}		
		orderList_textField.setText(df.format(totalPrice));
	}
	
		
	public void resetCostumerMenu() {
		invoice = false;
		completeOrderList.setRowCount(0);
		orderList_textField.setText("");
	}
}
