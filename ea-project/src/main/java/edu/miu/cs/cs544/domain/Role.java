package edu.miu.cs.cs544.domain;

public enum Role {
	ADMIN(1), CHECKER(2), STUDENT(3);

	private int numVal;

	Role(int numVal) {
		this.numVal = numVal;
	}

	public int getNumVal() {
		return numVal;
	}


}
