package com.caj.infra.repository.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caj.infra.repository.po.TicketPo;

@Repository
public interface TicketDao  extends JpaRepository<TicketPo, Long> {

	List<TicketPo> findByPnr(String pnr);
}

