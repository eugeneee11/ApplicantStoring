package com.example.scrollablelist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApplicantListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_applicant_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerApplicants);
        TextView emptyText = view.findViewById(R.id.textEmpty);
        TextView countText = view.findViewById(R.id.textCount);
        Button buttonBack = view.findViewById(R.id.buttonBack);

        List<Applicant> applicants = ApplicantStorage.getInstance().getAll();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ApplicantAdapter(applicants));

        countText.setText("Total: " + applicants.size());
        emptyText.setVisibility(applicants.isEmpty() ? View.VISIBLE : View.GONE);

        buttonBack.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack());
    }
}