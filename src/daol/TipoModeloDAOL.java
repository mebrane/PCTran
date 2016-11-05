package daol;

import java.util.List;

import model.TipoModelo;

public interface TipoModeloDAOL {

	public abstract List<TipoModelo> read() throws Exception;
}