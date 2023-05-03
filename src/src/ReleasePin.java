package src;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ReleasePin extends JPanel {
private JPanel contentPane;
private CardLayout cl;
private JPasswordField releasePin_passwordField;
	
	public ReleasePin(BH_GUI_Frame bh_GUI_Frame) {
		
//		setSize(1280, 720);
		setSize((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getHeight());
		setLayout(null);
		
		
		JPanel releasePin = new JPanel();
		releasePin.setLayout(null);
//		releasePin.setBounds(0, 0, 1280, 720);
		releasePin.setBounds(0, 0, (int) bh_GUI_Frame.getDimension().getWidth() , (int) bh_GUI_Frame.getHeight());
		add(releasePin);
		
		JPanel releasePinTitle_panel = new JPanel();
		releasePinTitle_panel.setBackground(Color.RED);
		releasePinTitle_panel.setBounds(444, 71, 391, 60);
		releasePin.add(releasePinTitle_panel);
		releasePinTitle_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the Release Pin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 371, 38);
		releasePinTitle_panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel pinPanel = new JPanel();
		pinPanel.setLayout(null);
		pinPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pinPanel.setBounds(444, 195, 391, 330);
		releasePin.add(pinPanel);
		
		JButton btnReleasePin1 = new JButton("1");
		btnReleasePin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"1");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"1");
				}
			}
		});
		btnReleasePin1.setBounds(10, 198, 112, 42);
		pinPanel.add(btnReleasePin1);
		
		JButton btnReleasePin2 = new JButton("2");
		btnReleasePin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"2");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"2");
				}
			}
		});
		btnReleasePin2.setBounds(132, 198, 112, 42);
		pinPanel.add(btnReleasePin2);
		
		JButton btnReleasePin3 = new JButton("3");
		btnReleasePin3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"3");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"3");
				}
			}
		});
		btnReleasePin3.setBounds(254, 198, 112, 42);
		pinPanel.add(btnReleasePin3);
		
		JButton btnReleasePin4 = new JButton("4");
		btnReleasePin4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"4");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"4");
				}
			}
		});
		btnReleasePin4.setBounds(10, 145, 112, 42);
		pinPanel.add(btnReleasePin4);
		
		JButton btnReleasePin5 = new JButton("5");
		btnReleasePin5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"5");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"5");
				}
			}
		});
		btnReleasePin5.setBounds(132, 145, 112, 42);
		pinPanel.add(btnReleasePin5);
		
		JButton btnReleasePin6 = new JButton("6");
		btnReleasePin6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"6");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"6");
				}
			}
		});
		btnReleasePin6.setBounds(254, 145, 112, 42);
		pinPanel.add(btnReleasePin6);
		
		JButton btnReleasePin7 = new JButton("7");
		btnReleasePin7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"7");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"7");
				}
			}
		});
		btnReleasePin7.setBounds(10, 92, 112, 42);
		pinPanel.add(btnReleasePin7);
		
		JButton btnReleasePin8 = new JButton("8");
		btnReleasePin8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
				releasePin_passwordField.setText(releasePin_passwordField.getText()+"9");
			} else {
				releasePin_passwordField.setText(releasePin_passwordField.getText()+"9");
			}
			}
		});
		btnReleasePin8.setBounds(132, 92, 112, 42);
		pinPanel.add(btnReleasePin8);
		
		JButton btnReleasePin9 = new JButton("9");
		btnReleasePin9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"1");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"1");
				}
			}
		});
		btnReleasePin9.setBounds(254, 92, 112, 42);
		pinPanel.add(btnReleasePin9);
		
		JButton btnReleasePin0 = new JButton("0");
		btnReleasePin0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("")) {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"0");
				} else {
					releasePin_passwordField.setText(releasePin_passwordField.getText()+"0");
				}
			}
		});
		btnReleasePin0.setBounds(132, 257, 112, 42);
		pinPanel.add(btnReleasePin0);
		
		JButton btnReleaseConfirm = new JButton("Confirm");
		btnReleaseConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (releasePin_passwordField.getText().equalsIgnoreCase("1234")) {					
					bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(),"Set Table");
					JOptionPane.showMessageDialog(btnReleaseConfirm, "Table released");
					releasePin_passwordField.setText("");
					bh_GUI_Frame.getCostumerMenu().cleanAllOrderList(bh_GUI_Frame);					
				}
				else {
					bh_GUI_Frame.getCardLayout().show(bh_GUI_Frame.getContentPane(), "Costumer Menu");
					JOptionPane.showMessageDialog(btnReleaseConfirm, "wrong Pin back to Menu");
					releasePin_passwordField.setText("");
				}
			}
		});
		btnReleaseConfirm.setBounds(10, 276, 112, 23);
		pinPanel.add(btnReleaseConfirm);
		
		releasePin_passwordField = new JPasswordField();
		releasePin_passwordField.setEditable(false);
		releasePin_passwordField.setBackground(Color.WHITE);
		releasePin_passwordField.setBounds(110, 25, 152, 42);
		pinPanel.add(releasePin_passwordField);
		
		JLabel releasePinBG = new JLabel("");
//		releasePinBG.setBounds(0, 0, 1280, 720);
		releasePinBG.setBounds(0, 0, (int)bh_GUI_Frame.getDimension().getWidth(), (int)bh_GUI_Frame.getDimension().getHeight());
		releasePin.add(releasePinBG);
		
		ImageIcon im = (new ImageIcon(((new ImageIcon(
				"image\\fast-food-cola-french-fries-burger-art.jpg").getImage()
	            .getScaledInstance((int) bh_GUI_Frame.getDimension().getWidth(), (int) bh_GUI_Frame.getDimension().getHeight(),
	                    java.awt.Image.SCALE_SMOOTH)))));
		releasePinBG.setIcon(im);
		
	}
}
