package validat;

/**
 * Created by elwin on 2017/11/8.
 */
public class ValidateMessage {

    /**
     * 验证目标结果KEY
     */
    private String key;

    /**
     * 反馈信息
     */
    private String message;

    /**
     * 验证结果
     */
    private Boolean result;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
