import java.util.HashMap;
import java.util.Map;

public class LoginUtil {
    private static Map<String, String> loginData = new HashMap<>();
    static {
        loginData.put("Diablo99", "gbhg56jhkf_");
        loginData.put("member_1", "qwerty123456");
        loginData.put("SantaClaus", "NewYear2022");
        loginData.put("misterX", "_password_");
        loginData.put("Mathematical_maniac", "3_14159265358979323");
    }


    static boolean isUserAuthentic(String login, String password){
        try {
            isLoginValid(login);
            isPasswordValid(password);

        } catch (WrongLoginException | WrongPasswordException exception){
            return false;
        }
        return true;
    }

    private static void isLoginValid(String login) throws WrongLoginException{
            if(!(login.matches("^[a-zA-Z0-9|_]+$") && login.length()<20 && loginData.containsKey(login))){
                throw new WrongLoginException("Login is incorrect");
            }
    }

    private static void isPasswordValid(String password) throws WrongPasswordException{
        if(!(password.matches("^[a-zA-Z0-9|_]+$") && password.length()<20)){
            throw new WrongPasswordException("Password is incorrect");
        }
    }
}
