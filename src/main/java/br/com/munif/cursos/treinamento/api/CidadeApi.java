package br.com.munif.cursos.treinamento.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.munif.cursos.treinamento.entidades.Cidade;
@RestController
@RequestMapping("/api/cidades")
public class CidadeApi extends BaseApi<Cidade>{
	
}

