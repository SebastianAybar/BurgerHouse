package src;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ConnectDB {

	public Connection getConnection() {
		//SQLite connection string;
		String url = "jdbc:sqlite:db/Prog_Exe_BH_DB.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection to DB \"Prog_Exe_BH_DB\" initialized");
			return conn;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null; 
	}
	
	public ArrayList<Zutat> getZutaten() throws Exception {
		ArrayList<Zutat> zutaten = new ArrayList<>();
		
		Connection conn = getConnection();
		String sql = "Select * From Zutaten";
		try (Statement stmt 	= conn.createStatement();
				ResultSet rs 	= stmt.executeQuery(sql)){
			while(rs.next()) {
				Zutat zutat = new Zutat(); 
				zutat.setId(rs.getInt("id"));
				zutat.setName(rs.getString("Name"));
				zutat.setPrice(rs.getBigDecimal("price"));
				
				zutaten.add(zutat);
			}	
		}
		return zutaten;
	}
	
	public void insertInvoice(DefaultTableModel completeOrderList, int tableNr, BigDecimal totalSum) throws SQLException {
		Connection conn = null;
		String sql = 	"insert into Invoice (DateInvoice, tableNr, orderList, totalSum )"
					+	"values(?,?,?,?);";	
		
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		df.getNumberFormat();
		
		conn = new ConnectDB().getConnection();
		String comepleteOrderString = "";
		
		for(int rowCount = 0; rowCount < completeOrderList.getRowCount(); rowCount++) {
			comepleteOrderString += "Order Name :" + completeOrderList.getValueAt(rowCount, 1) + " Quantity: "
									+ completeOrderList.getValueAt(rowCount, 2) + ";\n";
		}
		
		try (PreparedStatement pstmt 	= conn.prepareStatement(sql)){
			pstmt.setString(1, df.format(System.currentTimeMillis()));
			
			pstmt.setInt(2, tableNr);
			pstmt.setString(3, comepleteOrderString);
			pstmt.setBigDecimal(4, totalSum);
			
			pstmt.executeUpdate();
			pstmt.getGeneratedKeys();
		} 
	}
}

