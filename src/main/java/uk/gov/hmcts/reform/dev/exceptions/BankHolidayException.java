package uk.gov.hmcts.reform.dev.exceptions;

public class BankHolidayException extends RuntimeException {
    public BankHolidayException(String message) {
        super(message);
    }
}
