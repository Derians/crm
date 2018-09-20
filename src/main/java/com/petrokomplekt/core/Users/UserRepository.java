package com.petrokomplekt.core.Users;


import com.petrokomplekt.core.Users.madel.UserModel;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Resource
public interface UserRepository extends CrudRepository<UserModel, Long> {

    /**
     * Method findByUserPersonalEmail
     *
     * @param email the user personal email.
     * @return the user having the passed personal email or null if no user is found.
     */
    public UserModel findByUserPersonalEmail(String email);

    /**
     * Method findByUserEmail
     *
     * @param email the user email.
     * @return the user having the passed email or null if no user is found.
     */
    public UserModel findByUserEmail(String email);

    /**
     * Method findByUserGender
     *
     * @param gender the user gender.
     * @return the list of users having the passed gender or null if no user is found.
     */
    public List<UserModel> findByUserGender(String gender);

    /**
     * Method findByUserFirstName
     *
     * @param firstName the user first name.
     * @return the list of users having the passed firstName or null if no user is found.
     */

    public List<UserModel> findByUserFirstName(String firstName);

    /**
     * Method findByUserLastName
     *
     * @param lastName the user last name.
     * @return the list of users having the passed lastName or null if no user is found.
     */

    public List<UserModel> findByUserLastName(String lastName);

    /**
     * Method findByUserPosition
     *
     * @param userPosition the user user position.
     * @return the list of users having the passed userPosition or null if no user is found.
     */

    public List<UserModel> findByUserPosition(String userPosition);

    /**
     * Method findByUserPcName
     *
     * @param userPcName the user user pc name.
     * @return the user having the passed email or null if no user is found.
     */
    public UserModel findByUserPcName(String userPcName);

    /**
     * Method findByUserIpAddress
     *
     * @param userIpAddress the user user ip address.
     * @return the user having the passed userIpAddress or null if no user is found.
     */
    public UserModel findByUserIpAddress(String userIpAddress);

    /**
     * Method findByUserLevel
     *
     * @param userLevel the user user level.
     * @return the list of users having the passed userLevel or null if no user is found.
     */

    public List<UserModel> findByUserLevel(String userLevel);

    /**
     * Method findByUserDepartment
     *
     * @param userDepartment the user user department.
     * @return the list of users having the passed userDepartment or null if no user is found.
     */

    public List<UserModel> findByUserDepartment(String userDepartment);

    /**
     * Method findByUserExternalId
     *
     * @param userExternalId the user user external id.
     * @return the user having the passed userExternalId or null if no user is found.
     */
    public UserModel findByUserExternalId(String userExternalId);

}
