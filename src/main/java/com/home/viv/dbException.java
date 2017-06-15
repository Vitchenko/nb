package com.home.viv;

import java.sql.SQLException;

/**
 * Created by viv on 14.06.2017.
 */
public class dbException {




    public class NoSuchEmployeeException extends SQLException {

        public NoSuchEmployeeException() {
            super();
        }

        public NoSuchEmployeeException(String message) {
            super(message);
        }

        public NoSuchEmployeeException(Throwable cause) {
            super(cause);
        }

        public NoSuchEmployeeException(String reason, Throwable cause) {
            super(reason, cause);
        }
    }


}
