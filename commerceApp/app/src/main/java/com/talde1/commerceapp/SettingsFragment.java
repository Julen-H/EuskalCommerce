package com.talde1.commerceapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.talde1.commerceapp.dataAccess.DataAccess;
import com.talde1.commerceapp.databinding.FragmentSettingsBinding;
import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;
import com.talde1.commerceapp.model.Product;
import com.talde1.commerceapp.model.Settings;
import com.talde1.commerceapp.model.User;
import com.talde1.commerceapp.repos.ClientsRepo;
import com.talde1.commerceapp.viewmodel.BillViewModel;
import com.talde1.commerceapp.viewmodel.ClientViewModel;
import com.talde1.commerceapp.viewmodel.ProductsViewModel;
import com.talde1.commerceapp.viewmodel.SettingsViewModel;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SettingsFragment extends Fragment {

    private Spinner languageSpinner;
    FragmentSettingsBinding binding;
    private NavController navController;
    ClientsRepo clientsRepo;
    List<Client> clients;
    List<Product> products;
    List<Bill> bills;
    User user;
    DataAccess dataAccess = new DataAccess();

    public SettingsFragment() {
        // Required empty public constructor
    }


    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
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
        return (binding = FragmentSettingsBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        int id  = MainActivity.getUserId();
        SettingsViewModel settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);

        LiveData<Settings> userSettings = settingsViewModel.getUserSettings(id);
        if (userSettings != null || !userSettings.isInitialized()) {
            userSettings.observe(getViewLifecycleOwner(), new Observer<Settings>() {
                @Override
                public void onChanged(Settings settings) {
                    if (settings != null) {
                        binding.editTextIPAdress.setText(settings.getDirection_IP());
                        binding.editTextPassword.setText(settings.getPassword());
                        binding.editTextUsername.setText(settings.getUsername());
                    }
                }
            });
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ClientViewModel clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);
        ProductsViewModel productsViewModel = new ViewModelProvider(requireActivity()).get(ProductsViewModel.class);
        BillViewModel billViewModel = new ViewModelProvider(requireActivity()).get(BillViewModel.class);
        SettingsViewModel settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
        String[] languages = {"English", "Español","Euskera"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.languageSpinner.setAdapter(adapter);
        navController = Navigation.findNavController(view);
        int id  = MainActivity.getUserId();
        LiveData<Settings> userSettings = settingsViewModel.getUserSettings(id);
        if (userSettings != null){
            userSettings.observe(getViewLifecycleOwner(), new Observer<Settings>() {
                @Override
                public void onChanged(Settings settings) {
                    if(settings != null) {
                        binding.editTextIPAdress.setText(settings.getDirection_IP());
                        binding.editTextPassword.setText(settings.getPassword());
                        binding.editTextUsername.setText(settings.getUsername());
                    }
                }
            });
        }

        // Get the selected language from the ViewModel
        // Retrieve the selected language from the SettingsViewModel
        String selectedLanguage = settingsViewModel.getSelectedLanguage();

        // Set the selected language in the spinner
        int selectedLanguageIndex = 0; // Default to English
        if ("es".equals(selectedLanguage)) {
            selectedLanguageIndex = 1;
        } else if ("eu".equals(selectedLanguage)) {
            selectedLanguageIndex = 2;
        }
        binding.languageSpinner.setSelection(selectedLanguageIndex);

        // Set the locale based on the selected language
        setLocale(selectedLanguage);
        binding.languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    setLocale("en");
                    settingsViewModel.setSelectedLanguage("en");
                } else if (position == 1) {
                    setLocale("es");
                    settingsViewModel.setSelectedLanguage("es");
                } else if (position == 2) {
                    setLocale("eu");
                    settingsViewModel.setSelectedLanguage("eu");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

                // Do nothing
            }
        });

        binding.connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(() -> {
                    try {
                        clients = dataAccess.clientData();
                        products = dataAccess.productData();
                        bills = dataAccess.billData();
                        for (int i = 0; i < clients.toArray().length; i++){
                            clientViewModel.add(clients.get(i));
                        }
                        for (int i = 0; i < products.toArray().length; i++){
                            productsViewModel.add(products.get(i));
                        }
                        for (int i = 0; i < bills.toArray().length; i++){
                            billViewModel.add(bills.get(i));
                        }
                    } catch (Exception e){
                        requireActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), "Error loading the data", Toast.LENGTH_LONG).show();
                            }
                        });
                        e.printStackTrace();
                    }
                });
            }
        });
        binding.buttonApplySettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings settings = new Settings(MainActivity.getUserId(), binding.editTextIPAdress.getText().toString()
                , binding.editTextUsername.getText().toString(), binding.editTextPassword.getText().toString());
                dataAccess.setClientEndpoint(binding.editTextIPAdress.getText().toString());
                dataAccess.setProductEndpoint(binding.editTextIPAdress.getText().toString());
                dataAccess.setBillEndpoint(binding.editTextIPAdress.getText().toString());
                dataAccess.setUser(binding.editTextUsername.getText().toString());
                dataAccess.setPassword(binding.editTextPassword.getText().toString());

                settingsViewModel.add(settings);
            }
        });
        binding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              navController.navigate(R.id.action_settingsFragment_to_menu);
            }
        });
    }

    private void setLocale(String languageCode) {
        if (languageCode != null) {
            Locale locale = new Locale(languageCode);
            Locale.setDefault(locale);

            Configuration config = new Configuration();
            config.locale = locale;
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());

            // Save the selected language preference in SharedPreferences here for persistence.
            // You'll need to implement SharedPreferences to save and retrieve this preference.
        }
    }
    }
