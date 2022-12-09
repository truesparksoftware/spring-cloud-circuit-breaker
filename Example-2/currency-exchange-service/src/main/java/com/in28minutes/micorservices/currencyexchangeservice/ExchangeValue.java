package com.in28minutes.micorservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

	@Id
	private Long id;

	@Column(name="frm")
	private String frm;
	
	@Column(name="tto")
	private String tto;
	
	@Column(name="conversion_multiple")
	private BigDecimal ConversionMultiple;
	
	@Column(name="port")
	private int port;
	
	
	public String getTto() {
		return tto;
	}

	public void setTto(String tto) {
		this.tto = tto;
	}

	public String getFrm() {
		return frm;
	}

	public void setFrm(String frm) {
		this.frm = frm;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public BigDecimal getConversionMultiple() {
		return ConversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		ConversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ExchangeValue(Long id, String frm, String tto, BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.frm = frm;
		this.tto = tto;
		ConversionMultiple = conversionMultiple;
		this.port = port;
	}

	public ExchangeValue() {

	}

}
