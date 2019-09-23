package oefening4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PersoonList extends JFrame{
	
	public PersoonList() {
		
		//het setten van de windownaam.
		super("Eclipse-Personen");
		
		//properties van de window.
		setSize(500,500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//variabelen
		JTextField voornaam = new JTextField();								// de text field voor voornaam
		JTextField achternaam = new JTextField();							// de text field voor achternaam
		JButton subBtn = new JButton("Toevoegen");							// de button om toe te voegen
		JButton delBtn = new JButton("Reset");								// de button om te resetten
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> persoonList = new JList<>(model);
		
		//labels
		JLabel laVoornaam = new JLabel();
		laVoornaam.setText("Voornaam :");
		JLabel laAchternaam = new JLabel();
		laAchternaam.setText("Achternaam :");
		JLabel output = new JLabel();
		
		//opmaak
		voornaam.setBounds(110, 10, 100, 30);
		laVoornaam.setBounds(10,10,100,30);
		achternaam.setBounds(110, 50, 100, 30);
		laAchternaam.setBounds(10,50,100,30);
		subBtn.setBounds(10, 100, 100, 30);
		delBtn.setBounds(130, 100, 100, 30);
		output.setBounds(10, 150, 400, 20);
		persoonList.setBounds(10, 250, 460, 500);
		
		//tooltips
		voornaam.setToolTipText("Voer hier je voornaam in.");
		achternaam.setToolTipText("Voer hier je achternaam in.");
		subBtn.setToolTipText("Voegt jouw naam toe aan de lijst.");
		
		//uitprinten van button, fields en labels.
		add(laVoornaam);
		add(voornaam);
		add(laAchternaam);
		add(achternaam);
		add(output);
		add(subBtn);
		add(delBtn);
		add(persoonList);

		
		subBtn.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				String message = voornaam.getText() + " " + achternaam.getText() + " is toegevoegd aan de lijst.";
				String error = "Voor- en achternaam moeten ingevuld worden.";
				
				if (voornaam.getText().equals("") || achternaam.getText().equals("")) {
					output.setText(error);
					output.setForeground(Color.RED);
				} else {
					output.setText(message);
					output.setForeground(Color.BLUE);
					model.addElement(voornaam.getText() + " " + achternaam.getText());
					voornaam.setText("");
					achternaam.setText("");
				}
			}
			
		});
		
		delBtn.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				String clearMsg = "Alle namen zijn uit de lijst gehaald.";
				
				output.setText(clearMsg);
				output.setForeground(Color.BLUE);
				voornaam.setText("");
				achternaam.setText("");
				model.clear();
				
			}
			
		});
		
	}
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new PersoonList();
				}
			
		});
	}
	
}
