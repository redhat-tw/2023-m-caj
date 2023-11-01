package com.caj.ui.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caj.application.CalculateFareApplicationService;
import com.caj.ui.converter.FareConverter;
import com.caj.ui.dto.GenericResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.micrometer.tracing.Tracer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1")
public class FareApi {

	/**
	 * Logger
	 */
	 static Logger log = LoggerFactory.getLogger("jsonLogger");	
	
	/**
	 * 計算票價 Use Case
	 */
	@Autowired
	CalculateFareApplicationService calculateFareApplicationService;
	
	@Autowired
	FareConverter fareConverter;
	
	@Autowired
	Tracer tracer;
	
	/**
	 * 票價計算 API
	 * 
	 * @param reservationRequestDTO
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Operation(summary = "查詢票價", description = "根據起迄站、車廂等級查詢票價")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@GetMapping(value = "/fare", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> queryFare(
			@Schema(description = "出發站") @RequestParam String departure,
			@Schema(description = "到達站") @RequestParam String destination, 
			@Schema(description = "車廂等級") @RequestParam String classCode, 
			@Schema(description = "旅客身份") @RequestParam String passengerType)throws JsonMappingException, JsonProcessingException {
		log.info("GET /fare?");
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
				    .data(calculateFareApplicationService.execute(fareConverter.toDo(departure, destination, classCode, passengerType)))
					.code(String.valueOf(HttpStatus.OK.value()))
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}
	
	/**
	 * handleException
	 * @param exception
	 */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException(Exception exception) {
		log.error(exception.getMessage(), exception);
    }
	
}
