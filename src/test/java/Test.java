import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Test3.class})
public class Test {
    Test1 test1;
    Test2 test2;

    @Before
    public void runB() {
        test1 = Mockito.mock(Test1.class);
        test2 = Mockito.mock(Test2.class);
    }

    @org.junit.Test
    public void runA() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        test1.setName("sss");
        when(test1.getName()).thenReturn("success");
        verify(test1).setName("sss");
        System.out.println(test1.getName());

        when(test2.getName()).thenReturn("success");
        System.out.println(test2.getName());

        PowerMockito.mockStatic(Test3.class);
        when(Test3.getStr()).thenReturn("success");
        System.out.println(Test3.getStr());
    }

    @After
    public void runC() {}
}
