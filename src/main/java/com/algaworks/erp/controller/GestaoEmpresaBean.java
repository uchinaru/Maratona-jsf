package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.repository.Empresas;

@Named
// @RequestScoped // Cria uma instancia a cada requisão sendo requisoes do tipo get ou post. (F5 ou enviando formularios pelos botoes da pagina)
@ViewScoped // Escopo se inicia quando o usuario carrega a pagina. e terima quando a sessao termina, entao as instancias so serao criadas ao carregar a pagina via F5 ou acessando.
// @SessionScoped  // Escopo se inicia quando o usuario carrega a pagina mantendo apenas uma instancia por sessao iniciada, sendo unica para requisicoes get ou post. so criando a proxima instancia ao recarregar o browser
// @ApplicationScoped // Cria apenas uma instancia mesmo ao F5, post ou get na sessao.
public class GestaoEmpresaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	private List<Empresa> listarEmpresas;
	
	public void todasEmpresas() {
		listarEmpresas = empresas.todasEmpresas();
	}
	
	public List<Empresa> getListarEmpresas() {
		return listarEmpresas;
	}
	
}
