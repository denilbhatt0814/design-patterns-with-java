package IndustrySystem;

import java.util.ArrayList;

public class Industry {
    protected String name;
    protected ArrayList<Applicant> applicants;

    public Industry(String name) {
        this.name = name;
        this.applicants = new ArrayList<Applicant>();
    }

    public Industry(String name, ArrayList<Applicant> applicants) {
        this.name = name;
        this.applicants = applicants;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Applicant> getApplicantList() {
        return this.applicants;
    }

    public void addAnApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public void addApplicants(ArrayList<Applicant> applicants) {
        this.applicants.addAll(applicants);
    }

    public void addAnApplicant(String name, int yearsOfExpirience, ContactDetails contactDetails) {
        Applicant newApplicant = new Applicant(name, yearsOfExpirience, contactDetails);
        applicants.add(newApplicant);
    }

    public String toString() {
        return "Industry [name=" + name + ", applicants=" + applicants + "]";
    }
}
