package it.Test;

import it.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void testBeanutils() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        BeanUtils.setProperty(user,"username","唐绍权");
        System.out.println(user);

    }
}
