/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.selenium;

/**
 *
 * @author Костя
 */
public class CInputData
{
    protected static String testingURL = "https://id.rambler.ru/account/registration";
    protected static String testingIdString = "newPassword";
    
    protected static String checkingAttribute = "class";
    protected static String checkingClassString = "rui-Input-error";
    protected static String checkingClassXpathString = "//input[@id='newPassword']/..";   
    
    protected static String[] inputValidData = 
    {
        "123456Qq",
        "PassWord123",
        "cnwjUt5u!nrhvH"
    };
    
    protected static String[] inputInvalidData = 
    {
        " ",
        "32rd43f",
        "fwkb475"
    };
}
