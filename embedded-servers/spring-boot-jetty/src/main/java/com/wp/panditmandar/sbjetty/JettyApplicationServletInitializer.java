package com.wp.panditmandar.sbjetty;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JettyApplicationServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("JettyApplicationServletInitializer called.");
		return application.sources(SpringBootJettyApplication.class);
	}

}