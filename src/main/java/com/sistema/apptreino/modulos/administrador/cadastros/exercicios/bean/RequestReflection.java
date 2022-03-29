package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.bean;

import com.sistema.apptreino.TagConstants;
import com.sistema.apptreino.dao.TabNivelTreinoObj;
import lombok.Getter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@Getter
public class RequestReflection {

    private Class requestClass;
    private Constructor requestConstructor;
    private Object requestObject;
    private Method requestMethod;



    public RequestReflection(String element) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> elementClass = Class.forName(TagConstants.PACKAGE_EXERCICIOS + element);
        requestClass = elementClass;

        requestConstructor();
        requestObject();
    }

    private void requestConstructor() throws NoSuchMethodException {
        Constructor<?> constructor = requestClass.getConstructor();
        requestConstructor = constructor;
    }

    private void requestObject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Object object = requestConstructor.newInstance();
        requestObject = object;
    }

    public void requestMethod(String action) throws NoSuchMethodException {
        Method method = requestClass.getDeclaredMethod(action);
        requestMethod = method;
    }

    public Object invocarMetodo() {
        try {
            return requestMethod.invoke(requestObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e){
        }
        return new Object();
    }
}
