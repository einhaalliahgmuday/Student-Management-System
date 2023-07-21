/* This class contains custom JDialogs for Student Management System. 
 * 
 * For now, it has overloaded constructors of "showMessageDialog()" method - accepting 1 message, 2 messages, and
 * three messages. It is still subject for edit, to shorten and simplify the code structure.
 */

package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SMSDialog {
	
	public void showMessageDialog(JFrame frame, String message) {
		
		JDialog dlgMessage = new JDialog(frame, "Message");
		dlgMessage.setSize(300, 125);
		dlgMessage.setLayout(null);
		dlgMessage.setResizable(false);
		dlgMessage.setLocationRelativeTo(null);
		dlgMessage.getContentPane().setBackground(new Color(187, 37, 61));
		
		JLabel lblMainMessage = new JLabel(message);
		lblMainMessage.setBounds(0, 10, 280, 25);
		lblMainMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMessage.setFont(new Font("Tahoma", 1, 14));
		lblMainMessage.setForeground(new Color(255, 255, 255));
		
		JButton bttnOK = new JButton("OK");
		bttnOK.setBounds(105, 45, 70, 22);
		bttnOK.setFont(new Font("Tahoma", 1, 12));
		bttnOK.setForeground(new Color(0, 0, 0));
		bttnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlgMessage.dispose();
			}
		});
		
		
		dlgMessage.add(lblMainMessage);
		dlgMessage.add(bttnOK);
		dlgMessage.setVisible(true);
	}
	
	public void showMessageDialog(JFrame frame, String mainMessage, String message) {
		
		JDialog dlgMessage = new JDialog(frame, "Message");
		dlgMessage.setSize(300, 140);
		dlgMessage.setLayout(null);
		dlgMessage.setResizable(false);
		dlgMessage.setLocationRelativeTo(null);
		dlgMessage.getContentPane().setBackground(new Color(187, 37, 61));
		
		JLabel lblMainMessage = new JLabel(mainMessage);
		lblMainMessage.setBounds(0, 10, 280, 19);
		lblMainMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMessage.setFont(new Font("Tahoma", 1, 14));
		lblMainMessage.setForeground(new Color(255, 255, 255));
		
		JLabel lblMessage1 = new JLabel(message);
		lblMessage1.setBounds(0, 34, 280, 17);
		lblMessage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMessage1.setForeground(new Color(255, 255, 255));
		
		JButton bttnOK = new JButton("OK");
		bttnOK.setBounds(105, 63, 70, 22);
		bttnOK.setFont(new Font("Tahoma", 1, 12));
		bttnOK.setForeground(new Color(0, 0, 0));
		bttnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlgMessage.dispose();
			}
		});
		
		dlgMessage.add(lblMainMessage);
		dlgMessage.add(lblMessage1);
		dlgMessage.add(bttnOK);
		dlgMessage.setVisible(true);
	}
	
	public void showMessageDialog(JFrame frame, String mainMessage, String message1, String message2) {
		
		JDialog dlgMessage = new JDialog(frame, "Message");
		dlgMessage.setSize(290, 159);
		dlgMessage.setLayout(null);
		dlgMessage.setResizable(false);
		dlgMessage.setLocationRelativeTo(null);
		dlgMessage.getContentPane().setBackground(new Color(187, 37, 61));
		
		JLabel lblMainMessage = new JLabel(mainMessage);
		lblMainMessage.setBounds(0, 10, 270, 19);
		lblMainMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainMessage.setFont(new Font("Tahoma", 1, 14));
		lblMainMessage.setForeground(new Color(255, 255, 255));
		
		JLabel lblMessage1 = new JLabel(message1);
		lblMessage1.setBounds(0, 34, 270, 17);
		lblMessage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMessage1.setForeground(new Color(255, 255, 255));
		
		JLabel lblMessage2 = new JLabel(message2);
		lblMessage2.setBounds(0, 53, 270, 17);
		lblMessage2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMessage2.setForeground(new Color(255, 255, 255));
		
		JButton bttnOK = new JButton("OK");
		bttnOK.setBounds(100, 82, 70, 22);
		bttnOK.setFont(new Font("Tahoma", 1, 12));
		bttnOK.setForeground(new Color(0, 0, 0));
		bttnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dlgMessage.dispose();
			}
		});
		
		dlgMessage.add(lblMainMessage);
		dlgMessage.add(lblMessage1);
		dlgMessage.add(lblMessage2);
		dlgMessage.add(bttnOK);
		dlgMessage.setVisible(true);
	}
	
}
