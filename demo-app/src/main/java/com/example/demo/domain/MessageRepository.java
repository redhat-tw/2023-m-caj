package com.example.demo.domain;

import java.util.List;

public interface MessageRepository {
	
	/**
	 * findStations
	 * @return
	 */
	public List<MessageDo> findMessages();
	
	
	
	/**
	 * saveMessage
	 * @return
	 */
	public void saveMessage(MessageDo messageDo);
	
	
}
