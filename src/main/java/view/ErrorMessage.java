package view;

public enum ErrorMessage {
    SYSTEM_IO_ERROR("System IO Error"),
    ABNORMAL_EXIT("Abnormal Exit"),
    INVALID_INPUT_NUMBER("Invalid Input Number");

    private static final String ERROR_PREFIX_MSG = "[ERROR]: ";
    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return ERROR_PREFIX_MSG + msg;
    }
}
