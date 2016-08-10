package com.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Logica;
import com.model.Contato;
import com.model.ContatoDao;

public class ListaContatos implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Connection connection = (Connection) request.getAttribute("connection");
		List<Contato> contatos = new ContatoDao(connection).getLista();
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/listaContatos.jsp";
	}
}
