package com.ran.sample.spring.utils;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

public class DozerHelper {

	public static<T,U> ArrayList<U> map( Mapper mapper, List<T> source, Class<U> destinationType, String mapId){
		ArrayList<U> destinationList = new ArrayList<>();
		for(T t: source){
			U u=null;
			if(mapId != null){
				u = mapper.map(t, destinationType,mapId );
			}else{
				u= mapper.map(t, destinationType);
			}
			if(u != null){
				destinationList.add(u);
			}
		}
		return destinationList;
	}
}
