package com.ioc.models;

import org.springframework.context.annotation.Scope;


public class Test {
	
	private String testId;
	private String testTitle;
	private String testmarks;
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public String getTestmarks() {
		return testmarks;
	}
	public void setTestmarks(String testmarks) {
		this.testmarks = testmarks;
	}
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testmarks=" + testmarks + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testId == null) ? 0 : testId.hashCode());
		result = prime * result + ((testTitle == null) ? 0 : testTitle.hashCode());
		result = prime * result + ((testmarks == null) ? 0 : testmarks.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Test)) {
			return false;
		}
		Test other = (Test) obj;
		if (testId == null) {
			if (other.testId != null) {
				return false;
			}
		} else if (!testId.equals(other.testId)) {
			return false;
		}
		if (testTitle == null) {
			if (other.testTitle != null) {
				return false;
			}
		} else if (!testTitle.equals(other.testTitle)) {
			return false;
		}
		if (testmarks == null) {
			if (other.testmarks != null) {
				return false;
			}
		} else if (!testmarks.equals(other.testmarks)) {
			return false;
		}
		return true;
	}
	
	
}
