package org.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        PedidoEncomienda pedidoEncomienda2 = new PedidoEncomienda(
                35478,
                "Santiago Centro",
                8.7
        );

        PedidoComida pedidoComida2 = new PedidoComida(
                66687,
                "La Florida",
                6.3
        );

        //-------------SEMANA 4-------------//
        //----APLICAMOS HILOS----//

        //List<Pedido>  pedidosAna = List.of(pedidoComida);
       // List<Pedido>  pedidosCarla = List.of(pedidoEncomienda);
       // List<Pedido>  pedidosRebeca = List.of(pedidoExpress);

       // Repartidor repartidor1 = new Repartidor(
        //        "Ana", pedidosAna
       // );

       // Repartidor repartidor2 = new Repartidor(
       //         "Carla", pedidosCarla
       // );
       // Repartidor repartidor3 = new Repartidor(
       //         "Rebeca", pedidosRebeca
       // );

       // ExecutorService executor =
       //        Executors.newFixedThreadPool(3);

       // executor.execute(repartidor1);
        //executor.execute(repartidor2);
        //executor.execute(repartidor3);

        //executor.shutdown();

        //----SEMANA 5----//

        ZonaCarga zonaCarga = new ZonaCarga();

        zonaCarga.agregarPedido(pedidoComida);
        zonaCarga.agregarPedido(pedidoComida2);
        zonaCarga.agregarPedido(pedidoEncomienda);
        zonaCarga.agregarPedido(pedidoEncomienda2);
        zonaCarga.agregarPedido(pedidoExpress);

        Repartidor r1 = new Repartidor("Ana", zonaCarga);
        Repartidor r2 = new Repartidor("Carla", zonaCarga);
        Repartidor r3 = new Repartidor("Rebeca", zonaCarga);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        }catch (InterruptedException e){
            System.out.println("Error");
            Thread.currentThread().interrupt();
        }

        System.out.println("Todos los pedidos han sido entregados exitosamente");

    }
}



        //------SEMANA ANTERIORES----//
        //---VERSION SIN CONCURRENCIA--//
        //---DEMOSSTRABAMOS HERENCIA, POLIFORMISMO,INTERFACES---//


        // System.out.println("[Pedido Comida]");
        //pedidoComida.asignarRepartidor("Juan Pérez");
       // pedidoComida.mostrarResumen();
        //System.out.println("Tiempo estimado de entrega: "
          //      + pedidoComida.calcularTiempoEntrega() + " minutos");
        //pedidoComida.despachar();
       // System.out.println("\n");

       // System.out.println("[Pedido Encomienda]");
       // pedidoEncomienda.asignarRepartidor("Carla Aguirre");
       // pedidoEncomienda.mostrarResumen();
        //System.out.println("Tiempo estimado de entrega: "
          //      + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        //pedidoEncomienda.cancelar("Cliente no se encontraba en domicilio");
       // System.out.println("\n");

       // System.out.println("[Pedido Express]");
       // pedidoExpress.asignarRepartidor("María Soto");
       // pedidoExpress.mostrarResumen();
       // System.out.println("Tiempo estimado de entrega: "
        //        + pedidoExpress.calcularTiempoEntrega() + " minutos");
       // pedidoExpress.despachar();

        //AQUI MOSTRAMOS LOS HISTORIALES

       // System.out.println("\n[Historial Pedido Comida]");
       // pedidoComida.verHistorial().forEach(System.out::println);

       // System.out.println("\n[Historial Pedido Encomienda]");
       // pedidoEncomienda.verHistorial().forEach(System.out::println);

       // System.out.println("\n[Historial Pedido Express]");
        //pedidoExpress.verHistorial().forEach(System.out::println);