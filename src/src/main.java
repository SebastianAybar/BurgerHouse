package src;

public class main {

	public static void main(String[] args) {
		BH_GUI_Frame start = null;
		try {
			start = new BH_GUI_Frame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		start.setVisible(true);
		
//		ShowTable.main(ConnectDB.main(args));
	}

}
