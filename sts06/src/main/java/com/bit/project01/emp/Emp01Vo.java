package com.bit.project01.emp;

import java.sql.Date;

public class Emp01Vo {

	private int sabun;
	private String name;
	private Date nalja;
	private int pay;
	
	public Emp01Vo() {
	}

	public Emp01Vo(int sabun, String name, Date nalja, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
		this.pay = pay;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "Emp01Vo [sabun=" + sabun + ", name=" + name + ", nalja=" + nalja + ", pay=" + pay + "]";
	}
	
}
















