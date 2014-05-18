package monopoliswing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import customExceptions.MyException;
/**
 *
 * @author Riska IF
 */
public class UseCustomException {
    MyException newExc=new MyException("custom Exception");
    public UseCustomException() throws MyException{
        System.out.println("....");
        throw newExc;
    }
}
