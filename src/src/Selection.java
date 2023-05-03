package src;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;

public class Selection {

	private JCheckBox selection;
	private JSpinner spinner;
	
	//Constructor
	public Selection(String name) {
		selection = new JCheckBox(name);
		spinner = new JSpinner();
		
		selection.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(spinner.getValue().equals(0)) {
					spinner.setValue(1);
				}
				else if(selection.isSelected() == false) {
					spinner.setValue(0);
				}
			}
		});
	}

	public JCheckBox getSelection() {
		return selection;
	}

	public void setSelection(JCheckBox selection) {
		this.selection = selection;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}
	
	
	
	
}
