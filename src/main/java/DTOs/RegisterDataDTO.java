package DTOs;

public class RegisterDataDTO {
    String email;
    String phone;
    String password;
    String shipments;
    String platform;
    String ecomerce;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShipments() {
        return shipments;
    }

    public void setShipments(String shipments) {
        this.shipments = shipments;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getEcomerce() {
        return ecomerce;
    }

    public void setEcomerce(String ecomerce) {
        this.ecomerce = ecomerce;
    }
}
