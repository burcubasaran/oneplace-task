package com.testautomation.task;

public class TestAutomationException extends RuntimeException {

    public TestAutomationException() {
    }

    public TestAutomationException(String message) {
        super(message);
    }

    public TestAutomationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestAutomationException(Throwable cause) {
        super(cause);
    }

    public TestAutomationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
