package com.gov.nc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vincent_2 on 2014/12/18.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    /** id primary key */
    private int id ;

    /** user's identify info. */
    private String account;

    /** user's password  which should be contained number and characters */
    private String password;

    /** the nick name  is used to show on pages */
    private  String nickName;

    /**
     * Card Type contains four elements : ID_CARD, DRIVEN_CARD, STU_CARD,SOCIAL_CARD <br>
     * you can bind any one of them to make sure that the system can recognize your identity <br>
     * if <code>ID_CARD</code> is selected, property <code>cardNum</code> should be made of 15 or 18 numbers.
     * if <code>DRIVEN_CARD</code> is selected,  <code>cardNum</code>  should be made of 12 numbers;
     * <code>STU_CARD</code> can only used by student ,you can judge it by validating the property birthday.
     */
    private  enum  LEVEL {
        ID_CARD, DRIVEN_CARD, STU_CARD,SOCIAL_CARD
    }

    /** the number of card which will depends on property <code>cardType</code>
     *  you can find the validate rules on <Code>cardType</Code>
     */
    private String cardNum;


    /** email address  -- either null or not null is allowed. */
    private String emailAddress ;

    /** State :<CODE>BIND</CODE> has bind phone number to system ,<code>UNBIND</code> otherwise.*/
    private enum BINDPHONE{
        BIND,UNBIND
    }

    /** phone number -- usually use mobile phone number like 13812345678
     *  but special situation is also considered in system , so  some  like
     *  010-12345678 is also allowed.
     */
    private  String phoneNum;

    /**
     * the property <code>level</code>  in system  is a virtual information. it's proves that how much time
     * the user spend on this system. the value of <code>level</code> is depend on property <code>score</code><br>
     * for example: score [1,50] means Lv.1,(50,200] means Lv.2  etc.
     */
    private int level ;

    /**
     * <code>score</code> is used for supply data for calculating level, you can get more scores by those ways as follows:<br>
     * the way to get scores:<br>
     * 1. 5 scores will be given by login in the system , at most 20 per day.<br>
     * 2. each order can supply you 10 scores,but at most 100 per day.<br>
     * which operate will cause you to lose your scores:<br>
     * 1.login in the system frequently ,some like 5 login operate had done in just one minute.
     */
    private int score ;

    /**
     * Key property <code>address</code> <br>
     * Once this property is set, all the goods in order(s) will be sent to this place.
     * so, you should make it rightful.
     */
    private String address ;

    /** user's birthday , on this day , the system will send 100 scores automatically */
    private Date birthday ;
}
