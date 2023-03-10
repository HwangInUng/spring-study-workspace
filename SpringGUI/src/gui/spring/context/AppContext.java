package gui.spring.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import gui.school.Student;
import gui.view.JoinForm;

/*
 * Spring 프로젝트에서 사용할 모든 객체를 직접 new하지 않고
 * 주입을 받기 위하여, 모든 객체의 리스트를 등록해두어야함.
 */
public class AppContext {

	public AppContext() {
		// 지정된 XML을 읽어드려 전체 어플리케이션에서
		// 사용될 bean들을 관리해주는 컨테이너 객체
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("gui/spring/context/config.xml");
//		JoinForm form = (JoinForm)context.getBean("joinForm");
//		form.create();
		
		Student student = (Student)context.getBean("student");
		student.goSchool();
		student.startStudy1();
		student.haveLunch();
	}

	public static void main(String[] args) {
		new AppContext();
	}
}
