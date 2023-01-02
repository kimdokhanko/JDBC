package com.kh.jdbc.day01.student.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentView {

	public void showAll(List<Student> students) {
		System.out.println("=== === 학생 전체 목록 조회 === ===");
		for(Student sOne : students) {
			System.out.print("아이디 : " + sOne.getStudentId());
			System.out.print(", 비밀번호 : " + sOne.getStudentPwd());
			System.out.print(", 이름 : " + sOne.getStudentName());
			System.out.print(", 성별 : " + sOne.getGender());
			System.out.print(", 나이 : " + sOne.getAge());
			System.out.print(", 이메일 : " + sOne.getEmail());
			System.out.print(", 전화번호 : " + sOne.getPhone());
			System.out.print(", 주소 : " + sOne.getAddress());
			System.out.print(", 취미 : " + sOne.getHobby());
			System.out.println("가입날짜 : " + sOne.getEnrollDate());
		}
		
	}
	
	public Student inputStudent() {
		Scanner sc= new Scanner(System.in);
		System.out.print("아이디: ");
		String studentId = sc.next();
		
		System.out.print("이름 : ");
		String studentName = sc.next();
		
		System.out.print("비밀번호 : ");
		String studentPwd = sc.next();
		
		System.out.print("성별 : ");
		String gender = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		
		System.out.print("취미(,)로 구분 : ");
		String hobby = sc.next();
		
		Student student = new Student(studentId, studentName, studentPwd, gender, age, email, phone, address, hobby, null);

		return student;
		
	}
	public Student modifyStudent(Student student) {
		Scanner sc = new Scanner(System.in);
//		Student student = new Student();
		System.out.print("수정할 비밀번호 입력 : ");
		String studentPwd = sc.next();
		System.out.print("수정할 이메일 입력 : ");
		String email = sc.next();
		System.out.print("수정할 주소 입력 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("수정할 취미 입력 : ");
		String hobby = sc.next();
		student.setStudentPwd(studentPwd);
		student.setEmail(email);
		student.setAddress(address);
		student.setHobby(hobby);
		return student;
	}

	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴 선택 : ");
		int select = sc.nextInt();

		
		return select;
	}
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}
	
	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}
	public void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}
	
	public String inputStudentId(String message) {               // id로 조회
		Scanner sc = new Scanner(System.in);
		System.out.print(message + "할 ID 입력 : ");
		String studentId = sc.next();
		return studentId;
	}
	public String inputStudentName(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message + "할 이름 입력 : ");
		String studentName = sc.next();
		return studentName;
	}
	public void showOne(Student student) {       // 2. Id로 조회
		//System.out.println(student.toString());
		System.out.println("아이디 : " + student.getStudentId());
		System.out.println("비밀번호 : " + student.getStudentPwd());
		System.out.println("이름 : " + student.getStudentName());
		System.out.println("성별 : " + student.getGender());
		System.out.println("나이 : " + student.getAge());
		System.out.println("이메일 : " + student.getEmail());
		System.out.println("전화번호 : " + student.getPhone());
		System.out.println("주소 : " + student.getAddress());
		System.out.println("취미 : " + student.getHobby());
		System.out.println("가입날짜 : " + student.getEnrollDate());	
	}

	
	public Student setMemberInfo(Student student) {    // 5. 회원정보 수정
		Scanner sc = new Scanner(System.in);
		
		System.out.print("변경할 아이디 : ");
		String studentId = sc.next();
		student.setStudentId(studentId);
		
		System.out.print("변경할 비밀번호 : ");
		String studentPwd = sc.next();
		student.setStudentPwd(studentPwd);
		
		System.out.print("변경할 이름 : ");
		String studentName = sc.next();
		student.setStudentName(studentName);
		
		System.out.print("변경할 성별 : ");
		String gender = sc.next();
		student.setGender(gender);
		
		System.out.print("변경할 나이 : ");
		int age = sc.nextInt();
		student.setAge(age);
		
		System.out.print("변경할 이메일 : ");
		String email = sc.next();
		student.setEmail(email);
		
		System.out.print("변경할 전화번호 : ");
		String phone = sc.next();
		student.setPhone(phone);
		
		System.out.print("변경할 주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		student.setAddress(address);
		
		System.out.print("변경할 취미 : ");
		String hobby = sc.next();
		student.setHobby(hobby);
		
		return student;
	}
	
}
