package springbootTest;

import com.dfgx.user.proxy.ProxyStudentService;
import com.dfgx.user.service.StudentService;
import com.dfgx.user.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
public class MapperTest {

    @Test
    public void mapperTest1 () throws Exception{
        StudentService studentService = new StudentServiceImpl();
        StudentService stu = (StudentService)Proxy.newProxyInstance(studentService.getClass().getClassLoader(),
                studentService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
                        return method.invoke(studentService,args);
                    }
                });
        try{
            System.out.println(stu.selectByName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
