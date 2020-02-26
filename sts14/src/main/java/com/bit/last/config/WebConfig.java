package com.bit.last.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// 3.1
//interface WebApplicationInitializer
// 3.2~
public class WebConfig 
extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		/*
		<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/root-context.xml</param-value>
		</context-param>
		
		<!-- Creates the Spring Container shared by all Servlets and Filters -->
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		*/
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		/*
		<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
		*/
		return new Class[]{ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// <servlet-mapping>
		//		<servlet-name>appServlet</servlet-name>
		//		<url-pattern>/</url-pattern>
		//	</servlet-mapping>

		return new String[] {"/"};
	}
	

}










