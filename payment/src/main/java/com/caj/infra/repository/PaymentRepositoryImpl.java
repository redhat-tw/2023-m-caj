package com.caj.infra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.payment.PaymentRepository;
import com.caj.infra.repository.mapper.PaymentDao;
import com.caj.infra.repository.po.PaymentPo;

@Service
public class PaymentRepositoryImpl implements PaymentRepository {

	@Autowired
	PaymentDao paymentDao;

	@Override
	public void createPayRecord(String pnr, String paymentMethod, int amt) {
		paymentDao.save(PaymentPo.builder().pnr(pnr).paymentMethod(paymentMethod).amt(amt).build());

	}

}
