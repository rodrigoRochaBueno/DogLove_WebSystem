package br.com.criandoSozinho.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")){
			throw new ServletException("Token Invalido");
		}
		
		String token = header.substring(7); //extraindo somente o token sem o bearer
		
		//Verificar se o Token é valido
		
		try{
		Jwts.parser().setSigningKey("cripto").parseClaimsJws(token).getBody();
		}catch(SignatureException e){
			throw new ServletException("Token inválido");
		}
		
		chain.doFilter(request, response);
		
	}

}
