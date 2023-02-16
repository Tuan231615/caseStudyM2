package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{8,50})";
    public Password(){
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }
    public boolean validatePassword(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
