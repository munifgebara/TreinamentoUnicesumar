package br.com.munif.cursos.treinamento.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.munif.cursos.treinamento.entidades.Estado;
@RestController
@RequestMapping("/api/estados")
public class EstadoApi extends BaseApi<Estado>{
	
}

