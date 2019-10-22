package com.jr.curso_mc.domain;

import javax.persistence.Entity;

import com.jr.curso_mc.domain.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer numberOfInstallment;
	
	public CardPayment() {
	}

	public CardPayment(Integer id, PaymentStatus status, Order_ pedido, Integer numberOfInstallment) {
		super(id, status, pedido);
		this.numberOfInstallment = numberOfInstallment;
	}

	public Integer getNumeroDeParcelas() {
		return numberOfInstallment;
	}

	public void setNumeroDeParcelas(Integer numberOfInstallment) {
		this.numberOfInstallment = numberOfInstallment;
	}
		
}
