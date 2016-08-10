package com.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Logica;
import com.model.Contato;
import com.model.ContatoDao;

public class RemoveContato implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Contato contato = new Contato();
		contato.setId(Long.parseLong(request.getParameter("id")));
		
		ContatoDao dao = new ContatoDao();
	    dao.remove(contato);
	    
	    return "mvc?logica=ListaContatos";	
	}
}
