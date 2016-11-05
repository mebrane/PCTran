package daoi;

import java.util.List;

import javax.persistence.Query;

import daol.TipoModeloDAOL;
import model.TipoModelo;
import util.Conexion;
import model.TipoModelo;

public class TipoModeloDAOI implements TipoModeloDAOL {
Conexion cn = new Conexion();
	@Override
	public List<TipoModelo> read() throws Exception {
	cn.abrir();
		
		Query q=cn.em.createQuery("select m from TipoModelo m");
		List<TipoModelo> TipoModelos = q.getResultList();
		
		//List<TipoModelo> lista = cn.em.createQuery("select m from TipoModelo m").getResultList();
		
		// TODO Auto-generated method stub
		return TipoModelos;
	}

}
