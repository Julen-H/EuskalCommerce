package com.talde1.commerceapp.recyclers;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import androidx.recyclerview.widget.RecyclerView;


import com.talde1.commerceapp.ClientDetailFragment;
import com.talde1.commerceapp.R;

import com.talde1.commerceapp.databinding.ClientsViewholderBinding;
import com.talde1.commerceapp.databinding.FragmentClientsRecyclerBinding;

import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;
import com.talde1.commerceapp.viewmodel.ClientViewModel;

import java.util.ArrayList;
import java.util.List;

public class ClientsRecycler extends Fragment {
    FragmentClientsRecyclerBinding binding;
    private NavController navController;
    private ClientViewModel clientViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentClientsRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Client> clients = new ArrayList<>();

        clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);
        navController = Navigation.findNavController(view);
        ClientAdapter clientAdapter = new ClientAdapter();



        binding.clientsRecycler.setAdapter(clientAdapter);
        binding.clientsRecycler.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        clientViewModel.get().observe(getViewLifecycleOwner(), new Observer<List<Client>>() {
            @Override
            public void onChanged(List<Client> clients) {
                clientAdapter.establishList(clients);
            }
        });
    }

    class ClientsViewHolder extends RecyclerView.ViewHolder{
        private final ClientsViewholderBinding binding;

        public ClientsViewHolder(ClientsViewholderBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public class ClientAdapter extends RecyclerView.Adapter<ClientsViewHolder>{
        List<Client> clients;
        @NonNull
        @Override
        public ClientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ClientsViewHolder(ClientsViewholderBinding.inflate(getLayoutInflater(), parent, false));
        }

        public Client getClient(int position){ return clients.get(position); }

        @Override
        public void onBindViewHolder(@NonNull ClientsViewHolder holder, int position) {
            Client client = clients.get(position);

            holder.binding.clientNameHolder.setText(client.getName());
            LiveData<List<Bill>> unpaidBills = clientViewModel.getClientUnpaidBills(client.getId());
            LiveData<List<Bill>> unsentBills = clientViewModel.getClientUnsentBills(client.getId());

            unpaidBills.observe(getViewLifecycleOwner(), new Observer<List<Bill>>() {
                @Override
                public void onChanged(List<Bill> bills) {
                    if (bills.size() > 0 & bills != null){
                        holder.binding.billIndicatorHolder.setText(getString(R.string.opennedBills));
                        holder.binding.billIndicatorHolder.setTextColor(Color.RED);
                    } else {
                        holder.binding.billIndicatorHolder.setText(getString(R.string.notOpennedBills));
                        holder.binding.billIndicatorHolder.setTextColor(Color.GREEN);
                    }
                }
            });

            unsentBills.observe(getViewLifecycleOwner(), new Observer<List<Bill>>() {
                @Override
                public void onChanged(List<Bill> bills) {
                    if (bills.size() > 0 & bills != null){
                        holder.binding.tapIndicator.setText(getString(R.string.notSentProducts));
                        holder.binding.tapIndicator.setTextColor(Color.RED);
                    } else {
                        holder.binding.tapIndicator.setText(getString(R.string.sentProducts));
                        holder.binding.tapIndicator.setTextColor(Color.GREEN);
                    }
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClientDetailFragment.clientId = client.getId();
                    navController.navigate(R.id.action_clientsRecycler_to_clientDetailFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return clients != null ? clients.size() : 0;
        }

        public void establishList(List<Client> clients){
            this.clients = clients;
            notifyDataSetChanged();
        }
    }
}




