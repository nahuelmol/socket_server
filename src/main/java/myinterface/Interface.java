package myinterface;

import javax.swing.*;
import java.awt.event.*;
import server.Server;

public class Interface extends JFrame implements ActionListener {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;

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

		label3 = new JLabel("No one average");
		label3.setBounds(10,100,300,30);
		add(label3);

		label4 = new JLabel("People registered");
		label4.setBounds(10,140,300,30);
		add(label4);

		button1 = new JButton("Cerrar");
		button1.setBounds(10,400,100,25);
		add(button1);
		button1.addActionListener(this);

		button2 = new JButton("Useless");
		button2.setBounds(150,400,100,25);
		add(button2);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == button1){
			System.exit(0);
		}
		if (e.getSource() == button2){
			System.out.println("Age acumulada: " + Server.p.da());
			System.out.println("Average: " + Server.p.avr());

			this.label4.setText("People registerd: "+Server.p.counter);
			this.label1.setText("Members: "+ Server.p.members);
			this.label2.setText("coordinates: "+ Server.p.show_coo());
			this.label3.setText("Average: "+ Server.p.avr());
		}
	}

	public static void main(){
		Interface window = new Interface();
		window.setBounds(0,0,600,550);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
	}
}