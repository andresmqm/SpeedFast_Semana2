package org.example;

public class Main {
    public static void main(String[] args) {


        PedidoComida pedidoComida = new PedidoComida(
                111,
                "Los alerces 8541",
                8
        );

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(
                98745,
                "Zañartu 369",
                2.7
        );

        PedidoExpress pedidoExpress = new PedidoExpress(
                321456,
                "Portugal 3541",
                6
        );

        System.out.println("[Pedido Comida]");
        pedidoComida.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "
                + pedidoComida.calcularTiempoEntrega() + " minutos");
        System.out.println("\n");

        System.out.println("[Pedio Encomienda]");
        pedidoEncomienda.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "
                + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        System.out.println("\n");

        System.out.println("[Pedido Express]");
        pedidoExpress.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: "
                + pedidoExpress.calcularTiempoEntrega() + " minutos");
    }
}

