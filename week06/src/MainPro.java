import java.util.logging.*;
import java.io.IOException;

public class MainPro {
    private static final Logger logger = Logger.getLogger(MainPro.class.getName());

    static {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("app.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false); // 关闭控制台输出

    }

    // 多层调用链
    public static void serviceLayer(String name, int age) throws ApplicationException {
        try {
            businessLogicLayer(name, age);
        } catch (ApplicationException e) {
            logger.log(Level.SEVERE, "Service layer error!", e);
            throw new ApplicationException("Service error!", e);
        }
    }

    private static void businessLogicLayer(String name, int age) throws ApplicationException {
        UserRegistrationPro registration = new UserRegistrationPro();
        registration.registerUser(name, age);
    }

    public static void main(String[] args) {
        test("fQwQf", 18);   // 正常注册
        test("fQwQf6", 18);   // 非法字符
        test("fQ", 16);    // 姓名过短+年龄不足
    }

    private static void test(String name, int age) {
        try {
            serviceLayer(name, age);
            System.out.println("Success: " + name );
        } catch (ApplicationException e) {
            System.out.println("Fail: " + name + ": " + e.getMessage());
        }
    }
}