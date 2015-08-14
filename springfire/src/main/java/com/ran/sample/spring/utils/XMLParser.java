package com.ran.sample.spring.utils;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.ran.sample.spring.model.Orders;

@Component
public class XMLParser {
	public Orders readObject(InputStream content) {
		Orders orders=null;		
				JAXBContext jaxbContext = null;
				try {
					jaxbContext = JAXBContext.newInstance(Orders.class);
					Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
					orders= (Orders) jaxbUnmarshaller.unmarshal(content);					 
				} catch (JAXBException e) {
					e.printStackTrace();
				}	
				return orders;
	}
}
