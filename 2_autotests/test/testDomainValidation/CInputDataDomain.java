/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDomainValidation;

/**
 *
 * @author Костя
 */
public class CInputDataDomain
{
    protected static String testingURL = "https://id.rambler.ru/account/registration";
    protected static String testingIdString = "login";
    
    protected static String checkingAttribute = "class";
    protected static String checkingClassString = "rui-Input-error";
    protected static String checkingClassDomainXpathString = "//input[@id='login']/..";   
    
    public static String[] inputValidDomainData = 
    {
        "123456Qq",
        "PassWo rd123",
        "111111111222222233333344444556Qq",
        "test.login364",
        "test.l.ogin364",
        "test-login364",
        "test_login364"
    };
    
    public static String[] inputInvalidDomainData = 
    {
        "111111111222222233333344444556Qqw",
        "111111111222222233333344444556Q00000000000000000000000000000000000000"
            + "000000000000000000000000000000000000000000000000000000000000000"
            + "000000000000000000000000000000000000000000000000000000000000000",
        "你好你好你好你好你好你好",
        "№123456Qq",
        "#123456Qq",
        "test..login364",
        ":123456Qq",
        ";123456Qq",
        ">123456Qq",
        "test@login364",
        "test.login364.",
        ".test.login364",
        "test._login364",
        "_test.login364_",
        "<123456Qq",
        "°‘|}♥♦♣♠•◘○-♦♠☺☻",
        "♥123456Qq",
        "☺123456Qq",
        ";SELECT * FROM users;",
        "alert();"
    };
}
