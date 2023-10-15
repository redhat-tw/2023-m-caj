package com.caj.domain.reservation.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class MembershipVo {

	/**
	 * 會員類別
	 */
	private String memberType;
	
	/*
	 * 會員 ID
	 */
	private String memberId;
}
