package com.caj.infra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.reservation.ReservationRepository;
import com.caj.infra.repository.mapper.ReservationDao;
import com.caj.infra.repository.po.ReservationPo;

@Service
public class ReservationRepositoryImpl implements ReservationRepository {

	@Autowired
	ReservationDao reservationDao;
	
	
	/**
	 * Save PNR
	 */
	@Override
	public void savePnr(String pnr) {
		reservationDao.save(ReservationPo.builder().pnr(pnr).build());
	}

}
