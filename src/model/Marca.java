package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="pc_marca")
public class Marca {
	@Id
	@SequenceGenerator(name="pc_marca_seq", allocationSize=1, initialValue=3)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pc_marca_seq")  
	private int marc_id;
	@Column(name="marc_desc")
	private String marca_desc;
	@Temporal(TemporalType.DATE)
	@Column(name="marc_freg")
	private Date marca_freg;
	public int getMarc_id() {
		return marc_id;
	}
	public void setMarc_id(int marc_id) {
		this.marc_id = marc_id;
	}
	public String getMarca_desc() {
		return marca_desc;
	}
	public void setMarca_desc(String marca_desc) {
		this.marca_desc = marca_desc;
	}
	public Date getMarca_freg() {
		return marca_freg;
	}
	public void setMarca_freg(Date marca_freg) {
		this.marca_freg = marca_freg;
	}
	
	
}
