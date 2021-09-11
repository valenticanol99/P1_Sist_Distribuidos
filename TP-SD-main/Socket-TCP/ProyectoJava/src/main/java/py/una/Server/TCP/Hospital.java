package py.una.Server.TCP;

import java.util.ArrayList;
import java.util.List;


public class Hospital {

	String cod_hospital;
	List <Cama> listado_camas;
	
	public Hospital(){
		listado_camas = new ArrayList<>();
	}

	public Hospital(String cod_hospital){

		this.cod_hospital = cod_hospital;
		listado_camas = new ArrayList<>();
	}
	
	public String getCodHospital() {
		return cod_hospital;
	}

	public void setCodHospital(String cod_hospital) {
		this.cod_hospital = cod_hospital;
	}

	public Cama getCama (String cod_cama)
    {
		if (findCama(cod_cama))
		{
			for (Cama item: listado_camas)
			{
				if (item.getCodCama().equals(cod_cama))
				{
					return item;
				}
			}
		}
		
        return null;
    }

	public boolean findCama (String cod_cama)
    {
        for (Cama item: listado_camas)
        {
            if (item.getCodCama().equals(cod_cama))
            {
                return true;
            }
        }
        return false;
    }

    public void addNewCama (String cod_cama){

		if (!findCama(cod_cama))
		{
			System.out.println("Insertando camas (hospital)");
			Cama c = new Cama (cod_cama);
			this.listado_camas.add(c);
		}
		else
		{
			throw new HospitalException ("ERROR: Cama existente");
		}
			
    }

	public void removeCama (String cod_cama){

		if (findCama(cod_cama))
		{

			Cama c = getCama(cod_cama);
			if (c.getOcupacion()==0)
			{
				System.out.println("Eliminar cama");
				listado_camas.remove(c);
			}
			else
			{
				throw new HospitalException ("ERROR: Cama ocupada");
			}

		}
		else
		{
			throw new HospitalException ("ERROR: Cama no existente");
		}
    }


	public void ocuparCama (String cod_cama){

		if (findCama(cod_cama))
		{

			Cama c = getCama(cod_cama);
			if (c.getOcupacion()==0)
			{
				c.setOcupacion(1);
			}
			else
			{
				throw new HospitalException ("ERROR: Cama ocupada");
			}

		}
		else
		{
			throw new HospitalException ("ERROR: Cama no existente");
		}
		
    }

	public void desocuparCama (String cod_cama){

		if (findCama(cod_cama))
		{

			Cama c = getCama(cod_cama);
			if (c.getOcupacion()==1)
			{
				c.setOcupacion(0);
			}
			else
			{
				throw new HospitalException ("ERROR: Cama desocupada");
			}

		}
		else
		{
			throw new HospitalException ("ERROR: Cama no existente");
		}
    }

	public String getListadoCamas()
	{
		String list = "";

		//al enviar con \n no imprime correctamente, por lo que puse * y luego en JSON reemplazo el * con \n
		for (Cama item: listado_camas)
		{
			list = list + " Codigo Cama: " +item.getCodCama() + " - Ocupacion: " + item.getOcupacion() + "<br>";
		}
		return (list);
	}

}
