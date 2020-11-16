package com.ioc.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Student {

	private String studentId;
	private String studentName;
	private List<Test> studentTest;

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentTest
	 */
	public List<Test> getStudentTest() {
		if(null == studentTest) {
			this.studentTest = new ArrayList<Test>(5);
		}
		return studentTest;
	}

	/**
	 * @param studentTest the studentTest to set
	 */
	public void setStudentTest(List<Test> studentTest) {
		
		this.studentTest = studentTest;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentTest=" + studentTest
				+ "]";
	}

	

}
