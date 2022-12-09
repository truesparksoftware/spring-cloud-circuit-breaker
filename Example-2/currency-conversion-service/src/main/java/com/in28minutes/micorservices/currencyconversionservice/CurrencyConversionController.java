package com.in28minutes.micorservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/frm/{frm}/tto/{tto}/quantity/{quantity}")
	@HystrixCommand(fallbackMethod= "fallback_hello")
	public CurrencyConversionBean convertCurrency(@PathVariable String frm,
			@PathVariable String tto, @PathVariable double quantity) {

		Map<String, String> uriVariables=new HashMap<String, String>();
		
		uriVariables.put("frm", frm);
		uriVariables.put("tto", tto);
		
		ResponseEntity<CurrencyConversionBean> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/frm/{frm}/tto/{tto}", CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean response=responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(), frm, tto,response.getConversionMultiple()
				, quantity, response.getConversionMultiple(), response.getPort());
	} 
	
	public CurrencyConversionBean fallback_hello(@PathVariable String frm,
			@PathVariable String tto, @PathVariable double quantity) {
		CurrencyConversionBean bean=new CurrencyConversionBean();
		bean.setId((long) 12);
		bean.setPort(9090);
		bean.setFrm("INR");
		bean.setTto("USD");
		bean.setConversionMultiple(2975671681509007947508815.00);
		return bean;
		
	
	}
}
