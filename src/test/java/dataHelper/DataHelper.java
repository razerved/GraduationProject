package dataHelper;

import configuration.ReadProperties;
import models.Users;

public class DataHelper {
    public static Users getUser() {
        Users user = new Users();
        user.setEmail(ReadProperties.email());
        user.setPassword(ReadProperties.password());

        return user;
    }
}
