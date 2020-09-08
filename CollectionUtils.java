package com.cy.pj.sys.entity;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.ss.formula.functions.Count;

/**
 * 数据集合工具类
 * @author ningwz
 * @date 2020/09/08
 */
public class CollectionUtils {
	
	/**
	 * 判断为空集合
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return null == collection || collection.size() <=0 || collection.isEmpty();
	}
	
	/**
	 * 获取指定集合长度
	 * @param collection
	 * @return
	 */
	public static int size(Collection<?> collection) {
		return null == collection ? 0 :collection.size();
	}
	
	/**
	 * 获取Map长度
	 * @param map
	 * @return
	 */
	public static int size(Map map) {
		return null == map ? 0 : map.size();
	}
	
	/**
	 * 将list转换为多行的列表
	 * @param <T>
	 * @param objList 原始数据List
	 * @param colNumber 每行数量
	 * @param clazz
	 * @return
	 */
	public static <T> List<List<T>> getRowList(List<T> objList, int colNumber, Class<T> clazz){
		if (colNumber <=0) colNumber = 10;
		List<List<T>> resultList = new ArrayList<List<T>>();
		List<T> tmpList = null;
		int count = 0;
		for (T obj : objList) {
			if (count == 0) {
				tmpList = new ArrayList<T>();
			}
			if (count < colNumber) {
				tmpList.add(obj);
				count +=1;
			}
			if (count >=colNumber) {
				resultList.add(tmpList);
				tmpList = null;
				count = 0;
			}
		}
		if (null != tmpList) {
			resultList.add(tmpList);
		}
		return resultList;
	}
	
	/**
	 * 字符列表转字符串
	 * @param collection
	 * @return
	 */
	public static String collectionToStr(Collection<String> collection) {
		if (isEmpty(collection)) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		String separator = "";
		for (String value : collection) {
			builder.append(separator);
			builder.append(value);
			separator = ",";
		}
		return builder.toString();
	}
	
	/**
	 * Integer型列表转字符串,以逗号分割
	 * @param collection
	 * @return
	 */
	public static String integerCollectionToStr(Collection<Integer> collection) {
		if (isEmpty(collection)) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		String separator = "";
		for (int value : collection) {
			builder.append(separator);
			builder.append(value);
			separator = ",";
		}
		return builder.toString();
	}
	
	/**
	 * 数组转List
	 * @param array
	 * @return
	 */
	public static List<File> arrayToList(File[] array){
		array = Optional.ofNullable(array).orElse(new File[] {});
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	/**
	 * 数组转List
	 * @param array
	 * @return
	 */
	public static List<String> arrayToList(String[] array){
		array = Optional.ofNullable(array).orElse(new String[] {});
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	/**
	 * 数组转List
	 * @param array
	 * @return
	 */
	public static List<Long> arrayToList(Long[] array){
		array = Optional.ofNullable(array).orElse(new Long[] {});
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	/**
	 * 数组转List
	 * @param array
	 * @return
	 */
	public static List<Integer> arrayToList(Integer[] array){
		array = Optional.ofNullable(array).orElse(new Integer[] {});
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	/**
	 * 数组转List
	 * @param array
	 * @return
	 */
	public static List<Field> arrayToList(Field[] array){
		array = Optional.ofNullable(array).orElse(new Field[] {});
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	/**
	 * 集合中是否包含指定对象数据,若包含则返回true,否则返回false
	 * @param collection
	 * @param o
	 * @return
	 */
	public static boolean contains(Collection collection,Object o) {
		return Optional.ofNullable(collection).map(c -> c.contains(o)).orElse(false);
	}
	
	/**
	 * 集合中是否不包含指定对象数据,不包含则返回true,否则返回false
	 * @param collection
	 * @param o
	 * @return
	 */
	public static boolean notcontains(Collection collection,Object o) {
		return !contains(collection, o);
	}
	
	/**
	 * Map中是否包含指定Key,包含返回true,否则返回false
	 * @param collection
	 * @param o
	 * @return
	 */
	public static boolean containsKey(Map<Object, Object> map,Object key) {
		return Optional.ofNullable(map).map(m->m.containsKey(key)).orElse(false);
	}
	
	/**
	 * Map中是否不包含指定Key,不包含返回true,否则返回false
	 * @param collection
	 * @param o
	 * @return
	 */
	public static boolean notContainsKey(Map<Object, Object> map,Object key) {
		return !containsKey(map, key);
	}
	
	
}
