package bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import model.Marca;
import model.Modelo;
import model.TipoTransporte;
import model.Transporte;
import serv.MarcaServ;
import serv.ModeloServ;
import serv.TipoTransporteServ;
import serv.TransporteServ;

@ManagedBean
@SessionScoped
public class TransporteBean {
private int tran_id;
private TipoTransporte tipoTransporte;
private String tran_desc;
private double tran_cost;
private int tran_stoc;
private Modelo modelo;
private Marca marca;
private Date tran_freg;

TransporteServ oTransporteServ = new TransporteServ();
ModeloServ oModeloServ = new ModeloServ();
MarcaServ oMarcaServ = new  MarcaServ();
TipoTransporteServ oTipoTransporteServ = new TipoTransporteServ();


private List<Modelo> listaModelos;
private List<Marca> listaMarcas;
private List<TipoTransporte> listaTiposTransporte;
private List<Transporte> listaTransportes;
private int listaTransportesTamano;

private boolean sw_edit;
private int fila_seleccionada;


public void llenarCombos() throws Exception{
	listaModelos= oModeloServ.read();
	listaMarcas=oMarcaServ.read();
	listaTiposTransporte=oTipoTransporteServ.read();
}

public boolean accion_insertar() throws Exception{
	sw_edit=false;
	llenarCombos();
	return sw_edit;
}

public boolean accion_editar() throws Exception{
	sw_edit=true;
	llenarCombos();
	return sw_edit;
}


private Transporte get(){
	Transporte oTransporte = new Transporte();
	oTransporte.setTran_desc(getTran_desc());
	oTransporte.setTran_cost(tran_cost);
	oTransporte.setTran_stock(tran_stoc);
	oTransporte.setModelo(modelo);
	oTransporte.setMarca(marca);
	oTransporte.setTran_freg(tran_freg);
	oTransporte.setTipoTransporte(tipoTransporte);
	
	return oTransporte;

}
public void limpiar(){
	
	setTran_id(0);
	setTran_desc(null);
	setTran_stoc(0);
	setTran_cost(0);
	setModelo(new Modelo());
	setMarca(new Marca());
	setTran_freg(null);
	setTipoTransporte(new TipoTransporte());
	
}

public void insertar() throws Exception{
	
	Transporte oTransporte=get();
	//oTransporte.setTran_id(tran_id);
	Thread.sleep(4500);
	oTransporteServ.create(oTransporte);
	limpiar();
}

public void seleccionar(ActionEvent e) throws Exception
{
	String fila=e.getComponent().getAttributes().get("atributo_id").toString();
	System.out.println(fila);
	fila_seleccionada=Integer.parseInt(fila);
}

public void obtener_datos(ActionEvent e) throws Exception{
	seleccionar(e);
	accion_editar();
	Transporte t = new Transporte();
	t.setTran_id(fila_seleccionada);
	Transporte t2=oTransporteServ.get(t);
	setTran_id(t2.getTran_id());
	setTipoTransporte(t2.getTipoTransporte());
	setTran_desc(t2.getTran_desc());
	setTran_cost(t2.getTran_cost());
	setTran_stoc(t2.getTran_stock());
	setModelo(t2.getModelo());
	setMarca(t2.getMarca());
	setTran_freg(t2.getTran_freg());
	
}

public void modificar() throws Exception{
	Transporte oTransporte= new Transporte();
	oTransporte=get();
	oTransporte.setTran_id(tran_id);
	Thread.sleep(4500);
	oTransporteServ.update(oTransporte);
}



public void busqueda() throws Exception{
	Transporte t = new Transporte();
	t.setTran_desc(tran_desc);
	listaTransportes=oTransporteServ.readByParameters(t);
	listaTransportesTamano=listaTransportes.size();
	
	
}


public void borrar() throws Exception{
	Transporte oTransporte = new Transporte();
	oTransporte.setTran_id(fila_seleccionada);
	oTransporteServ.delete(oTransporte);
	busqueda();
	limpiar();
}

public int getTran_id() {
	return tran_id;
}
public void setTran_id(int tran_id) {
	this.tran_id = tran_id;
}
public TipoTransporte getTipoTransporte() {
	return tipoTransporte;
}
public void setTipoTransporte(TipoTransporte tipoTransporte) {
	this.tipoTransporte = tipoTransporte;
}
public String getTran_desc() {
	return tran_desc;
}
public void setTran_desc(String tran_desc) {
	this.tran_desc = tran_desc;
}
public double getTran_cost() {
	return tran_cost;
}
public void setTran_cost(double tran_cost) {
	this.tran_cost = tran_cost;
}
public int getTran_stoc() {
	return tran_stoc;
}
public void setTran_stoc(int tran_stoc) {
	this.tran_stoc = tran_stoc;
}
public Modelo getModelo() {
	return modelo;
}
public void setModelo(Modelo modelo) {
	this.modelo = modelo;
}
public Marca getMarca() {
	return marca;
}
public void setMarca(Marca marca) {
	this.marca = marca;
}
public Date getTran_freg() {
	return tran_freg;
}
public void setTran_freg(Date tran_freg) {
	this.tran_freg = tran_freg;
}




public TransporteServ getoTransporteServ() {
	return oTransporteServ;
}

public void setoTransporteServ(TransporteServ oTransporteServ) {
	this.oTransporteServ = oTransporteServ;
}

public ModeloServ getoModeloServ() {
	return oModeloServ;
}

public void setoModeloServ(ModeloServ oModeloServ) {
	this.oModeloServ = oModeloServ;
}

public MarcaServ getoMarcaServ() {
	return oMarcaServ;
}

public void setoMarcaServ(MarcaServ oMarcaServ) {
	this.oMarcaServ = oMarcaServ;
}

public TipoTransporteServ getoTipoTransporteServ() {
	return oTipoTransporteServ;
}

public void setoTipoTransporteServ(TipoTransporteServ oTipoTransporteServ) {
	this.oTipoTransporteServ = oTipoTransporteServ;
}

public List<Modelo> getListaModelos() {
	return listaModelos;
}

public void setListaModelos(List<Modelo> listaModelos) {
	this.listaModelos = listaModelos;
}

public List<Marca> getListaMarcas() {
	return listaMarcas;
}

public void setListaMarcas(List<Marca> listaMarcas) {
	this.listaMarcas = listaMarcas;
}

public List<TipoTransporte> getListaTiposTransporte() {
	return listaTiposTransporte;
}

public void setListaTiposTransporte(List<TipoTransporte> listaTiposTransporte) {
	this.listaTiposTransporte = listaTiposTransporte;
}

public List<Transporte> getListaTransportes() {
	return listaTransportes;
}

public void setListaTransportes(List<Transporte> listaTransportes) {
	this.listaTransportes = listaTransportes;
}

public int getListaTransportesTamano() {
	return listaTransportesTamano;
}

public void setListaTransportesTamano(int listaTransportesTamano) {
	this.listaTransportesTamano = listaTransportesTamano;
}

public boolean isSw_edit() {
	return sw_edit;
}

public void setSw_edit(boolean sw_edit) {
	this.sw_edit = sw_edit;
}

public int getFila_seleccionada() {
	return fila_seleccionada;
}

public void setFila_seleccionada(int fila_seleccionada) {
	this.fila_seleccionada = fila_seleccionada;
}

@PostConstruct
public void init() {
	modelo = new Modelo();
	tipoTransporte= new TipoTransporte();
	marca = new Marca();
}



}
