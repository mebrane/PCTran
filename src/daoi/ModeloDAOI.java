package daoi;

import java.util.List;

import javax.persistence.Query;

import daol.ModeloDAOL;
import model.Modelo;
import util.Conexion;

public class ModeloDAOI implements ModeloDAOL {

	Conexion cn = new Conexion();
	@Override
	public List<Modelo> read() throws Exception {
	cn.abrir();
		
		Query q=cn.em.createQuery("select m from Modelo m");
		List<Modelo> Modelos = q.getResultList();
		
		//List<Modelo> lista = cn.em.createQuery("select m from Modelo m").getResultList();
		
		// TODO Auto-generated method stub
		return Modelos;
	}

}
