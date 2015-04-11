package com.likeyichu.webservice;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
	public  App() {
		//向jersey框架注册资源类，凡完全限定名是以指定字符串开头的类，都将包含
		packages("com.likeyichu.webservice");
		//它所在的jar为jersey-media-json-jackson-2.5.jar  
        /* 
         * <dependency> 
            <groupId>org.glassfish.jersey.media</groupId> 
            <artifactId>jersey-media-json-jackson</artifactId> 
            <version>2.5</version> 
        </dependency> 
         */  
		register(JacksonFeature.class);
	}
}
