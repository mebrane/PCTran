package daol;

import java.util.List;

import model.Marca;

public interface MarcaDAOL {
	
	
	public abstract List<Marca> read() throws Exception;

}