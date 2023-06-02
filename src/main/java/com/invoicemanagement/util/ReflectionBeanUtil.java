package com.invoicemanagement.util;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReflectionBeanUtil {
	public static void mapClassFields(Map<String, Object> map, Object entity) {
		for (Field field : entity.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String fieldType = field.getType().getSimpleName();
			try {
				if (field.getName() != "id" && map.get(field.getName()) != null) {
					String a = "";
					if (fieldType.equals("long")) {
						
						if (map.get(field.getName()).toString() != "") {
							a = map.get(field.getName()).toString();
						} else {
							a = "0";
						}
						
						field.set(entity, Long.parseLong(a));
					} else if (fieldType.equals("int")) {
						if (map.get(field.getName()).toString() != "") {
							a = map.get(field.getName()).toString();
						} else {
							a = "0";
						}
						field.set(entity, Integer.parseInt(a));
					} else if (fieldType.equals("float")) {
						if (map.get(field.getName()).toString() != "") {
							a = map.get(field.getName()).toString();
						} else {
							a = "0.0";
						}
						System.out.println(field.getName());
						field.set(entity, Float.parseFloat(a));
					} else if (fieldType.equals("Date")) {
						String dateString = map.get(field.getName()).toString();
						if (dateString.isEmpty()) {
							field.set(entity, null);
						} else {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date date = dateFormat.parse(dateString);
							field.set(entity, date);
						}
					} else if (fieldType.equals("boolean")) {
						field.set(entity, Boolean.parseBoolean(map.get(field.getName()).toString()));
					} else if (fieldType.equals("double")) {
						if (map.get(field.getName()).toString() != "") {
							a = map.get(field.getName()).toString();
						} else {
							a = "0";
						}
						field.set(entity, Double.parseDouble(a));
					} else if (fieldType.equals("String")){
						if (field.getName() != "id") {
			
							field.set(entity, map.get(field.getName()));
						}
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	public static  void map(Object dto, Object entity) {
		Map<String, Object>map = new HashMap<String, Object>();
		for (Field field : entity.getClass().getDeclaredFields()) {
			for(Field field1 : dto.getClass().getDeclaredFields()) {
				if(field.getName().equalsIgnoreCase(field1.getName())) {
					try {
						field.set(entity, map.get(field1.getName()));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					
				}
				
			}
			
			
		}	
		
	}
}
