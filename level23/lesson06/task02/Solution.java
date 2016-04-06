package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {


    public static final class Constants {

        public final static String SERVER_NOT_ACCESSIBLE_EXCEPTION = "Server is not accessible for now.";
        public final static String UNAUTHORIZED_USER_EXCEPTION = "User is not authorized.";
        public final static String BANNED_USER_EXCEPTION = "User is banned.";
        public final static String RESTRICT_EXCEPTION = "Access is denied.";


        public class ServerNotAccessibleException extends Exception {
            public ServerNotAccessibleException() {
                super(Constants.SERVER_NOT_ACCESSIBLE_EXCEPTION);
            }

            public ServerNotAccessibleException(Throwable cause) {
                super(Constants.SERVER_NOT_ACCESSIBLE_EXCEPTION, cause);
            }
        }

        public class UnauthorizedUserException extends Exception {
            public UnauthorizedUserException() {
                super(Constants.UNAUTHORIZED_USER_EXCEPTION);
            }

            public UnauthorizedUserException(Throwable cause) {
                super(Constants.UNAUTHORIZED_USER_EXCEPTION, cause);
            }
        }

        public class BannedUserException extends Exception {
            public BannedUserException() {
                super(Constants.BANNED_USER_EXCEPTION);
            }

            public BannedUserException(Throwable cause) {
                super(Constants.BANNED_USER_EXCEPTION, cause);
            }
        }

        public class RestrictionException extends Exception {
            public RestrictionException() {
                super(Constants.RESTRICT_EXCEPTION);
            }

            public RestrictionException(Throwable cause) {
                super(Constants.RESTRICT_EXCEPTION, cause);
            }
        }

    }
}
