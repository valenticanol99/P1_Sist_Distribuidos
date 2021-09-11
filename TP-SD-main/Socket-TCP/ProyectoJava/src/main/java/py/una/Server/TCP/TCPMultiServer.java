package py.una.Server.TCP;

import java.util.*;
import java.net.*;
import java.io.*;

public class TCPMultiServer {

    //variables compartidas
    boolean listening = true;
    List<TCPServerHilo> hilosClientes;
    List<String> usuarios;

    public TCPMultiServer() throws IOException {
        hilosClientes = new ArrayList<>();
        usuarios = new ArrayList<>();
        ejecutar();
    }

    public void ejecutar() throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("No se puede abrir el puerto: 4444.");
            System.exit(1);
        }
        System.out.println("Puerto abierto: 4444.");

        while (listening) {

            TCPServerHilo hilo = new TCPServerHilo(serverSocket.accept(), this);
            hilosClientes.add(hilo);
            hilo.start();
        }

        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {

        TCPMultiServer tms = new TCPMultiServer();
    }
}
