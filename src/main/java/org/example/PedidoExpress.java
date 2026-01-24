package org.example;

import Validaciones.*;

import java.util.List;

public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (distanciaKm > 5) {
            tiempo += 5;
        }
        return tiempo;
    }


    // AQUI APLICAMOS LAS INTERFACES

    @Override
    public boolean despachar() {
        historial.add("Pedido express despachado");
        return true;
    }

    @Override
    public boolean cancelar(String motivo) {
        historial.add("Pedido express cancelado: " + motivo);
        return true;
    }

    @Override
    public List<String> verHistorial() {
        return historial;
    }
}
