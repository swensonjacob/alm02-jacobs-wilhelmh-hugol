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
    String fileName = "fortunes.txt";

    public int getTheNumber(String name, String nationality, int age) {
        int randomNr = getRandomNumber(name,nationality,age);
        if(randomNr>100) {
            return randomNr+1;
        } else {
            return randomNr-1;
        }
    }

    private int getRandomNumber(String name, String nationality, int age) {
        return (randomFactor.getIntFromName(name) +
                randomFactor.getIntFromNationality(nationality) +
                randomFactor.getIntFromAge(age))/4;
    }


    public List<String> getFortuneList(String fileName) {
        File file;
        List<String> fortuneList = new ArrayList<>();
        try {
            file  = ResourceUtils.getFile("classpath:" + fileName);
            Scanner sc = new Scanner(file);
            String line = "";

            while (sc.hasNextLine()){
                line = sc.nextLine();
                fortuneList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fortuneList;
    }

    public String getFortuneFromList(String name,String nationality,int age)  {
        return getFortuneList(this.fileName).get(getTheNumber(name,nationality,age));
    }
}
