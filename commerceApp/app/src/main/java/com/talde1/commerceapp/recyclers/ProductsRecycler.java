package com.talde1.commerceapp.recyclers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.talde1.commerceapp.R;
import com.talde1.commerceapp.databinding.FragmentProductsRecyclerBinding;
import com.talde1.commerceapp.databinding.ProductsViewholderBinding;
import com.talde1.commerceapp.model.Product;
import com.talde1.commerceapp.viewmodel.ProductsViewModel;

import java.util.List;

public class ProductsRecycler extends Fragment {
    FragmentProductsRecyclerBinding binding;
    private NavController navController;
    private ProductsViewModel productViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (binding = FragmentProductsRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productViewModel = new ViewModelProvider(requireActivity()).get(ProductsViewModel.class);
        navController = Navigation.findNavController(view);
        ProductAdapter productAdapter=new ProductAdapter();

        binding.productsRecycler.setAdapter(productAdapter);
        binding.productsRecycler.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        productViewModel.get().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productAdapter.establishList(products);
            }
        });
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder {
        private final ProductsViewholderBinding binding;

        public ProductsViewHolder(ProductsViewholderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class ProductAdapter extends RecyclerView.Adapter<ProductsViewHolder> {
        List<Product> products;

        @NonNull
        @Override
        public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ProductsViewHolder(ProductsViewholderBinding.inflate(getLayoutInflater(), parent, false));
        }

        public Product getProduct(int position) {
            return products.get(position);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
            Product product = products.get(position);

            holder.binding.productNameHolder.setText(product.getName());
            holder.binding.saleDelayHolder.setText(getString(R.string.saleDelayStr) + Double.toString(product.getSale_delay()));
            holder.binding.priceHolder.setText(product.getSale_price() + "€");
            //TODO: parametros de la clase Client al viewholder.

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: Crear vista de detalle y poner navegacion hasta ella.
                }
            });
        }

        @Override
        public int getItemCount() {
            return products != null ? products.size() : 0;
        }

        public void establishList(List<Product> products) {
            this.products = products;
            notifyDataSetChanged();
        }
    }
}