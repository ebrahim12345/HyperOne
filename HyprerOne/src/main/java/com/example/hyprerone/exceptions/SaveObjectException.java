package com.example.hyprerone.exceptions;


import com.example.hyprerone.enums.ErrorCode;

/**
 * @author mosio
 */
public class SaveObjectException extends EkiDaoException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param errorCode
     */
    public SaveObjectException () {
        super(ErrorCode.SAVE_ERROR);
    }
}
