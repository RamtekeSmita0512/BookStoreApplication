package com.bridgelabz.BookStoreApplication.utility;


import org.springframework.stereotype.Component;


@Component
public class Response {
	private  String reponsemessage;
	private Integer ReponseStatus;
	private Object RespobseData;
	
	
	public Response(String reponsemessage, Integer reponseStatus, Object respobseData) {
	
		this.reponsemessage = reponsemessage;
		ReponseStatus = reponseStatus;
		RespobseData = respobseData;
	}


	public Response() {
		
	}


	public String getReponsemessage() {
		return reponsemessage;
	}


	public void setReponsemessage(String reponsemessage) {
		this.reponsemessage = reponsemessage;
	}


	public Integer getReponseStatus() {
		return ReponseStatus;
	}


	public void setReponseStatus(Integer reponseStatus) {
		ReponseStatus = reponseStatus;
	}


	public Object getRespobseData() {
		return RespobseData;
	}


	public void setRespobseData(Object respobseData) {
		RespobseData = respobseData;
	}
	
	

}
