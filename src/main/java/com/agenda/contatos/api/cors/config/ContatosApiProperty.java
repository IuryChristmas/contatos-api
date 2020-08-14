package com.agenda.contatos.api.cors.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("contatos")
public class ContatosApiProperty {

	private String originPermitida = "http://localhost:8000";
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}
}
