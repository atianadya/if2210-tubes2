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

    /**
     * Kelas Khusus Exception
     * @param ex
     */
    public MyException(String ex){
        super(ex);
    }

    /**
     * Mendapatkan message error dari exception
     * @return message exception
     */
    public String getMessage(){
        return super.getMessage();
    }
}
