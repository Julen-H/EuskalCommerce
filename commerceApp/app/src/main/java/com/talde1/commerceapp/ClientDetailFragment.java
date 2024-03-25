package com.talde1.commerceapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.talde1.commerceapp.databinding.FragmentBillViewholderBinding;
import com.talde1.commerceapp.databinding.FragmentClientDetailBinding;
import com.talde1.commerceapp.model.Bill;
import com.talde1.commerceapp.model.Client;
import com.talde1.commerceapp.viewmodel.BillViewModel;
import com.talde1.commerceapp.viewmodel.ClientViewModel;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ClientDetailFragment extends Fragment {

    private FragmentClientDetailBinding binding;
    public static int clientId;
    private BillViewModel billViewModel;
    private ClientViewModel clientViewModel;
    private  Client client;
    Executor executor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentClientDetailBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BillAdapter billAdapter = new BillAdapter();
            billViewModel = new ViewModelProvider(requireActivity()).get(BillViewModel.class);
            clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);
            executor = Executors.newSingleThreadExecutor();
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(super.getContext()));
            binding.recyclerView.setAdapter(billAdapter);
            binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));


            executor.execute(new Runnable() {
                @Override
                public void run() {
                    client = clientViewModel.detailClient(clientId);
                    if (client != null){
                       requireActivity().runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               String address = "";
                               if (!client.getStreet().isEmpty() && !client.getPostalCode().isEmpty() && !client.getCity().isEmpty()){
                                   address = client.getStreet() + ", " + client.getCity() + ", " + client.getPostalCode();
                               }
                               binding.detailName.setText(client.getName());
                               if (client.getTelephone().isEmpty() && client.getMobile().isEmpty()){
                                   binding.detailPhone.setText(getString(R.string.detailClientPhone) + " " + getString(R.string.phoneNotFound));
                               } else if (client.getTelephone().isEmpty() && !client.getMobile().isEmpty()) {
                                   binding.detailPhone.setText(getString(R.string.detailClientPhone) + " " + client.getTelephone());
                               } else if (!client.getTelephone().isEmpty() && client.getMobile().isEmpty()) {
                                   binding.detailPhone.setText(getString(R.string.detailClientPhone) + " " + client.getMobile());
                               } else {
                                   binding.detailPhone.setText(getString(R.string.detailClientPhone) + " " + client.getTelephone() + ", " + client.getMobile());
                               }

                               if (!address.isEmpty()){
                                    binding.detailAddress.setText(getString(R.string.detailClientAddress) + " " + address);
                               } else {
                                   binding.detailAddress.setText(getString(R.string.detailClientAddress) + " " + getString(R.string.addressNotFound));
                               }

                               if (!client.getEmail().isEmpty()){
                                   binding.detailEmail.setText(getString(R.string.detailClientEmail) + " " + client.getEmail());
                               } else {
                                   binding.detailEmail.setText(getString(R.string.detailClientEmail) + " " + getString(R.string.emailNotFound));
                               }

                           }
                       });
                    }
                }
            });

        billViewModel.getClientBills(clientId).observe(getViewLifecycleOwner(), new Observer<List<Bill>>() {
            @Override
            public void onChanged(List<Bill> bills) {
                billAdapter.establishList(bills);
            }
        });
        /*
        billViewModel.get().observe(getViewLifecycleOwner(), new Observer<List<Bill>>() {
            @Override
            public void onChanged(List<Bill> bills) {
                billAdapter.establishList(bills);
            }
        });*/
    }

    class BillViewholder extends RecyclerView.ViewHolder{
        private final FragmentBillViewholderBinding binding;

        public BillViewholder(FragmentBillViewholderBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public class BillAdapter extends RecyclerView.Adapter<BillViewholder>{
        List<Bill> bills;

        @NonNull
        @Override
        public BillViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new BillViewholder(FragmentBillViewholderBinding.inflate(getLayoutInflater(), parent, false));
        }

        public Bill getBill(int position){ return bills.get(position); }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull BillViewholder holder, int position) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            Bill bill = bills.get(position);
            Double totalPrice = bill.getAmountTax() + bill.getAmountUntaxed();
            String totalPriceStr = totalPrice.toString();
            Double qtyInvoiced = bill.getQtyInvoiced();
            String qtyInvoicedStr = qtyInvoiced.toString();
            String paid = bill.getDeliveryStatus();
            String sent = bill.getInvoiceStatus();

            holder.binding.billIdHolder.setText(getString(R.string.billId) + "  " + bill.getBillId());
            holder.binding.billDate.setText(getString(R.string.billDate) + "  " + bill.getDateOrder().toString());
            holder.binding.billPrice.setText(totalPriceStr + "€");
            holder.binding.billItemAmount.setText(qtyInvoicedStr);
            holder.binding.billDate.setText(bill.getDateOrder().format(formatter));

            if (bill.getAmountUnpaid() != totalPrice && bill.getAmountUnpaid() != 0){
                holder.binding.billIsPaid.setText(getString(R.string.billPaidStr) + "   Partially paid  " + getString(R.string.yellowEmoji));
            } else if (bill.getAmountUnpaid() == 0) {
                holder.binding.billIsPaid.setText(getString(R.string.billPaidStr) + "   Bill paid  " + getString(R.string.greenEmoji));
            } else {
                holder.binding.billIsPaid.setText(getString(R.string.billPaidStr) + "   Unpaid  " + getString(R.string.redEmoji));
            }

            switch (bill.getDeliveryStatus()) {
                case "partial":
                    holder.binding.billIsSent.setText(getString(R.string.billSentStr) + "   Partially sent  " + getString(R.string.yellowEmoji));
                    break;
                case "pending":
                    holder.binding.billIsSent.setText(getString(R.string.billSentStr) + "   Not sent  " + getString(R.string.redEmoji));
                    break;
                case "full":
                    holder.binding.billIsSent.setText(getString(R.string.billSentStr) + "   Sent " + getString(R.string.greenEmoji));
                    break;
                default:
                    holder.binding.billIsSent.setText(getString(R.string.billSentStr) + "   Error. Couldn't get delivery status");
                    break;
            }

        }

        @Override
        public int getItemCount() { return bills != null ? bills.size(): 0; }

        public void establishList(List<Bill> bills){
            this.bills = bills;
            notifyDataSetChanged();
        }
    }
}