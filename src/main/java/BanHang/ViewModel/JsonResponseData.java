package BanHang.ViewModel;

public class JsonResponseData<T> extends JsonResponse {

    private T Data;

    public JsonResponseData(Boolean success, String message, T Data) {
        super(success, message);
        this.Data = Data;
    }

    public T getData() {
        return Data;
    }

    public void setData(T Data) {
        this.Data = Data;
    }
}
