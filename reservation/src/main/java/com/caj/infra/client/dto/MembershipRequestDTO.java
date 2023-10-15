package com.caj.infra.client.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipRequestDTO implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 會員身份別
	 * 1 無 , 2 企業 , 3 XGO
	 */
	private String memberType;
	
	/**
	 * 會員 ID
	 */
	private String memberId;
	
	/**
	 * 付款金額
	 */
	private int paymentAmt;

}
