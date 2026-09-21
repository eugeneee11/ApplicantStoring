package com.example.scrollablelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApplicantAdapter extends RecyclerView.Adapter<ApplicantAdapter.ApplicantViewHolder> {

    private final List<Applicant> applicants;

    public ApplicantAdapter(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    @NonNull
    @Override
    public ApplicantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_applicant, parent, false);
        return new ApplicantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicantViewHolder holder, int position) {
        Applicant applicant = applicants.get(position);
        holder.numberText.setText(String.valueOf(position + 1));
        holder.nameText.setText("Name: " + applicant.getName());
        holder.emailText.setText("Email: " + applicant.getEmail());
    }

    @Override
    public int getItemCount() {
        return applicants.size();
    }

    static class ApplicantViewHolder extends RecyclerView.ViewHolder {

        final TextView numberText;
        final TextView nameText;
        final TextView emailText;

        ApplicantViewHolder(@NonNull View itemView) {
            super(itemView);
            numberText = itemView.findViewById(R.id.textItemNumber);
            nameText = itemView.findViewById(R.id.textItemName);
            emailText = itemView.findViewById(R.id.textItemEmail);
        }
    }
}