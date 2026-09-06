// Subclase Automovil
public class Automovil extends Vehiculo {
    private int cantidadPuertas;
    private String tipoCombustible;

    public Automovil(String marca, String modelo, int anio, int cantidadPuertas, String tipoCombustible) {
        super(marca, modelo, anio);
        this.cantidadPuertas = cantidadPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cantidad de puertas: " + cantidadPuertas);
        System.out.println("Tipo de combustible: " + tipoCombustible);
    }
    
}
