package com.coodesh.billybrianm.usuariosapi;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class TestRequestAPIKeyFactory {
	public static MockHttpServletRequestBuilder get(String url) {
        return MockMvcRequestBuilders.get(url)
                .header("X-API-KEY", "fc857686d5928f4b1babb2574e93e4f3");
    }
	
	public static MockHttpServletRequestBuilder post(String url) {
        return MockMvcRequestBuilders.post(url)
                .header("X-API-KEY", "fc857686d5928f4b1babb2574e93e4f3");
    }
	
	public static MockHttpServletRequestBuilder put(String url) {
        return MockMvcRequestBuilders.post(url)
                .header("X-API-KEY", "fc857686d5928f4b1babb2574e93e4f3");
    }
}
