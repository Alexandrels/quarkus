package br.com.als.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.als.model.Ordem;
import br.com.als.model.Usuario;
import br.com.als.repository.OrdemRespository;

@ApplicationScoped
public class OrdemService {
	
	@Inject
	OrdemRespository ordemRespository;

	public void inserir(SecurityContext securityContext, Ordem ordem) {
		Optional<Usuario> usuarioOptinal = Usuario.findByIdOptional(ordem.getUserId());
		Usuario usuario = usuarioOptinal.orElseThrow();
		if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
			throw new RuntimeException("O usuário logado é diferente do userId");
		}
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRespository.persist(ordem);
	}

	public List<Ordem> listar() {
		return ordemRespository.listAll();
	}

}
