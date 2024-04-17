package exercise1;
import java.util.Scanner;

class LoginFailedException extends Exception {
    public LoginFailedException(){
        super("Login failed");
    }
}

class UserManager {
    private String name = "admin";
    private String password = "admin";

    public void changeUserNameAndPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username and Password");
        String inputUserName = scanner.nextLine();
        String inputPassword = scanner.nextLine();
        if (name.equals(inputUserName) || password.equals(inputPassword)) {
            System.out.println("Enter New User Name: ");
            this.name = scanner.nextLine();
            System.out.println("Enter New User Password: ");
            this.password = scanner.nextLine();
            scanner.close();
        } else {
            System.out.println("Wrong username or password");
        }
    }

    public void login(String name, String password) throws LoginFailedException {
        if (this.name.equals(name) && this.password.equals(password)) {
            System.out.println("Login Successful");
        } else {
            throw new LoginFailedException();
        }
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class testException {
    public static void main(String[] args) {
        UserManager user1 = new UserManager();
        System.out.println(user1);
        try {
            user1.login("testUser", "testPassword");
        }
        catch (LoginFailedException e) {
            System.out.println("Wrong: "+e.getMessage());
        }
        finally{
            System.out.println("End of login");
        }
    }
}
