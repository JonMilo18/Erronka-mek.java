package erronka;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Makinak extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private String lastTableName;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Makinak frame = new Makinak();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Makinak() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 871, 459);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 857, 91);
        panel.setBackground(new Color(105, 156, 255));
        contentPane.add(panel);
        panel.setLayout(null);
        
        table = new JTable();
        table.setBounds(365, 101, 482, 311);
        contentPane.add(table);
        
        JButton btnNewButton = new JButton("Makinak");
        btnNewButton.setBounds(10, 164, 152, 21);
        btnNewButton.addActionListener(e -> {
            lastTableName = "makinak";
            cargarDatos(lastTableName);
        });
        contentPane.add(btnNewButton);
        
        JButton btnHondakinak = new JButton("Hondakinak");
        btnHondakinak.setBounds(10, 191, 152, 21);
        btnHondakinak.addActionListener(e -> {
            lastTableName = "hondakinak";
            cargarDatos(lastTableName);
        });
        contentPane.add(btnHondakinak);
        
        JButton btnBabeserakoEkipoak = new JButton("Babeserako ekipoak");
        btnBabeserakoEkipoak.setBounds(10, 222, 152, 21);
        btnBabeserakoEkipoak.addActionListener(e -> {
            lastTableName = "babeserakoekipoak";
            cargarDatos(lastTableName);
        });
        contentPane.add(btnBabeserakoEkipoak);
        
        JButton btnProduktuKimikoak = new JButton("Produktu kimikoak");
        btnProduktuKimikoak.setBounds(10, 253, 152, 21);
        btnProduktuKimikoak.addActionListener(e -> {
            lastTableName = "produktukimikoak";
            cargarDatos(lastTableName);
        });
        contentPane.add(btnProduktuKimikoak);
        
        JButton btnArriskuak = new JButton("Arriskuak");
        btnArriskuak.setBounds(10, 284, 152, 21);
        btnArriskuak.addActionListener(e -> {
            lastTableName = "arriskuak";
            cargarDatos(lastTableName);
        });
        contentPane.add(btnArriskuak);
        
        JLabel lblNewLabel = new JLabel("Taulak");
        lblNewLabel.setBounds(10, 137, 45, 13);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(lblNewLabel);

        // Resto de los botones existentes
        JButton btnNewButton_1 = new JButton("+");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MakinakAltak MakinakAltak = new MakinakAltak();
        		MakinakAltak.setVisible(true);
        	}
        });
        btnNewButton_1.setBounds(172, 159, 47, 30);
        btnNewButton_1.setBackground(Color.GREEN);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("-");
        btnNewButton_2.setBounds(308, 101, 47, 30);
        btnNewButton_2.setBackground(Color.RED);
        btnNewButton_2.addActionListener(e -> eliminarRegistro());
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_1_1 = new JButton("+");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HondakinakAltak HondakinakAltak = new HondakinakAltak();
        		HondakinakAltak.setVisible(true);
        	}
        });
        btnNewButton_1_1.setBounds(172, 186, 47, 30);
        btnNewButton_1_1.setBackground(Color.GREEN);
        contentPane.add(btnNewButton_1_1);
        
        JButton btnNewButton_1_1_1 = new JButton("+");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		BabeserakoekipoakAltak BabeserakoekipoakAltak = new BabeserakoekipoakAltak();
        		BabeserakoekipoakAltak.setVisible(true);
        	}
        });
        btnNewButton_1_1_1.setBounds(172, 217, 47, 30);
        btnNewButton_1_1_1.setBackground(Color.GREEN);
        contentPane.add(btnNewButton_1_1_1);
        
        JButton btnNewButton_1_1_1_1 = new JButton("+");
        btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ProduktuKimikoakAltak ProduktuKimikoakAltak = new ProduktuKimikoakAltak();
        		ProduktuKimikoakAltak.setVisible(true);
        	}
        });
        btnNewButton_1_1_1_1.setBackground(Color.GREEN);
        btnNewButton_1_1_1_1.setBounds(172, 248, 47, 30);
        contentPane.add(btnNewButton_1_1_1_1);
        
        JButton btnNewButton_1_1_1_2 = new JButton("+");
        btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArriskoakAltak ArriskoakAltak = new ArriskoakAltak();
        		ArriskoakAltak.setVisible(true);
        	}
        });
        btnNewButton_1_1_1_2.setBackground(Color.GREEN);
        btnNewButton_1_1_1_2.setBounds(172, 279, 47, 30);
        contentPane.add(btnNewButton_1_1_1_2);
    }

    // Método para cargar los datos de la tabla especificada desde la base de datos
    private void cargarDatos(String tabla) {
        try {
            // Conexión a la base de datos (ajusta los valores según tu configuración)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronkamek", "root", "1WMG2023");
            Statement statement = connection.createStatement();
            
            // Ejecutar consulta SQL para obtener los datos de la tabla especificada
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tabla);
            
            // Crear un modelo de tabla para almacenar los datos
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
            table.setModel(model);

            // Agregar las columnas a la tabla
            java.sql.ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            // Agregar filas a la tabla
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                   
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }

            // Cierra la conexión y los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar el registro seleccionado de la tabla actual
    private void eliminarRegistro() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
                String primaryKeyColumn = obtenerClavePrimaria(lastTableName);
                String id = table.getValueAt(selectedRow, 0).toString();

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronkamek", "root", "1WMG2023");
                Statement statement = connection.createStatement();

                String query = "DELETE FROM " + lastTableName + " WHERE " + primaryKeyColumn + " = '" + id + "'";
                statement.executeUpdate(query);

                cargarDatos(lastTableName);  // Recargar datos en la tabla
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para guardar los cambios realizados en la tabla
    private void guardarCambios() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erronkamek", "root", "1WMG2023");
            Statement statement = connection.createStatement();

            // Iterar sobre cada fila y guardar los cambios en la base de datos
            for (int i = 0; i < rowCount; i++) {
                String primaryKeyColumn = obtenerClavePrimaria(lastTableName);
                String id = model.getValueAt(i, 0).toString(); // Suponiendo que el ID es la primera columna

                // Construir la consulta de actualización
                StringBuilder queryBuilder = new StringBuilder("UPDATE ");
                queryBuilder.append(lastTableName).append(" SET ");

                // Añadir los campos y sus valores
                for (int j = 1; j < model.getColumnCount(); j++) {
                    String columnName = model.getColumnName(j);
                    Object columnValue = model.getValueAt(i, j);
                    queryBuilder.append(columnName).append(" = '").append(columnValue).append("', ");
                }
                // Eliminar la coma y el espacio extra del último elemento
                queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());

                // Agregar la condición WHERE
                queryBuilder.append(" WHERE ").append(primaryKeyColumn).append(" = '").append(id).append("'");
                String query = queryBuilder.toString();

                // Ejecutar la consulta de actualización
                statement.executeUpdate(query);
            }

            // Cerrar la conexión y los recursos
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la clave primaria de la tabla especificada
    private String obtenerClavePrimaria(String tabla) {
        switch (tabla) {
            case "makinak":
                return "id";  // Ajusta esto al nombre real de la columna clave primaria
            case "hondakinak":
                return "id";  // Ajusta esto al nombre real de la columna clave primaria
            case "babeserakoekipoak":
                return "id";  // Ajusta esto al nombre real de la columna clave primaria
            case "produktukimikoak":
                return "id";  // Ajusta esto al nombre real de la columna clave primaria
            case "arriskuak":
                return "id";  // Ajusta esto al nombre real de la columna clave primaria
            default:
                return "id";  // Ajusta esto al nombre real de la columna clave primaria si es diferente
        }
    }
}
