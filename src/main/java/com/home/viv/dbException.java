package com.home.viv;

import java.sql.SQLException;

/**
 * Created by viv on 14.06.2017.
 */
public class dbException {




    public class NoSuchPersonException extends SQLException {

        public NoSuchPersonException() {
            super();
        }

        public NoSuchPersonException(String message) {
            super(message);
        }




    }


}
