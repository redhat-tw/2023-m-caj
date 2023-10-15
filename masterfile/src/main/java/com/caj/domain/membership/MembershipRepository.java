package com.caj.domain.membership;

public interface MembershipRepository {

	/**
	 * 新增消費紀錄
	 * @param memberType
	 * @param memberId
	 * @param amt
	 */
	public void createExpense(String memberType,String memberId,int amt);
	
}
