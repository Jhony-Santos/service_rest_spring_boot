package com.example.E_Commerce;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class EventoCliente extends ApplicationEvent {
	
	private static final long serialVersionUID=1;
	
	private HttpServletResponse response;
	private String cpf;
	
	
	public EventoCliente(Object source, HttpServletResponse response, String cpf ){
		super(source);
		this.response = response;
		this.cpf = cpf;
	}
	

	public HttpServletResponse getResponse() {
		return response;
	}
	

	public String getCpf() {
		return cpf;
	}


}
