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
    @org.junit.Test
    public void runA() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Test1 test1 = Mockito.mock(Test1.class);
        test1.setName("sss");
        when(test1.getName()).thenReturn("success");
        verify(test1).setName("sss");
        System.out.println(test1.getName());

        Test2 test2 = Mockito.mock(Test2.class);
        when(test2.getName()).thenReturn("success");
        System.out.println(test2.getName());

        PowerMockito.mockStatic(Test3.class);
        when(Test3.getStr()).thenReturn("success");
        System.out.println(Test3.getStr());

    }
}
