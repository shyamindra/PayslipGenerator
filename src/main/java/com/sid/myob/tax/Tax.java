package com.sid.myob.tax;

public class Tax {
	
	private long fixedComponent;
	private double variablePercentage;
	
	public Tax(long fixedComponent, double variablePercentage){
		this.fixedComponent = fixedComponent;
		this.variablePercentage = variablePercentage;
	}
	
	public long getFixedComponent() {
		return fixedComponent;
	}
	public void setFixedComponent(long fixedComponent) {
		this.fixedComponent = fixedComponent;
	}
	public double getVariablePercentage() {
		return variablePercentage;
	}
	public void setVariablePercentage(double variablePercentage) {
		this.variablePercentage = variablePercentage;
	}
	
}
