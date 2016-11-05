package daoi;

import java.util.List;

import javax.persistence.Query;

import daol.TipoTransporteDAOL;
import model.TipoTransporte;
import util.Conexion;
import model.TipoTransporte;

public class TipoTransporteDAOI implements TipoTransporteDAOL {

	Conexion cn = new Conexion();
	@Override
	public List<TipoTransporte> read() throws Exception {
	cn.abrir();
		
		Query q=cn.em.createQuery("select m from TipoTransporte m");
		List<TipoTransporte> TipoTransportes = q.getResultList();
	
		return TipoTransportes;
	}

}
