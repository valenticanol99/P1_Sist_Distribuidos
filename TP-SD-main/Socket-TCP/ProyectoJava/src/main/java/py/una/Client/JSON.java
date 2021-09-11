package py.una.Client;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;
public class JSON {

    String cod_mensaje = null;
    String hora = null;
	String tipo_operacion = null;
    Object mensaje = null;
    int estado = 0;
    String hospital = null;
    String cama = null;
    public JSON() {}
	
	public JSON (String tipo_operacion, Object mensaje, int estado, String hospital, String cama)
    {
		this.cod_mensaje = "";
        this.hora = "";
	    this.tipo_operacion = tipo_operacion;
        this.mensaje = mensaje;
        this.estado = estado;
        this.hospital = hospital;
        this.cama = cama;
	}
	
	public String getCodMensaje() {
		return cod_mensaje;
	}

	public void setCodMensaje(String cod_mensaje) {
		this.cod_mensaje = cod_mensaje;
	}

    public String getHora() {
		return hora;
	}

	public void setHora (String hora) {
		this.hora = hora;
	}

    public String getTipoOperacion() {
		return tipo_operacion;
	}

	public void setTipoOperacion (String tipo_operacion) {
		this.tipo_operacion = tipo_operacion;
	}

    public String getHospital() {
		return hospital;
	}

	public void setHospital (String hospital) {
		this.hospital = hospital;
	}

    public String getCama() {
		return cama;
	}

	public void setCama (String cama) {
		this.cama = cama;
	}

    public int getEstado () {
		return estado;
	}

	public void setEstado (int estado) {
		this.estado = estado;
	}

    public Object getMensaje() {
		return mensaje;
	}

	public void setMensaje (Object mensaje) {
		this.mensaje = mensaje;
	}
/*
	public void getJSON(String s) throws ParseException {
        JSONParser p = new JSONParser();
        Object o = p.parse(s.trim());
        JSONObject j = (JSONObject) o;
        
        this.tipo_operacion = (String) j.get("tipo_operacion");
		this.mensaje = (Object) j.get("mensaje");
		this.estado = (int) j.get("estado");
		this.hospital = (String) j.get("hospital");
		this.cama = (String) j.get("cama");

    }
    */
    
    public String JSONtoString() {
    	
		JSONObject o = new JSONObject();
		

        o.put("tipo_operacion", this.tipo_operacion);
        o.put("mensaje", this.mensaje);
        o.put("estado", this.estado);
        o.put("hospital", this.hospital);
		o.put("cama", this.cama);

        return o.toJSONString();
    }
    
    public void toJSON(String JSONstring) {
    	int index_tipo_operacion = JSONstring.indexOf("tipo_operacion");
    	int index_mensaje = JSONstring.indexOf("mensaje");
    	int index_estado = JSONstring.indexOf("estado");
    	int index_hospital = JSONstring.indexOf("hospital");
    	int index_cama = JSONstring.indexOf("cama");
    	int index_fin = JSONstring.indexOf("\"}");
    	
    	// ejemplo del string {"estado":0,"mensaje":"OK","hospital":"Migone","cama":"001","tipo_operacion":"crear_cama"}
    	this.estado = Integer.parseInt(JSONstring.substring(index_estado + 8, index_mensaje - 2)) ;
    	this.mensaje = JSONstring.substring(index_mensaje + 10, index_hospital - 3);
    	this.hospital = JSONstring.substring(index_hospital + 11, index_cama - 3);
    	this.cama = JSONstring.substring(index_cama + 7, index_tipo_operacion - 3);
    	this.tipo_operacion = JSONstring.substring(index_tipo_operacion + 17, index_fin);	
    }
    
    //transforma todos los * en \n

    
}
