package hqxh.tzpowerproject.bean;

import java.io.Serializable;

public class Approve implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String instruction;
	private String ispositive;

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getIspositive() {
		return ispositive;
	}

	public void setIspositive(String ispositive) {
		this.ispositive = ispositive;
	}
}
