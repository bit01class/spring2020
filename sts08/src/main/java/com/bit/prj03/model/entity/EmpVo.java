package com.bit.prj03.model.entity;

import java.sql.Date;

public class EmpVo {
	private int sabun;
	private String name;
	private Date nalja;
	private int pay;
	private int deptno;
	
	public EmpVo() {
	}

	public EmpVo(int sabun, String name, Date nalja, int pay, int deptno) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
		this.pay = pay;
		this.deptno = deptno;
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

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpVo [sabun=" + sabun + ", name=" + name + ", nalja=" + nalja + ", pay=" + pay + ", deptno=" + deptno
				+ "]";
	}
	
}
