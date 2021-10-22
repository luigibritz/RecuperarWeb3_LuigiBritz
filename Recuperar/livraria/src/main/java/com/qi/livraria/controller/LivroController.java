package com.qi.livraria.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.qi.livraria.model.Livro;
import com.qi.livraria.repository.LivroRepository;
@Service
@Transactional
@Controller
public class LivroController {
	@Autowired
	private LivroRepository rep;
	
	public List<Livro> listarTodos(){
		return rep.findAll();
	}
	public void salvar(Livro liv) {
		rep.save(liv);
	}
	public Livro getLivro(long codigo) {
		return rep.findById(codigo).get();
	}
	
	public void excluir(long codigo) {
		rep.deleteById(codigo);
	}
	
	@RequestMapping("/")
	public String chamarLista(Model modelo) {
		List<Livro> listaLivros = listarTodos();
		modelo.addAttribute("listaLivros", listaLivros);
		return "index";
	}
	
	@RequestMapping("/novo")
	public ModelAndView chamarNovo() {
		ModelAndView modelo = new ModelAndView("novo");
		Livro livro = new Livro();
		modelo.addObject("livro",livro);
		return modelo;
	}
	
	@RequestMapping("/editar/{codigo}")
	public ModelAndView chamarEditar(@PathVariable(name = "codigo")long codigo) {
		ModelAndView modelo = new ModelAndView("editar");
		Livro livro = getLivro(codigo);
		modelo.addObject("livro",livro);
		return modelo;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
		public String chamarSalvar(@ModelAttribute("livro")Livro livro) {
			salvar(livro);
			return "redirect:/";
		}
	
	@RequestMapping("/excluir/{codigo}")
	public String chamarExcluir(@PathVariable(name = "codigo") long codigo) {
		excluir(codigo);
		return "redirect:/";
	}
}

