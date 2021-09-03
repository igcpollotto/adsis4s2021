package br.unicesumar.adsis4s2021.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicesumar.adsis4s2021.base.BaseController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController extends BaseController<Pessoa, PessoaRepository>{

}
