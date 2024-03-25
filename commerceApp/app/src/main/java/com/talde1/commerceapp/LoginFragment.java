package com.talde1.commerceapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import com.talde1.commerceapp.databinding.FragmentLoginBinding;

import com.talde1.commerceapp.viewmodel.UserViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


import kotlin.text.Charsets;

public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    NavController navController;
    UserViewModel userViewModel;
    HashFunction hf;
    Executor executor;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentLoginBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        executor = Executors.newSingleThreadExecutor();

        binding.gotoSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_loginFragment_to_singupFragment);
            }
        });

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hf = Hashing.sha256();
                String userIn = binding.loginUsername.getText().toString();
                String pass = binding.loginPassword.getText().toString();

                HashCode hashIn = hf.newHasher()
                        .putString(pass, Charsets.UTF_8)
                        .hash();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        String hashDb = userViewModel.getPasswordLogin(userIn);
                        int id = userViewModel.getUserId(userIn);
                        if (hashIn.toString().equals(hashDb)){
                            requireActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    MainActivity.setUserId(id);
                                    navController.navigate(R.id.action_loginFragment_to_mainMenuFragment);
                                }
                            });
                        } else {
                            requireActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast t = Toast.makeText(getContext(), "Login failed", Toast.LENGTH_LONG);
                                    t.show();
                                }
                            });
                        }
                    }
                });
            }
        });
        binding.switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Toggle password visibility
                if (isChecked) {
                    // Show the password
                    binding.loginPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    // Hide the password
                    binding.loginPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                // Move the cursor to the end of the text
                binding.loginPassword.setSelection(binding.loginPassword.getText().length());
            }

        });
    }
}