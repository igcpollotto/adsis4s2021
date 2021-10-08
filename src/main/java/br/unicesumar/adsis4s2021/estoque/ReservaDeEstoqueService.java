package br.unicesumar.adsis4s2021.estoque;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicesumar.adsis4s2021.pessoa.Pessoa;
import br.unicesumar.adsis4s2021.produto.Produto;

@Service
public class ReservaDeEstoqueService {
	@Autowired
	private ReservaDeEstoqueRepository repo;
	
	public String insert(ReservaDeEstoque nova) {
		BigDecimal quantidadeTotalJáReservada = repo.recuperarQuantidadeTotalJáReservada(nova.getCliente().getId(), nova.getProduto().getId());
		//if (quantidadeTotalJáReservada  > 0) {
		if (quantidadeTotalJáReservada.compareTo( new BigDecimal("0.00") ) > 0) {
			throw new ReservaDeEstoqueExcedidaException("Não é possível reservar mais estoque para este produto, reserva prévia encontrada.");
		}
		return repo.save(nova).getId();
	}

}
