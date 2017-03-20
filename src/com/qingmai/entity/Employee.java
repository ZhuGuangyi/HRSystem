package com.qingmai.entity;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String degree;
	private String department;
	private String duty;
	private String state;
	private String introduction;
	private String path;
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIntroduction(){
		return introduction;
	}
	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}
	public String getPath(){
		return path;
	}
	public void setPath(String path){
		this.path = path;
	}
	
	
	public Employee(int id,String name, int age, String sex, String degree,
			String department, String duty, String state ,String introduction) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.degree = degree;
		this.department = department;
		this.duty = duty;
		this.state = state;
		this.introduction = introduction;
	}
	public Employee(String name ,int age ,String sex ,String degree ,String department ,String duty){
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.degree = degree;
		this.department = department;
		this.duty = duty;
	}
	public Employee(int id ,String name ,int age ,String sex ,String degree ,String department ,String duty,String path){
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.degree = degree;
		this.department = department;
		this.duty = duty;
		this.path = path;
	}
	public Employee(String name,String department,String duty){
		super();
		this.name = name;
		this.department = department;
		this.duty = duty;
	}
	public Employee(int id,String name,int age,String degree,String department,String duty){
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.degree = degree;
		this.department = department;
		this.duty = duty;
	}
	public Employee() {
		super();
	}
	
}
