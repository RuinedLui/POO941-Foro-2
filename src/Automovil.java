/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luise
 */
public class Automovil extends Vehiculo {
    private int cantidadPuertas;
    private String tipoCombustible;

    public Automovil(String codigo, String marca, String modelo, int anio, double precio,
                     int cantidadPuertas, String tipoCombustible) {
        super(codigo, marca, modelo, anio, precio);
        this.cantidadPuertas = cantidadPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCantidad de puertas: " + cantidadPuertas +
                "\nTipo de combustible: " + tipoCombustible;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
