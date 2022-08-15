package com.example.project2.Service;


import com.example.project2.modle.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
    public class MerchantStockService {
        private static ArrayList<MerchantStock> merchantStockArrayList=new ArrayList<>();

        public static ArrayList<MerchantStock> getMerchantStock(){
            return merchantStockArrayList;
        }
        public static void addMerchantStock(MerchantStock merchantStock){
            merchantStockArrayList.add(merchantStock);
        }
        public static void updateMerchantStock(int index, MerchantStock merchantStock){
            merchantStockArrayList.set(index,merchantStock);
        }
        public static void delMerchantStock(int index){
            merchantStockArrayList.remove(index);
        }
}
