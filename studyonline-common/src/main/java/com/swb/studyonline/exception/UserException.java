package com.swb.studyonline.exception;

/**
 * <p>文件  UserException</p>
 * <p>时间  2020-12-26 21:06:56</p>
 *
 * @author swb
 */
public class UserException extends ErrorException{
    private Type type;

    public UserException(String message) {
        super(message);
        this.type = Type.LACK_PARAMETER;
    }

    public UserException(Type type, String message) {
        super(message);
        this.type = type;
    }

    public Type type(){
        return type;
    }


    public enum Type{
        WRONG_PAGE_NUM,LACK_PARAMETER,USER_NOT_LOGIN,USER_NOT_FOUND,USER_AUTH_FAIL,USER_EMAIL_HAVE,USER_HAVE,
        USER_USERNAMEORPASSWORD_NULL,USER_USERNAME_NOT_HAVA,USER_PASSWORD_ERROR,USER_EMAIL_NOT_REGISTER,USER_Insufficient_permissions
    }
}
