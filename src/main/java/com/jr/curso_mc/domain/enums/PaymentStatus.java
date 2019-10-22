package com.jr.curso_mc.domain.enums;

public enum PaymentStatus {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quítador"),
	CANCELADO(3, "Cancelado");

	
	private int cod;
	private String description;
	
	private PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (PaymentStatus tc : PaymentStatus.values()) {
			return tc;
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
