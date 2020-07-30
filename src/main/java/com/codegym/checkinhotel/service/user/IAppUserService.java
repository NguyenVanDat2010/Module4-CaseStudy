package com.codegym.checkinhotel.service.user;

import com.codegym.checkinhotel.model.AppUser;
import com.codegym.checkinhotel.service.IService;

public interface IAppUserService extends IService<AppUser> {
    AppUser getUserByUserName(String username);
}
