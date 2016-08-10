package com.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Logica;

public class ExibeFormulario implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/WEB-INF/jsp/adicionaContato.jsp";
	}
}
