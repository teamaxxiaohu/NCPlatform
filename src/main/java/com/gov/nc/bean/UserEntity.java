package com.gov.nc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Vincent_2 on 2014/12/18.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    /** id primary key */
    private int id ;

    private String userName;

    private String userPwd;

    /** email address  -- both null or not null is allowed. */
    private String userEmail ;

}
