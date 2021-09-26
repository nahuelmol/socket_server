package myinterface;

import javax.swing.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener {

	private JLabel label1;
	private JLabel label2;

	private JButton button1;
	private JButton button2;

	public Interface(){
		setLayout(null);

		label1 = new JLabel("First label");
		label1.setBounds(10,20,300,30);
		add(label1);

		label2 = new JLabel("This is a second label");
		label2.setBounds(10,60,300,30);
		add(label2);

		button1 = new JButton("Cerrar");
		button1.setBounds(10,150,100,25);
		add(button1);
		button1.addActionListener(this);

		button2 = new JButton("Useless");
		button2.setBounds(100,150,150,25);
		add(button2);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == button1){
			System.exit(0);
		}
		if (e.getSource() == button2){
			System.out.println("Nothing is happening");
		}
	}

	public static void main(){
		System.out.println("Hola");
		Interface window = new Interface();
		window.setBounds(0,0,600,550);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
	}
}