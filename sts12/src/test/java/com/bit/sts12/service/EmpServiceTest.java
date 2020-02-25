package com.bit.sts12.service;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import com.bit.sts12.model.entity.EmpVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class EmpServiceTest {

	@Autowired
	EmpService service;
	
	@Test
	public void test() {
		Model model=null;
		model=new Model() {
			Map<String, Object> map=new HashMap<String, Object>();
			
			@Override
			public Model mergeAttributes(Map<String, ?> attributes) {
				return null;
			}
			
			@Override
			public boolean containsAttribute(String attributeName) {
				return false;
			}
			
			@Override
			public Map<String, Object> asMap() {
				return map;
			}
			
			@Override
			public Model addAttribute(String attributeName, Object attributeValue) {
				map.put(attributeName, attributeValue);
				return this;
			}
			
			@Override
			public Model addAttribute(Object attributeValue) {
				return null;
			}
			
			@Override
			public Model addAllAttributes(Map<String, ?> attributes) {
				return null;
			}
			
			@Override
			public Model addAllAttributes(Collection<?> attributeValues) {
				return null;
			}
		};
		service.selectAll(model);
		Map<String, Object> map = model.asMap();
		List<EmpVo> list = (List) map.get("list");
		for(EmpVo bean: list) {
			System.out.println(bean);
		}
	}

}




















