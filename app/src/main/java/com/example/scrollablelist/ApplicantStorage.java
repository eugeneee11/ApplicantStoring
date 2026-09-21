package com.example.scrollablelist;

import java.util.ArrayList;
import java.util.List;

public class ApplicantStorage {
    private static ApplicantStorage instance;
    private final ArrayList<Applicant> applicants = new ArrayList<>();
    private ApplicantStorage() {
        // private so nobody can create a second storage
    }

    public static ApplicantStorage getInstance() {
        if (instance == null) {
            instance = new ApplicantStorage();
        }
        return instance;
    }

    public void add(Applicant applicant) {
        applicants.add(applicant);
    }

    public List<Applicant> getAll() {
        return applicants;
    }

    public int size() {
        return applicants.size();
    }

    public void clear() {
        applicants.clear();

    }
}
