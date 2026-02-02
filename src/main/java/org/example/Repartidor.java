package org.example;

import Validaciones.Despachable;

import java.util.List;

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidos;

    public Repartidor(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    @Override
    public void run() {
        System.out.println("Repartidor " + nombre + " inicia entregas");

        for (Pedido pedido : pedidos) {
            try {
                System.out.println(nombre + " entregando pedido " + pedido.idPedido);
                pedido.asignarRepartidor(nombre);

                int tiempo = pedido.calcularTiempoEntrega();
                Thread.sleep(5000);

                if (pedido instanceof Despachable despachable) {
                    despachable.despachar();
                }

                System.out.println("Pedido " + pedido.idPedido + " entregado");

            } catch (InterruptedException e) {
                System.out.println("Repartidor interrumpido");

            }

            System.out.println("Repartidor " + nombre + " finalizo");
        }

    }
}

