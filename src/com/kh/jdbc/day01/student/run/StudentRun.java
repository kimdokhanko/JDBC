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
		List<Student> sList = null;
		
		done :
		while(true) {
			int choice = sView.mainMenu();
			
			switch(choice) {
			case 1 :	// 전체 조회 
				
				sList = sCon.printAll();
				sView.showAll(sList);
				break;
			case 2 : 
				
				break;
			case 3 : 
				
				break;
			case 4 :	// 회원 가입 
				student = sView.inputStudent();
				int result = sCon.registerStudent(student);
				
				if(result > 0) {
					sView.displaySuccess("가입이 완료되었습니다.");
				}
				else {
					sView.displayError("가입 실패하였습니다.");
				}
					
				break;
			case 5 : break;
			case 6 : break;
			case 0 : break done;
			default : 
				sView.printMessage("잘못입력 1~6 사이 수 입력");
				break;
			}
		}
		
	}

}
