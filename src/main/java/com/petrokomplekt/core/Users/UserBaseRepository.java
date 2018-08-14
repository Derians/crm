package com.petrokomplekt.core.Users;

import com.petrokomplekt.core.Users.madel.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface UserBaseRepository<T extends UserModel> extends CrudRepository<T, Long> {

    /**
     * Method findByUserPersonalEmail
     *
     * @param email the user personal email.
     * @return the user having the passed personal email or null if no user is found.
     */
    public T findByUserPersonalEmail(String email);

    /**
     * Method findByUserEmail
     *
     * @param email the user email.
     * @return the user having the passed email or null if no user is found.
     */
    public T findByUserEmail(String email);

    /**
     * Method findByUserGender
     *
     * @param gender the user gender.
     * @return the list of users having the passed gender or null if no user is found.
     */
    public List<T> findByUserGender(String gender);

    /**
     * Method findByUserFirstName
     *
     * @param firstName the user first name.
     * @return the list of users having the passed firstName or null if no user is found.
     */

    public List<T> findByUserFirstName(String firstName);

    /**
     * Method findByUserLastName
     *
     * @param lastName the user last name.
     * @return the list of users having the passed lastName or null if no user is found.
     */

    public List<T> findByUserLastName(String lastName);

    /**
     * Method findByUserPosition
     *
     * @param userPosition the user user position.
     * @return the list of users having the passed userPosition or null if no user is found.
     */

    public List<T> findByUserPosition(String userPosition);

    /**
     * Method findByUserPcName
     *
     * @param userPcName the user user pc name.
     * @return the user having the passed email or null if no user is found.
     */
    public T findByUserPcName(String userPcName);

    /**
     * Method findByUserIpAddress
     *
     * @param userIpAddress the user user ip address.
     * @return the user having the passed userIpAddress or null if no user is found.
     */
    public T findByUserIpAddress(String userIpAddress);

    /**
     * Method findByUserLevel
     *
     * @param userLevel the user user level.
     * @return the list of users having the passed userLevel or null if no user is found.
     */

    public List<T> findByUserLevel(String userLevel);

    /**
     * Method findByUserDepartment
     *
     * @param userDepartment the user user department.
     * @return the list of users having the passed userDepartment or null if no user is found.
     */

    public List<T> findByUserDepartment(String userDepartment);

    /**
     * Method findByUserExternalId
     *
     * @param userExternalId the user user external id.
     * @return the user having the passed userExternalId or null if no user is found.
     */
    public T findByUserExternalId(String userExternalId);



} // UserBaseRepository
