import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Scanner;

import IndustrySystem.*;

public class Main {
    public static void main(String[] args) {
        Industry softwareIndustry = new Industry("Software Industry");

        Applicant[] applicants = new Applicant[] {
                new Applicant("John", 1, new ContactDetails("john1@mail.com", 123, "London")),
                new Applicant("Dev", 2, new ContactDetails("dev2@mail.com", 456, "Brooklyn")),
                new Applicant("Claire", 7, new ContactDetails("claire7@mail.com", 999, "NYC")),
                new Applicant("Rahul", 9, new ContactDetails("rahul9@mail.com", 679, "Delhi")),
                new Applicant("Carl", 6, new ContactDetails("carl6@mail.com", 445, "Toronto"))
        };

        softwareIndustry.addApplicants(new ArrayList<Applicant>(Arrays.asList(applicants)));
        System.out.println(softwareIndustry);
    }
}
