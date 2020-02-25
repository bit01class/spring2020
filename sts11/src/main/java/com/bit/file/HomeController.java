package com.bit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	String path="C:\\sts\\workspace\\upload\\";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("index");
		return "home";
	}
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(int sabun,MultipartFile[] files,Model model) {
		
		List<String> renames=new ArrayList<String>();
		
		for(MultipartFile multi : files) {
			if(multi.getOriginalFilename().isEmpty())continue;
			logger.debug(multi.getOriginalFilename());
			
			String filenames =multi.getOriginalFilename();
			String rename=System.currentTimeMillis()+"_"+filenames;
			renames.add(rename);
			File file = new File(path+rename);
			
			try {
				multi.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("sabun", sabun);
		model.addAttribute("files", renames);
		return "download";
	}
	
	
	@RequestMapping("/download/{filename:.+}")
	public void download(@PathVariable String filename, HttpServletResponse res) {
		String origin=filename.substring(filename.indexOf("_")+1);
		
		File file=new File(path+filename);
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition","attachment; filename=\""+origin+"\"");
		try(
				InputStream is=new FileInputStream(file);
				OutputStream os=res.getOutputStream();
				){
			int su=-1;
			while((su=is.read())!=-1)os.write(su);
		} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}




















