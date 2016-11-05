package daoi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import daol.TransporteDAOL;
import model.Transporte;
import util.Conexion;

public class TransporteDAOI implements TransporteDAOL {

	Conexion cn = new Conexion();
	@Override
	public void create(Transporte obj) throws Exception {
		// TODO Auto-generated method stub
		
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.persist(obj);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public List<Transporte> read() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Transporte obj) throws Exception {
		cn.abrir();
		try {
			cn.em.getTransaction().begin();
			cn.em.merge(obj);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public void delete(Transporte obj) throws Exception {
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			Transporte oTransporte=cn.em.find(Transporte.class, obj.getTran_id());
			cn.em.remove(oTransporte);
			cn.em.getTransaction().commit();
			
		} catch (Exception e) {
			cn.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public Transporte get(Transporte obj) throws Exception {
		Transporte t=null;
		cn.abrir();
		try {
			
			cn.em.getTransaction().begin();
			t=cn.em.find(Transporte.class, obj.getTran_id());
			
			cn.em.getTransaction().commit();
			
		} catch (Exception ex) {
			cn.em.getTransaction().rollback();
			System.out.println(ex.getMessage());
			// TODO: handle exception
		}
		return t;
	}

	@Override
	public List<Transporte> readByParameters(Transporte obj) throws Exception {
	
		cn.abrir();
		
		String descTransporte=obj.getTran_desc();
		descTransporte='%'+descTransporte.toLowerCase() +'%';
		

		String sentencia= "select t, "
				+"t.tipoTransporte.ttra_id, "
				+"t.marca.marc_id, "
				+"t.modelo.mode_id "
				+"from Transporte t "
				+"where lower(t.tran_desc) like :descTransporte";
		
		Query q= cn.em.createQuery(sentencia);
		
		q.setParameter("descTransporte", descTransporte);
		
		List<Object[]> lista_objetos =q.getResultList();

		List<Transporte> lista = new ArrayList<Transporte>();
		for(Object objs[]: lista_objetos){
			Transporte transporte=(Transporte) objs[0];
			lista.add(transporte);
		}

		return lista;
	}

}
