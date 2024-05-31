package erronka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logina frame = new Logina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 156, 255));
		panel.setBounds(0, 0, 739, 91);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Logeatu");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Crear una instancia de Erabiltzailea al pulsar el botón "Logeatu"
		        Erabiltzailea erabiltzailea = new Erabiltzailea(textField.getText(), new String(passwordField.getPassword()));
		        
		        // Verificar en la base de datos
		        if (erabiltzailea.verificarEnBaseDeDatos()) {
		            // Si el usuario es válido, haz algo
		            System.out.println("Usuario válido");
		            Makinak makinak = new Makinak();
	                makinak.setVisible(true);
		        } else {
		            // Si el usuario no es válido, haz algo más
		            System.out.println("Usuario no válido");
		        }
		    }
		});

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(105, 156, 255));
		btnNewButton.setBounds(314, 366, 85, 21);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(283, 207, 144, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Erregistratu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Erregistratu Erregistratu = new Erregistratu();
				Erregistratu.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(105, 156, 255));
		btnNewButton_1.setBounds(611, 394, 118, 21);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(283, 289, 144, 35);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(283, 184, 144, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(283, 266, 144, 13);
		contentPane.add(lblNewLabel_1);
	}
}
