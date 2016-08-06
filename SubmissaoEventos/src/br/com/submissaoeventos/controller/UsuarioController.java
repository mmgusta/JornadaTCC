package br.com.submissaoeventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.submissaoeventos.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@RequestMapping("/form")
	public String filtro(Model model){
		
		model.addAttribute("usuario", new Usuario());
		return "usuario/form";
		
	}
}
