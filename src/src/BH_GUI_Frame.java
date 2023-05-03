package src;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class BH_GUI_Frame extends JFrame {
	// variable
	private Dimension dim; 
//	eigene Panels
	private SetTable setT;
	private CostumerMenu costM;
	private ReleasePin releaseP;
	private StandardBurger standardB;
	private IndividualBurger individualB;
	private Drinks drinks;
	private SideDishes sideDishes;

//	Elements for CardLayout
	private JPanel contentPane;
	private CardLayout cl;
	
	public BH_GUI_Frame() throws Exception {
		GUI_BH_Init();
				
		contentPane.add(setT, "Set Table");
		contentPane.add(costM, "Costumer Menu");
		contentPane.add(releaseP, "Release Pin");
		contentPane.add(standardB, "Standard Burger");
		contentPane.add(individualB, "Individual Burger");
		contentPane.add(drinks, "Drinks");
		contentPane.add(sideDishes, "Side Dishes");
		
		cl.show(contentPane,"Set Table");
	}

	private void GUI_BH_Init() throws Exception {
		dim = getToolkit().getScreenSize();
//		setSize(1280,720);
		setSize((int) dim.getWidth(),(int) dim.getHeight());
		setBounds(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(cl);
		setContentPane(contentPane);
		cl = new CardLayout();
		setLayout(cl);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);		
		
		ConnectDB db = new ConnectDB();
		ArrayList<Zutat> zutaten = db.getZutaten();
		System.out.println("Pricelist Updated");
		
		setT = new SetTable(this);
		costM = new CostumerMenu(this);
		releaseP = new ReleasePin(this);
		standardB = new StandardBurger(this, zutaten);
		individualB = new IndividualBurger(this, zutaten);
		drinks = new Drinks(this);
		sideDishes = new SideDishes(this);
	}
	
	public SetTable getSetTable () {
		return setT;		
	}
	
	public CostumerMenu getCostumerMenu () {
		return costM;
	}
	
	public SideDishes getSideDishes () {
		return sideDishes;		
	}
	
	public Drinks getDrinks() {
		return drinks;		
	}

	public StandardBurger getStandardBurger() {
		return standardB;
	}
	
	public IndividualBurger getIndividualBurger() {
		return individualB;
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public CardLayout getCardLayout() {
		return this.cl;
	}
	
	public Dimension getDimension() {
		return this.dim;
	}
}
