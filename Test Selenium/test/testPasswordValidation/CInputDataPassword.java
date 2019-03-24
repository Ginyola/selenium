/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPasswordValidation;

/**
 *
 * @author Костя
 */
public class CInputDataPassword
{
    protected static String testingURL = "https://id.rambler.ru/account/registration";
    protected static String testingIdString = "newPassword";
    
    protected static String checkingAttribute = "class";
    protected static String checkingClassString = "rui-Input-error";
    protected static String checkingClassPasswordXpathString = "//input[@id='newPassword']/..";   
    
    public static String[] inputValidPasswordData = 
    {
        "123456Qq",
        "PassWord123",
        "cnwjUt5u!nrhvH",
        "111111111222222233333344444556Qq",
        "!@$%^&*()_-+Qq1"
    };
    
    public static String[] inputInvalidPasswordData = 
    {
        " ",
        "32rd43f",
        "fwkb475",
        "111111111222222233333344444556Qqw",
        "111111111222222233333344444556Q00000000000000000000000000000000000000"
            + "000000000000000000000000000000000000000000000000000000000000000"
            + "000000000000000000000000000000000000000000000000000000000000000",
        "12345Qq",
        "你好你好你好你好你好你好",
        "№123456Qq",
        "#123456Qq",
        ":123456Qq",
        ";123456Qq",
        ">123456Qq",
        "<123456Qq",
        "°‘|}♥♦♣♠•◘○-♦♠☺☻",
        "♥123456Qq",
        "☺123456Qq",
        ";SELECT * FROM users;",
        "alert();"
    };
}
