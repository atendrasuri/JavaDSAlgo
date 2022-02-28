package com.suri.upstock.utils;

import com.suri.upstock.model.Engineer;
import com.suri.upstock.model.Role;

import java.util.List;
import java.util.stream.Collectors;

public class EngineerUtils {

    public static List<Engineer> getEngineersBasedOnRoleType(List<Engineer> engineerList, Role role){
        return engineerList.stream().filter(e->e.getRole().equals(role)).collect(Collectors.toList());
    }
}
