package main.domain;

import main.constants.COLOR;

public abstract class Vehicle {

	private String regNo;
	private COLOR colour;
	
	Vehicle(String regNo){
		this.regNo = regNo;
	}
	
	Vehicle(String regNo, COLOR color){
		this.regNo = regNo;
		this.colour =color;
	}
	
	public String getRegNo() {
		return regNo;
	}
	public COLOR getColour() {
		return colour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (regNo == null) {
			if (other.regNo != null)
				return false;
		} else if (!regNo.equals(other.regNo))
			return false;
		return true;
	}
	
	
	
}
