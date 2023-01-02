package com.kh.jdbc.day02.member.run;

import java.util.List;

import com.kh.jdbc.day02.member.controller.MemberController;
import com.kh.jdbc.day02.member.view.MemberView;
import com.kh.jdbc.day02.member.vo.Member;

public class MemberRun {
	public static void main(String[] args){
	MemberView mView = new MemberView();
	MemberController mCon = new MemberController();
	List<Member> mList = null;
	Member member = null;
	String memberId = "";
	String memberName = "";
	int result = 0;
	goodbye :
	while(true) {
		int choice = mView.mainMenu();
		switch(choice) {
		case 0 : break goodbye;
		case 1 : // 회원 전체조회
			mList = mCon.printAll();
			if(!mList.isEmpty()) {
				mView.showAll(mList);
			} else {
				mView.displayError("일치하는 정보가 없습니다.");
			}
			break;
		case 2 : // 회원 아이디로 조회
			memberId = mView.inputMemberId("검색");
			member = mCon.printOneById(memberId);
			if(member != null) {
				mView.showOne(member);
			}else {
				mView.displayError("일치하는 회원이 없습니다.");
			}
			break;
		case 3 : // 회원 이름으로 조회
			memberName = mView.inputMemberName("검색");
			mList = mCon.printMembersByName(memberName);
			if(mList.size() > 0 ) {
				mView.showAll(mList);
			}else {
				mView.displayError("일치하는 회원이 없습니다.");
			}
			break;
		case 4 : // 회원가입
			member = mView.inputMember();
			result = mCon.registerMember(member);
			if (result > 0 ) {
				mView.displaySuccess("가입이 완료되었습니다.");
			} else {
				mView.displayError("가입이 실패하였습니다.");
			}
			break;
		case 5 : // 회원정보 수정  
			// 아이디를 입력받고
			memberId = mView.inputMemberId("수정");
			// 데이터가 존재하면
			member = mCon.printOneById(memberId);
			if(member != null) {
				// 수정할 데이터 입력받기 
				member = mView.modifyMember(memberId);
				// 입력받은 데이터로 수정하기
				result = mCon.modifyMemberInfo(member);
			}else {
				mView.displayError("정보 수정에 실패했습니다.");
			}
			break;
		case 6 : // 회원 삭제
			memberId = mView.inputMemberId("탈퇴");
			result = mCon.removeMember(memberId);
			if(result > 0 ) {
				mView.displaySuccess("탈퇴완료");
			} else {
				mView.displayError("탈퇴실패");
			}
			
			break;
		case 7 : // 로그인
			member = mView.inputLoginInfor();
			result = mCon.checkInfo(member);
			if(result > 0) {
				// 로그인 성공
				mView.displaySuccess("로그인 성공");
			}else {
				// 로그인 실패
				mView.displayError("일치하는 정보가 없습니다.");
			}
			break;
		default : break;
		}
	}
	}

}
