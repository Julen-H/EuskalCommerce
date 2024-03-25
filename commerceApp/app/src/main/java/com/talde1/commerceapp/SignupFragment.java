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

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.talde1.commerceapp.databinding.FragmentSignupBinding;
import com.talde1.commerceapp.model.User;
import com.talde1.commerceapp.viewmodel.UserViewModel;

public class SignupFragment extends Fragment {

    String username, password, email, phone, passwordHash;
    FragmentSignupBinding binding;
    private NavController navController;

    public SignupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return(binding = FragmentSignupBinding.inflate(inflater, container, false)).getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserViewModel userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        navController = Navigation.findNavController(view);
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    username = binding.signupUsername.getText().toString();
                    email = binding.signupEmail.getText().toString();
                    phone = binding.signupPhone.getText().toString();
                    password = binding.signupPassword.getText().toString();
                    HashFunction hf = Hashing.sha256();
                    HashCode code = hf.newHasher()
                            .putString(password, Charsets.UTF_8)
                            .hash();
                    passwordHash = code.toString();

                    User user = new User(username, email, phone, passwordHash);
                    userViewModel.add(user);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        binding.signupBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_singupFragment_to_loginFragment);
            }
        });
        binding.switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Toggle password visibility
                if (isChecked) {
                    // Show the password
                    binding.signupPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    // Hide the password
                    binding.signupPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                // Move the cursor to the end of the text
                binding.signupPassword.setSelection(binding.signupPassword.getText().length());
            }

        });
    }
}