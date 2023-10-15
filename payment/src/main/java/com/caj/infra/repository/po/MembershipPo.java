package com.caj.infra.repository.po;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEMBERSHIP")
public class MembershipPo {

	/**
	 * id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
    @CreationTimestamp
    private Instant createdOn;
	
	/**
	 * 會員類別
	 */
	@Column(name = "MEMBER_TYPE")
	private String memberType;
	
	/*
	 * 會員 ID
	 */
	@Column(name = "MEMBER_ID")
	private String memberId;
	
	/*
	 * 會員 ID
	 */
	@Column(name = "AMT")
	private int amt;

	
	
}
