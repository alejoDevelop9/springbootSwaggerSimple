package com.lab.swagger.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/laboratorio")
@Api(value = "/labSwgger", description = "Utilizando framework swagger", produces = "text/plain")
public class Controller {

	@RequestMapping(value = "/sumar", method = RequestMethod.GET, params = { "operando1", "operando2" })
	@ApiOperation(value = "Suma aritmética", notes = "Realiza la suma de dos operandos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Devuelve el resultado de la suma.") })
	public Integer sumar(
			@RequestParam(value = "operando1", defaultValue = "0") @ApiParam(value = "operando 1 de la suma", defaultValue = "0", required = true, example = "5") Integer operando1,
			@RequestParam(value = "operando2", defaultValue = "0") @ApiParam(value = "operando 2 de la suma", defaultValue = "0", required = true, example = "15") Integer operando2) {
		return operando1 + operando2;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete an user", notes = "Delete a user by Id")
	public ResponseEntity deleteUser(@PathVariable String userId) {
		return new ResponseEntity<String>("se eleimino", HttpStatus.OK);
	}

}
