package daoi;

import java.util.List;

import javax.persistence.Query;

import daol.MarcaDAOL;
import model.Marca;
import util.Conexion;

public class MarcaDAOI  implements MarcaDAOL{
	Conexion cn = new Conexion();
	
	@Override
	public List<Marca> read() throws Exception {
		cn.abrir();
		
		Query q=cn.em.createQuery("select m from Marca m");
		List<Marca> marcas = q.getResultList();
		
		//List<Marca> lista = cn.em.createQuery("select m from Marca m").getResultList();
		
		// TODO Auto-generated method stub
		return marcas;
	}
}
