package com.example.demo.data.vo.v1;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;


public class PersonVo extends RepresentationModel<PersonVo> implements Serializable {

	private static final long serialVersionUID = 1L;
	

	
	private long key;
	private String firstName; 
	private String lasttName;
	private String address;    
	private String gender;
	private Date birthday;
	
	public PersonVo() {
		
	}
	
	
	
	
	
	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = new Date();
	}



	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasttName() {
		return lasttName;
	}
	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(address, firstName, gender, key, lasttName);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVo other = (PersonVo) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && key == other.key
				&& Objects.equals(lasttName, other.lasttName);
	}
	
	
}
