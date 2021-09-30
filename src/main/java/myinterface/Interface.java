package myinterface;

import javax.swing.*;
import java.awt.event.*;
import server.Server;
import java.util.ArrayList;

public class Interface extends JFrame implements ActionListener {

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;

	private JButton button1;
	private JButton button2;
	private int size = 10;
	private ArrayList<ArrayList<JButton>> mytable = new ArrayList(size);

	public Interface(){
		setLayout(null);

		int i = 0;
		int j = 0;

		for(i=0; i < size; i++) {
    		mytable.add(new ArrayList());
		}

		int desp_x = 25;
		int desp_y = 100;

		for(i=0;i<size;i++){
			for(j=0;j<size;j++){
            	JButton button = new JButton("Exa" + i);
            	button.setBounds(desp_x,desp_y,40,40);
				add(button);
				button.addActionListener(this);

				desp_x = desp_x + 40;
				mytable.get(i).add(button);
			}
			desp_x = 25;
			desp_y = desp_y + 40;
        }

		label1 = new JLabel("First label");
		label1.setBounds(10,20,300,30);
		add(label1);

		label2 = new JLabel("This is a second label");
		label2.setBounds(10,60,300,30);
		add(label2);

		label3 = new JLabel("No one average");
		label3.setBounds(320,60,300,30);
		add(label3);

		label4 = new JLabel("People registered");
		label4.setBounds(150,495,150,30);
		add(label4);

		button1 = new JButton("Cerrar");
		button1.setBounds(250,20,100,25);
		add(button1);
		button1.addActionListener(this);

		button2 = new JButton("Useless");
		button2.setBounds(350,20,100,25);
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
			this.label2.setText(Server.p.show_coo());
			this.label3.setText("Average: "+ Server.p.avr());
		}

		for(int k = 0;mytable.size() > k;k++){
			if(mytable.get(k).contains(e.getSource())){
				int x = mytable.get(k).indexOf(e.getSource());
				int y = mytable.indexOf(mytable.get(k));
				System.out.println("["+x+","+y+"]");
			}
		}
		
	}

	public static void main(){
		Interface window = new Interface();
		window.setBounds(0,0,900,550);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
	}
}