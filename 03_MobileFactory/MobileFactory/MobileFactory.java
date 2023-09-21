package MobileFactory;

public class MobileFactory {

    public Mobile createMobile(String mobile) {
        switch (mobile) {
            case "IPHONE":
                return new iphone();
            case "JIOPHONE":
                return new jiophone();

            default:
                return null;

        }
    }
}
