package erronka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BabeserakoekipoakAltak extends JFrame {

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
                    BabeserakoekipoakAltak frame = new BabeserakoekipoakAltak();
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
    public BabeserakoekipoakAltak() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Izena:");
        lblNewLabel.setBounds(34, 57, 45, 13);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(34, 84, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Alta");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del JTextField
                String izena = textField.getText();
                
                // Insertar el texto en la base de datos
                insertarRegistro(izena);
            }
        });
        btnNewButton.setBounds(212, 83, 85, 21);
        contentPane.add(btnNewButton);
    }
    
    // Método para insertar un registro en la tabla babeserakoekipoak
    private void insertarRegistro(String izena) {
        try {
            // Establecer conexión con la base de datos (ajusta los valores según tu configuración)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronkamek", "root", "1WMG2023");

            // Consulta SQL para insertar el registro en la tabla babeserakoekipoak
            String sql = "INSERT INTO babeserakoekipoak (izena) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, izena);
            
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
