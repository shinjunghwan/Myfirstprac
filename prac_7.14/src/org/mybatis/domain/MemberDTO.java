package org.mybatis.domain;

public class MemberDTO {
	String name;
	int age;
	int height;
	int weight;
	char sex;
	static String highlight = "";
	
	public String getHighlight() {
		return highlight;
	}
	public void setHighlight(String highlight) {
		MemberDTO.highlight = highlight;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
}
