package com.caj.domain.reservation;

import java.util.List;

import com.caj.domain.reservation.vo.MembershipVo;
import com.caj.domain.reservation.vo.PassengerVo;
import com.caj.domain.reservation.vo.PaymentVo;
import com.caj.domain.reservation.vo.ScheduleVo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDo {

	/**
	 * 訂位代號
	 */
	private String pnr;

	/**
	 * 自由/對號
	 */
	private String serviceTpye;

	/**
	 * 單程/來回
	 */
	private String roundTrip;

	/**
	 * 起站
	 */
	private String departure;

	/**
	 * 迄站
	 */
	private String destination;

	/**
	 * 旅客清單
	 */
	private List<PassengerVo> passengers;

	/**
	 * 會員身份
	 */
	private MembershipVo membership;

	/**
	 * 付款方式
	 */
	private PaymentVo payment;

	/**
	 * 出發車次
	 */
	private ScheduleVo outbound;

	/**
	 * 出發車次車廂等級
	 */
	private String outboundClass;

	/**
	 * 回程車次
	 */
	private ScheduleVo inbound;

	/**
	 * 回程車次車廂等級
	 */
	private String inboundClass;



}
