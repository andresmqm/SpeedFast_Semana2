package org.example;

import Validaciones.*;

import java.util.List;

public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (20 + distanciaKm * 1.5);
    }


    // AQUI APLICAMOS LAS INTERFACES

    @Override
    public boolean despachar() {
        historial.add("Pedido encomienda despachado");
        return true;
    }

    @Override
    public boolean cancelar(String motivo) {
        historial.add("Pedido encomienda cancelado: " + motivo);
        return true;
    }

    @Override
    public List<String> verHistorial() {
        return historial;
    }
}

