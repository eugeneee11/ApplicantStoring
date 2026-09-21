package com.example.scrollablelist;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ApplicantFormFragment extends Fragment {

    private EditText inputName;
    private EditText inputEmail;
    private TextView resultName;
    private TextView resultEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_applicant_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputName = view.findViewById(R.id.inputName);
        inputEmail = view.findViewById(R.id.inputEmail);
        resultName = view.findViewById(R.id.resultName);
        resultEmail = view.findViewById(R.id.resultEmail);

        Button buttonAdd = view.findViewById(R.id.buttonAdd);
        Button buttonNext = view.findViewById(R.id.buttonNext);

        buttonAdd.setOnClickListener(v -> addApplicant());
        buttonNext.setOnClickListener(v -> openApplicantList());
    }

    private void addApplicant() {
        String name = inputName.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email)) {
            Toast.makeText(getContext(), "Please fill in both name and email.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save into the ArrayList storage
        ApplicantStorage.getInstance().add(new Applicant(name, email));

        // Show the applicant that was just saved
        resultName.setText("Name: " + name);
        resultEmail.setText("Email: " + email);

        // Clear the inputs so the user can add another one
        inputName.setText("");
        inputEmail.setText("");
        inputName.requestFocus();

        Toast.makeText(getContext(),
                "Added. Total applicants: " + ApplicantStorage.getInstance().size(),
                Toast.LENGTH_SHORT).show();
    }

    private void openApplicantList() {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new ApplicantListFragment())
                .addToBackStack(null)   // lets the back button return to this form
                .commit();
    }
}