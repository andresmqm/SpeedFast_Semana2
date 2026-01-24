package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {

    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidor;
    protected List<String> historial;

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidor = "Sin asignar";
        this.historial = new ArrayList<>();
    }

    //  AQUI APLICAMOS LA SOBRECARGA FALTANTE

    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
        historial.add("Repartidor asignado: " + nombre);
    }

    // AQUI APLICAMOS LA SOBREESCRITURA FALTANTE

    public void asignarRepartidor() {
        this.repartidor = "Repartidor automático";
        historial.add("Repartidor asignado automáticamente");
    }


    // AQUI APLICAMOS EL METODO

    public void mostrarResumen() {
        System.out.println("ID Pedido: " + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor: " + repartidor);
    }

    public abstract int calcularTiempoEntrega();
}
