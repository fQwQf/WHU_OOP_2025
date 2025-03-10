import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String name;
    private int age;
    private String email;
    private String address;
    private String phone;
    private String gender;
    private String occupation;
}