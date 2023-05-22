package com.invoicemanagement.util;

import java.lang.reflect.Field;
import java.util.Map;

public class ReflectionBeanUtil {

public static void mapClassFields(Map<Object, Object> map, Object entity) {
		
		for (Field field : entity.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String fieldType = field.getType().getSimpleName();
			try {

				if (field.getName() != "id" && map.get(field.getName()) != null) {

					if (fieldType.equals("long")) {

						String a = "";
						if (map.get(field.getName()).toString() != "") {
							a = map.get(field.getName()).toString();
						} else {
							a = "0";
						}
						field.set(entity, Long.parseLong(a));

					} else if (fieldType.equals("int")) {

						field.set(entity, Integer.parseInt(map.get(field.getName()).toString()));

					} else if (fieldType.equals("float")) {

						field.set(entity, Float.parseFloat(map.get(field.getName()).toString()));

					}

					/*
					 * else if (fieldType.equals("List")) { System.out.println(field.getName()); //
					 * System.out.println(map.get(field.getName()));
					 * System.out.println(field.getClass()); Object o = (Object)
					 * map.get(field.getName()); List<Object> listValue = (List<Object>)o; // Field
					 * stringListField = testClass.getDeclaredField("stringList") ParameterizedType
					 * stringListType = (ParameterizedType) field.getGenericType(); Class<?>
					 * stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
					 * System.out.println("++++++++++"+stringListClass.getCanonicalName()); Object
					 * listEntity=null; try { listEntity =
					 * (Object)Class.forName(stringListClass.getCanonicalName()).newInstance(); }
					 * catch (InstantiationException e) { // TODO Auto-generated catch block
					 * e.printStackTrace(); } catch (ClassNotFoundException e) { // TODO
					 * Auto-generated catch block e.printStackTrace(); } List<?> entityList = new
					 * ArrayList<>(); for(Field fi: listEntity.getClass().getDeclaredFields()) {
					 * if(field.getName() != "id" && field.getName()!="client") {
					 * fi.set(stringListClass, map.get(fi.getName()));
					 * System.out.println("fgfgfgfgfgfgfgfg"+fi); }
					 * 
					 * } }
					 */

					else {
						System.out.println(field.getType()+"---"+field.getName());
						field.set(entity, map.get(field.getName()));
					}

				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * public static void mapClassFields(Map<Object, Object> map, Object entity) {
	 * 
	 * for (Field field : entity.getClass().getDeclaredFields()) {
	 * field.setAccessible(true); String fieldType =
	 * field.getType().getSimpleName(); try {
	 * 
	 * if (field.getName() != "id" && map.get(field.getName()) != null) {
	 * 
	 * if (fieldType.equals("long")) {
	 * 
	 * String a = ""; if (map.get(field.getName()).toString() != "") { a =
	 * map.get(field.getName()).toString(); } else { a = "0"; } field.set(entity,
	 * Long.parseLong(a));
	 * 
	 * } else if (fieldType.equals("int")) {
	 * 
	 * field.set(entity, Integer.parseInt(map.get(field.getName()).toString()));
	 * 
	 * } else if (fieldType.equals("float")) {
	 * 
	 * field.set(entity, Float.parseFloat(map.get(field.getName()).toString()));
	 * 
	 * }
	 * 
	 * else if (fieldType.equals("String")){
	 * 
	 * field.set(entity, map.get(field.getName())); } else {
	 * System.out.println(field.getName()); entity= field.getName();
	 * field.setAccessible(true); String fieldType1 =
	 * field.getType().getSimpleName(); for (Field field1 :
	 * entity.getClass().getDeclaredFields()) { try {
	 * 
	 * if (field1.getName() != "id" && map.get(field1.getName()) != null) {
	 * 
	 * if (fieldType1.equals("long")) {
	 * 
	 * String a = ""; if (map.get(field1.getName()).toString() != "") { a =
	 * map.get(field1.getName()).toString(); } else { a = "0"; } field1.set(entity,
	 * Long.parseLong(a));
	 * 
	 * } else if (fieldType1.equals("int")) {
	 * 
	 * field1.set(entity, Integer.parseInt(map.get(field1.getName()).toString()));
	 * 
	 * } else if (fieldType1.equals("float")) {
	 * 
	 * field1.set(entity, Float.parseFloat(map.get(field1.getName()).toString()));
	 * 
	 * }
	 * 
	 * else if (fieldType1.equals("String")){ field1.set(entity,
	 * map.get(field1.getName())); } else { entity= field1.getName();
	 * 
	 * field1.set(entity, map.get(field1.getName())); }
	 * 
	 * } } catch (IllegalAccessException e) { e.printStackTrace(); }
	 * 
	 * } //field.set(entity, map.get(field.getName())); }
	 * 
	 * } } catch (IllegalAccessException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */
}
