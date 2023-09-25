package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDo {

	/**
	 * messageId
	 */	
	private long messageId;
	
	/**
	 * data
	 */
	private String data;
	
}
