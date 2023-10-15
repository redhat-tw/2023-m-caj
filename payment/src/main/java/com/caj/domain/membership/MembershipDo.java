package com.caj.domain.membership;

import java.util.List;

import com.caj.domain.membership.vo.ExpenseRecordVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipDo {
	
	/**
	 * 會員類別
	 */
	private String memberType;
	
	/*
	 * 會員 ID
	 */
	private String memberId;
	
	/**
	 * 消費紀錄
	 */
	private List<ExpenseRecordVo> expenseRecords;
	

}
