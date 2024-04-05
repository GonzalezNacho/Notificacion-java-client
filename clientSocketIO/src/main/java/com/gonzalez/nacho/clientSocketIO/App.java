package com.gonzalez.nacho.clientSocketIO;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;


/**
 * Cliente de socket io
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	try {
            // Conectar al servidor Socket.IO
            Socket socket = IO.socket("http://localhost:3000");

            // Escuchar eventos desde el servidor
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    System.out.println("Conectado al servidor");
                }
            }).on("message", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    String titulo = (String) args[0];
                    String mensaje = (String) args[1];
                    System.out.println("Titulo: " + titulo);
                    System.out.println("Mensaje del servidor: " + mensaje);
                    Ventana ventana = new Ventana(titulo, mensaje);
                    ventana.mostrarVentana();
                    try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                    ventana.ocultarVentana();
                }
            });

            // Conectar al servidor
            socket.connect();

            // Esperar unos segundos antes de desconectar
            //Thread.sleep(5000);

            // Desconectar del servidor
            //socket.disconnect();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
