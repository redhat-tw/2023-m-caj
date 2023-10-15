package com.caj.infra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.domain.membership.MembershipRepository;
import com.caj.infra.repository.mapper.MembershipDao;
import com.caj.infra.repository.po.MembershipPo;

@Service
public class MembershipRepositoryImpl implements MembershipRepository {

	@Autowired
	MembershipDao membershipDao;

	@Override
	public void createExpense(String memberType, String memberId, int amt) {
		MembershipPo membershipPo = MembershipPo.builder().memberId(memberId).memberType(memberType).amt(amt).build();
		membershipDao.save(membershipPo);
	}

}
