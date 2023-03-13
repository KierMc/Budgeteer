package com.kiernan.budgetapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=2, max=255, message="Expense name must be between 2 and 255 characters!")
	private String name;
	
	@Min(value=0, message="Amount must be greater than 0!")
	@NotNull
	private Double amount;
	
	@NotEmpty
	@Size(min=2, max=255, message="Type must be between 2 and 255 characters!")
	private String type;
	
	@NotEmpty
	@Size(min=2, max=255, message="Frequency must be between 2 and 255 characters!")
	private String freq;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User account;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    
    //constructor
	public Expense() {}
	
	
	//Getters and Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getFreq() {
		return freq;
	}


	public void setFreq(String freq) {
		this.freq = freq;
	}


	public User getAccount() {
		return account;
	}


	public void setAccount(User account) {
		this.account = account;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	//Other Methods
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
