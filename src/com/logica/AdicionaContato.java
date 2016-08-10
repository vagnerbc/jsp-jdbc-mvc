package com.logica;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Logica;
import com.model.Contato;
import com.model.ContatoDao;

public class AdicionaContato implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// busca o writer
		PrintWriter out = response.getWriter();
		
		// buscando os par�metros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		// fazendo a convers�o da data
		try {
			Date date =
			new SimpleDateFormat("dd/MM/yyyy")
			.parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de convers�o da data");
			throw new Exception();
		}
		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato
		Connection connection = (Connection) request.getAttribute("connection");
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);
		
		return "/WEB-INF/jsp/contatoAdicionado.jsp";
	}
}
