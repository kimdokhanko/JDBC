package com.kh.jdbc.day01.student.run;

import java.util.List;

import com.kh.jdbc.day01.student.controller.StudentController;
import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day01.student.view.StudentView;

public class StudentRun {

	public static void main(String[] args) {
		StudentView sView = new StudentView();
		StudentController sCon = new StudentController();
		Student student = null;
		Student setStudent = null;
		List<Student> sList = null;
		String studentId = "";
		String studentName = "";
		int result = 0; // 선언하면 변수형만 쓰면된다
		done: 
		while (true) {
		int choice = sView.mainMenu();
		switch (choice) {
			case 1: // 전체 조회
				sList = sCon.printAll();
				if(!sList.isEmpty()) {
					sView.showAll(sList);					
				}else {
					sView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
			case 2: // id로 조회
				studentId = sView.inputStudentId("검색");
				student = sCon.printOneById(studentId);
				if(student != null) {
					sView.showOne(student);
				}else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 3: // 이름으로 조회
				studentName = sView.inputStudentName("검색");
				sList = sCon.printAllByName(studentName);
				// sList 항상 Null이 아니다. StudentDao: 72
				if(!sList.isEmpty()) {
				// 비어있지 않으면 false, 비어있으면 true 반환 
					sView.showAll(sList);
				} else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 4: // 회원 가입
				student = sView.inputStudent();
				result = sCon.registerStudent(student);
				if (result > 0) {
					sView.displaySuccess("가입이 완료되었습니다.");
				} else {
					sView.displayError("가입 실패하였습니다.");
				}
				break;
			case 5: // 회원정보 수정
				studentId = sView.inputStudentId("수정");
				student = sCon.printOneById(studentId);
				if(student != null) {
					student = sView.modifyStudent(student);
//					student.setStudentId(studentId); 아이디는 가지고 있기때문에 set필요없음 
					sCon.modifyStudent(student);
				} else {
					sView.displayError("일치하는 학생이 없습니다.");
				}
				break;
			case 6: // 회원 탈퇴
				studentId = sView.inputStudentId("삭제");
				result = sCon.removeStudent(studentId);
				// Duplicate local variable result
				if(result > 0) {
					// 성공
					sView.displaySuccess("탈퇴완료");
				}else {
					// 실패
					sView.displayError("탈퇴실패");
				}
				break;
			case 0:
				break done;
			default:
				sView.printMessage("잘못입력하였습니다. 1~6 사이 수 입력 하세요.");
				break;
			}
		}

	}

}
