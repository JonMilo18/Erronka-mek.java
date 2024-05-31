package erronka;

public class Erabiltzailea {
    private String erabiltzailea;
    private String pasahitza;

    // Constructor
    public Erabiltzailea(String erabiltzailea, String pasahitza) {
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
    }

    // Getters y setters
    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    // Método para verificar la instancia en la base de datos
    public boolean verificarEnBaseDeDatos() {
        // Suponiendo que tienes una clase BaseDatos con un método de verificación
        BaseDatos db = new BaseDatos();
        // Aquí debes implementar la lógica para verificar en la base de datos
        return db.verificarUsuario(this.erabiltzailea, this.pasahitza);
    }
}
