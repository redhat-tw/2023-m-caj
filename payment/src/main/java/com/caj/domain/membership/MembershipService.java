package com.caj.domain.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipService {

	/**
	 * membershipRepository
	 */
	@Autowired
	MembershipRepository membershipRepository;
	
	/**
	 * createExpenseRecord
	 * 
	 * @return
	 */
	public void createExpenseRecord(String memberType,String memberId,int amt) {
		membershipRepository.createExpense(memberType, memberId, amt);
	}
	
}
