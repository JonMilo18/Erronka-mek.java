package erronka;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MakinakAltak extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MakinakAltak frame = new MakinakAltak();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MakinakAltak() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 351);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(10, 49, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Izena:");
        lblNewLabel.setBounds(10, 34, 45, 13);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Marka:");
        lblNewLabel_1.setBounds(316, 34, 45, 13);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Modeloa");
        lblNewLabel_2.setBounds(178, 34, 81, 13);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("fabrikazio urtea");
        lblNewLabel_3.setBounds(10, 97, 96, 13);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("erosketa urtea");
        lblNewLabel_4.setBounds(10, 149, 96, 13);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("ceMarka(bai/ez)");
        lblNewLabel_5.setBounds(178, 97, 96, 13);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Oharrak:");
        lblNewLabel_6.setBounds(178, 149, 81, 13);
        contentPane.add(lblNewLabel_6);
        
        textField_1 = new JTextField();
        textField_1.setBounds(178, 49, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(316, 49, 96, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(10, 120, 96, 19);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(178, 120, 96, 19);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(10, 172, 96, 19);
        contentPane.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(178, 172, 96, 19);
        contentPane.add(textField_6);
        textField_6.setColumns(10);
        
        JButton btnNewButton = new JButton("Alta");
        btnNewButton.setBounds(327, 119, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertarRegistro();
            }
        });
        contentPane.add(btnNewButton);
    }
    
    private void insertarRegistro() {
        try {
            // Establecer conexión con la base de datos (ajusta los valores según tu configuración)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronkamek", "root", "1WMG2023");

            // Consulta SQL para insertar un nuevo registro en la tabla makinak
            String sql = "INSERT INTO makinak (izena, marka, modeloa, fabrikazioUrtea, erosketaUrtea, ceMarka, oharrak) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Obtener los valores de los campos de texto
            String izena = textField.getText();
            String marka = textField_2.getText();
            String modeloa = textField_1.getText();
            String fabrikazioUrtea = textField_3.getText();
            String erosketaUrtea = textField_4.getText();
            String ceMarka = textField_5.getText();
            String oharrak = textField_6.getText();
            
           
            
            // Establecer los parámetros para la consulta preparada
            statement.setString(1, izena);
            statement.setString(2, marka);
            statement.setString(3, modeloa);
            statement.setString(4, fabrikazioUrtea);
            statement.setString(5, erosketaUrtea);
            statement.setString(6, ceMarka);
            statement.setString(7, oharrak);

            // Ejecutar la consulta
            statement.executeUpdate();
            
            // Cerrar la conexión y liberar recursos
            statement.close();
            connection.close();
            
            // Mensaje de éxito
            System.out.println("Registro insertado correctamente en la tabla makinak.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
