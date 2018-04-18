package nz.co.aj.expensemanager.type;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import nz.co.aj.expensemanager.subType.SubType;

@Entity
@Table(name="TYPE")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idtype")
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtype")
	private Long idtype;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="createdTime")
	private Date createdTime = new Date();
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "type",
            orphanRemoval = true)
    private Set<SubType> subTypes = new HashSet<>();
	
	
	public Long getIdtype() {
		return idtype;
	}
	
	public void setIdtype(Long idtype) {
		this.idtype = idtype;
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
	
	public Date getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public Set<SubType> getSubTypes() {
		return subTypes;
	}
	
	public void setSubTypes(Set<SubType> subTypes) {
		this.subTypes = subTypes;
	}

}
