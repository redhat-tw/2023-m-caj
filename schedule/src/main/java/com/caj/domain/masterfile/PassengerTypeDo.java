package com.caj.domain.masterfile;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerTypeDo {
	
	/**
	 * id
	 */
	private String id;
	
	/**
	 * 名稱
	 */
	private String name;
	
	/**
	 * 折扣
	 */
	private BigDecimal discount;

}
