package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SendData extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.send_data, container, false);
        TextView getData = view.findViewById(R.id.getData);
        EditText userName = view.findViewById(R.id.username);
        EditText password = view.findViewById(R.id.password);

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView getUsername = getActivity().findViewById(R.id.getUsername);
                getUsername.setText(userName.getText().toString());
                TextView getPassword = getActivity().findViewById(R.id.getPassword);
                getPassword.setText(password.getText().toString());
            }
        });

        return view;
    }
}
