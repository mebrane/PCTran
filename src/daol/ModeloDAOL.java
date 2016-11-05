package daol;

import java.util.List;

import model.Modelo;

public interface ModeloDAOL  {

	public abstract List<Modelo> read() throws Exception;
}