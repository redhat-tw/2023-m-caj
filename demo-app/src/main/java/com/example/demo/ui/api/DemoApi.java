package com.example.demo.ui.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.MessageApplicationService;
import com.example.demo.ui.converter.MessageConverter;
import com.example.demo.ui.dto.GenericResponseDTO;
import com.example.demo.ui.dto.MessageRequestDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DemoApi {

	@Autowired
	private Tracer tracer;
	
	@Autowired
	private MessageApplicationService messageApplicationService;
	
	@Autowired
	private MessageConverter messageConverter;
	
	@Value("${is-fault}")
	private boolean isFault;
	
	/**
	 * Get Messages by Demo API  ...
	 * @return
	 * @throws Exception 
	 */
	@GetMapping(value = "/api/messages", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> getMessages() throws Exception {
		log.info("GET /api/messages");
		if(isFault) {
			throw new Exception("An intentional exception.Who set is-fault to ture?");
		}
		return new ResponseEntity<>(
			GenericResponseDTO.builder()
				.code(String.valueOf(HttpStatus.OK.value()))
				.message(HttpStatus.OK.name())
				.data(messageApplicationService.getMessages())
				.traceId(tracer.currentSpan().context().traceId())
				.build(), HttpStatus.OK);
	}
	
	/**
	 * Add Message by Demo API ...
	 * @return
	 */
	@PostMapping(value = "/api/messages", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> addMessage(@RequestBody MessageRequestDTO requestDTO) {
		log.info("POST /api/messages");
		messageApplicationService.saveMessage(messageConverter.toDo(requestDTO));
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
					.code(String.valueOf(HttpStatus.OK.value()))
					.message(HttpStatus.OK.name())
					.traceId(tracer.currentSpan().context().traceId())
					.build(), HttpStatus.OK);
	}
	
	/**
	 * handle Exception
	 * @param exception
	 * @return
	 */
    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<GenericResponseDTO> handleException(Exception exception) {
    	log.error(exception.getMessage());
		return new ResponseEntity<>(
				GenericResponseDTO.builder()
					.code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
					.message(HttpStatus.INTERNAL_SERVER_ERROR.name())
					.traceId(tracer.currentSpan().context().traceId())
					.data(exception.getMessage())
					.build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	
}
