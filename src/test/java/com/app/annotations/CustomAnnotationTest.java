package com.app.annotations;

import com.busi.interceptor.annotation.Table;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author WangLei
 * on 2018/3/8
 */
public class CustomAnnotationTest {

    @Test
    public void testAnnotation() {
        String packageName = "com.busi.domain.*";
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> classList = reflections.getTypesAnnotatedWith(Table.class);
        for (Class classes : classList) {
            System.out.println(classes.toString());
        }
    }

}
