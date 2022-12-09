package com.in28minutes.micorservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private Long id;
	private String frm;
	private String tto;
	private double conversionMultiple;
	private double quantity;
	private double calculatedAmount;
	private int port;

	public CurrencyConversionBean() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrm() {
		return frm;
	}

	public void setFrm(String frm) {
		this.frm = frm;
	}

	public String getTto() {
		return tto;
	}

	public void setTto(String tto) {
		this.tto = tto;
	}

	public double getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(double d) {
		this.conversionMultiple = d;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(double calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public CurrencyConversionBean(Long id, String frm, String tto, double conversionMultiple, double quantity,
			double calculatedAmount, int port) {
		super();
		this.id = id;
		this.frm = frm;
		this.tto = tto;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}

}
