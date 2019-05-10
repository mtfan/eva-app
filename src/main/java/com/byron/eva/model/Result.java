package com.byron.eva.model;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/4/29
 */
public class Result<T> {
    private static final String SUCCESS_CODE = "0000000";
    private String errorCode;
    private String errorMessage;
    private T data;

    public Result() {
    }

    public Result(Result<T> old) {
        if (null != old.getErrorCode()) {
            this.errorCode = new String(old.getErrorCode());
        }

        if (null != old.getErrorMessage() && !"".equals(old.getErrorMessage())) {
            this.errorMessage = new String(old.getErrorMessage());
        }

        if (null != old.getData()) {
            this.data = old.getData();
        }

    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> error(String errorCode, Object errorMessage) {
        Result<T> result = new Result();
        result.setErrorCode(errorCode);
        result.setErrorMessage(errorMessage.toString());
        return result;
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result();
        result.setErrorCode("0000000");
        result.setErrorMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> empty() {
        Result<T> result = new Result();
        result.setErrorCode("0000000");
        result.setErrorMessage("empty");
        result.setData(null);
        return result;
    }

    public boolean isSucceed() {
        return "0000000".equals(this.errorCode);
    }

    @Override
    public String toString() {
        return this.data != null ? "ResponseResult [errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data.toString() + "]" : "ResponseResult [errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + "]";
    }

    public static class Void {
        public static final Result.Void V = null;

        private Void() {
        }
    }
}