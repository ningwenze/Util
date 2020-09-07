package com.cy.pj.sys.entity;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * 对象相关处理工具类
 * @author ningwz
 * @date 2020/09/07
 */
public class ObjectUtils {
	/**
	 * 对象为空,返回true,否则返回false
	 * @param object
	 * @return
	 */
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}else if (object instanceof Object[]) {
			if (((Object[]) object).length <=0) {
				return true;
			}
		}else if (object instanceof String) {
			if (((String) object).length() <=0) {
				return true;
			}
		}else if (object instanceof Collection) {
			if (((Collection) object).isEmpty() || ((Collection) object).size() <= 0) {
				return true;
			}
		}else if (object instanceof Map) {
			if (((Map) object).isEmpty() || ((Map) object).size() <= 0) {
				return true;
			}
		}else if (object instanceof Byte[]) {
			if (((Byte[]) object).length <= 0) {
				return true;
			}
		}else if (object instanceof File) {
			if (!((File) object).isFile() || ((File) object).length() <= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 对象不为空,返回true,否则返回null
	 * @param object
	 * @return
	 */
	public static boolean isNotEmpty(Object object) {
		return !isEmpty(object);
	}

	/**
	 * 有一个对象为空,则返回true,否则返回false
	 * 此处可接受对象包括: 普通bean,String,Integer,Double,Float,Long,List,Set,Map等
	 * @return
	 */
	public static boolean isEmptyLeastOne(Object... objects) {
		if (objects == null) {
			return true;
		}
		for (Object object : objects) {
			if (isEmpty(object)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 全部对象为空,则返回true,否则返回false
	 * 此处可接受对象包括: 普通bean,String,Integer,Double,Float,Long,List,Set,Map等
	 * @return
	 */
	public static boolean isEmptyAll(Object... objects) {
		if (objects == null) {
			return true;
		}
		for (Object object : objects) {
			if (isEmpty(object)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 所有对象都不空时,则返回true,否则返回false
	 * 此处可接受对象包括: 普通bean,String,Integer,Double,Float,Long,List,Set,Map等
	 * @return
	 */
	public static boolean isNotEmptyAll(Object... objects) {
		if (objects == null) {
			return false;
		}
		for (Object object : objects) {
			if (isEmpty(object)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 至少有一个对象不为空时,返回true,否则返回false
	 * 此处可接受对象包括: 普通bean,String,Integer,Double,Float,Long,List,Set,Map等
	 * @return
	 */
	public static boolean isNotEmptyLeastOne(Object... objects) {
		if (objects == null) {
			return false;
		}
		for (Object object : objects) {
			if (isEmpty(object)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 包装的对象是否为空
	 * @param optional
	 * @return
	 */
	public static boolean isEmpty(Optional<?> optional) {
		return !optional.isPresent();
	};
	
	/**
	 * 包装的对象是否不为空
	 * @param optional
	 * @return
	 */
	public static boolean isNotEmpty(Optional<?> optional) {
		return !optional.isPresent();
	};
	
	/**
	 * 打印所有字段的set方法
	 * @param cls
	 */
	public static final void printAllSetMethods(Class cls) {
		if (isEmpty(cls)) {
			return;
		}
		Method[] fieldsArr = cls.getDeclaredMethods();
		if (fieldsArr.length == 0) {
			return;
		}
		for (Method f : fieldsArr) {
			String name = f.getName();
			if (name.contains("set")) {
				System.err.println("ao." + name + "();");
			}
		}
	}
}
