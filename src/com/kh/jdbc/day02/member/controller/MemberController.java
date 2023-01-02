package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.vo.Member;

// ResultSet이 1개면 Member
// ResultSet이 1개 이상이면 List<Member>
public class MemberController {
	public List<Member> printAll() {
		MemberDAO mDao = new MemberDAO();
		List<Member> member = mDao.selectAll();
		return member;
	}

	public int registerMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.signMember(member);
		return result;
	}
	public int removeMember(String memberId) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.deleteMember(memberId);
		return result;
	}
	public Member printOneById(String memberId) { //SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?
		MemberDAO mDao = new MemberDAO();
		Member member = mDao.selectOneById(memberId);
		return member;
	}
	public List<Member> printMembersbyname( ) { 
		List<Member> mList = null;
		return mList;
	}
	public int checkInfo(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.checkLogin(member);
		return result;
	}
	public List<Member> printMembersByName(String memberName){
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = mDao.selectMembersByName(memberName);
		return mList;
	}

	public int modifyMemberInfo(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.updateMember(member);
		return result; //return 0으로 두지 않기
	}

}
