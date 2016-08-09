package br.com.submissaoeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.submissaoeventos.dao.Dao;
import br.com.submissaoeventos.model.Evento;

@Controller
@Transactional
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	Dao<Evento> dao;
	
	@RequestMapping("/form")
	public String filtro(Model model){
		
		if(!model.containsAttribute("evento")) 
			model.addAttribute("evento", new Evento());
		
		return "evento/form";
		
	}
	
	@RequestMapping("/cadastra")
	public String cadastra(Model model, Evento evento) {
		
		dao.adiciona(evento);
		
		model.addAttribute("mensagem", "Evento " + evento.getNome()  + " cadastrado com sucesso");
		
		return this.lista(model);
	}
	
	@RequestMapping("/lista")
	public String lista (Model model) {
		
		List<Evento> lista = dao.lista();
		
		model.addAttribute("eventos", lista);
		
		return "evento/lista";
	}
	
	@RequestMapping("/altera")
	public String altera (Model model, Evento evento) {
		
		dao.altera(evento);
		
		model.addAttribute("mensagem", "Evento alterado com sucesso");
		
		return this.lista(model);
	}
	
	@RequestMapping("/remove")
	public String remove (@RequestParam long id, Model model) {
		
		dao.remove(id);
		
		model.addAttribute("mensagem", "Evento removido com sucesso");
		
		return this.lista(model);
	}
	
	@RequestMapping("/carrega")
	public String carrega(@RequestParam long id, Model model) {
		
		Evento evento = dao.busca(id);
		
		model.addAttribute("evento", evento);
		
		return "evento/edita";
	}
}
