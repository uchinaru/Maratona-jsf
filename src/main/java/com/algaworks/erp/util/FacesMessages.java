package com.algaworks.erp.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessages implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private void add(String msg, FacesMessage.Severity severity) {
		FacesMessage faceMessage = new FacesMessage(msg); //Adicionando a mensagem no construtor.
		faceMessage.setSeverity(severity); // Adicionando o severity (info, warning ou error)
		
		FacesContext.getCurrentInstance().addMessage(null, faceMessage); // adicionando a mensagem ao JSF
	}

	public void info(String msg) {
		add(msg, FacesMessage.SEVERITY_INFO);
	}
	public void warning(String msg) {
		add(msg, FacesMessage.SEVERITY_WARN);
	}
	public void error(String msg) {
		add(msg, FacesMessage.SEVERITY_ERROR);
	}
}
