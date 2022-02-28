package com.suri.upstock.service.impl;

import com.suri.upstock.model.Engineer;
import com.suri.upstock.model.Role;
import com.suri.upstock.service.Rewards;
import com.suri.upstock.utils.EngineerUtils;

import java.util.List;

public class QARewardsImpl implements Rewards {
    @Override
    public Engineer calculateMaxReward(List<Engineer> engineerList) throws Exception {

        int maxPoint = Integer.MIN_VALUE;
        Engineer result = null;
        engineerList = EngineerUtils.getEngineersBasedOnRoleType(engineerList, Role.QA);
        for (Engineer engineer : engineerList) {
            int totalPoint = totalReward(engineer);
            if (totalPoint > maxPoint) {
                maxPoint = totalPoint;
                result = engineer;
            }
        }
        return result;
    }

    private int totalReward(Engineer engineer) {
        return (engineer.getFeatureStory() * 5) + (engineer.getUatBugStory() * 10  ) + (engineer.getProdBugStory() * -10);
    }
}
