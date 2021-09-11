package py.una.Server.TCP;

import java.util.ArrayList;
import java.util.List;

public  class HospitalJSON {

	static List <Hospital> listado_hospital;
    static List <JSON> listado_mensaje;
	
	public HospitalJSON(){

		listado_hospital = new ArrayList<>();
        listado_mensaje = new ArrayList<>();

        Hospital h1 = new Hospital ("Clinicas");
        listado_hospital.add(h1);

        Hospital h2 = new Hospital ("Materno");
        listado_hospital.add(h2);

        Hospital h3 = new Hospital ("Migone");
        listado_hospital.add(h3);

        Hospital h4 = new Hospital ("IPS");
        listado_hospital.add(h4);
	}

    public Hospital getHospital (String cod_hospital)
    {
        if (findHospital(cod_hospital))
        {
            for (Hospital item: listado_hospital)
            {
                if (item.getCodHospital().equals(cod_hospital))
                {
                    return item;
                }
            }
        }
        else
        {
            throw new HospitalException ("ERROR: Hospital no existente");
        }
        return null;
        
    }

    static public String getHospitalesYCamas ()
    {
    	String hospitales_camas = "";

        for (Hospital item: listado_hospital)
        {
            //System.out.println(" ---> Hospital: " + item.getCodHospital() + "\n" +item.getListadoCamas()) ;
        	//al enviar con \n no imprime correctamente, por lo que puse * y luego en JSON reemplazo lo * con \n
        	hospitales_camas = hospitales_camas + " ---> Hospital: " + item.getCodHospital() + "<br>" +item.getListadoCamas() ;
        }
        return (hospitales_camas);
    }

    static public void getListadoMensaje ()
    {

        for (JSON item: listado_mensaje)
        {
            System.out.println(" { tipo_operacion: " + item.getTipoOperacion() + "\n" 
                + "Mensaje: " + item.getMensaje() + "\n"
                + "Estado: " + item.getEstado() + "\n"
                + "Hospital: " + item.getHospital() + "\n"
                + "Cama: " + item.getCama() + " }") ;
        }
    }

    public boolean findHospital (String cod_hospital)
    {
        for (Hospital item: listado_hospital)
        {
            if (item.getCodHospital().equals(cod_hospital))
            {
                return true;
            }
        }
        return false;
    }

    public JSON realizarOperacion(HospitalJSON program, JSON mensajeJSON)
	{

	    String tipo_operacion = mensajeJSON.getTipoOperacion();
        Object mensaje = mensajeJSON.getMensaje();
        int estado = mensajeJSON.getEstado();
        String hospital = mensajeJSON.getHospital();
        String cama = mensajeJSON.getCama();
        
            try 
            {
                switch (tipo_operacion) 
                {
                    case "crear_cama":
                        program.getHospital(hospital).addNewCama(cama);
                        estado = 0;
                        mensaje = "0K";
                        break;
                    case "eliminar_cama":
                        program.getHospital(hospital).removeCama(cama);
                        estado =0;
                        mensaje = "0K";
                        break;
                    case "ocupar_cama":
                        program.getHospital(hospital).ocuparCama(cama);
                        estado = 0;
                        mensaje = "0K";
                        break;
                    case "desocupar_cama":
                        program.getHospital(hospital).desocuparCama(cama);
                        estado = 0;
                        mensaje = "0K";
                        break;
                    case "ver_estado_camas":
                     	cama = ("<html>"+program.getHospital(hospital).getListadoCamas());
                     	estado=0;
                        mensaje = "0K";
                        break;
                    case "ver_estado_hospitales_camas":
                    	
                        cama = ("<html>"+getHospitalesYCamas());
                        estado = 0;
                        mensaje = "0K";
                        break;
                    
                    default:
                        estado = -1;
                        mensaje = "Operacion no valida";
                        break;
                }

            } catch (Exception e) 
            {
                
                estado = 1;
                mensaje = e;

                JSON m = new JSON (tipo_operacion, mensaje, estado, hospital, cama);
                listado_mensaje.add(m); 
                return m;
            }

            JSON m = new JSON (tipo_operacion, mensaje, estado, hospital, cama);
            listado_mensaje.add(m); 
            return m;	
	}

}
