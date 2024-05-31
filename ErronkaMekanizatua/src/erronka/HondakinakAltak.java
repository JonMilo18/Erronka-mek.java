package erronka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HondakinakAltak extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HondakinakAltak frame = new HondakinakAltak();
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
    public HondakinakAltak() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Izena:");
        lblNewLabel.setBounds(106, 49, 45, 13);
        contentPane.add(lblNewLabel);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(97, 72, 146, 105);
        contentPane.add(textArea);
        
        JButton btnNewButton = new JButton("Alta");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del JTextArea
                String izena = textArea.getText();
                
                // Insertar el texto en la base de datos
                insertarRegistro(izena);
            }
        });
        btnNewButton.setBounds(301, 153, 85, 21);
        contentPane.add(btnNewButton);
    }
    
    // Método para insertar un registro en la tabla hondakinak
    private void insertarRegistro(String izena) {
        try {
            // Establecer conexión con la base de datos (ajusta los valores según tu configuración)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronkamek", "root", "1WMG2023");

            // Consulta SQL para insertar el registro en la tabla hondakinak
            String sql = "INSERT INTO hondakinak (izena) VALUES (?)";
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
