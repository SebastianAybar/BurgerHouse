package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class SideDishes extends JPanel {

	private DefaultTableModel sideDish_priceList;
	private DefaultTableModel sideDish_orderList;
	private static final DecimalFormat df = new DecimalFormat("0.00",  new DecimalFormatSymbols(Locale.US));
	private JTable orderList_SideDishes;
	private JTable list_of_side_dishes;
	private JTextField textFieldSum;
	private JTextField txtTotalSideDishes;


	public SideDishes(BH_GUI_Frame bh_GUI_Frame) {
		setBounds(0,0,(int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
		setSize((int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
//		setSize(1280, 720);
		setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
//		mainPanel.setBounds(0, 0, 1280, 720);
		mainPanel.setBounds(0, 0, (int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
		mainPanel.setLayout(null);
		add(mainPanel);
		
		SideDishes_Init();
		mainPanel.setLayout(null);
		add(mainPanel);

		DefaultTableModel SideDishesList = new DefaultTableModel();
		JButton btnAddToOrderList = new JButton("Add to Order");

		JButton btnDeleteInSideDishesList = new JButton("delete");
		JButton btnBack = new JButton("back to menu");
		
		Selection selectionFrenchFries = new Selection("French Fries (2,50$)");	
		Selection selectionSweetPotatoFries = new Selection("Sweet Potato Fries (2,70$)");		
		Selection selectionCheeseFries = new Selection("Cheese Fries (3,00$)");		
			
		Selection selectionAmerican = new Selection("American (2,50$)");	
		Selection selectionVinegar = new Selection("Vinegar (2.50$)");	
		Selection selectionTangyApple = new Selection("Tangy Apple (2,50$)");	

		Selection selectionKetchup = new Selection("Ketchup (0,20$)");
		Selection selectionMayonaise = new Selection("Mayonaise (0,20$)");	
		Selection selectionAndalucia = new Selection("Andalucia (1,00$)");	
		Selection selectionSweetChilli = new Selection("Sweet Chilli (1,00$)");	
		Selection selectionHomemadeSauce = new Selection("Homemade Sauce (1,00$)");	
		Selection selectionGuacamole = new Selection("Guacamole (2,00$)");
		
		JLabel lblLogo = new JLabel("BH");
		JPanel panelRightCornerLogo = new JPanel();
		JPanel panelTitel = new JPanel();		
		JLabel lblHeaderListOfSideDishes = new JLabel("List of Side Dishes");
		JPanel panelHeaderListOfSideDishes = new JPanel();
		
		JScrollPane scrollPaneListOfSideDishes = new JScrollPane();
		
		JScrollPane scrollPanePriceList = new JScrollPane();
		JTable priceList_JTable = new JTable(sideDish_priceList);
		SideDishesList.addColumn("Name");
		SideDishesList.addColumn("Amount");
		SideDishesList.addColumn("Price in $");
		
		JTable jTableListOfSideDishes = new JTable();
		jTableListOfSideDishes.setDefaultEditor(Object.class, null);
		jTableListOfSideDishes.setModel(sideDish_orderList);
		jTableListOfSideDishes.getColumnModel().getColumn(2).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		scrollPaneListOfSideDishes.setBounds(1016, 176, 254, 209);
		mainPanel.add(scrollPaneListOfSideDishes);
		scrollPaneListOfSideDishes.setViewportView(jTableListOfSideDishes);
		priceList_JTable.getColumnModel().getColumn(2).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		btnAddToOrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
				bh_GUI_Frame.getCostumerMenu().updateOrderList(bh_GUI_Frame);
			}
		});
		
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(255, 204, 153));
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
				bh_GUI_Frame.getCostumerMenu().updateOrderList(bh_GUI_Frame);
			}
		});
		
	
		selectionMayonaise.getSpinner().setBounds(712, 291, 30, 20);
		mainPanel.add(selectionMayonaise.getSpinner());
		
		selectionAndalucia.getSpinner().setBounds(712, 268, 30, 20);
		mainPanel.add(selectionAndalucia.getSpinner());
		
		selectionAmerican.getSpinner().setBounds(448, 199, 30, 20);
		mainPanel.add(selectionAmerican.getSpinner());
		
		selectionHomemadeSauce.getSpinner().setBounds(712, 245, 30, 20);
		mainPanel.add(selectionHomemadeSauce.getSpinner());
		
		selectionGuacamole.getSpinner().setBounds(712, 222, 30, 20);
		mainPanel.add(selectionGuacamole.getSpinner());
		
		selectionTangyApple.getSpinner().setBounds(448, 291, 30, 20);
		mainPanel.add(selectionTangyApple.getSpinner());
		
		selectionVinegar.getSpinner().setBounds(448, 245, 30, 20);
		mainPanel.add(selectionVinegar.getSpinner());
		
		selectionCheeseFries.getSpinner().setBounds(200, 245, 30, 20);
		mainPanel.add(selectionCheeseFries.getSpinner());
		
		selectionSweetChilli.getSpinner().setBounds(712, 314, 30, 20);
		mainPanel.add(selectionSweetChilli.getSpinner());
		
		selectionKetchup.getSpinner().setBounds(712, 199, 30, 20);
		mainPanel.add(selectionKetchup.getSpinner());
		
		selectionFrenchFries.getSpinner().setBounds(200, 199, 30, 20);
		mainPanel.add(selectionFrenchFries.getSpinner());
		
		selectionSweetPotatoFries.getSpinner().setBounds(200, 291, 30, 20);
		mainPanel.add(selectionSweetPotatoFries.getSpinner());

		selectionGuacamole.getSelection().setBounds(531, 222, 168, 20);
		mainPanel.add(selectionGuacamole.getSelection());

		selectionHomemadeSauce.getSelection().setBounds(531, 245, 168, 20);
		mainPanel.add(selectionHomemadeSauce.getSelection());

		selectionSweetChilli.getSelection().setBounds(531, 314, 168, 20);
		mainPanel.add(selectionSweetChilli.getSelection());

		selectionAndalucia.getSelection().setBounds(531, 268, 168, 20);
		mainPanel.add(selectionAndalucia.getSelection());

		selectionMayonaise.getSelection().setBounds(531, 291, 168, 20);
		mainPanel.add(selectionMayonaise.getSelection());

		selectionKetchup.getSelection().setBounds(531, 199, 168, 20);
		mainPanel.add(selectionKetchup.getSelection());

		selectionTangyApple.getSelection().setBounds(269, 291, 168, 20);
		mainPanel.add(selectionTangyApple.getSelection());

		selectionVinegar.getSelection().setBounds(269, 245, 168, 20);
		mainPanel.add(selectionVinegar.getSelection());

		selectionAmerican.getSelection().setBounds(269, 199, 168, 20);
		mainPanel.add(selectionAmerican.getSelection());

		selectionCheeseFries.getSelection().setBounds(20, 245, 168, 20);
		mainPanel.add(selectionCheeseFries.getSelection());

		selectionSweetPotatoFries.getSelection().setBounds(20, 291, 168, 20);
		mainPanel.add(selectionSweetPotatoFries.getSelection());
		
		selectionFrenchFries.getSelection().setBounds(20, 199, 168, 20);
		mainPanel.add(selectionFrenchFries.getSelection());
		
		panelHeaderListOfSideDishes.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelHeaderListOfSideDishes.setBackground(new Color(255, 255, 153));
		panelHeaderListOfSideDishes.setBounds(1016, 125, 254, 52);
		mainPanel.add(panelHeaderListOfSideDishes);
		panelHeaderListOfSideDishes.setLayout(null);

		lblHeaderListOfSideDishes.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblHeaderListOfSideDishes.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderListOfSideDishes.setBounds(0, 11, 254, 30);
		panelHeaderListOfSideDishes.add(lblHeaderListOfSideDishes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(521, 125, 190, 352);
		mainPanel.add(panel_2);
		panel_2.setLayout(null);
		JLabel lblDips = new JLabel("Dips");		
		JPanel panelDips = new JPanel();
		panelDips.setBounds(0, 0, 190, 66);
		panel_2.add(panelDips);

		panelDips.setLayout(null);
		panelDips.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelDips.setBackground(new Color(255, 255, 153));

		lblDips.setIcon(new ImageIcon("C:\\Users\\sebia\\eclipse-workspace\\Prog_Exe_BurgerHouse\\image\\soy-sauce.png"));
		lblDips.setHorizontalAlignment(SwingConstants.CENTER);
		lblDips.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDips.setBounds(0, 0, 190, 66);
		panelDips.add(lblDips);
		JButton addDips = new JButton("add");
		addDips.setBounds(0, 311, 190, 41);
		panel_2.add(addDips);
		
				addDips.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {				
		
						if( selectionKetchup.getSelection().isSelected() && !(selectionKetchup.getSpinner().getValue().equals(0)) && (int) selectionKetchup.getSpinner().getValue() > 0){
							BigDecimal ketchupPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(5, 2))
									.multiply(BigDecimal.valueOf((int)selectionKetchup.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Ketchup", (int)selectionKetchup.getSpinner().getValue(), ketchupPrice});
						}
						if( selectionMayonaise.getSelection().isSelected() && !(selectionMayonaise.getSpinner().getValue().equals(0)) && (int) selectionMayonaise.getSpinner().getValue() > 0){
							BigDecimal mayonaisePrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(0, 2))
									.multiply(BigDecimal.valueOf((int)selectionMayonaise.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Mayonaise", (int)selectionMayonaise.getSpinner().getValue(), mayonaisePrice});
						}
						if( selectionAndalucia.getSelection().isSelected() && !(selectionAndalucia.getSpinner().getValue().equals(0)) && (int) selectionAndalucia.getSpinner().getValue() > 0){
							BigDecimal andaluciaPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(0, 2))
									.multiply(BigDecimal.valueOf((int)selectionAndalucia.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Andaluca", (int)selectionAndalucia.getSpinner().getValue(), andaluciaPrice});
						}
						if( selectionSweetChilli.getSelection().isSelected() && !(selectionSweetChilli.getSpinner().getValue().equals(0)) && (int) selectionSweetChilli.getSpinner().getValue() > 0){
							BigDecimal SweetChilliPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(0, 2))
									.multiply(BigDecimal.valueOf((int)selectionSweetChilli.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Sweet Chilli", (int)selectionSweetChilli.getSpinner().getValue(), SweetChilliPrice});
						}
						if( selectionHomemadeSauce.getSelection().isSelected() && !(selectionHomemadeSauce.getSpinner().getValue().equals(0)) && (int) selectionHomemadeSauce.getSpinner().getValue() > 0){
							BigDecimal homemadeSaucePrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(0, 2))
									.multiply(BigDecimal.valueOf((int)selectionHomemadeSauce.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Homemade Sauce", (int)selectionHomemadeSauce.getSpinner().getValue(), homemadeSaucePrice});
						}
						if( selectionGuacamole.getSelection().isSelected() && !(selectionGuacamole.getSpinner().getValue().equals(0)) && (int) selectionGuacamole.getSpinner().getValue() > 0){
							BigDecimal guacamolePrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(0, 2))
									.multiply(BigDecimal.valueOf((int)selectionGuacamole.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Guacamole", (int)selectionGuacamole.getSpinner().getValue(), guacamolePrice});
						selectionKetchup.getSelection().setSelected(false);
						selectionMayonaise.getSelection().setSelected(false);
						selectionAndalucia.getSelection().setSelected(false);
						selectionSweetChilli.getSelection().setSelected(false);
						selectionHomemadeSauce.getSelection().setSelected(false);
						selectionGuacamole.getSelection().setSelected(false);
		
						}
						
						BigDecimal totalPrice = new BigDecimal(0);
						for(int i = 0; i < sideDish_orderList.getRowCount(); i++) {
								totalPrice = totalPrice.add((BigDecimal) sideDish_orderList.getValueAt(i, 2));  
								{
						textFieldSum.setText(df.format(totalPrice));
						}
					}
				}
			}
					
			
					
					
				);
				
						addDips.setIcon(new ImageIcon("image\\plus.png"));
						addDips.setFont(new Font("Arial Black", Font.PLAIN, 12));
						addDips.setBackground(new Color(255, 255, 153));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(258, 125, 188, 352);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblColeslaw = new JLabel("Coleslaw");	
		JPanel panelColeslaw = new JPanel();		
		panelColeslaw.setBounds(0, 0, 188, 66);
		panel_1.add(panelColeslaw);

		panelColeslaw.setLayout(null);
		panelColeslaw.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColeslaw.setBackground(new Color(255, 255, 153));

		lblColeslaw.setIcon(new ImageIcon("C:\\Users\\sebia\\eclipse-workspace\\Prog_Exe_BurgerHouse\\image\\cabbage.png"));
		lblColeslaw.setHorizontalAlignment(SwingConstants.CENTER);
		lblColeslaw.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblColeslaw.setBounds(0, 0, 188, 66);
		panelColeslaw.add(lblColeslaw);
		JButton addColeslaw = new JButton("add");
		addColeslaw.setBounds(0, 311, 188, 41);
		panel_1.add(addColeslaw);
		
				addColeslaw.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {				
		
						if( selectionAmerican.getSelection().isSelected() && !(selectionAmerican.getSpinner().getValue().equals(0)) && (int) selectionAmerican.getSpinner().getValue() > 0){
							BigDecimal americanPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(8, 2))
									.multiply(BigDecimal.valueOf((int)selectionAmerican.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"American", (int)selectionAmerican.getSpinner().getValue(), americanPrice});
						}
						if( selectionVinegar.getSelection().isSelected() && !(selectionVinegar.getSpinner().getValue().equals(0)) && (int) selectionVinegar.getSpinner().getValue() > 0){
							BigDecimal vinegarPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(7, 2))
									.multiply(BigDecimal.valueOf((int)selectionVinegar.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Vinegar", (int)selectionVinegar.getSpinner().getValue(), vinegarPrice});
						}
						if( selectionTangyApple.getSelection().isSelected() && !(selectionTangyApple.getSpinner().getValue().equals(0)) && (int) selectionTangyApple.getSpinner().getValue() > 0){
							BigDecimal tangyApplePrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(6, 2))
									.multiply(BigDecimal.valueOf((int)selectionTangyApple.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"TangyApple", (int)selectionTangyApple.getSpinner().getValue(), tangyApplePrice});
						}
						selectionAmerican.getSelection().setSelected(false);
						selectionVinegar.getSelection().setSelected(false);
						selectionTangyApple.getSelection().setSelected(false);
		
						
						BigDecimal totalPrice = new BigDecimal(0);
						for(int i = 0; i < sideDish_orderList.getRowCount(); i++) {
							totalPrice = totalPrice.add((BigDecimal) sideDish_orderList.getValueAt(i, 2));  
							
						}
						textFieldSum.setText(df.format(totalPrice));
					}
				});
				
						addColeslaw.setIcon(new ImageIcon("image\\plus.png"));
						addColeslaw.setFont(new Font("Arial Black", Font.PLAIN, 12));
						addColeslaw.setBackground(new Color(255, 255, 153));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 125, 189, 352);
		mainPanel.add(panel);
		panel.setLayout(null);
		JLabel lblFries = new JLabel("Fries");		
		JPanel panelFries = new JPanel();		
		panelFries.setBounds(0, 0, 189, 66);
		panel.add(panelFries);

		panelFries.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelFries.setBackground(new Color(255, 255, 153));
		panelFries.setLayout(null);

		lblFries.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblFries.setIcon(new ImageIcon("C:\\Users\\sebia\\eclipse-workspace\\Prog_Exe_BurgerHouse\\image\\fried-potatoes (1).png"));
		lblFries.setHorizontalAlignment(SwingConstants.CENTER);
		lblFries.setBounds(0, 0, 189, 66);
		panelFries.add(lblFries);
		
		JButton addFries = new JButton("add");
		addFries.setBounds(0, 311, 189, 41);
		panel.add(addFries);
		
				addFries.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {				
		
						if( selectionFrenchFries.getSelection().isSelected() && !(selectionFrenchFries.getSpinner().getValue().equals(0)) && (int) selectionFrenchFries.getSpinner().getValue() > 0){
							BigDecimal frenchFriesPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(11, 2))
									.multiply(BigDecimal.valueOf((int)selectionFrenchFries.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"French Fries", (int)selectionFrenchFries.getSpinner().getValue(), frenchFriesPrice});
						}					
						if( selectionSweetPotatoFries.getSelection().isSelected() && !(selectionSweetPotatoFries.getSpinner().getValue().equals(0)) && (int) selectionSweetPotatoFries.getSpinner().getValue() > 0){
							BigDecimal sweetPotatoFriesPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(10, 2))
									.multiply(BigDecimal.valueOf((int)selectionSweetPotatoFries.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Sweet Potato Fries", (int)selectionSweetPotatoFries.getSpinner().getValue(), sweetPotatoFriesPrice});
						}
						if( selectionCheeseFries.getSelection().isSelected() && !(selectionCheeseFries.getSpinner().getValue().equals(0)) && (int) selectionCheeseFries.getSpinner().getValue() > 0){
							BigDecimal cheeseFriesPrice = new BigDecimal(0)
									.add((BigDecimal)sideDish_priceList.getValueAt(9, 2))
									.multiply(BigDecimal.valueOf((int)selectionCheeseFries.getSpinner().getValue()));
							sideDish_orderList.addRow(new Object[] {"Cheese Fries", (int)selectionCheeseFries.getSpinner().getValue(), cheeseFriesPrice});
						}
						selectionFrenchFries.getSelection().setSelected(false);
						selectionSweetPotatoFries.getSelection().setSelected(false);
						selectionCheeseFries.getSelection().setSelected(false);
						
						BigDecimal totalPrice = new BigDecimal(0);
						for(int i = 0; i < sideDish_orderList.getRowCount(); i++) {
							totalPrice = totalPrice.add((BigDecimal) sideDish_orderList.getValueAt(i, 2));  
							
						}
						textFieldSum.setText(df.format(totalPrice));
		
					}
				});
				
						addFries.setIcon(new ImageIcon("image\\plus.png"));
						addFries.setFont(new Font("Arial Black", Font.PLAIN, 12));
						addFries.setBackground(new Color(255, 255, 153));

		panelTitel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelTitel.setBackground(new Color(255, 69, 0));
		panelTitel.setBounds(231, 11, 840, 103);
		mainPanel.add(panelTitel);
		panelTitel.setLayout(null);
		
		JLabel sideDishesTittle_Label = new JLabel("Side Dishes");
		sideDishesTittle_Label.setFont(new Font("Tahoma", Font.PLAIN, 37));
		sideDishesTittle_Label.setHorizontalAlignment(SwingConstants.CENTER);
		sideDishesTittle_Label.setBounds(10, 11, 820, 81);
		panelTitel.add(sideDishesTittle_Label);

		panelRightCornerLogo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRightCornerLogo.setBackground(new Color(255, 222, 173));
		panelRightCornerLogo.setBounds(1081, 11, 189, 103);
		mainPanel.add(panelRightCornerLogo);
		panelRightCornerLogo.setLayout(null);
		
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(61, 11, 72, 65);
		panelRightCornerLogo.add(lblLogo);

		btnDeleteInSideDishesList.setIcon(new ImageIcon("image\\bin (2).png"));
		btnDeleteInSideDishesList.setBackground(Color.LIGHT_GRAY);
		btnDeleteInSideDishesList.setBounds(1016, 386, 254, 33);
		btnDeleteInSideDishesList.setFont(new Font("Arial Black", Font.PLAIN, 13));
		mainPanel.add(btnDeleteInSideDishesList);

		scrollPanePriceList.setBounds(10, 513, 504, 103);
		mainPanel.add(scrollPanePriceList);

		priceList_JTable.setRowSelectionAllowed(false);
		priceList_JTable.setDefaultEditor(Object.class, null);
		scrollPanePriceList.setViewportView(priceList_JTable);		

		
		
		//Delete in List of Drinks
		btnDeleteInSideDishesList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					sideDish_orderList.removeRow(jTableListOfSideDishes.getSelectedRow());
					int i = orderList_SideDishes.getSelectedRow();
