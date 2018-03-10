package Exceptions;

public class FileNotReadableOrWritableException extends Exception {
    public FileNotReadableOrWritableException() {
        System.err.println("File is not readable or writable");
    }
}
