package IndustrySystem;

public class Applicant {
    protected String name;
    protected int yearsOfExpirience;
    protected ContactDetails contactDeatils;

    public Applicant(String name, int yearsOfExpirience, ContactDetails contactDetails) {
        this.name = name;
        this.yearsOfExpirience = yearsOfExpirience;
        this.contactDeatils = contactDetails;
    }

    public String getName() {
        return this.name;
    }

    public int getYearsOfExpirience() {
        return this.yearsOfExpirience;
    }

    public int setYearsOfExpirience(int years) {
        this.yearsOfExpirience = years;
        return this.yearsOfExpirience;
    }

    public ContactDetails getContactDetails() {
        return this.contactDeatils;
    }

    public ContactDetails updateContactDetails(ContactDetails contactDetails) {
        this.contactDeatils = contactDetails;
        return contactDetails;
    }

    public String toString() {
        return "Applicant [name=" + name + ", yearsOfExpirience=" + yearsOfExpirience + ", contactDeatils="
                + contactDeatils + "]";
    }

}
