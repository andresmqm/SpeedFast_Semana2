package org.example;

import Validaciones.*;

import java.util.List;

public class PedidoComida extends Pedido implements Despachable, Cancelable, Rastreable {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + distanciaKm * 2);
    }

    // AQUI APLICAMOS LAS INTERFACES

    @Override
    public boolean despachar() {
        historial.add("Pedido comida despachado");
        return true;
    }

    @Override
    public boolean cancelar(String motivo) {
        historial.add("Pedido comida cancelado: " + motivo);
        return true;
    }

    @Override
    public List<String> verHistorial() {
        return historial;
    }
}
