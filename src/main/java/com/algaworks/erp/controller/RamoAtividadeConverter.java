package com.algaworks.erp.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.algaworks.erp.model.RamoAtividade;

public class RamoAtividadeConverter implements Converter{
	
	private List<RamoAtividade> listRamoAtividade;
	
	public RamoAtividadeConverter(List<RamoAtividade> listRamoAtividade) {
		
		this.listRamoAtividade = listRamoAtividade;
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null) {
			return null;
		}		
		
		Long id = Long.valueOf(value);
		
		for(RamoAtividade ramo: listRamoAtividade) {
			
			if(id.equals(ramo.getId())) {
				return ramo;
			}
			
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value == null) {
			return null;
		}
		
		RamoAtividade ramoAtividade = (RamoAtividade) value;
		
		return ramoAtividade.getId().toString();
	}

}
