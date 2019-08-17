package com.javalec.profile;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		//setting beans depending on profiles (xml-based). This is more of choosing an environment, not about external values in referencing.
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 'dev' or 'run'");
		String str = sc.next();
		if (str.equalsIgnoreCase("dev")) {
			config = "dev";	//development environment
			
		}else {
			config = "run";	//running environment
		}
		sc.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);	//dev or run
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
//		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip: " + info.getIp());
		System.out.println("port: " + info.getPort());
		
		ctx.close();
	}

}
