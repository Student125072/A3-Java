package oefening4;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{	
	
	public MainFrame() {
		super("Personen");
		
		JButton btn = new JButton("Toevoegen");
		btn.setBounds(100,150,140,40);
		
		//maakt de voornaam label aan
		JLabel labelVoornaam = new JLabel();
		labelVoornaam.setBounds(10,10,100,100);
		//set de tekst van het label voor de input field.
		labelVoornaam.setText("Voornaam :");
		
		//maakt het textfield voornaam aan.
		JTextField voornaam = new JTextField();
		voornaam.setBounds(110,50,130,30);
		
		//maakt de achternaam label aan.
		JLabel labelAchternaam = new JLabel();
		labelAchternaam.setBounds(10,60,100,100);
		//set de tekst voor de input field.
		labelAchternaam.setText("Achternaam :");
		
		//textfield voor achternaam.
		JTextField achternaam = new JTextField();
		achternaam.setBounds(110,100,130,30);
		
		//lege label voor output. nadat de knop is ingedrukt komt hier informatie te staan.
		JLabel output = new JLabel();
		output.setBounds(10, 160, 200, 100);
		//kleur van de label
		output.setForeground(Color.red);
		
		add(labelVoornaam);
		add(voornaam);
		add(labelAchternaam);
		add(achternaam);
		add(output);
		add(btn);
		setLayout(null);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				output.setText("Voor- en Achternaam toegevoegd.");
			}
			
		});
	}
	
	
}
