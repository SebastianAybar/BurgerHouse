package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class StandardBurger extends JPanel {
	// variable
	private static final DecimalFormat df = new DecimalFormat("0.00",  new DecimalFormatSymbols(Locale.US));
	private DefaultTableModel standardBurger_priceList;
	private DefaultTableModel standardBurger_orderList;
	private JTable orderList_StandardBurger_JTable;
	
	
	//--
	JTable priceList_JTable;
	// standardBurger
	JPanel standardBurger;
	JLabel sb_TitleLabel;
	JPanel standardBurger_TitlePanel;
	JLabel standardBurger_Title;
	JPanel standardBurger_SelectPanel;
	JPanel selection_Panel;
	
	JCheckBox hambuger_check;
	JCheckBox cheeseBurger_check;
	JCheckBox chickenBurger_check;
	JCheckBox fishBurger_check;
	JCheckBox vegieBurger_check;
	
	JSpinner hamburger_spinner;
	JSpinner cheesBurger_spinner;
	JSpinner chickenBurger_spinner;
	JSpinner fishBurger_spinner;
	JSpinner vegieBurger_spinner;
//	private JTable table;
	
	JSeparator hamChe_seperator;
	JSeparator cheChi_seperator;
	JSeparator chiFish_seperator;
	JSeparator FisVeg_seperator;
	JSeparator vegAdd_seperator;
	JScrollPane priceList_ScrollPane;
	private JTextField sumStandardBurger_txtField;
	private JButton back_CostumerMenu;
	private JPanel panel;
	
	
	/**
	 * Create the panel.
	 * @param bh_GUI_Frame 
	 * @throws Exception 
	 */
	public StandardBurger(BH_GUI_Frame bh_GUI_Frame, ArrayList<Zutat> zutaten) throws Exception {
		StandardBurger_Init(zutaten);
		setSize((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight());
		standardBurger.setBounds(0,0,(int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
//		setSize(1280, 720);
		setLayout(null);		

		standardBurger.setLayout(null);
//		standardBurger.setBounds(0, 0, 1280, 720);
		standardBurger.setBounds(0, 0, bh_GUI_Frame.getWidth(), bh_GUI_Frame.getHeight());
		add(standardBurger);
		
		sb_TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sb_TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));;
		
		standardBurger_TitlePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		standardBurger_TitlePanel.setBounds(216, 11, 1054, 138);
		standardBurger.add(standardBurger_TitlePanel);
		standardBurger_TitlePanel.setLayout(null);
		
		standardBurger_Title.setHorizontalAlignment(SwingConstants.CENTER);
		standardBurger_Title.setFont(new Font("Tahoma", Font.PLAIN, 37));
		standardBurger_Title.setBounds(10, 11, 1045, 127);
		standardBurger_TitlePanel.add(standardBurger_Title);
		
		standardBurger_SelectPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		standardBurger_SelectPanel.setBounds(10, 181, 225, 290);
		standardBurger.add(standardBurger_SelectPanel);
		standardBurger_SelectPanel.setLayout(null);
		
		selection_Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		selection_Panel.setBounds(10, 11, 205, 268);
		standardBurger_SelectPanel.add(selection_Panel);
		selection_Panel.setLayout(null);
		
		hambuger_check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (hambuger_check.isSelected()) {
					hamburger_spinner.setValue(1);
				} else {
					hamburger_spinner.setValue(0);
				}
			}
		});
		hambuger_check.setBounds(6, 7, 148, 23);
		selection_Panel.add(hambuger_check);
		
		cheeseBurger_check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cheeseBurger_check.isSelected()) {
					cheesBurger_spinner.setValue(1);
				} else {
					cheesBurger_spinner.setValue(0);
				}
			}
		});
		cheeseBurger_check.setBounds(6, 46, 148, 23);
		selection_Panel.add(cheeseBurger_check);
		
		chickenBurger_check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chickenBurger_check.isSelected()) {
					chickenBurger_spinner.setValue(1);
				} else {
					chickenBurger_spinner.setValue(0);
				}
			}
		});
		chickenBurger_check.setBounds(6, 85, 148, 23);
		selection_Panel.add(chickenBurger_check);
		
		fishBurger_check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (fishBurger_check.isSelected()) {
					fishBurger_spinner.setValue(1);
				} else {
					fishBurger_spinner.setValue(0);
				}
			}
		});
		fishBurger_check.setBounds(6, 124, 148, 23);
		selection_Panel.add(fishBurger_check);
		
		vegieBurger_check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (vegieBurger_check.isSelected()) {
					vegieBurger_spinner.setValue(1);
				} else {
					vegieBurger_spinner.setValue(0);
				}
			}
		});
		vegieBurger_check.setBounds(6, 163, 148, 23);
		selection_Panel.add(vegieBurger_check);
		
