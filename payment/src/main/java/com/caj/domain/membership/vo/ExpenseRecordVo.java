package com.caj.domain.membership.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRecordVo {

	/**
	 * 消費日期
	 */
	private String expenseDate;
	
	/**
	 * 消費金額
	 */
	private int amt;
}
