package erronka;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ArriskoakAltak extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArriskoakAltak frame = new ArriskoakAltak();
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
    public ArriskoakAltak() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JButton btnNewButton = new JButton("Alta");
        btnNewButton.setBounds(294, 98, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Insertar un registro en la tabla arriskuak
                insertarRegistro();
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);
        
        textField = new JTextField();
        textField.setBounds(97, 99, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Deskribapena");
        lblNewLabel.setBounds(100, 76, 93, 13);
        contentPane.add(lblNewLabel);
    }
    
    // Método para insertar un registro en la tabla arriskuak
    private void insertarRegistro() {
        try {
            // Establecer conexión con la base de datos (ajusta los valores según tu configuración)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronkamek", "root", "1WMG2023");

            // Consulta SQL para insertar el registro en la tabla arriskuak
            String sql = "INSERT INTO arriskuak (deskribapena) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, textField.getText());
            
            // Ejecutar la consulta
            statement.executeUpdate();
            
            // Cerrar la conexión y el statement
            statement.close();
            connection.close();
            
            // Mensaje de éxito
            System.out.println("Registro insertado correctamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
