package com.example.recyclerview;

import java.util.ArrayList;

public class CakeData {
    private static String[] title = {
            "Two Layer Cake",
            "Flowerish Cake",
            "Character Cake",
            "Bento Cake",
            "Mandarin Cake",
            "Ubi Cake",
            "Strawberry Square Cake"};
    private static int[] thumbnail = {
            R.drawable.twolayercake,
            R.drawable.flowerishcake,
            R.drawable.charactercake,
            R.drawable.bentocake,
            R.drawable.mandarincake,
            R.drawable.ubicake,
            R.drawable.berry};
    private static String[] deskripsiKue = {
            "Kuenya enak",
            "Langganan sih",
            "Yaampun enak",
            "Favorit",
            "Kok kayak jeruk",
            "Kayak ubi",
            "Terenak"};

    public static ArrayList<CakeModel> getListData(){
        CakeModel cakeModel = null;
        ArrayList<CakeModel> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++){
            cakeModel = new CakeModel();
            cakeModel.setNamacake(title[i]);
            cakeModel.setFotocake(thumbnail[i]);
            cakeModel.setDeskripsi(deskripsiKue[i]);
            list.add(cakeModel);
        }
        return list;
    }
}
