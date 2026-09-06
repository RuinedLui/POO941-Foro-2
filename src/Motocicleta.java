public class Motocicleta extends Vehiculo {

    private int cilindraje;
    private String tipoMotocicleta;

    public Motocicleta(String codigo, String marca, String modelo, int anio, double precio,
                       int cilindraje, String tipoMotocicleta) {

        super(codigo, marca, modelo, anio, precio);

        this.cilindraje = cilindraje;
        this.tipoMotocicleta = tipoMotocicleta;
    }
    public int getCilindraje() {
    return cilindraje;
}

public void setCilindraje(int cilindraje) {
    this.cilindraje = cilindraje;
}

public String getTipoMotocicleta() {
    return tipoMotocicleta;
}

public void setTipoMotocicleta(String tipoMotocicleta) {
    this.tipoMotocicleta = tipoMotocicleta;
}
@Override
public String toString() {
    return super.toString() +
           "\nCilindraje: " + cilindraje +
           "\nTipo de motocicleta: " + tipoMotocicleta;
}
}