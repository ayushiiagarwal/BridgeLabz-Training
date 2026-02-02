import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted");
    }
}

public class RoleBasedAccess {

    static String currentRole = "USER"; 

    public static void main(String[] args) throws Exception {
        AdminService service = new AdminService();
        Method method = service.getClass().getMethod("deleteUser");

        RoleAllowed role = method.getAnnotation(RoleAllowed.class);

        if (role.value().equals(currentRole))
            method.invoke(service);
        else
            System.out.println("Access Denied!");
    }
}