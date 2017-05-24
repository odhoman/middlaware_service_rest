package com.anibal.educational.rest_service.domain;

import java.util.Date;

public class TicketUser implements Cloneable{
	
	private Long userId;
	private String userName;
	private String userPassword;
	private String userFirstame;
	private String userLastName;
	private String userEmail;
	private String userPhoneNumber;
	private Date hireDateStart;
	private Date hireDateEnd;

	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;

	private Long employeeId;
	private String employeeDesc;

	private Long imageId;
	private String pathImage;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFirstame() {
		return userFirstame;
	}
	public void setUserFirstame(String userFirstame) {
		this.userFirstame = userFirstame;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public Date getHireDateStart() {
		return hireDateStart;
	}
	public void setHireDateStart(Date hireDateStart) {
		this.hireDateStart = hireDateStart;
	}
	public Date getHireDateEnd() {
		return hireDateEnd;
	}
	public void setHireDateEnd(Date hireDateEnd) {
		this.hireDateEnd = hireDateEnd;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeDesc() {
		return employeeDesc;
	}
	public void setEmployeeDesc(String employeeDesc) {
		this.employeeDesc = employeeDesc;
	}
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

    public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Override
	public String toString() {
		return "TicketUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userFirstame=" + userFirstame + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userPhoneNumber=" + userPhoneNumber + ", hireDateStart=" + hireDateStart + ", hireDateEnd="
				+ hireDateEnd + ", street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", country=" + country + ", employeeId=" + employeeId + ", employeeDesc=" + employeeDesc
				+ ", imageId=" + imageId + ", pathImage=" + pathImage + "]";
	}
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	

}
