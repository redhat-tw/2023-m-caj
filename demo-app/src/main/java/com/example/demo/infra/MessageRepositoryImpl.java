package com.example.demo.infra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MessageDo;
import com.example.demo.domain.MessageRepository;
import com.example.demo.infra.repository.mapper.MessageDao;
import com.example.demo.infra.repository.po.MessagePo;

@Service
public class MessageRepositoryImpl implements MessageRepository {

	@Autowired
	MessageDao messageDao;

	/**
	 * Implement find messages
	 */
	@Override
	public List<MessageDo> findMessages() {
		List<MessageDo> messageDoList = new ArrayList<>();
		messageDao.findAll().forEach(item -> {
			MessageDo messageDo = new MessageDo();
			messageDo.setMessageId(item.getMessageId());
			messageDo.setData(item.getMessageData());
			messageDoList.add(messageDo);
		});
		return messageDoList;
	}

	/**
	 * Implement save message
	 */
	@Override
	public void saveMessage(MessageDo messageDo) {
		MessagePo messagePo=new MessagePo();
		messagePo.setMessageId(messageDo.getMessageId());
		messagePo.setMessageData(messageDo.getData());
		messageDao.save(messagePo);
	}



	
	
	

}
