package com.suri.upstock;


import com.suri.upstock.model.Engineer;
import com.suri.upstock.model.Role;
import com.suri.upstock.service.RewardCalculator;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {


        List<Engineer> engineerList = new ArrayList<>();

        Engineer e1 = new Engineer("Ashok", Role.DEV, "Anup",156,29,13);
        Engineer e2 = new Engineer("Naynish", Role.DEV, "Anup",127,54,0);
        Engineer e3 = new Engineer("Anup", Role.DEV, "Sami",487,65,31);
        Engineer e4 = new Engineer("Ujjwal", Role.QA, "Anup",200,547,65);
        engineerList.add(e1);
        engineerList.add(e2);
        engineerList.add(e3);
        engineerList.add(e4);

        RewardCalculator rewardCalculator = new RewardCalculator();

        Engineer bestDeveloper = rewardCalculator.findBestEngineer(engineerList, Role.DEV);
        Engineer bestQA = rewardCalculator.findBestEngineer(engineerList, Role.QA);
        System.out.println("bestDeveloper >>> "+bestDeveloper);
        System.out.println("bestQA >>> "+bestQA);

    }
}



