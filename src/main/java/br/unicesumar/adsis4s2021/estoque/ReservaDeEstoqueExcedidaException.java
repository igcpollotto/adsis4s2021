package br.unicesumar.adsis4s2021.estoque;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ReservaDeEstoqueExcedidaException extends RuntimeException {

	public ReservaDeEstoqueExcedidaException(String message) {
		super(message);
	}

}
