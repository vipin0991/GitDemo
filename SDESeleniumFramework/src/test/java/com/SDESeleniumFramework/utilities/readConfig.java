package com.SDESeleniumFramework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	Properties p;

	public readConfig() {
		try {
			FileInputStream fis = new FileInputStream("../SDESeleniumFramework/Configuration/config.properties");
			p = new Properties();
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUrl() {
		String u = p.getProperty("baseURL");
		return u;
	}

	public String getName() {
		String uname = p.getProperty("username");
		return uname;
	}

	public String getPassword() {
		String upass = p.getProperty("password");
		return upass;
	}

	public String getChromPath() {
		String cpath = p.getProperty("chromepath");
		return cpath;
	}
	public String getEdgePath() {
		String cpath = p.getProperty("edgepath");
		return cpath;
	}

}
