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
@Table(name="pc_tipomodelo")
public class TipoModelo {
	
	@Id
	@SequenceGenerator(name="pc_tipomodelo_seq", allocationSize=1, initialValue=3)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pc_tipomodelo_seq")
	private int tmod_id;
	private String tmod_desc;
	@Temporal(TemporalType.DATE)
	private Date tmod_freg;
	public int getTmod_id() {
		return tmod_id;
	}
	public void setTmod_id(int tmod_id) {
		this.tmod_id = tmod_id;
	}
	public String getTmod_desc() {
		return tmod_desc;
	}
	public void setTmod_desc(String tmod_desc) {
		this.tmod_desc = tmod_desc;
	}
	public Date getTmod_freg() {
		return tmod_freg;
	}
	public void setTmod_freg(Date tmod_freg) {
		this.tmod_freg = tmod_freg;
	}
	
	
	

}
