package com.caj.ui.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caj.domain.membership.MembershipService;
import com.caj.ui.dto.GenericResponseDTO;
import com.caj.ui.dto.MembershipRequestDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.micrometer.tracing.Tracer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1")
public class MembershipApi {

	/**
	 * Logger
	 */
	 static Logger log = LoggerFactory.getLogger("jsonLogger");	
	
	@Autowired
	MembershipService membershipService;
	
	@Autowired
	Tracer tracer;
	
	/**
	 * 新增會員消費紀錄 API
	 * 
	 * @param reservationRequestDTO
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Operation(summary = "會員消費紀錄", description = "新增會員消費紀錄")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@PostMapping(value = "/membership", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> reservation(@RequestBody MembershipRequestDTO membershipRequestDTO)
			throws JsonMappingException, JsonProcessingException {
		log.info("POST /membership");
		membershipService.createExpenseRecord(membershipRequestDTO.getMemberType(),membershipRequestDTO.getMemberId(),membershipRequestDTO.getPaymentAmt());
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
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