//		JSpinner hamburger_spinner = new JSpinner();
		hamburger_spinner.setBounds(160, 8, 30, 20);
		selection_Panel.add(hamburger_spinner);
		
		cheesBurger_spinner.setBounds(160, 47, 30, 20);
		selection_Panel.add(cheesBurger_spinner);
		
		chickenBurger_spinner.setBounds(160, 86, 30, 20);
		selection_Panel.add(chickenBurger_spinner);
		
		fishBurger_spinner.setBounds(160, 125, 30, 20);
		selection_Panel.add(fishBurger_spinner);
		
		vegieBurger_spinner.setBounds(160, 164, 30, 20);
		selection_Panel.add(vegieBurger_spinner);
		
		hamChe_seperator.setBounds(16, 37, 180, 2);
		selection_Panel.add(hamChe_seperator);
		
		cheChi_seperator.setBounds(16, 76, 180, 2);
		selection_Panel.add(cheChi_seperator);
		
		chiFish_seperator.setBounds(16, 115, 180, 2);
		selection_Panel.add(chiFish_seperator);
		
		FisVeg_seperator.setBounds(16, 154, 180, 2);
		selection_Panel.add(FisVeg_seperator);
		
		vegAdd_seperator.setBounds(16, 193, 180, 2);
		selection_Panel.add(vegAdd_seperator);
		
		JButton addSelection = new JButton("Add Selection");
		BigDecimal bunFactor = new BigDecimal(2);
		BigDecimal fee = new BigDecimal(2);
		addSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hambuger_check.isSelected() && !hamburger_spinner.getValue().equals(0) && !((int) hamburger_spinner.getValue() < 0)) {
					BigDecimal price = new BigDecimal(0)
							  .add((bunFactor.multiply((BigDecimal)standardBurger_priceList.getValueAt(0, 2))))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(1, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(6, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(13, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(14, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(15, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(16, 2))
							  .add(fee)
							  .multiply(BigDecimal.valueOf((int) hamburger_spinner.getValue()));
					standardBurger_orderList.addRow(new Object[] {"Hamburger", hamburger_spinner.getValue(), price});	
				}
				if (cheeseBurger_check.isSelected() && !cheesBurger_spinner.getValue().equals(0) && !((int) cheesBurger_spinner.getValue() < 0)) {
					BigDecimal price = new BigDecimal(0)
							  .add((bunFactor.multiply((BigDecimal)standardBurger_priceList.getValueAt(0, 2))))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(1, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(5, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(6, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(13, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(14, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(15, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(16, 2))
							  .add(fee)
							  .multiply(BigDecimal.valueOf((int) cheesBurger_spinner.getValue()));
					standardBurger_orderList.addRow(new Object[] {"Cheese Burger", cheesBurger_spinner.getValue(), price});
				}
				if (chickenBurger_check.isSelected() && !chickenBurger_spinner.getValue().equals(0) && !((int) chickenBurger_spinner.getValue() < 0)) {
					BigDecimal price = new BigDecimal(0)
							  .add((bunFactor.multiply((BigDecimal)standardBurger_priceList.getValueAt(0, 2))))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(2, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(6, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(6, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(13, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(14, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(15, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(16, 2))
							  .add(fee)
							  .multiply(BigDecimal.valueOf((int) chickenBurger_spinner.getValue()));
					standardBurger_orderList.addRow(new Object[] {"Chicken Burger", chickenBurger_spinner.getValue(), price});
				}
				if (fishBurger_check.isSelected() && !fishBurger_spinner.getValue().equals(0) && !((int) fishBurger_spinner.getValue() < 0)) {
					BigDecimal price = new BigDecimal(0)
							  .add((bunFactor.multiply((BigDecimal)standardBurger_priceList.getValueAt(0, 2))))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(3, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(6, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(13, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(14, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(15, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(16, 2))
							  .add(fee)
							  .multiply(BigDecimal.valueOf((int) fishBurger_spinner.getValue()));
					standardBurger_orderList.addRow(new Object[] {"Fish Burger", fishBurger_spinner.getValue(), price});
				}
				if (vegieBurger_check.isSelected() && !vegieBurger_spinner.getValue().equals(0) && !((int) vegieBurger_spinner.getValue() < 0)) {
					BigDecimal price = new BigDecimal(0)
							  .add((bunFactor.multiply((BigDecimal)standardBurger_priceList.getValueAt(0, 2))))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(4, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(6, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(13, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(14, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(15, 2))
							  .add((BigDecimal)standardBurger_priceList.getValueAt(16, 2))
							  .add(fee)
							  .multiply(BigDecimal.valueOf((int) vegieBurger_spinner.getValue()));
					standardBurger_orderList.addRow(new Object[] {"Vegie Burger", vegieBurger_spinner.getValue(), price});
				}
				hambuger_check.setSelected(false);
				cheeseBurger_check.setSelected(false);
				chickenBurger_check.setSelected(false);
				fishBurger_check.setSelected(false);
				vegieBurger_check.setSelected(false);
				BigDecimal totalPrice = new BigDecimal(0);
				for(int i = 0; i < standardBurger_orderList.getRowCount(); i++) {
					totalPrice = totalPrice.add((BigDecimal)standardBurger_orderList.getValueAt(i, 2));
				}
				sumStandardBurger_txtField.setText(df.format(totalPrice));
			}
		});
		addSelection.setBounds(10, 206, 125, 23);
		selection_Panel.add(addSelection);
		
		JPanel panel_sbOrderList = new JPanel();
		panel_sbOrderList.setLayout(null);
		panel_sbOrderList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_sbOrderList.setBackground(new Color(255, 255, 153));
		panel_sbOrderList.setBounds(871, 181, 399, 518);
		standardBurger.add(panel_sbOrderList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 379, 437);
		panel_sbOrderList.add(scrollPane);
		
		scrollPane.setViewportView(orderList_StandardBurger_JTable);
		
		JButton deleteOrder_sbList = new JButton("Delete from Order");
		deleteOrder_sbList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(orderList_StandardBurger_JTable.getSelectedRow() !=-1) {
					int selected = orderList_StandardBurger_JTable.getSelectedRow();
					standardBurger_orderList.removeRow(orderList_StandardBurger_JTable.getSelectedRow());
					if(selected  < orderList_StandardBurger_JTable.getSelectedRow()) {
						orderList_StandardBurger_JTable.setRowSelectionInterval(selected, selected);
					}					
					BigDecimal totalPrice = new BigDecimal(0);
					for(int j = 0; j < standardBurger_orderList.getRowCount(); j++) {
						totalPrice = totalPrice.add((BigDecimal)standardBurger_orderList.getValueAt(j, 2));
					}
					sumStandardBurger_txtField.setText(df.format(totalPrice));
				}
			}
		});
		deleteOrder_sbList.setBounds(10, 459, 114, 48);
		panel_sbOrderList.add(deleteOrder_sbList);
		
		JButton placeOrder_sbList = new JButton("Place Order");
		placeOrder_sbList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
				bh_GUI_Frame.getCostumerMenu().updateOrderList(bh_GUI_Frame);				
			}
		});
		placeOrder_sbList.setBounds(134, 459, 109, 48);
		panel_sbOrderList.add(placeOrder_sbList);
		
		sumStandardBurger_txtField = new JTextField();
		sumStandardBurger_txtField.setEditable(false);
		sumStandardBurger_txtField.setBounds(253, 459, 136, 48);
		panel_sbOrderList.add(sumStandardBurger_txtField);
		sumStandardBurger_txtField.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(279, 181, 225, 290);
		standardBurger.add(panel);
		panel.setLayout(null);
		JTable priceList_JTable = new JTable(standardBurger_priceList);
		priceList_JTable.getColumnModel().getColumn(2).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		priceList_JTable.setRowSelectionAllowed(false);
		priceList_JTable.setDefaultEditor(Object.class, null);
		priceList_ScrollPane.setViewportView(priceList_JTable);
		priceList_ScrollPane = new JScrollPane(priceList_JTable);
		priceList_ScrollPane.setBounds(0, 0, 225, 290);
		panel.add(priceList_ScrollPane);
		
		priceList_JTable.setModel(standardBurger_priceList);
		
		back_CostumerMenu = new JButton("Back");
		back_CostumerMenu.setIcon(new ImageIcon("image\\previous_1.png"));
		back_CostumerMenu.setBackground(Color.WHITE);
		back_CostumerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
				bh_GUI_Frame.getCostumerMenu().updateOrderList(bh_GUI_Frame);
			}
		});
		back_CostumerMenu.setBounds(10, 11, 201, 138);
		back_CostumerMenu.setFont(new Font("Arial Black", Font.PLAIN, 14));
		standardBurger.add(back_CostumerMenu);
		
		JLabel standardBurger_BG = new JLabel("");
//		standardBurger_BG.setBounds(0, 0, 1280, 720);
		standardBurger_BG.setBounds(0, 0, (int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getHeight());
		standardBurger.add(standardBurger_BG);
		
		ImageIcon im = (new ImageIcon(((new ImageIcon(
				"image\\fast-food-cola-french-fries-burger-art.jpg").getImage()
	            .getScaledInstance((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight(),
	                    java.awt.Image.SCALE_SMOOTH)))));
		standardBurger_BG.setIcon(im);
	}
	
	private void StandardBurger_Init(ArrayList<Zutat> zutaten) throws Exception {
		standardBurger_priceList = new DefaultTableModel();
		standardBurger_priceList.addColumn("id");
		standardBurger_priceList.addColumn("Ingredient");
		standardBurger_priceList.addColumn("Price");
		for (Zutat zutat : zutaten) {
			standardBurger_priceList.addRow(new Object[] {zutat.getId(),zutat.getName(),zutat.getPrice()});
		}
		
		standardBurger_orderList = new DefaultTableModel();
		standardBurger_orderList.addColumn("Nr");
		standardBurger_orderList.addColumn("Ingredient Name");
		standardBurger_orderList.addColumn("Price");
		
		orderList_StandardBurger_JTable = new JTable(standardBurger_orderList);
		orderList_StandardBurger_JTable.getColumnModel().getColumn(2).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		orderList_StandardBurger_JTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList_StandardBurger_JTable.setDefaultEditor(Object.class, null);
		
		priceList_ScrollPane = new JScrollPane();
				
		standardBurger = new JPanel();
		sb_TitleLabel = new JLabel("Welcome to the Burger House");
		standardBurger_TitlePanel = new JPanel();
		standardBurger_TitlePanel.setBackground(new Color(255, 99, 71));
		standardBurger_Title = new JLabel("Standard Burger");
		standardBurger_SelectPanel = new JPanel();
		standardBurger_SelectPanel.setBackground(new Color(255, 255, 153));
		selection_Panel = new JPanel();
		
		hambuger_check = new JCheckBox("Hamburger");
		cheeseBurger_check = new JCheckBox("Cheese Burger");
		chickenBurger_check = new JCheckBox("Chicken Burger");
		fishBurger_check = new JCheckBox("Fish Burger");
		vegieBurger_check = new JCheckBox("Vegie burger");
		
		hamburger_spinner = new JSpinner();
		cheesBurger_spinner = new JSpinner();
		chickenBurger_spinner = new JSpinner();
		fishBurger_spinner = new JSpinner();
		vegieBurger_spinner = new JSpinner();
		
		hamChe_seperator = new JSeparator();
		cheChi_seperator = new JSeparator();
		chiFish_seperator = new JSeparator();
		FisVeg_seperator = new JSeparator();
		vegAdd_seperator = new JSeparator();
	}
	
	public DefaultTableModel getStandardBurger_OrderList() {
		return this.standardBurger_orderList;		
	}
	
	public void updateStandardBurger_TextField(BigDecimal totalPrice) {
		sumStandardBurger_txtField.setText(df.format(totalPrice));
	}
	
	public void resetStandardBurger() {
		standardBurger_orderList.setRowCount(0);
		hambuger_check.setSelected(false);
		cheeseBurger_check.setSelected(false);
		chickenBurger_check.setSelected(false);
		fishBurger_check.setSelected(false);
		vegieBurger_check.setSelected(false);
		
		hamburger_spinner.setValue(0);
		cheesBurger_spinner.setValue(0);
		chickenBurger_spinner.setValue(0);
		fishBurger_spinner.setValue(0);
		vegieBurger_spinner.setValue(0);
		sumStandardBurger_txtField.setText("");
	}
}
