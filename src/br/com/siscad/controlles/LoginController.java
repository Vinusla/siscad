package br.com.siscad.controlles;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.siscad.entities.Autenticavel;
import br.com.siscad.entities.Professor;
import br.com.siscad.entities.Usuario;
import br.com.siscad.services.AutenticavelService;

@Controller
public class LoginController {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String form(ModelMap map){
		Autenticavel usuario = new Professor();
		map.addAttribute("usuario", usuario);
		return "login";
	}
	
	@RequestMapping(value="/logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Usuario usuario, ModelMap map, HttpSession session){
		if(usuario.getLogin().equals("") || usuario.getSenha().equals("") ){
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);
			map.addAttribute("erro", "Login ou senha vazios");
			return "login";
		}
		
		Autenticavel usuarioLogado = AutenticavelService.efetuarLogin(usuario.getLogin(), usuario.getSenha());
		
		if(usuarioLogado == null){
			usuario.setSenha("");
			map.addAttribute("usuario", usuario);
			map.addAttribute("erro", "Usu�rio n�o existe");
			return "login";
		}
		
		session.setAttribute("usuario", usuarioLogado);
		
		return "redirect:/conta/listar";
	}
	

}
