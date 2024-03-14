package com.example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "data_model")
public class DataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String datetime;
    private int deviceID;
    private int functionName;
    private String name;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "variable_id", referencedColumnName = "id")
    private Variable variable;

   

	public DataModel() {
		super();
	}



	public DataModel(Long id, String datetime, int deviceID, int functionName, String name, String password,
			Variable variable) {
		super();
		this.id = id;
		this.datetime = datetime;
		this.deviceID = deviceID;
		this.functionName = functionName;
		this.name = name;
		this.password = password;
		this.variable = variable;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDatetime() {
		return datetime;
	}



	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}



	public int getDeviceID() {
		return deviceID;
	}



	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}



	public int getFunctionName() {
		return functionName;
	}



	public void setFunctionName(int functionName) {
		this.functionName = functionName;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Variable getVariable() {
		return variable;
	}



	public void setVariable(Variable variable) {
		this.variable = variable;
	}



	@Override
	public String toString() {
		return "DataModel [id=" + id + ", datetime=" + datetime + ", deviceID=" + deviceID + ", functionName="
				+ functionName + ", name=" + name + ", password=" + password + ", variable=" + variable + "]";
	}
	
	
    

    // Getters and setters

    // toString method
}
