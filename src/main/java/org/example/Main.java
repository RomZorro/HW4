package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> listData_F = new ArrayList<String>();
        ArrayList<String> listData_I = new ArrayList<String>();
        ArrayList<String> listData_O = new ArrayList<String>();
        ArrayList<Integer> listData_V = new ArrayList<Integer>();
        ArrayList<String> listData_P = new ArrayList<String>();

        String str = "";
        Scanner in = new Scanner(System.in);
        while (!str.equals("Exit")) {

            System.out.println("Введите ФИО, Возраст, Пол: ");
            str = in.nextLine();
            if (!str.equals("Exit")) {
                String[] tmp = new String[3];
                tmp = str.split(",");

                String[] fio = new String[3];
                fio = tmp[0].split(" ");

                listData_F.add(fio[0]);
                listData_I.add(fio[1]);
                listData_O.add(fio[2]);
                listData_V.add(Integer.parseInt(tmp[1].trim()));
                listData_P.add(tmp[2]);
            }
        }
//        listData.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int r = Integer.parseInt(o1.split(" ")[2])-Integer.parseInt(o2.split(" ")[2]);
//                return r;
//            }
//        });

        ArrayList<Integer> listData_V_tmp = new ArrayList<Integer>(listData_V);
        int[] indexV = new int[listData_V.size()];
        for (int i = 0; i < indexV.length; i++) {
            indexV[i] = i;
        }
        for (int i = 0; i < listData_V.size()-1 ; i++) {
            int minV = listData_V_tmp.get(i);
            for (int j = i+1; j < listData_V_tmp.size(); j++) {
                int nextV = listData_V_tmp.get(j);
                if(nextV < minV) {
                    int tmp_j =  indexV[j];
                    indexV[j]=indexV[i];
                    indexV[i]=tmp_j;
                    listData_V_tmp.set(i,nextV);
                    listData_V_tmp.set(j,minV);
                    minV = nextV;
                }
            }
        }
        System.out.println(Arrays.toString(indexV));
        for (int k = 0; k < indexV.length ;k++){
            int s = indexV[k];
            String itogStr = listData_F.get(s)+" "+listData_I.get(s).toUpperCase().charAt(0)+"."
                    +listData_O.get(s).toUpperCase().charAt(0)+"."+listData_V.get(s)+listData_P.get(s);
            System.out.println(itogStr);
        }

        int[] indexVP = new int[listData_P.size()];
        ArrayList<Integer> indexVP_tmp1 = new ArrayList<Integer>();
        ArrayList<Integer> indexVP_tmp2 = new ArrayList<Integer>();
        String tmp_P = listData_P.get(0);
        indexVP_tmp1.add(indexV[0]);
        for (int k = 1; k < indexV.length ;k++){
            int s = indexV[k];
            if (listData_P.get(s).equals(tmp_P)) {
                indexVP_tmp1.add(s);
            }
            else{
                indexVP_tmp2.add(s);
            }
        }
        int i = 0;
        for (int j = 0; j < indexVP_tmp1.size(); j++){
            indexVP[i] = indexVP_tmp1.get(j);
            i++;
        }
        for (int j = 0; j < indexVP_tmp2.size(); j++) {
            indexVP[i] = indexVP_tmp2.get(j);
            i++;
        }
        System.out.println(Arrays.toString(indexVP));
        for (int k = 0; k < indexVP.length ;k++){
            int s = indexVP[k];
            String itogStr = listData_F.get(s)+" "+listData_I.get(s).toUpperCase().charAt(0)+"."
                    +listData_O.get(s).toUpperCase().charAt(0)+"."+listData_V.get(s)+listData_P.get(s);
            System.out.println(itogStr);
        }
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Boolean run = true;
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<String> familia = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> batka = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        System.out.println("Введите фио, возраст и пол");
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (run) {
            String str = scanner.nextLine();

            if (str.equals("q")) {
                System.out.println("Вышли)))");
                break;
            }

            String[] fio = str.split(" ");
            index.add(i);
            familia.add(fio[0]);
            name.add(fio[1]);
            batka.add(fio[2]);
            age.add(Integer.parseInt(fio[3]));
            gender.add(fio[4]);

            i++;
        }
        ArrayList<Integer> temporary = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            temporary.add(age.get(j));

        }
        // Сортировка индексов по возрасту
        for (int j = 0; j < index.size() - 1; j++) {
            for (int k = 0; k < index.size() - 1 - j; k++) {
                if (temporary.get(k) > temporary.get(k + 1)) {

                    int temp = index.get(k);
                    index.set(k, index.get(k + 1));
                    index.set(k + 1, temp);
                    temp = temporary.get(k);
                    temporary.set(k, temporary.get(k + 1));
                    temporary.set(k + 1, temp);

                }
            }
        }
        for (int j = 0; j < index.size(); j++) {
            System.out.printf("%s %s. %s. %s %s \n", familia.get(index.get(j)), name.get(index.get(j)).charAt(0),
                    batka.get(index.get(j)).charAt(0), age.get(index.get(j)), gender.get(index.get(j)));
        }

        ArrayList<String> temporary2 = new ArrayList<>();
        for (int j = 0; j < index.size(); j++) {
            temporary2.add(gender.get(index.get(j)));
        }
        // Сортировка по полу
        for (int j = 0; j < index.size() - 1; j++) {

            if (temporary2.get(j).contains("м") && temporary2.get(j + 1).contains("ж")) {
                int temp = index.get(j);
                index.set(j, index.get(j + 1));
                index.set(j + 1, temp);
                String temp2 = temporary2.get(j);
                temporary2.set(j, temporary2.get(j + 1));
                temporary2.set(j + 1, temp2);
            } else continue;
        }
        System.out.println("\n");
        for (int j = 0; j < index.size(); j++) {
            System.out.printf("%s %s. %s. %s %s \n", familia.get(index.get(j)), name.get(index.get(j)).charAt(0),
                    batka.get(index.get(j)).charAt(0), age.get(index.get(j)), gender.get(index.get(j)));
        }
    }
}

 */