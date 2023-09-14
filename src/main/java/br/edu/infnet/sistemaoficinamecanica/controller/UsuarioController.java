package br.edu.infnet.sistemaoficinamecanica.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.sistemaoficinamecanica.model.negocio.Usuario;

@SessionAttributes("username")
@Controller
public class UsuarioController {

	private Map<String, Usuario> mapaUsuario = new HashMap<String, Usuario>();

	public Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}

	public void incluir(Usuario usuario) {
		mapaUsuario.put(usuario.getEmail(), usuario);
		System.out.println("[Usuário] Inclusão realizada com sucesso: " + usuario);
	}

	public void excluir(String email) {
		mapaUsuario.remove(email);
	}

	public Usuario validar(String email, String senha) {

		Usuario usuario = mapaUsuario.get(email);

		if (usuario != null) {
			if (senha.equalsIgnoreCase(usuario.getSenha())) {
				return usuario;
			}
		}

		return null;
	}

	@PostMapping(value = "/valida")
	public String validaLogin(Model model, @RequestParam String email, @RequestParam String senha) {

		Usuario user = validar(email, senha);

		if (user != null) {

			model.addAttribute("username", user);

			return "home";
		}
		return "redirect:/login";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {

		model.addAttribute("listaUsuario", obterLista());

		return "usuario/lista";
	}

	@GetMapping(value = "/usuario/cadastro")
	public String telaCadastro() {

		return "usuario/cadastro";
	}

	@PostMapping(value = "/usuario/incluir")
	public String inclusao(Usuario usuario) {

		incluir(usuario);

		return "redirect:/";
	}

	@GetMapping(value = "/usuario/{email}/excluir")
	public String exclusao(@PathVariable String email) {

		excluir(email);

		return "redirect:/usuario/lista";
	}
}