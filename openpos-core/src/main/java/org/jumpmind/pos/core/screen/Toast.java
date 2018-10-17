package org.jumpmind.pos.core.screen;

public class Toast extends Screen {

    private static final long serialVersionUID = 1L;

    private String message;
    private ToastType toastType;
    private int duration = 2500;

    public static Toast createSuccessToast(String message) {
        Toast toast = new Toast(message);
        toast.setToastType(ToastType.Success);
        return toast;
    }

    public static Toast createWarningToast(String message) {
        Toast toast = new Toast(message);
        toast.setToastType(ToastType.Warn);
        toast.setDuration(0);
        return toast;
    }

    public Toast() {
        setScreenType("Toast");
        setName("Toast");
    }

    public Toast(String message) {
        this();
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ToastType getToastType() {
        return toastType;
    }

    public void setToastType(ToastType toastType) {
        this.toastType = toastType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
