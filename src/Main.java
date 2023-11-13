public class Main {
    public static boolean authorization(String login, String password, String confirmPassoword){
        boolean loginLength = login.length()<= 20;
        boolean loginMatch = login.matches("[a-zA-Z0-9_]+");
        boolean passwordLength = password.length() <= 20;
        boolean passwordMatch = password.matches("[a-zA-Z0-9_]+");
        boolean passwordConfirmed = password.equals(confirmPassoword);

        if (!loginLength) {
            throw new WrongLoginException("Недопустимая длина логина");
        }

        if (!loginMatch) {
            throw new WrongLoginException("Логин может содержать только латинскиe символы, цифры и знаки подчеркивания");
        }

        if (!passwordLength) {
            throw new WrongPasswordException("Недопустимая длина пароля");
        }

        if (!passwordMatch) {
            throw new WrongPasswordException("Пароль может содержать только латинскиe символы, цифры и знаки подчеркивания");
        }

        if (!passwordConfirmed) {
            throw new WrongConfirmPasswordException("Поля пароль и подтвержение пароля не одинаковые");
        }

        return true;
    }
    public static void main(String[] args) {
        try {
            boolean authorization = authorization("Qwerty_12", "password1", "password1");
            if (authorization) {
                System.out.println("Регистрация прошла успешно");
            }
        } catch (WrongLoginException e) {
            System.out.println("Логин не верен, регистрация не возможна");
        } catch (WrongPasswordException e) {
            System.out.println("Пароль не верен, регистрация не возможна");
        } catch (WrongConfirmPasswordException e) {
            System.out.println("Пароль не совпадает, регистрация не возможна");
        }
    }
}