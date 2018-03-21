package com.asiscode.simpleandroidapps.data;

import com.asiscode.simpleandroidapps.data.bean.Food;

import java.util.ArrayList;

/**
 * Created by muhammad.azis on 02/10/2017.
 */

public class FoodData {
    public static String[][] data = new String[][] {
            {"Indomie Goreng Iga Penyet",
                    "8000",
                    "Indomie Mie Goreng Iga Penyet (squeezed rib) flavour. Indomie brand instant noodle, mie goreng (fried noodle), served with fried egg and vegetables. Served in Jakarta, Indonesia.",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Indomie_Mie_Goreng_Iga_Penyet_1.JPG/1280px-Indomie_Mie_Goreng_Iga_Penyet_1.JPG"
            },
            {"Nasi Goreng Istimewa",
                    "20000",
                    "Special Indonesian nasi goreng (literally, fried rice) with slices of tomatoes and cucumber, fried egg and fried chicken.",
                    "https://upload.wikimedia.org/wikipedia/commons/d/d0/Nasi_goreng_istimewa.JPG"
            },
            {"Nasi Kuning Ibu Sulastri",
                    "23000",
                    "Delicious and succulent Nasi Kuning Ibu Sulastri, yellow rice colored with turmeric, surrounded by teri kacang (anchovy with peanuts), empal gepuk (sweet fried beef), udang balado (shrimp in chilli), urab (vegetables in shredded coconut dressing), and sambal goreng kentang (spicy potato). Yellow rice is considered as celebrative Indonesian dish and often made as Tumpeng (cone shaped rice with assortment of Indonesian dishes). Jakarta, Indonesia.",
                    "https://upload.wikimedia.org/wikipedia/commons/5/5d/Nasi_Kuning_Ibu_Sulastri.jpg"
            },
            {"Masakan Padang",
                    "35000",
                    "Minangkabau cuisine (Padang food) served at a restaurant in Bukittinggi. For the uninitiated, all of the bowls of food are laid out in front of you, you pay for whatever bowl you eat from.",
                    "https://upload.wikimedia.org/wikipedia/commons/5/52/Minangkabau_cuisine_Bukittingi.jpg"
            },
            {"Nasi Bakar Ayam",
                    "23000",
                    "Nasi bakar, a seasoned and spiced rice cooked (grilled) inside banana leaf, served with ayam goreng (fried chicken) with mushroom, vegetables, and spicy chilli sambal. Jakarta, Indonesia.",
                    "https://upload.wikimedia.org/wikipedia/commons/6/6f/Nasi_Bakar_Ayam.JPG"
            },
            {"Nasi Timbel Ayam Penyet",
                    "25000",
                    "Nasi timbel with ayam penyet. Nasi timbel (rice wrapped in banana leaf in the Sundanese style) served with ayam penyet (\"smashed\" fried chicken), sambal chili sauce and a sprinking of fresh veggies. Taken at Dapoet Kampoeng, Nagoya Hill, Batam., Batam.",
                    "https://upload.wikimedia.org/wikipedia/commons/1/12/NasiTimbelAyamPenyet.JPG"
            },
            {"Bubur Ayam",
                    "15000",
                    "A Bubur Ayam (chicken rice congee) with chicken liver and gizzard satay, sold by travelling vendor cart that frequenting kampung or residential area every morning in Jakarta, Indonesia.",
                    "https://upload.wikimedia.org/wikipedia/commons/5/50/Bubur_Ayam_Chicken_Liver-Gizzard_Satay.JPG"
            }
    };

    public static ArrayList<Food> getListData() {
        Food food = null;
        ArrayList<Food> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            food = new Food();
            food.setName(data[i][0]);
            food.setPrice(data[i][1]);
            food.setDescription(data[i][2]);
            food.setPhoto(data[i][3]);

            list.add(food);
        }
        return list;
    }
}
