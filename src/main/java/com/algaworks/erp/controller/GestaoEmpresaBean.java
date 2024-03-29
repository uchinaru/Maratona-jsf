package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.weld.context.RequestContext;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;

import com.algaworks.erp.CadastroEmpresaService;
import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.repository.RamoAtividades;
import com.algaworks.erp.util.FacesMessages;

@Named
// @RequestScoped // Cria uma instancia a cada requis�o sendo requisoes do tipo get ou post. (F5 ou enviando formularios pelos botoes da pagina)
@ViewScoped // Escopo se inicia quando o usuario carrega a pagina. e terima quando a sessao termina, entao as instancias so serao criadas ao carregar a pagina via F5 ou acessando.
// @SessionScoped  // Escopo se inicia quando o usuario carrega a pagina mantendo apenas uma instancia por sessao iniciada, sendo unica para requisicoes get ou post. so criando a proxima instancia ao recarregar o browser
// @ApplicationScoped // Cria apenas uma instancia mesmo ao F5, post ou get na sessao.
public class GestaoEmpresaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private RamoAtividades ramoAtividades;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresa;
	
	private Empresa empresa;
	private String termoPesquisa;
	private List<Empresa> listarEmpresas;
	private RamoAtividadeConverter converterRamoAtividade;
	
	public void pesquisar() {
		listarEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listarEmpresas.isEmpty()) {
			messages.info("Nenhuma empresa encontrada");
		}
	}
	
	public void todasEmpresas() {
		listarEmpresas = empresas.todasEmpresas();
	}
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		List<RamoAtividade> listRamoAtividades = ramoAtividades.pesquisar(termo);
		
		converterRamoAtividade = new RamoAtividadeConverter(listRamoAtividades);
		return listRamoAtividades;
	}
	
	public void salvar() {
		cadastroEmpresa.salvar(empresa);
		
		messages.info("Registro salvo!","formulario:messagesForm");
		todasEmpresas();
	}
	
	public void excluir() {
		cadastroEmpresa.excluir(empresa);
		empresa = null;
		todasEmpresas();
		messages.info("Registro deletado");
	}
	
	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}
	
	public void prepararEdicao() {
		converterRamoAtividade = new RamoAtividadeConverter(Arrays.asList(empresa.getRamoAtividade()));
	}
	
	public boolean isEmpresaSelected() {
		return empresa != null && empresa.getId() != null;
	}

	public List<Empresa> getListarEmpresas() {
		return listarEmpresas;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

	public RamoAtividadeConverter getConverterRamoAtividade() {
		return converterRamoAtividade;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
