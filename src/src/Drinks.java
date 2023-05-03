package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class Drinks extends JPanel {

	private DefaultTableModel drink_PriceList;
	private DefaultTableModel drinks_orderList;
	private static final DecimalFormat df = new DecimalFormat("0.00",  new DecimalFormatSymbols(Locale.US));
	private JTable orderList_Drinks;
	private JTable list_of_drinks;
	private JTextField textFieldSum;
	private JTextField txtTotalDrinks;

	public Drinks(BH_GUI_Frame bh_GUI_Frame) {
		
		setSize((int)bh_GUI_Frame.getDimension().getWidth(),(int) bh_GUI_Frame.getDimension().getHeight());
		setBounds( 0, 0,(int)bh_GUI_Frame.getDimension().getWidth(),(int) bh_GUI_Frame.getDimension().getHeight());
//		setBounds( 0, 0,1280, 720);
//		setSize(1280, 720);
		setLayout(null);
		

		JPanel mainPanel = new JPanel();
//		mainPanel.setSize(1280,720);
		mainPanel.setBackground(Color.WHITE);
//		mainPanel.setBounds(0, 0, 1280, 720);
		mainPanel.setBounds(0, 0,(int)bh_GUI_Frame.getDimension().getWidth(),(int) bh_GUI_Frame.getDimension().getHeight());
		mainPanel.setLayout(null);
		add(mainPanel);
		
		Drinks_Init();
		mainPanel.setLayout(null);
		add(mainPanel);
		
		DefaultTableModel DrinksList = new DefaultTableModel();
		JButton btnAddToOrderList = new JButton("Add to Order");

		JButton btnDeleteInDrinksList = new JButton("delete");
		JButton btnBack = new JButton("back to menu");
		
		Selection selectionCocaCola = new Selection("CocaCola (1,50$)");	
		Selection selectionLemonade = new Selection("Lemonade (1,70$)");		
		Selection selectionSprite = new Selection("Sprite (1,50$)");		
		Selection selectionIceTea = new Selection("Ice Tea (1,50$)");
		Selection selectionFanta = new Selection("Fanta (2,50$)");	
		Selection selectionAppleSpritzer = new Selection("Apple Spritzer (1,70$)");	
		Selection selectionCocaColaLight = new Selection("CocaColaLight (1,50$)");	
		Selection selectionBioHollunder = new Selection("Bionade (1,70$)");	
		Selection selectionSoda = new Selection("Soda (1,20$)");	
		Selection selectionHeiniken = new Selection("Heiniken (2,50$)");	
		Selection selectionRadler = new Selection("Radler (2.50$)");	
		Selection selectionWineSmall = new Selection("Wine 0,25 (2,40$)");	
		Selection selectionWine = new Selection("Wine 0,75 (4,00$)");		
		Selection selectionBecks = new Selection("Becks (2,50$)");
		Selection selectionNutellaDonut = new Selection("Nutella Donut (6,50$)");
		Selection selectionCoconutKiss = new Selection("Coconut Kiss (5,00$)");	
		Selection selectionOreo = new Selection("Oreo (5,00$)");	
		Selection selectionTropicalPunch = new Selection("Tropical Punch (5,00$)");	
		Selection selectionSnickers = new Selection("Snickers (5,00$)");	
		Selection selectionStrawberryBanana = new Selection("Strawberry Banana (5,00$)");
		
		JLabel lblLogo = new JLabel("BH");
		JPanel panelRightCornerLogo = new JPanel();		
		JPanel panelTitel = new JPanel();		
		JLabel lblHeaderListOfDrinks = new JLabel("List of Drinks");
		JPanel panelHeaderListOfDrinks = new JPanel();
		
		JScrollPane scrollPaneListOfDrinks = new JScrollPane();
		
		JTable jTableListOfDrinks = new JTable();
		JScrollPane scrollPanePriceList = new JScrollPane();
		JTable priceList_JTable = new JTable(drink_PriceList);


		DrinksList.addColumn("Name");
		DrinksList.addColumn("Amount");
		DrinksList.addColumn("Price in $");
		
		
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
		
	
		selectionCoconutKiss.getSpinner().setBounds(712, 291, 30, 20);
		mainPanel.add(selectionCoconutKiss.getSpinner());
		
		selectionIceTea.getSpinner().setBounds(200, 314, 30, 20);
		mainPanel.add(selectionIceTea.getSpinner());
		
		selectionWine.getSpinner().setBounds(448, 268, 30, 20);
		mainPanel.add(selectionWine.getSpinner());
		
		selectionOreo.getSpinner().setBounds(712, 268, 30, 20);
		mainPanel.add(selectionOreo.getSpinner());

		selectionBioHollunder.getSpinner().setBounds(200, 360, 30, 20);
		mainPanel.add(selectionBioHollunder.getSpinner());
		
		selectionHeiniken.getSpinner().setBounds(448, 199, 30, 20);
		mainPanel.add(selectionHeiniken.getSpinner());
		
		selectionFanta.getSpinner().setBounds(200, 222, 30, 20);
		mainPanel.add(selectionFanta.getSpinner());
		
		selectionSnickers.getSpinner().setBounds(712, 245, 30, 20);
		mainPanel.add(selectionSnickers.getSpinner());
		
		selectionBecks.getSpinner().setBounds(448, 222, 30, 20);
		mainPanel.add(selectionBecks.getSpinner());
		
		selectionCocaColaLight.getSpinner().setBounds(200, 268, 30, 20);
		mainPanel.add(selectionCocaColaLight.getSpinner());
		
		selectionStrawberryBanana.getSpinner().setBounds(712, 222, 30, 20);
		mainPanel.add(selectionStrawberryBanana.getSpinner());
		
		selectionWineSmall.getSpinner().setBounds(448, 291, 30, 20);
		mainPanel.add(selectionWineSmall.getSpinner());
		
		selectionAppleSpritzer.getSpinner().setBounds(200, 337, 30, 20);
		mainPanel.add(selectionAppleSpritzer.getSpinner());
		
		selectionRadler.getSpinner().setBounds(448, 245, 30, 20);
		mainPanel.add(selectionRadler.getSpinner());
		
		selectionSprite.getSpinner().setBounds(200, 245, 30, 20);
		mainPanel.add(selectionSprite.getSpinner());
		
		selectionTropicalPunch.getSpinner().setBounds(712, 314, 30, 20);
		mainPanel.add(selectionTropicalPunch.getSpinner());
		
		selectionNutellaDonut.getSpinner().setBounds(712, 199, 30, 20);
		mainPanel.add(selectionNutellaDonut.getSpinner());
		
		selectionCocaCola.getSpinner().setBounds(200, 199, 30, 20);
		mainPanel.add(selectionCocaCola.getSpinner());
		
		selectionSoda.getSpinner().setBounds(200, 383, 30, 20);
		mainPanel.add(selectionSoda.getSpinner());
		
		selectionLemonade.getSpinner().setBounds(200, 291, 30, 20);
		mainPanel.add(selectionLemonade.getSpinner());

		selectionStrawberryBanana.getSelection().setBounds(531, 222, 168, 20);
		mainPanel.add(selectionStrawberryBanana.getSelection());

		selectionSnickers.getSelection().setBounds(531, 245, 168, 20);
		mainPanel.add(selectionSnickers.getSelection());

		selectionTropicalPunch.getSelection().setBounds(531, 314, 168, 20);
		mainPanel.add(selectionTropicalPunch.getSelection());

		selectionOreo.getSelection().setBounds(531, 268, 168, 20);
		mainPanel.add(selectionOreo.getSelection());

		selectionCoconutKiss.getSelection().setBounds(531, 291, 168, 20);
		mainPanel.add(selectionCoconutKiss.getSelection());

		selectionNutellaDonut.getSelection().setBounds(531, 199, 168, 20);
		mainPanel.add(selectionNutellaDonut.getSelection());

		selectionBecks.getSelection().setBounds(269, 222, 168, 20);
		mainPanel.add(selectionBecks.getSelection());

		selectionWine.getSelection().setBounds(269, 268, 168, 20);
		mainPanel.add(selectionWine.getSelection());

		selectionWineSmall.getSelection().setBounds(269, 291, 168, 20);
		mainPanel.add(selectionWineSmall.getSelection());

		selectionRadler.getSelection().setBounds(269, 245, 168, 20);
		mainPanel.add(selectionRadler.getSelection());

		selectionHeiniken.getSelection().setBounds(269, 199, 168, 20);
		mainPanel.add(selectionHeiniken.getSelection());

		selectionSoda.getSelection().setBounds(20, 383, 168, 20);
		mainPanel.add(selectionSoda.getSelection());

		selectionBioHollunder.getSelection().setBounds(20, 360, 168, 20);
		mainPanel.add(selectionBioHollunder.getSelection());

		selectionCocaColaLight.getSelection().setBounds(20, 268, 168, 20);
		mainPanel.add(selectionCocaColaLight.getSelection());

		selectionAppleSpritzer.getSelection().setBounds(20, 337, 168, 20);
		mainPanel.add(selectionAppleSpritzer.getSelection());

		selectionFanta.getSelection().setBounds(20, 222, 168, 20);
		mainPanel.add(selectionFanta.getSelection());

		selectionIceTea.getSelection().setBounds(20, 314, 168, 20);
		mainPanel.add(selectionIceTea.getSelection());

		selectionSprite.getSelection().setBounds(20, 245, 168, 20);
		mainPanel.add(selectionSprite.getSelection());

		selectionLemonade.getSelection().setBounds(20, 291, 168, 20);
		mainPanel.add(selectionLemonade.getSelection());
		

		selectionCocaCola.getSelection().setBounds(20, 199, 168, 20);
		mainPanel.add(selectionCocaCola.getSelection());
		
		panelHeaderListOfDrinks.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelHeaderListOfDrinks.setBackground(new Color(255, 255, 153));
		panelHeaderListOfDrinks.setBounds(1016, 132, 254, 52);
		mainPanel.add(panelHeaderListOfDrinks);
		panelHeaderListOfDrinks.setLayout(null);

		lblHeaderListOfDrinks.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblHeaderListOfDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderListOfDrinks.setBounds(0, 11, 254, 30);
		panelHeaderListOfDrinks.add(lblHeaderListOfDrinks);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(521, 132, 190, 352);
		mainPanel.add(panel_2);
		panel_2.setLayout(null);
		JLabel lblSmoothies = new JLabel("Smoothies");		
		JPanel panelSmoothies = new JPanel();
		panelSmoothies.setBounds(0, 0, 190, 66);
		panel_2.add(panelSmoothies);

		panelSmoothies.setLayout(null);
		panelSmoothies.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelSmoothies.setBackground(new Color(255, 255, 153));

		lblSmoothies.setIcon(new ImageIcon("image\\smoothie.png"));
		lblSmoothies.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmoothies.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblSmoothies.setBounds(0, 0, 200, 66);
		panelSmoothies.add(lblSmoothies);
		JButton addSmoothies = new JButton("add");
		addSmoothies.setBounds(0, 311, 190, 41);
		panel_2.add(addSmoothies);
		
				addSmoothies.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {				
		
						if( selectionNutellaDonut.getSelection().isSelected() && !(selectionNutellaDonut.getSpinner().getValue().equals(0)) && (int) selectionNutellaDonut.getSpinner().getValue() > 0){
							BigDecimal nutellaDonutPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(14, 2))
									.multiply(BigDecimal.valueOf((int)selectionNutellaDonut.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"NutellaDonut", (int)selectionNutellaDonut.getSpinner().getValue(), nutellaDonutPrice});
						}
						if( selectionStrawberryBanana.getSelection().isSelected() && !(selectionStrawberryBanana.getSpinner().getValue().equals(0)) && (int) selectionStrawberryBanana.getSpinner().getValue() > 0){
							BigDecimal strawberryBananaPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(15, 2))
									.multiply(BigDecimal.valueOf((int)selectionStrawberryBanana.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"StrawberryBanana", (int)selectionStrawberryBanana.getSpinner().getValue(), strawberryBananaPrice});
						}
						if( selectionSnickers.getSelection().isSelected() && !(selectionSnickers.getSpinner().getValue().equals(0)) && (int) selectionStrawberryBanana.getSpinner().getValue() > 0){
							BigDecimal snickersPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(16, 2))
									.multiply(BigDecimal.valueOf((int)selectionSnickers.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Snickers", (int)selectionSnickers.getSpinner().getValue(), snickersPrice});
						}
						if( selectionOreo.getSelection().isSelected() && !(selectionOreo.getSpinner().getValue().equals(0)) && (int) selectionOreo.getSpinner().getValue() > 0){
							BigDecimal oreoPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(17, 2))
									.multiply(BigDecimal.valueOf((int)selectionOreo.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Oreo", (int)selectionOreo.getSpinner().getValue(), oreoPrice});
							
						}
						if( selectionCoconutKiss.getSelection().isSelected() && !(selectionCoconutKiss.getSpinner().getValue().equals(0)) && (int) selectionCoconutKiss.getSpinner().getValue() > 0){
							BigDecimal coconutKissPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(18, 2))
									.multiply(BigDecimal.valueOf((int)selectionCoconutKiss.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"CoconutKiss", (int)selectionCoconutKiss.getSpinner().getValue(), coconutKissPrice});
						}
						if( selectionTropicalPunch.getSelection().isSelected() && !(selectionTropicalPunch.getSpinner().getValue().equals(0)) && (int) selectionTropicalPunch.getSpinner().getValue() > 0){
							BigDecimal tropicalPunchPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(19, 2))
									.multiply(BigDecimal.valueOf((int)selectionTropicalPunch.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"TropicalPunch", (int)selectionTropicalPunch.getSpinner().getValue(), tropicalPunchPrice});
						}
						selectionNutellaDonut.getSelection().setSelected(false);
						selectionStrawberryBanana.getSelection().setSelected(false);
						selectionSnickers.getSelection().setSelected(false);
						selectionOreo.getSelection().setSelected(false);
						selectionCoconutKiss.getSelection().setSelected(false);
						selectionTropicalPunch.getSelection().setSelected(false);
						
						BigDecimal totalPrice = new BigDecimal(0);
						for(int i = 0; i < drinks_orderList.getRowCount(); i++) {
							totalPrice = totalPrice.add((BigDecimal) drinks_orderList.getValueAt(i, 2));  
							
						}
						textFieldSum.setText(df.format(totalPrice));
					
					}
				});
				
						addSmoothies.setIcon(new ImageIcon("image\\plus.png"));
						addSmoothies.setFont(new Font("Arial Black", Font.PLAIN, 12));
						addSmoothies.setBackground(new Color(255, 255, 153));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(259, 132, 188, 352);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblAlcoholicDrinks = new JLabel("Alcoholics");	
		JPanel panelAlcDrinks = new JPanel();		
		panelAlcDrinks.setBounds(0, 0, 188, 66);
		panel_1.add(panelAlcDrinks);

		panelAlcDrinks.setLayout(null);
		panelAlcDrinks.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelAlcDrinks.setBackground(new Color(255, 255, 153));

		lblAlcoholicDrinks.setIcon(new ImageIcon("image\\beer (1).png"));
		lblAlcoholicDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlcoholicDrinks.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblAlcoholicDrinks.setBounds(0, 0, 188, 66);
		panelAlcDrinks.add(lblAlcoholicDrinks);
		JButton addAlcDrinks = new JButton("add");
		addAlcDrinks.setBounds(0, 311, 188, 41);
		panel_1.add(addAlcDrinks);
		
				addAlcDrinks.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {				
		
						if( selectionHeiniken.getSelection().isSelected() && !(selectionHeiniken.getSpinner().getValue().equals(0)) && (int) selectionHeiniken.getSpinner().getValue() > 0){
							BigDecimal heinikenPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(9, 2))
									.multiply(BigDecimal.valueOf((int)selectionHeiniken.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Heiniken", (int)selectionHeiniken.getSpinner().getValue(), heinikenPrice});
						}
						if( selectionBecks.getSelection().isSelected() && !(selectionBecks.getSpinner().getValue().equals(0)) && (int) selectionBecks.getSpinner().getValue() > 0){
							BigDecimal becksPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(10, 2))
									.multiply(BigDecimal.valueOf((int)selectionBecks.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Becks", (int)selectionBecks.getSpinner().getValue(), becksPrice});
						}
						if( selectionRadler.getSelection().isSelected() && !(selectionRadler.getSpinner().getValue().equals(0)) && (int) selectionRadler.getSpinner().getValue() > 0){
							BigDecimal radlerPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(11, 2))
									.multiply(BigDecimal.valueOf((int)selectionRadler.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Radler", (int)selectionRadler.getSpinner().getValue(), radlerPrice});
						}
						if( selectionWine.getSelection().isSelected() && !(selectionWine.getSpinner().getValue().equals(0)) && (int) selectionWine.getSpinner().getValue() > 0){
							BigDecimal winePrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(12, 2))
									.multiply(BigDecimal.valueOf((int)selectionWine.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Wine", (int)selectionWine.getSpinner().getValue(), winePrice});
						}
						if( selectionWineSmall.getSelection().isSelected() && !(selectionWineSmall.getSpinner().getValue().equals(0)) && (int) selectionWineSmall.getSpinner().getValue() > 0){
							BigDecimal wineSmallPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(13, 2))
									.multiply(BigDecimal.valueOf((int)selectionWineSmall.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"WineSmall", (int)selectionWineSmall.getSpinner().getValue(), wineSmallPrice});
						}
						selectionHeiniken.getSelection().setSelected(false);
						selectionBecks.getSelection().setSelected(false);
						selectionRadler.getSelection().setSelected(false);
						selectionWine.getSelection().setSelected(false);
						selectionWineSmall.getSelection().setSelected(false);
						
						BigDecimal totalPrice = new BigDecimal(0);
						for(int i = 0; i < drinks_orderList.getRowCount(); i++) {
							totalPrice = totalPrice.add((BigDecimal) drinks_orderList.getValueAt(i, 2));  
							
						}
						textFieldSum.setText(df.format(totalPrice));
					}
				});
				
						addAlcDrinks.setIcon(new ImageIcon("image\\plus.png"));
						addAlcDrinks.setFont(new Font("Arial Black", Font.PLAIN, 12));
						addAlcDrinks.setBackground(new Color(255, 255, 153));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 132, 189, 352);
		mainPanel.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Softdrinks");		
		JPanel panelSoftdrinks = new JPanel();		
		panelSoftdrinks.setBounds(0, 0, 189, 66);
		panel.add(panelSoftdrinks);

		panelSoftdrinks.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelSoftdrinks.setBackground(new Color(255, 255, 153));
		panelSoftdrinks.setLayout(null);

		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon("image\\soft-drink.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 189, 66);
		panelSoftdrinks.add(lblNewLabel);
		
		JButton addSoftdrinks = new JButton("add");
		addSoftdrinks.setBounds(0, 311, 189, 41);
		panel.add(addSoftdrinks);
		
				addSoftdrinks.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {				
		
						if( selectionCocaCola.getSelection().isSelected() && !(selectionCocaCola.getSpinner().getValue().equals(0)) && (int) selectionCocaCola.getSpinner().getValue() > 0){
							BigDecimal colaPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(0, 2))
									.multiply(BigDecimal.valueOf((int)selectionCocaCola.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"CocaCola", (int)selectionCocaCola.getSpinner().getValue(), colaPrice});
						}					
						if( selectionFanta.getSelection().isSelected() && !(selectionFanta.getSpinner().getValue().equals(0)) && (int) selectionFanta.getSpinner().getValue() > 0){
							BigDecimal fantaPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(1, 2))
									.multiply(BigDecimal.valueOf((int)selectionFanta.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Fanta", (int)selectionFanta.getSpinner().getValue(), fantaPrice});
						}
						if( selectionSprite.getSelection().isSelected() && !(selectionSprite.getSpinner().getValue().equals(0)) && (int) selectionSprite.getSpinner().getValue() > 0){
							BigDecimal spritePrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(2, 2))
									.multiply(BigDecimal.valueOf((int)selectionSprite.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Sprite", (int)selectionSprite.getSpinner().getValue(), spritePrice});
						}
						if( selectionCocaColaLight.getSelection().isSelected() && !(selectionCocaColaLight.getSpinner().getValue().equals(0)) && (int) selectionCocaColaLight.getSpinner().getValue() > 0){
							BigDecimal cocaColaLightPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(3, 2))
									.multiply(BigDecimal.valueOf((int)selectionCocaColaLight.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"CocaColaLight", (int)selectionCocaColaLight.getSpinner().getValue(), cocaColaLightPrice});
						}
						if( selectionLemonade.getSelection().isSelected() && !(selectionLemonade.getSpinner().getValue().equals(0)) && (int) selectionLemonade.getSpinner().getValue() > 0){
							BigDecimal lemonadePrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(4, 2))
									.multiply(BigDecimal.valueOf((int)selectionLemonade.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"CocaCola", (int)selectionLemonade.getSpinner().getValue(), lemonadePrice});
						}
						if( selectionIceTea.getSelection().isSelected() && !(selectionIceTea.getSpinner().getValue().equals(0)) && (int) selectionIceTea.getSpinner().getValue() > 0){
							BigDecimal iceTeaPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(5, 2))
									.multiply(BigDecimal.valueOf((int)selectionIceTea.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"IceTea", (int)selectionIceTea.getSpinner().getValue(), iceTeaPrice});
						}
						if( selectionAppleSpritzer.getSelection().isSelected() && !(selectionAppleSpritzer.getSpinner().getValue().equals(0)) && (int) selectionAppleSpritzer.getSpinner().getValue() > 0){
							BigDecimal appleSpriterPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(6, 2))
									.multiply(BigDecimal.valueOf((int)selectionAppleSpritzer.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"AppleSpritzer", (int)selectionAppleSpritzer.getSpinner().getValue(), appleSpriterPrice});
						}
						if( selectionBioHollunder.getSelection().isSelected() && !(selectionBioHollunder.getSpinner().getValue().equals(0)) && (int) selectionBioHollunder.getSpinner().getValue() > 0){
							BigDecimal bioHollunderPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(7, 2))
									.multiply(BigDecimal.valueOf((int)selectionBioHollunder.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"BioHollunder", (int)selectionBioHollunder.getSpinner().getValue(), bioHollunderPrice});
						}
						if( selectionSoda.getSelection().isSelected() && !(selectionSoda.getSpinner().getValue().equals(0)) && (int) selectionSoda.getSpinner().getValue() > 0){
							BigDecimal sodaPrice = new BigDecimal(0)
									.add((BigDecimal)drink_PriceList.getValueAt(8, 2))
									.multiply(BigDecimal.valueOf((int)selectionSoda.getSpinner().getValue()));
							drinks_orderList.addRow(new Object[] {"Soda", (int)selectionSoda.getSpinner().getValue(), sodaPrice});
						}
		
						selectionCocaCola.getSelection().setSelected(false);
						selectionFanta.getSelection().setSelected(false);
						selectionSprite.getSelection().setSelected(false);
						selectionCocaColaLight.getSelection().setSelected(false);
						selectionLemonade.getSelection().setSelected(false);
						selectionIceTea.getSelection().setSelected(false);
						selectionAppleSpritzer.getSelection().setSelected(false);
						selectionBioHollunder.getSelection().setSelected(false);
						selectionSoda.getSelection().setSelected(false);
						
						BigDecimal totalPrice = new BigDecimal(0);
						for(int i = 0; i < drinks_orderList.getRowCount(); i++) {
							totalPrice = totalPrice.add((BigDecimal) drinks_orderList.getValueAt(i, 2));  
							
						}
						textFieldSum.setText(df.format(totalPrice));
		
					}
				});
				
						addSoftdrinks.setIcon(new ImageIcon("image\\plus.png"));
						addSoftdrinks.setFont(new Font("Arial Black", Font.PLAIN, 12));
						addSoftdrinks.setBackground(new Color(255, 255, 153));

		panelTitel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelTitel.setBackground(new Color(255, 69, 0));
		panelTitel.setBounds(231, 11, 840, 103);
		mainPanel.add(panelTitel);
		panelTitel.setLayout(null);
		
		JLabel DrinksTitle_Label = new JLabel("Drinks");
		DrinksTitle_Label.setHorizontalAlignment(SwingConstants.CENTER);
		DrinksTitle_Label.setFont(new Font("Tahoma", Font.PLAIN, 37));
		DrinksTitle_Label.setBounds(10, 11, 820, 81);
		panelTitel.add(DrinksTitle_Label);

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

		btnDeleteInDrinksList.setIcon(new ImageIcon("image\\bin (2).png"));
		btnDeleteInDrinksList.setBackground(Color.LIGHT_GRAY);
		btnDeleteInDrinksList.setBounds(1016, 393, 254, 33);
		btnDeleteInDrinksList.setFont(new Font("Arial Black", Font.PLAIN, 13));
		mainPanel.add(btnDeleteInDrinksList);

		scrollPanePriceList.setBounds(10, 513, 504, 103);
		mainPanel.add(scrollPanePriceList);

		priceList_JTable.setRowSelectionAllowed(false);
		priceList_JTable.setDefaultEditor(Object.class, null);
		scrollPanePriceList.setViewportView(priceList_JTable);		

		jTableListOfDrinks.setDefaultEditor(Object.class, null);
		jTableListOfDrinks.setModel(drinks_orderList);
		scrollPaneListOfDrinks.setBounds(1016, 183, 254, 209);
		mainPanel.add(scrollPaneListOfDrinks);
		scrollPaneListOfDrinks.setViewportView(jTableListOfDrinks);
		jTableListOfDrinks.getColumnModel().getColumn(2).setCellRenderer(new Decimal_JTableCellRenderer()); //set BigDecimal format for JTable cell
		
		//Delete in List of Drinks
		btnDeleteInDrinksList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((jTableListOfDrinks.getSelectedRow() != -1)) {
					drinks_orderList.removeRow(jTableListOfDrinks.getSelectedRow());
					BigDecimal totalPrice = new BigDecimal(0);
					for(int drinkRowCount = 0; drinkRowCount < drinks_orderList.getRowCount(); drinkRowCount++) {
						totalPrice = totalPrice.add((BigDecimal) drinks_orderList.getValueAt(drinkRowCount, 2));						
					}
					textFieldSum.setText(df.format(totalPrice));
				}
			}
		});

		btnAddToOrderList.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnAddToOrderList.setIcon(new ImageIcon("image\\next-button (2).png"));
		btnAddToOrderList.setBounds(1016, 451, 254, 33);
		mainPanel.add(btnAddToOrderList);

		txtTotalDrinks = new JTextField();
		txtTotalDrinks.setBackground(new Color(255, 255, 204));
		txtTotalDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDrinks.setText("Total Drinks =");
		txtTotalDrinks.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTotalDrinks.setBounds(1016, 427, 126, 23);
		mainPanel.add(txtTotalDrinks);
		txtTotalDrinks.setColumns(10);

		textFieldSum = new JTextField();
		textFieldSum.setBackground(new Color(255, 255, 153));
		textFieldSum.setBounds(1139, 427, 131, 23);
		mainPanel.add(textFieldSum);
		textFieldSum.setColumns(10);

		btnBack.setIcon(new ImageIcon("image\\previous_1.png"));
		btnBack.setBounds(10, 11, 211, 103);
		mainPanel.add(btnBack);
		
		list_of_drinks = new JTable();
		list_of_drinks.setBounds(0, 0, 1, 1);
		mainPanel.add(list_of_drinks);
		JLabel drinks_BG = new JLabel("");		
