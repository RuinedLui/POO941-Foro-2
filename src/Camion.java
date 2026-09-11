/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luise
 */
public class Camion extends Vehiculo
{

    // Atributos
    private double capacidadCarga;
    private int cantidadEjes;

    // Constructor
    public Camion (String codigo, String marca, String modelo, int anio, double precio, double capacidadCarga, int cantidadEjes)
    {
        super(codigo, marca, modelo, anio, precio);
        setCapacidadCarga(capacidadCarga);
        setCantidadEjes(cantidadEjes);
    }

    // Getters y Setters
    public double getCapacidadCarga()
    {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga)
    {
        if (capacidadCarga <= 0) {
            throw new IllegalArgumentException("La capacidad de carga debe ser mayor a 0");
        }
        this.capacidadCarga = capacidadCarga;
    }

    public int getCantidadEjes()
    {
        return cantidadEjes;
    }

    public void setCantidadEjes(int cantidadEjes)
    {
        if (cantidadEjes <= 0) {
            throw new IllegalArgumentException("La cantidad de ejes debe ser mayor a 0");
        }
        this.cantidadEjes = cantidadEjes;
    }

    // Mostrar detalles
    @Override
    public String toString()
    {
        return super.toString() + 
                "\nCapacidad de Carga: " + capacidadCarga + " Toneladas" +
                "\nCantidad de Ejes: " + cantidadEjes;
    }
}
