package org.example;

import Validaciones.Despachable;

import java.util.List;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaCarga zonaCarga;

    public Repartidor(String nombre, ZonaCarga zonaCarga) {
        this.nombre = nombre;
        this.zonaCarga = zonaCarga;
    }


    //----SEMANA4----//

   // @Override
    //public void run() {
      //  System.out.println("Repartidor " + nombre + " inicia entregas");

        //for (Pedido pedido : pedidos) {
          //  try {
            //    System.out.println(nombre + " entregando pedido " + pedido.idPedido);
              //  pedido.asignarRepartidor(nombre);

//                int tiempo = pedido.calcularTiempoEntrega();
  //              Thread.sleep(5000);

//                if (pedido instanceof Despachable despachable) {
  //                  despachable.despachar();
    //            }

      //          System.out.println("Pedido " + pedido.idPedido + " entregado");

        //    } catch (InterruptedException e) {
          //      System.out.println("Repartidor interrumpido");

            //}

          //  System.out.println("Repartidor " + nombre + " finalizo");
       // }

   // }


    //----SEMANA5----//

    public void run() {
        System.out.println("Repartidor " + nombre + " inicia entregas");

        while (true) {
            Pedido pedido = zonaCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            try {
                pedido.asignarRepartidor(nombre);
                Thread.sleep(5000);

                if (pedido instanceof Despachable despachable) {
                    despachable.despachar();
                }

                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("Pedido " + pedido.getIdPedido()
                        + " entregado por " + nombre);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Repartidor " + nombre + " finalizó");
    }
}

