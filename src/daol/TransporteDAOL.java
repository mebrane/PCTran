package daol;

import java.util.List;

import model.Transporte;

public interface TransporteDAOL {
	
	public abstract void create(Transporte obj) throws Exception;
	public abstract List<Transporte> read() throws Exception;
	public abstract void update(Transporte obj) throws Exception;
	public abstract void delete(Transporte obj) throws Exception;
	
	public abstract Transporte get(Transporte obj) throws Exception;
	//public abstract List<Transporte> buscarListaTransporte(Transporte obj) throws Exception;
	public abstract List<Transporte> readByParameters(Transporte obj) throws Exception;
	

}