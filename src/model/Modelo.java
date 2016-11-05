package model;

import java.util.Date;

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
@Table(name="pc_modelo")
public class Modelo {

	@Id
	@SequenceGenerator(name="pc_modelo_seq", allocationSize=1, initialValue=3)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pc_modelo_seq")  
	private int mode_id;
	@JoinColumn(name="tmod_id")
	@ManyToOne
	private TipoModelo tipoModelo;
	private String mode_desc;
	@Temporal(TemporalType.DATE)
	private Date mode_freg;
}
