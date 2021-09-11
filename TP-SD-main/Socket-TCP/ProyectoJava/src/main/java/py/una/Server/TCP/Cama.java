package py.una.Server.TCP;

public class Cama {

	String cod_cama;
	int ocupacion;
	
	public Cama (String cod_cama){
		this.cod_cama = cod_cama;
		this.ocupacion = 0;
	}
	
	public String getCodCama() {
		return cod_cama;
	}

	public void setCodCama(String cod_cama) {
		this.cod_cama = cod_cama;
	}

	public int getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(int ocupacion) {
		this.ocupacion = ocupacion;
	}

}
