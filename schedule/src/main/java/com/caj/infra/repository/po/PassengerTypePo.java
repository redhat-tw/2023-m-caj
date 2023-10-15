package com.caj.infra.repository.po;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PASSENGER_TYPE")
public class PassengerTypePo {

	/**
	 * id
	 */
	@Id
	@Column(name = "ID")
	private String id;
	
	/**
	 * 名稱
	 */
	@Column(name = "NAME")
	private String name;
	
	/**
	 * 折扣
	 */
	@Column(name = "DISCOUNT")
	private BigDecimal discount;
}
