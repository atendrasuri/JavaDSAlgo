package com.suri.upstock.service;

import com.suri.upstock.model.Engineer;
import com.suri.upstock.model.Role;

import java.util.List;

public class RewardCalculator {

    public Engineer findBestEngineer(List<Engineer> engineerList, Role role) throws Exception {
        Rewards rewards = RewardFactory.getReward(role);
        return rewards.calculateMaxReward(engineerList);
    }
}
