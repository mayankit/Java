package com.mayank.test.client;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.mayank.test.xml.LocationTime;

public class APIClient {
	
	
	private String lattitude;
	private String longitude;
	private final String APIKEY = "MZWZ54TVHPCT";
	private String url =  "http://api.timezonedb.com/?";
	
	
	public APIClient(String lattitude, String longitude) {
		super();
		this.longitude = longitude;
		this.lattitude = lattitude;	
	}
	
	public LocationTime getLocationTime(){
		
		url = url+"lat="+lattitude+"&lng="+longitude+"&key="+APIKEY;
		
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://api.timezonedb.com/?lat=-44.490947&lng=171.220966&key=MZWZ54TVHPCT");
		try {
			HttpResponse response = client.execute(request);
			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(LocationTime.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        return (LocationTime) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	
	public long getTimeStamp(String date) throws ParseException{
		
		DateFormat formatter = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date d  = formatter.parse(date);
		/*Calendar c = Calendar.getInstance(); 
	    c.setTime(d);*/
		return d.getTime()/1000;
	}
	
	public String getDate(long timestamp,String timeZone){
		DateFormat formatter = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
		Date d = new Date(timestamp*1000L);
		return formatter.format(d);
		
	}
	
	
	
	
	
	
	

}
