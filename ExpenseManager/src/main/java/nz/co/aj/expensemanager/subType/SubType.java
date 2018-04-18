package nz.co.aj.expensemanager.subType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import nz.co.aj.expensemanager.type.Type;

@Entity
@Table( name ="sub_type")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idsubtype")
public class SubType {
	
	@Id
	@Column(name="idsubtype")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idsubtype;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idtype", nullable = false)
	private Type type;
	
	public Long getIdsubtype() {
		return idsubtype;
	}
	public void setIdsubtype(Long idsubtype) {
		this.idsubtype = idsubtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	

}
