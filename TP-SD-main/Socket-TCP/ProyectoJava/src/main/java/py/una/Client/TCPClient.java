package py.una.Client;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.net.*;
public class TCPClient {
    NewJFrame screen;

    TCPClient() {
        screen = new NewJFrame();
        screen.setVisible(true);
    }
    public void logger(String ip1, String ip2, int tipo_operacion) throws IOException {
        String texto = (LocalDateTime.now() + ", origen(" + InetAddress.getLocalHost() +":"+ip1+ "), destino(" + InetAddress.getLocalHost() +":"+ip2 + "), tipo_operacion:" + tipo_operacion+"\n");
        File file = new File("src/main/java/py/una/Server/log.txt");
        FileWriter fr = new FileWriter(file, true);
        fr.write(texto);
        fr.close();
    }
    public static void main(String[] args) throws IOException {
        TCPClient t = new TCPClient();
        Socket unSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            unSocket = new Socket("localhost", 4444);
            // enviamos nosotros
            out = new PrintWriter(unSocket.getOutputStream(), true);

            // viene del servidor
            in = new BufferedReader(new InputStreamReader(unSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error de I/O en la conexion al host. EDICIÓN TEXTO PLANO DENTRO DE CLIENT PARA EL P1");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        int fromUser;
        String tipo_operacion = null;
        int hospital_int = 0;
        String cama = "000";
        JSON from_server_JSON = new JSON();
        String hospitales[] = { "Clinicas", "Materno", "Migone", "IPS" };
        JSON outline;

        while (t.screen.stop == 0) {
            fromServer = in.readLine();
            from_server_JSON.toJSON(fromServer);

            boolean a = false;
            System.out.println("Esperando Respuesta desde Interfaz");
            while (!a) {
                a = t.screen.newOperation;
                System.out.println(a);
            }
            fromUser = t.screen.operation;

            System.out.println(fromUser);
            switch (fromUser) {
                case 0:
                    tipo_operacion = "crear_cama";
                    while (!t.screen.exito) {
                        System.out.println("esperando");
                    }
                    hospital_int = t.screen.getHospital();
                    cama = t.screen.getCama();
                    t.logger("4444","6969",0);
                    break;
                case 1:
                    tipo_operacion = "eliminar_cama";
                    while (!t.screen.exito) {
                        System.out.println("esperando");
                    }
                    hospital_int = t.screen.getHospital();
                    cama = t.screen.getCama();
                    t.logger("4444","6969",1);
                    break;
                case 2:
                    tipo_operacion = "ver_estado_camas";
                    
                    
                    while (!t.screen.exito) {
                        System.out.println("Esperando Respuesta desde Interfaz");
                    }
                    hospital_int = t.screen.hospital;
                    // ==================
                    outline = new JSON(tipo_operacion, "OK", 0, hospitales[hospital_int], cama);
                    out.println(outline.JSONtoString());
                    fromServer = in.readLine();
                    from_server_JSON.toJSON(fromServer);
                    t.screen.listaCama = from_server_JSON.getCama();

                    // ==================
                    t.logger("4444","6969",2);
                    break;
                    
                case 3:
                    tipo_operacion = "ver_estado_hospitales_camas";
                    // ==================

                    // ==================
                    break;
                case 4:
                    tipo_operacion = "ocupar_cama";
                    while (!t.screen.exito) {
                        System.out.println("esperando");
                    }
                    hospital_int = t.screen.getHospital();
                    cama = t.screen.getCama();
                    t.logger("4444","6969",4);
                    break;                    
                case 5:
                    tipo_operacion = "desocupar_cama";
                    while (!t.screen.exito) {

                        System.out.println("Servidor:");
                    }
                    System.out.println("Codigo de la cama");
                    cama = t.screen.getCama();
                    t.logger("4444","6969",5);
                    break;
                case 6:
                    tipo_operacion = "cerrar_hilo";
                    break;
                default:
                    System.out.println("Operacion invalida");
                    tipo_operacion = null;
                    break;
            }
            System.out.println("Cliente: " + fromUser + "\nOperacion: " + tipo_operacion);

            // escribimos al servidor
            if (tipo_operacion != null) {
                // JSON outline;
                outline = new JSON(tipo_operacion, "OK", 0, hospitales[hospital_int], cama);
                out.println(outline.JSONtoString());
            }
            
        }

        out.close();
        in.close();
        stdIn.close();
        unSocket.close();
    }
    
 
    
}
