package br.unicesumar.adsis4s2021.cidade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.base.BaseController;

@RestController
@RequestMapping("/cidades")
public class CidadeController extends BaseController<Cidade, CidadeRepository> {

}
