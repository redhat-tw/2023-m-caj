package com.caj.ui.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caj.application.ReservationApplicationService;
import com.caj.application.ReservationPricingApplicationService;
import com.caj.infra.repository.mapper.TicketDao;
import com.caj.ui.converter.ReservationConverter;
import com.caj.ui.dto.GenericResponseDTO;
import com.caj.ui.dto.ReservationRequestDTO;
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
public class ReservationApi {

	/**
	 * Logger
	 */
	static Logger log = LoggerFactory.getLogger("jsonLogger");	
	 
	@Autowired
	ReservationApplicationService reservationApplicationService;
	
	@Autowired
	ReservationPricingApplicationService reservationPricingApplicationService;
	
	@Autowired
	ReservationConverter reservationConverter;
	
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	Tracer tracer;

	/**
	 * 訂位 API
	 * 
	 * @param reservationRequestDTO
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Operation(summary = "訂位", description = "產生訂位紀錄，並回傳訂位代號")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@PostMapping(value = "/reservations", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> reservation(@RequestBody ReservationRequestDTO reservationRequestDTO)
			throws JsonMappingException, JsonProcessingException {
		log.info("POST /reservations");
		String pnr =reservationApplicationService.execute(reservationConverter.toDo(reservationRequestDTO));
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
					.code(String.valueOf(HttpStatus.OK.value()))
					.data(pnr)
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}

	/**
	 * 訂位價格試算 API
	 * 
	 * @param reservationRequestDTO
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Operation(summary = "訂位價格試算", description = "訂位價格試算")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@PostMapping(value = "/reservations/{id}/pricing", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> reservation(@Schema(description = "試算固定填0", defaultValue = "0") @PathVariable String id,  @RequestBody ReservationRequestDTO reservationRequestDTO)
			throws JsonMappingException, JsonProcessingException {
		log.info("POST /reservations/{}/pricing",id);
		int price =reservationPricingApplicationService.execute(reservationConverter.toDo(reservationRequestDTO));
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
					.code(String.valueOf(HttpStatus.OK.value()))
					.data(price)
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}
	
	/**
	 * 查詢訂位 API
	 * 
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Operation(summary = "查詢訂位", description = "根據訂位代號查詢訂位紀錄並回傳車票")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@GetMapping(value = "/reservations/{id}", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> getTicket(@PathVariable("id") String pnr)
			throws JsonMappingException, JsonProcessingException {
		log.info("GET /reservations/{}" + pnr);
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
				    .data(ticketDao.findByPnr(pnr))
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
