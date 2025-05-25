package com.bananahrm.hrms.Service.user;

import com.bananahrm.hrms.Entity.User;

public interface IUserService {
    User getUserByUsername(String username) throws Exception;
}