//					orderList_SideDishes.setRowSelectionInterval(i, i);
					BigDecimal totalPrice = new BigDecimal(0);
					for(int j = 0; j < sideDish_orderList.getRowCount(); j++) {
						totalPrice = totalPrice.add((BigDecimal)sideDish_orderList.getValueAt(j, 2));						
					}
					textFieldSum.setText(df.format(totalPrice));
			}
		});

		btnAddToOrderList.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnAddToOrderList.setIcon(new ImageIcon("image\\next-button (2).png"));
		btnAddToOrderList.setBounds(1016, 444, 254, 33);
		mainPanel.add(btnAddToOrderList);

		txtTotalSideDishes = new JTextField();
		txtTotalSideDishes.setBackground(new Color(255, 255, 204));
		txtTotalSideDishes.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalSideDishes.setText("Total Side Dishes =");
		txtTotalSideDishes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTotalSideDishes.setBounds(1016, 420, 139, 23);
		mainPanel.add(txtTotalSideDishes);
		txtTotalSideDishes.setColumns(10);

		textFieldSum = new JTextField();
		textFieldSum.setBackground(new Color(255, 255, 153));
		textFieldSum.setBounds(1156, 420, 114, 23);
		mainPanel.add(textFieldSum);
		textFieldSum.setColumns(10);
		btnBack.setIcon(new ImageIcon("image\\previous_1.png"));
		btnBack.setBounds(10, 11, 211, 103);
		mainPanel.add(btnBack);
		
		list_of_side_dishes = new JTable();
		list_of_side_dishes.setBounds(0, 0, 1, 1);
		mainPanel.add(list_of_side_dishes);
		
		JLabel sideDish_BG = new JLabel("");
