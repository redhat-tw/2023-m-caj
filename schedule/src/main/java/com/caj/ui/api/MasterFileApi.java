package com.caj.ui.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caj.domain.masterfile.PassengerTypeService;
import com.caj.domain.masterfile.StationService;
import com.caj.ui.dto.GenericResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.micrometer.tracing.Tracer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1")
public class MasterFileApi {
	
	/**
	 * 
	 */
	@Value("${caj.release-no}")
	String webTittle;
	
	/**
	 * 
	 */
	@Value("${caj.masterfile.is-fault}")
	boolean isFault;


	/**
	 * Station Service
	 */
	@Autowired
	StationService stationService;
	
	/**
	 * Passenger TypeService
	 */
	@Autowired
	PassengerTypeService passengerTypeService;
	
	@Autowired
	Tracer tracer;
	
	
	/**
	 * 車站查詢 API
	 * 
	 * @param reservationRequestDTO
	 * @return
	 * @throws Exception 
	 */
	@Operation(summary = "查詢車站", description = "查詢車站")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@GetMapping(value = "/stations", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> queryStation() throws Exception {
		log.info("GET /stations");
		if(isFault) {
			throw new Exception("An intentional exception.Who set is-fault to ture?");
		}
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
				    .data(stationService.getStationDoList())
					.code(String.valueOf(HttpStatus.OK.value()))
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}
	
	/**
	 * 查詢車站距離 API
	 * @param departureId
	 * @param destinationId
	 * @return
	 * @throws Exception 
	 */
	@Operation(summary = "查詢車站距離", description = "依照起迄站查詢車站距離")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@GetMapping(value = "/stations/distance", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> queryStationDistance(
			@Schema(description = "出發站") @RequestParam String departureId,
			@Schema(description = "到達站") @RequestParam String destinationId
			) throws Exception {
		log.info("GET /stations?departureId={},destinationId={}",departureId,destinationId);
		if(isFault) {
			throw new Exception("An intentional exception.Who set is-fault to ture?");
		}
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
				    .data(stationService.getStationDistance(departureId,destinationId))
					.code(String.valueOf(HttpStatus.OK.value()))
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}

	/**
	 * 身份別查詢 API
	 * @param reservationRequestDTO
	 * @return
	 * @throws Exception 
	 */
	@Operation(summary = "查詢身份別", description = "查詢身份別與折扣")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@GetMapping(value = "/passengerTypes", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> queryPassengerTypes()
			throws Exception {
		log.info("GET /passengerTypes");
		if(isFault) {
			throw new Exception("An intentional exception.Who set is-fault to ture?");
		}
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
				    .data(passengerTypeService.getPassengerTypeDoList())
					.code(String.valueOf(HttpStatus.OK.value()))
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}
	
	/**
	 * 身份別折扣率查詢 API
	 * @param reservationRequestDTO
	 * @return
	 * @throws Exception 
	 */
	@Operation(summary = "查詢身份別折扣", description = "查詢身份別對應之折扣率")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@GetMapping(value = "/passengerTypes/{id}", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> queryPassengerDiscount(
			@Schema(description = "身份別") @PathVariable String id)
			throws Exception {
		log.info("GET /passengerTypes/{}",id);
		if(isFault) {
			throw new Exception("An intentional exception.Who set is-fault to ture?");
		}
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
				    .data(passengerTypeService.getPassengerDiscount(id))
					.code(String.valueOf(HttpStatus.OK.value()))
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}
	
	/**
	 * 版本號碼查詢 API
	 * @param reservationRequestDTO
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Operation(summary = "查詢當前系統版本號碼", description = "查詢當前系統版本號碼")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "操作成功"),
			@ApiResponse(responseCode = "500", description = "操作失敗") })
	@GetMapping(value = "/versions", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> queryRelease()
			throws JsonMappingException, JsonProcessingException {
		log.info("GET /versions");
		return new ResponseEntity<>(GenericResponseDTO.builder()
				.data(webTittle)
				.code(String.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.name())
				.traceId(tracer.currentSpan().context().traceId())
				.build(), HttpStatus.OK);
	}


}
