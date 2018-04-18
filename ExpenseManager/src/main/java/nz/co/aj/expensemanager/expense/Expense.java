package nz.co.aj.expensemanager.expense;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import nz.co.aj.expensemanager.subType.SubType;
import nz.co.aj.expensemanager.type.Type;
import nz.co.aj.expensemanager.user.User;

@Entity
@Table(name="expense")
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idexpense")
	private Long idexpense;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "spent_date")
	private Date spentDate;
	
	@Column(name = "created_time")
	private Date createdTime = new Date();
	
	@OneToOne
	@JoinColumn(name = "type_idtype")
	private Type type;
	
	@OneToOne
	@JoinColumn(name = "subtype_type_idtype")
	private SubType subType;
	
	@ManyToOne
	@JoinColumn(name = "user_iduser")
	private User user;
	
	
	public Long getIdexpense() {
		return idexpense;
	}
	public void setIdexpense(Long idexpense) {
		this.idexpense = idexpense;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getSpentDate() {
		return spentDate;
	}
	public void setSpentDate(Date spentDate) {
		this.spentDate = spentDate;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public SubType getSubType() {
		return subType;
	}
	public void setSubType(SubType subType) {
		this.subType = subType;
	}
	
}
