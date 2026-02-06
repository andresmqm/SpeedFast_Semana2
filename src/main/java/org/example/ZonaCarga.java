package org.example;

import java.util.LinkedList;
import java.util.List;

public class ZonaCarga {

    private final List<Pedido>pedidos;

    public ZonaCarga() {
        this.pedidos = new LinkedList<>();
        System.out.println("Zona Carga Iniciada ");
    }

    public synchronized void agregarPedido(Pedido p) {
        pedidos.add(p);
        System.out.println("Agregando pedido ID: " + p.getIdPedido() +
                " | Con el Destino " + p.getDireccionEntrega());
    }

        public synchronized Pedido retirarPedido(){
        if (pedidos.isEmpty()){
            System.out.println("Pedido no encontrado ");
            return null;

        }
        Pedido p = pedidos.remove(0);
            p.setEstado(EstadoPedido.EN_REPARTO);
            System.out.println("Pedido ID:  " + p.getIdPedido() +
                    " | Estado: EN REPARTO ");
            return p;

        }

        public synchronized boolean estaVacio(){
        return pedidos.isEmpty();
        }
}
