package br.com.submissaoeventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.submissaoeventos.dao.Dao;
import br.com.submissaoeventos.model.Usuario;

@Controller
@Transactional
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	Dao<Usuario> dao;
	
	@RequestMapping("/form")
	public String filtro(Model model){
		
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
		
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(Model model, Usuario usuario) {
		
		dao.adiciona(usuario);
		
		model.addAttribute("mensagem", "Usuário cadastrado com sucesso");
		
		return filtro(model);
	}
}
