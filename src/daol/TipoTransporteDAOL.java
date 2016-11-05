package daol;

import java.util.List;

import model.TipoTransporte;

public interface TipoTransporteDAOL {

	public abstract List<TipoTransporte> read() throws Exception;
}