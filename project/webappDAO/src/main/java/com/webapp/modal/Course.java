package com.webapp.modal;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="course")
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 private Integer courseid;
	 private String coursename;
	 private Set<Student> student=new HashSet<Student>();
	 @Version
	 private Long version;
	 
	 public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	@Column(length= 8)
	 private Float fee;
	
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinTable(name = "stu_course",joinColumns = { 
				@JoinColumn(name = "STU_ID", nullable = false, updatable = false) }
				)
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CID", unique = true, nullable = false)
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}
	 @Column(length=8)
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Float getFee() {
		return fee;
	}
	public void setFee(Float fee) {
		this.fee = fee;
	}
	 

}
