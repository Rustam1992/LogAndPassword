import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.WrongMethodTypeException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String login = reader.readLine();
        String pass = reader.readLine();
        String confirmPass = reader.readLine();
        confirm(login, pass, confirmPass);
        int age;
        age = Integer.parseInt(reader.readLine());
        if (age <=18 ) {
            System.out.println("вы еще маленький)))");
        } else {
            System.out.println("welcome");
        }


    }

    private static boolean checkChars(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '_' || (ch[i] <= 'z' && ch[i] >= 'a') || (ch[i] <= 'Z' && ch[i] >= 'A')) {
                return false;
            }

        }
        return true;
    }

    public static boolean confirm(String login, String pass, String confirmPass) {
        try {
            if (login.length() >= 20 || checkChars(login.toCharArray())) {
                throw new WrongLoginException("неправильный логин");
            }
            if (!pass.equals(confirmPass)) {
                throw new WrongPasswordException("неправильный пароль");
            }
        } catch (WrongLoginException e) {
            e.printStackTrace();
            return false;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}

