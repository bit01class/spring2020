package com.bit.last;

import java.net.URI;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		RestTemplate template=new RestTemplate();
		
		String url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
		ResponseEntity<String> entity = template.getForEntity(url, String.class);
		String msg=entity.getBody();
		System.out.println(msg);
		model.addAttribute("msg", msg);
		return "home";
	}
	
}
















