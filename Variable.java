package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "variable_table")
public class Variable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String flags;
    private String unit;
    private String variableValue;
    private String variableName;
    private String value;
	public Variable() {
		super();
	}
	public Variable(Long id, String flags, String unit, String variableValue, String variableName, String value) {
		super();
		this.id = id;
		this.flags = flags;
		this.unit = unit;
		this.variableValue = variableValue;
		this.variableName = variableName;
		this.value = value;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getVariableValue() {
		return variableValue;
	}
	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}
	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Variable [id=" + id + ", flags=" + flags + ", unit=" + unit + ", variableValue=" + variableValue
				+ ", variableName=" + variableName + ", value=" + value + "]";
	}
	public void setDataModel(DataModel dataModel) {
		// TODO Auto-generated method stub
		
	}

    
    // Getters and setters

    // toString method
}
