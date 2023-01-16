package com.backFalahApp.BackFalahApp.exceptions;

public class FileTypeInappropriateException extends UserException {
    public FileTypeInappropriateException(String actual, String... expected) {
        super(FileTypeInappropriateException.class.getSimpleName(), "expected one of the following file types: " + String.join(", ", expected) + "but found : " + actual);
    }
}
