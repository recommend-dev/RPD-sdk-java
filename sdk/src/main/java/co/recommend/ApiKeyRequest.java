package co.recommend;

public class ApiKeyRequest
{
    public String Code;
    public String ApiToken;
    public String Phone;
    public String Email;
    
    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
    
    public String getApiToken() {
        return ApiToken;
    }

    public void setApiToken(String apiToken) {
        ApiToken = apiToken;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}