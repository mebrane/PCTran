package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="pc_transporte")
public class Transporte {
	
	@Id
	@SequenceGenerator(name="pc_transporte_seq", allocationSize=1, initialValue=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pc_transporte_seq")
	private int tran_id;
	@JoinColumn(name="ttra_id")
	@ManyToOne
	private TipoTransporte tipoTransporte;
	private String tran_desc;
	private double tran_cost;
	@Column(name="tran_stoc")
	private int tran_stock;
	@JoinColumn(name="mode_id")
	@ManyToOne
	private Modelo modelo;
	@JoinColumn(name="marc_id")
	@ManyToOne
	private Marca marca;
	@Temporal(TemporalType.DATE)
	private Date tran_freg;
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
	public int getTran_stock() {
		return tran_stock;
	}
	public void setTran_stock(int tran_stock) {
		this.tran_stock = tran_stock;
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
	
	
	

}
