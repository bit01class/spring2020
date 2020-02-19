package com.bit.project01;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
public class Ex07Controller {

	@RequestMapping("/ex07")
	public View ex07() {
		View view=new View() {
			
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				PrintWriter out = response.getWriter();
				out.print("<h1>ex07 page</h1>");
			}
			
			@Override
			public String getContentType() {
				return "text/json";
			}
		};
		return view;
	}
	
	@RequestMapping("/ex/ex08")
	public void ex08() {}
}



















