package com.example.demo.ui.converter;

import org.springframework.stereotype.Service;

import com.example.demo.domain.MessageDo;
import com.example.demo.ui.dto.MessageRequestDTO;

@Service
public class MessageConverter {

	
	/**
	 * toDo
	 * @param scheduleRequestDTO
	 * @return
	 */
	public MessageDo toDo(MessageRequestDTO messageRequestDTO) {
		return MessageDo.builder().data(messageRequestDTO.getData()).build();
	}
}
