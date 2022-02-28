package com.suri.upstock.service;

import com.suri.upstock.model.Role;
import com.suri.upstock.service.impl.DevRewardsImpl;
import com.suri.upstock.service.impl.QARewardsImpl;

public class RewardFactory {

    public static Rewards getReward(Role role){
        if(role.equals(Role.DEV)){
            return new DevRewardsImpl();
        }else{
            return new QARewardsImpl();
        }
    }
}
