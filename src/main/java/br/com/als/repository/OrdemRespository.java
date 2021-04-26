package br.com.als.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.als.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRespository implements PanacheRepository<Ordem> {

}
