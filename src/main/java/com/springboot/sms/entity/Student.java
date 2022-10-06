package com.springboot.sms.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.aspectj.apache.bcel.ExceptionConstants;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false)
	@NotEmpty(message = "First name must not be empty!")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "Last name must not be empty!")
	private String lastName;

	@Column(name = "email")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email!")
	private String email;

	@Column(name = "course")
	@NotEmpty(message = "Course must not be empty!")
	private String course;

	@Pattern(regexp = "^(09|\\+639)\\d{9}$", message = "Invalid mobile number!")
	@Size(max = 11, message = "mobile number should be 11")
	private String mobile;
	
	@NotEmpty(message="Please pick a gender")
	private String gender;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	private LocalDateTime timestamp = LocalDateTime.now();

	public Student() {

	}

	public Student(Long id, @NotEmpty(message = "First name must not be empty!") String firstName,
			@NotEmpty(message = "Last name must not be empty!") String lastName,
			@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email!") String email,
			@NotEmpty(message = "Course must not be empty!") String course,
			@Pattern(regexp = "^(09|\\+639)\\d{9}$", message = "Invalid mobile number!") @Size(max = 11, message = "mobile number should be 11") String mobile,
			@NotEmpty(message = "Please pick a gender") String gender, Date birthday, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.course = course;
		this.mobile = mobile;
		this.gender = gender;
		this.birthday = birthday;
		this.timestamp = timestamp;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
