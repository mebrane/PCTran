package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pc_tipotransporte")
public class TipoTransporte {
	
	@Id
	@SequenceGenerator(name="pc_tipotransporte_seq", allocationSize=1, initialValue=3)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pc_tipotransporte_seq")
	private int ttra_id;
	private String ttra_desc;
	@Temporal(TemporalType.DATE)
	private Date ttra_freg;
	
	public int getTtra_id() {
		return ttra_id;
	}
	public void setTtra_id(int ttra_id) {
		this.ttra_id = ttra_id;
	}
	public String getTtra_desc() {
		return ttra_desc;
	}
	public void setTtra_desc(String ttra_desc) {
		this.ttra_desc = ttra_desc;
	}
	public Date getTtra_freg() {
		return ttra_freg;
	}
	public void setTtra_freg(Date ttra_freg) {
		this.ttra_freg = ttra_freg;
	}

	
}
