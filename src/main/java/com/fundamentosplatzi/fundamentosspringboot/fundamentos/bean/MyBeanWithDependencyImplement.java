package com.fundamentosplatzi.fundamentosspringboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printwithDependency() {
        LOGGER.info("Hemos ingresado al metodo printwithDependency");
        int numero = 1;
        LOGGER.debug("EL numero enviado como parametro a la dependencia operacion es"+numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Hola desde la implementacion de un bean con dependecia");

    }
}
