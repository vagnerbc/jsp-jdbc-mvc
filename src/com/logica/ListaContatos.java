package com.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Logica;
import com.model.Contato;
import com.model.ContatoDao;

public class ListaContatos implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Contato> contatos = new ContatoDao().getLista();
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/listaContatos.jsp";
	}

}
