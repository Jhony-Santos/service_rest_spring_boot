package com.example.E_Commerce;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class EventoCliente extends ApplicationEvent {
	
	private static final long serialVersionUID=1;
	
	private HttpServletResponse response;
	private Long id;
	
	
	public EventoCliente(Object source, HttpServletResponse response, Long id ){
		super(source);
		this.response = response;
		this.id = id;
	}
	

	public HttpServletResponse getResponse() {
		return response;
	}
	

	public Long getCpf() {
		return id;
	}


}
