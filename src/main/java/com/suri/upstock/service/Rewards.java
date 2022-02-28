package com.suri.upstock.service;

import com.suri.upstock.model.Engineer;

import java.util.List;

public interface Rewards {

    Engineer calculateMaxReward(List<Engineer> engineerList) throws Exception;

}
