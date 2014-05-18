package monopoliswing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Riska IF
 */
public class MyException extends Exception{
    public MyException(String exc){
        super(exc);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