//		drinks_BG.setBounds(0, 0, 1280, 720);
		drinks_BG.setBounds(0, 0, (int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
		
		drinks_BG.setIcon(new ImageIcon("image\\burger (1).png"));
		drinks_BG.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		ImageIcon im = (new ImageIcon(((new ImageIcon(
				"image\\fast-food-cola-french-fries-burger-art.jpg").getImage()
	            .getScaledInstance((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight(),
	                    java.awt.Image.SCALE_SMOOTH)))));
		drinks_BG.setIcon(im);
		
		mainPanel.add(drinks_BG);
	}	
	
	private void Drinks_Init() {
		drink_PriceList = new DefaultTableModel();
		drink_PriceList.addColumn("ID");
		drink_PriceList.addColumn("Name");
		drink_PriceList.addColumn("Price");
		
		updateDrinks_priceList(drink_PriceList);
		drinks_orderList = new DefaultTableModel();
		drinks_orderList.addColumn("Item Name");
		drinks_orderList.addColumn("Quantity");
		drinks_orderList.addColumn("Price");
		
		orderList_Drinks = new JTable(drink_PriceList);
		orderList_Drinks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList_Drinks.setDefaultEditor(Object.class, null);
	}
	
	private void updateDrinks_priceList(DefaultTableModel Drinks_PriceList) {
		String url = "jdbc:sqlite:db/Prog_Exe_BH_DB.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		

		String sql = "SELECT * From Drinks";
		try (
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){
			while (rs.next()) {   
				rs.getFloat("Price");
				Drinks_PriceList.addRow(new Object[] {rs.getInt("ID"), rs.getString("Name"), rs.getBigDecimal("Price")});
			}
			stmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public DefaultTableModel getDrinks_OrderList() {
		return this.drinks_orderList;
	}
	
	public void updateDrinks_TextField(BigDecimal totalPrice) {
		textFieldSum.setText(df.format(totalPrice));
	}
	
	public void resetDrinks() {
		drinks_orderList.setRowCount(0);
		textFieldSum.setText("");
	}
}
