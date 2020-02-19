package com.bit.project01.emp;

import java.util.List;

public interface Emp01Dao {

	List<Emp01Vo> selectAll();

	void insertOne(String name, int pay);
}
