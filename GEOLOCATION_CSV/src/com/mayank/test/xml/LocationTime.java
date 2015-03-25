package com.mayank.test.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="result")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationTime {
	
	 @XmlElement(name="status")
	private String status;
	 
	 @XmlElement(name="message")
	private String message;
	 
	 @XmlElement(name="countryCode")
	private String countryCode;
	 
	 @XmlElement(name="zoneName")
	private String zoneName;
	 
	 @XmlElement(name="abbreviation")
	private String abbreviation;
	 
	 @XmlElement(name="gmtOffset")
	private String gmtOffset;
	 
	 @XmlElement(name="dst")
	private String dst;
	 
	 @XmlElement(name="timestamp")
	private String timestamp;
	
	
	 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getGmtOffset() {
		return gmtOffset;
	}
	public void setGmtOffset(String gmtOffset) {
		this.gmtOffset = gmtOffset;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	

}

