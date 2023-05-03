package src;

import java.awt.Component;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class Decimal_JTableCellRenderer implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		BigDecimal newValue = (BigDecimal)value;
		DecimalFormat df = new DecimalFormat("0.00");
		JLabel label = new JLabel();
		label.setText(df.format(newValue));
		label.setFont(label.getFont().deriveFont(Font.PLAIN)); //standard font bold
		return label;
	}

}
