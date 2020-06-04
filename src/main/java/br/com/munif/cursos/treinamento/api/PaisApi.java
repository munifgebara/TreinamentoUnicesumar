package br.com.munif.cursos.treinamento.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.munif.cursos.treinamento.entidades.Pais;
@RestController
@RequestMapping("/api/paises")
public class PaisApi extends BaseApi<Pais>{
	
}

