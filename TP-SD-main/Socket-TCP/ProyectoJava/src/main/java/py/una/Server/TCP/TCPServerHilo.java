package py.una.Server.TCP;

import java.net.*;
import java.io.*;

public class TCPServerHilo extends Thread {

    private Socket socket = null;

    TCPMultiServer servidor;
    public HospitalJSON __program__;
    
    public TCPServerHilo(Socket socket, TCPMultiServer servidor ) {
        __program__= new HospitalJSON();
        //super("TCPServerHilo");
        this.socket = socket;
        this.servidor = servidor;
    }

    public void run() {

        try {
        	//enviamos al cliente
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            //recibimos del cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //out.println("TCPSserverHilo - connected");
            out.println("{\"estado\":0,\"mensaje\":\"OK\",\"hospital\":\"Clinicas\",\"cama\":\"000\",\"tipo_operacion\":\"confirmar_conexion\"}");
            
            // String inputLine, outputLine;
            // __program__.realizarOperacion(__program__,inputLine.toJSON());
            // out.println(outputLine.toJSONString());
            boolean cerrar_hilo = false;
            while(!cerrar_hilo) {
	            JSON inputLine , outline;
	            inputLine = new JSON();
	            String stringJSON = in.readLine();
	            inputLine.toJSON(stringJSON);
	            if(inputLine.tipo_operacion.equals("cerrar_hilo")) {
	            	cerrar_hilo = true;
	            	out.println("Bye");
	            	break;
	            	}
	            outline = __program__.realizarOperacion(__program__,inputLine);
	            out.println(outline.JSONtoString());
            }
            out.close();
            in.close();
            socket.close();
            System.out.println("Finalizando Hilo");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}