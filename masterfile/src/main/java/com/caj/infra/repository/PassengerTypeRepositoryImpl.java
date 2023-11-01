package com.caj.infra.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.masterfile.PassengerTypeDo;
import com.caj.domain.masterfile.PassengerTypeRepository;
import com.caj.infra.repository.mapper.PassengerTypeDao;
import com.caj.infra.repository.po.PassengerTypePo;

@Service
public class PassengerTypeRepositoryImpl implements PassengerTypeRepository {

	@Autowired
	PassengerTypeDao passengerTypeDao;

	/**
	 * 取得主檔
	 */
	@Override
	public List<PassengerTypeDo> findPassengerTypes() {
		List<PassengerTypeDo> passengerTypeDoList = new ArrayList<>();
		passengerTypeDao.findAll().forEach(item -> {
			PassengerTypeDo passengerTypeDo = new PassengerTypeDo();
			passengerTypeDo.setId(item.getId());
			passengerTypeDo.setName(item.getName());
			passengerTypeDo.setDiscount(item.getDiscount());
			passengerTypeDoList.add(passengerTypeDo);
		});
		return passengerTypeDoList;
	}

	/**
	 * 取得折扣率
	 */
	@Override
	public BigDecimal findPassengerDiscount(String passengerType) {
		Optional<PassengerTypePo> result = passengerTypeDao.findById(passengerType);
		if (result.isPresent()) {
			return result.get().getDiscount();
		};
		return null;
	}

}
