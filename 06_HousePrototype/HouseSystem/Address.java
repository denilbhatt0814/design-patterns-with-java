package HouseSystem;

public class Address {
    private String city;
    private String societyName;

    public Address(String city, String societyName) {
        this.city = city;
        this.societyName = societyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", societyName=" + societyName + "]";
    }
}
