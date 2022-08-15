package com.example.project2.Service;

import com.example.project2.modle.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
    public class CategoryService {

        public static ArrayList<Category> categoryArrayList=new ArrayList<>();


        public static ArrayList<Category> getCategory() {
            return categoryArrayList;
        }

        public static void addCategory(Category category) {
            categoryArrayList.add(category);
        }
        public static void updateCategory(int index, Category category){
            categoryArrayList.set(index , category);
        }
        public static void DelCategory(int index){
            categoryArrayList.remove(index);

        }

    }
