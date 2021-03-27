package com.codegym.socialNetwork.service.role;

import com.codegym.socialNetwork.model.AppRole;
import com.codegym.socialNetwork.service.IService;

public interface IRoleService extends IService<AppRole> {
    AppRole findByName(String name);
}
