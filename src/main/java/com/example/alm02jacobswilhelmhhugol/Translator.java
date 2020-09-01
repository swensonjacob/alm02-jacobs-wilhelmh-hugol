package com.example.alm02jacobswilhelmhhugol;//Class Translator – The rules for the message that will be displayed. It will contain
//methods that will take a RandomFactor object and the inputs that were filled in the
//form and, then, based on certain rules that you will define, e.g. if first name starts with
//a-h or l-z, if the person is under 20 yo, etc, will return a String with a fortune message.


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


    public List<String> getFortuneList() throws FileNotFoundException {

        File file = new File(getClass().getClassLoader().getResource("fortunes.txt").getFile());
        List<String> fortuneList = new ArrayList<>();
        try {
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

    public String getFortuneFromList(String name,String nationality,int age) throws FileNotFoundException  {
        return getFortuneList().get(getTheNumber(name,nationality,age));
    }
}
