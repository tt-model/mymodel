package com.application.v1.library;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class CustomSelectAnalyze {

   private static final String basePackage = "com.application.v1.library.select";

   private static final String methodName = "getOption";

   public Map<String, Object> parseSelect(String name) {
       Map<String, Object> optionMap = new HashMap<>();
       String basePackageName = basePackage + "." + name;
       try {
           Class<?> classes = Class.forName(basePackageName);
           Object object = classes.newInstance();
           Method method = classes.getDeclaredMethod(methodName);
           optionMap = (Map<String, Object>) method.invoke(object);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InstantiationException e) {
           e.printStackTrace();
       } catch (NoSuchMethodException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       } finally {
           return optionMap;
       }
   }

}
