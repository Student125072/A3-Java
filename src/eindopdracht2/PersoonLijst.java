package eindopdracht2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PersoonLijst extends JFrame{
	
	public static DefaultListModel<String> listModel;
	
	public static void main(String[] args) {
		ConnectDB database = new ConnectDB();
		database.createConnection("persoonlijst", "root", "");
		JFrame f = new JFrame("Persoonlijst");
		f.setVisible(true);
		f.setSize(500,500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		f.add(panel);
		
		JTextField voornaam = new JTextField(20);
		voornaam.setBounds(0,0,200,30);
		panel.add(voornaam);
		
		JTextField achternaam = new JTextField(20);
		achternaam.setBounds(335,0,200,30);
		panel.add(achternaam);
		
		listModel = new DefaultListModel<>();
		
		JList<String> list = new JList<>(listModel);
		JScrollPane s = new JScrollPane(list);
		s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		s.setBounds(150,120, 200, 100);
		panel.add(s);
		
		JButton toevoeg = new JButton("Persoon toevoegen");
		toevoeg.setBounds(150, 250, 200, 50);
		toevoeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == toevoeg) {
					database.insertData(voornaam.getText(), achternaam.getText());
				}
			}
		});
		panel.add(toevoeg);
		JButton selectall = new JButton("Krijg alle personen");
		selectall.setBounds(150,300,200,50);
		selectall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == selectall) {
					listModel.clear();
					database.getData();
				}
			}
		});
		panel.add(selectall);
		f.revalidate();
		f.setVisible(true);
		f.setResizable(false);
	}
		
	}
	
}
