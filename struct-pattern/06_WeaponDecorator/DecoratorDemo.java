interface WeaponComponent {
    // method()
    public int getPrice();
}

class WeaponConcreteComponent implements WeaponComponent {
    int ammo = 0;
    int price = 100;

    public WeaponConcreteComponent(int ammo) {
        this.ammo = ammo;
    }

    public void aim_and_fire() {
        if (ammo == 0) {
            System.out.println("Out of ammo, please reload!!");
            return;
        }
        ammo--;
    }

    // method()
    public int getPrice() {
        return this.price;
    }
}

class WeaponAccessoryBaseDecorator implements WeaponComponent {
    int price = 0;
    // wrappee
    WeaponComponent weaponComponent;

    WeaponAccessoryBaseDecorator(WeaponComponent wc) {
        this.weaponComponent = wc;
    }

    // method()
    public int getPrice() {
        return weaponComponent.getPrice() + this.price;
    }
}

class WeaponWithScope extends WeaponAccessoryBaseDecorator {

    WeaponWithScope(WeaponComponent wc) {
        super(wc);
        this.price = 50;
    }

    // extraWork()
    public void useScope(int zoom) {
        System.out.println("Zooming " + zoom + "x");
    }
}

class WeaponWithSilencer extends WeaponAccessoryBaseDecorator {

    WeaponWithSilencer(WeaponComponent wc) {
        super(wc);
        this.price = 30;
    }

    public void silence() {
        System.out.println("Silencer attached, shooting quietly.");
    }
}

class WeaponWithGrip extends WeaponAccessoryBaseDecorator {

    WeaponWithGrip(WeaponComponent wc) {
        super(wc);
        this.price = 20;
    }

    public void stabilize() {
        System.out.println("Grip attached, better stability.");
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {

        WeaponComponent weapon = new WeaponConcreteComponent(10);
        WeaponWithScope weaponWithScope = new WeaponWithScope(weapon);
        WeaponWithSilencer weaponWithScopeAndSilencer = new WeaponWithSilencer(weaponWithScope);
        WeaponWithGrip fullyUpgradedWeapon = new WeaponWithGrip(weaponWithScopeAndSilencer);

        int totalPrice = fullyUpgradedWeapon.getPrice();
        System.out.println("Total price of the weapon with all accessories: " + totalPrice);
    }
}