//		sideDish_BG.setBounds(0, 0, 1280, 720);
		sideDish_BG.setBounds(0, 0, (int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
		
		
		ImageIcon im = (new ImageIcon(((new ImageIcon(
				"image\\fast-food-cola-french-fries-burger-art.jpg").getImage()
	            .getScaledInstance((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight(),
	                    java.awt.Image.SCALE_SMOOTH)))));
		sideDish_BG.setIcon(im);
		
		mainPanel.add(sideDish_BG);
	}	
	
	private void SideDishes_Init() {
		sideDish_priceList = new DefaultTableModel();
		sideDish_priceList.addColumn("ID");
		sideDish_priceList.addColumn("Name");
		sideDish_priceList.addColumn("Price");
		updateSideDishes_priceList(sideDish_priceList);
		sideDish_orderList = new DefaultTableModel();
		sideDish_orderList.addColumn("Item Name");
		sideDish_orderList.addColumn("Quantity");
		sideDish_orderList.addColumn("Price");
		
		orderList_SideDishes = new JTable(sideDish_priceList);
		orderList_SideDishes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList_SideDishes.setDefaultEditor(Object.class, null);
	}
	
	private void updateSideDishes_priceList(DefaultTableModel SideDishes_PriceList) {
		String url = "jdbc:sqlite:db/Prog_Exe_BH_DB.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		

		String sql = "SELECT * From SideDishes";
		try (
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {   
				rs.getFloat("Price");
				SideDishes_PriceList.addRow(new Object[] {rs.getInt("ID"), rs.getString("Name"), rs.getBigDecimal("Price")});
			}
			stmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public DefaultTableModel getSideDishes_OrderList() {
		return this.sideDish_orderList;
	}
	
	public void updateSideDish_TextField(BigDecimal totalPrice) {
		textFieldSum.setText(totalPrice.toString());
	}
	
	public void resetSideDish() {
		textFieldSum.setText("");
		sideDish_orderList.setRowCount(0);
	}
}
