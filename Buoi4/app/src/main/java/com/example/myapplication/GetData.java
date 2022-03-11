package com.example.myapplication;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class GetData extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.get_data, container, false);

        TextView reset = view.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView getUsername = getActivity().findViewById(R.id.getUsername);
                getUsername.setText("");
                TextView getPassword = getActivity().findViewById(R.id.getPassword);
                getPassword.setText("");

                EditText username = getActivity().findViewById(R.id.username);
                username.setText("");
                EditText password = getActivity().findViewById(R.id.password);
                password.setText("");
            }
        });

        return view;
    }

}
