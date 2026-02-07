package view;

public enum ErrorMessage {
    SYSTEM_IO_ERROR("System IO Error"),
    ABNORMAL_EXIT("Abnormal Exit"),
    INVALID_INPUT_NUMBER("숫자만 입력해주세요."),
    INVALID_INPUT_LENGTH("3자리의 숫자를 입력해주세요.");

    private static final String ERROR_PREFIX_MSG = "[ERROR]: ";
    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return ERROR_PREFIX_MSG + msg;
    }
}
