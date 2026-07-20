package com.yuri.clientes_pedidos.handle;

import com.yuri.clientes_pedidos.dto.CampoErrorDto;
import com.yuri.clientes_pedidos.dto.ErrorResponseDto;
import com.yuri.clientes_pedidos.exception.ClienteNaoEncontradoException;
import com.yuri.clientes_pedidos.exception.EmailDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException exception)
	{
		List<CampoErrorDto> campos = exception
				.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(fieldError -> new CampoErrorDto(
						fieldError.getField(),
						fieldError.getDefaultMessage()
				)).toList();
		ErrorResponseDto erro = new ErrorResponseDto(
				HttpStatus.BAD_REQUEST.value(), "Erro de validação", campos
		);
		return ResponseEntity.badRequest().body(erro);
	}
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<ErrorResponseDto> handleClienteNaoEncontradoException(
			ClienteNaoEncontradoException exception) {
		ErrorResponseDto erro = new ErrorResponseDto(
				HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				List.of()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(EmailDuplicadoException.class)
	public ResponseEntity<ErrorResponseDto> handleEmailDuplicadoException(
			EmailDuplicadoException exception) {
		ErrorResponseDto erro = new ErrorResponseDto(
				HttpStatus.CONFLICT.value(),
				exception.getMessage(),
				List.of()
		);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}



}
