package co.recommend;

public class ApiKeyRequest
{
    public String Code;
    public String ApiToken;
    public String Phone;
    public String Email;
    public String OrderNumber;
    public String CartTotal;
    public String SSNID;

    public String getSSNID() {
        return SSNID;
    }

    public void setSSNID(String sSNID) {
        SSNID = sSNID;
    }

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

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getCartTotal() {
        return CartTotal;
    }

    public void setCartTotal(String cartTotal) {
        CartTotal = cartTotal;
    }
}