package com.petrokomplekt.core.Users;

import com.petrokomplekt.core.Users.madel.UserModel;

import javax.transaction.Transactional;


@Transactional
public interface UserRepository extends UserBaseRepository<UserModel> {


}
