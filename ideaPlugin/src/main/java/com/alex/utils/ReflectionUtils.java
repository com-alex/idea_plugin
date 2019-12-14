package com.alex.utils;

import com.alex.annotation.Column;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2019-12-09
 * 反射工具类
 * 用于创建实例对象和实例对象链表
 */
public class ReflectionUtils {

    public static List<Object> createObjects(Class clazz, List<List<Object>> fieldsGroud){
        List<Object> objectList = new ArrayList<>();
        for(List<Object> fields : fieldsGroud){
            Object object =  ReflectionUtils.createObject(clazz, fields);
            objectList.add(object);
        }
        return objectList;
    }

    public static Object createObject(Class clazz, List<Object> params){
        Object object = null;
        try {
            object = clazz.newInstance();
            Field[] f = clazz.getDeclaredFields();
            for (int i = 0; i < f.length; i++){
                String attributeName = f[i].getName();
                String methodName=attributeName.substring(0,1).toUpperCase()+attributeName.substring(1);
                try {
                    Method setMethod = clazz.getMethod("set" + methodName, String.class);
                    setMethod.invoke(object, params.get(i));
                } catch (NoSuchMethodException e) {
                    Method setMethod = null;
                    try {
                        setMethod = clazz.getMethod("set" + methodName, Integer.class);
                        setMethod.invoke(object, params.get(i));
                    } catch (NoSuchMethodException ex) {
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    } catch (InvocationTargetException ex) {
                        ex.printStackTrace();
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static List<Object> getObjectParams(Object object){
        List<Object> objectParams = new ArrayList<>();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            String attributeName = fields[i].getName();
            String methodName=attributeName.substring(0,1).toUpperCase()+attributeName.substring(1);
            Object result;
            try {
                Method getMethod=clazz.getMethod("get"+methodName);
                result = getMethod.invoke(object);
                objectParams.add(result);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return objectParams;
    }


    public static List<String> getAttributeAnnotations(Object object){
        List<String> attributeAnnotations = new ArrayList<>();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            Column column = fields[i].getAnnotation(Column.class);
            if(column != null){
                attributeAnnotations.add(column.column());
            }
        }
        return attributeAnnotations;
    }
}
