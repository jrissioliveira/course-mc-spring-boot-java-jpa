package com.jr.curso_mc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jr.curso_mc.domain.enums.PaymentStatus;

@Entity
public class InvoicePayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date payDateo;

	public InvoicePayment() {
	}

	public InvoicePayment(Integer id, PaymentStatus status, Order_ pedido, Date dueDate, Date payDateo) {
		super(id, status, pedido);
		this.payDateo = payDateo;
		this.dueDate = dueDate;
	}

	public Date getDataVencimento() {
		return dueDate;
	}

	public void setDataVencimento(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDataPagamento() {
		return payDateo;
	}

	public void setDataPagamento(Date payDateo) {
		this.payDateo = payDateo;
	}	
	
}
