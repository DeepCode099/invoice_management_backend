package com.invoicemanagement.util;

import java.lang.reflect.Field;
import java.util.Map;

public class ReflectionBeanUtil {
	
	public void myFunction(Map<Object, Object> map, Object entity) throws ClassNotFoundException {
		for (Field field : entity.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String fieldType = field.getType().getSimpleName();

			try {
				if (field.getName() != "id") {
					if (fieldType.equals("long")) {

						field.set(entity, Long.parseLong(map.get(field.getName()).toString()));
					} else if (fieldType.equals("int")) {

						field.set(entity, Integer.parseInt(map.get(field.getName()).toString()));
					} else {
						field.set(entity, map.get(field.getName()));
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
