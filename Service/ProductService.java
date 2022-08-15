package com.example.project2.Service;

import com.example.project2.modle.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
    public class ProductService {
        private static ArrayList<Product> productArrayList=new ArrayList<>();

        public static ArrayList<Product> getProduct(){
            return productArrayList;
        }
        public static void addProduct(Product product){
            productArrayList.add(product);
        }
        public static void updateProduct(int index, Product product){
            productArrayList.set(index,product);
        }
        public void delProduct(int index){
            productArrayList.remove(index);
        }
}
