package com.example.pract__2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {

    View view;

    String debugTAG = "fragmentLifeCycle";

    public LoginFragment() {
        super(R.layout.fragment_login);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Toast.makeText(getActivity(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d(debugTAG, "onStart");
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        EditText editText = (EditText) view.findViewById(R.id.editTextTextEmailAddress);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        editText.setText(getResources().getString(R.string.testEmail));
        imageView.setImageResource(R.drawable.transparency_demonstration_1);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ((EditText) view.findViewById(R.id.editTextTextEmailAddress)).setText(bundle.getString("email"));
        }
        view.findViewById(R.id.continueBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("email", String.valueOf(((EditText) view
                        .findViewById(R.id.editTextTextEmailAddress))
                        .getText()));
                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_mainMenuFragment,bundle);
            }
        });
        view.findViewById(R.id.regBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("email", String.valueOf(((EditText) view
                        .findViewById(R.id.editTextTextEmailAddress))
                        .getText()));
                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_linearFragment, bundle);
            }
        });

        return view;
    }

}