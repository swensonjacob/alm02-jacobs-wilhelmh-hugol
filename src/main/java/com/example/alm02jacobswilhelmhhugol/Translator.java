package com.example.alm02jacobswilhelmhhugol;


import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Translator {

    RandomFactor randomFactor = new RandomFactor();


    public int getTheNumber(String name, String nationality, int age) {
        int intFromName = randomFactor.getIntFromName(name);
        int intFromNationality = randomFactor.getIntFromNationality(nationality);
        int intFromAge = randomFactor.getIntFromAge(age);
        int randomNr = (intFromAge + intFromNationality + intFromName ) / 4;

        if (randomNr > 100){
            randomNr ++;
        }else {
            randomNr --;
        }
        return randomNr;
    }


    public List<String> getFortuneList() {

        File file;

        List<String> fortuneList = new ArrayList<>();
        try {
            file  = ResourceUtils.getFile("classpath:fortunes.txt");
            Scanner sc = new Scanner(file);
            String line = "";
            while (sc.hasNextLine()){
                line = sc.nextLine();
                fortuneList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fortuneList;
    }

    public String getFortuneFromList(String name,String nationality,int age)  {
        return getFortuneList().get(getTheNumber(name,nationality,age));
    }
}
