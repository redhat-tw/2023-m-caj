package com.caj.ui.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class MembershipRequestDTO {

	/**
	 * 會員身份別
	 * 1 無 , 2 企業 , 3 XGO
	 */
	@Schema(description = "會員身份別")
	private String memberType;
	
	/**
	 * 會員 ID
	 */
	@Schema(description = "會員ID")
	private String memberId;
	
	/**
	 * 付款金額
	 */
	@Schema(description = "付款金額")
	private int paymentAmt;
	
	
}
