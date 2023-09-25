package com.example.demo.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MessageDo;
import com.example.demo.infra.MessageRepositoryImpl;

@Service
public class MessageApplicationService {

	@Autowired
	MessageRepositoryImpl messageRepositoryImpl;
	
	/**
	 * Get Messages
	 * @return
	 */
	public List<MessageDo> getMessages() {
		return messageRepositoryImpl.findMessages();

	}
	
	/**
	 * Save Message
	 * @return
	 */
	public void saveMessage(MessageDo messageDo) {
		messageRepositoryImpl.saveMessage(messageDo);
	}

}
