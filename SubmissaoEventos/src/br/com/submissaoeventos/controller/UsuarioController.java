package br.com.submissaoeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		if(!model.containsAttribute("usuario")) 
			model.addAttribute("usuario", new Usuario());
		
		return "usuario/form";
		
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(Model model, Usuario usuario) {
		
		dao.adiciona(usuario);
		
		model.addAttribute("mensagem", "Usuário " + usuario.getNome()  + " cadastrado com sucesso");
		
		return this.lista(model);
	}
	
	@RequestMapping("/lista")
	public String lista (Model model) {
		
		List<Usuario> lista = dao.lista();
		
		model.addAttribute("usuarios", lista);
		
		return "usuario/lista";
	}
	
	@RequestMapping("/altera")
	public String altera (Model model, Usuario usuario) {
		
		dao.altera(usuario);
		
		model.addAttribute("mensagem", "Usuário alterado com sucesso");
		
		return this.lista(model);
	}
	
	@RequestMapping("/remove")
	public String remove (@RequestParam long id, Model model) {
		
		dao.remove(id);
		
		model.addAttribute("mensagem", "Usuário removido com sucesso");
		
		return this.lista(model);
	}
	
	@RequestMapping("/carrega")
	public String carrega(@RequestParam long id, Model model) {
		
		Usuario usuario = dao.busca(id);
		
		model.addAttribute("usuario", usuario);
		
		return this.filtro(model);
	}
}
