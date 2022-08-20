package com.viz.udemy.brewery201.brewery.client.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value = "rest.settings", ignoreUnknownFields = false)
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {
	
	private Integer maxtotal;//100
	public Integer getMaxtotal() {
		return maxtotal;
	}

	public void setMaxtotal(Integer maxtotal) {
		this.maxtotal = maxtotal;
	}

	public Integer getMaxperroute() {
		return maxperroute;
	}

	public void setMaxperroute(Integer maxperroute) {
		this.maxperroute = maxperroute;
	}

	public Integer getSockettimeout() {
		return sockettimeout;
	}

	public void setSockettimeout(Integer sockettimeout) {
		this.sockettimeout = sockettimeout;
	}

	private Integer maxperroute;//20
	private Integer sockettimeout;//3000
	
	public ClientHttpRequestFactory clientHttpRequestFactory() {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(maxtotal);
		connectionManager.setDefaultMaxPerRoute(maxperroute);
		
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(sockettimeout)
				.setSocketTimeout(sockettimeout).build();
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
				.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy()).setDefaultRequestConfig(requestConfig).build();
		
		return new HttpComponentsClientHttpRequestFactory(httpClient);
		
	}
	
	@Override
	public void customize(RestTemplate restTemplate) {
		restTemplate.setRequestFactory(this.clientHttpRequestFactory());
	}
}
