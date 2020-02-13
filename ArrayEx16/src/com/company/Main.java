package com.company;
import javax.swing.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        int answer=(int)(Math.random()*100+1);
        int input=0;
        String temp="";
        int count=0;
        do {
            count++;
            temp=JOptionPane.showInputDialog("1~100사이의 숫자를 입력하세요");
            if(temp==null||temp.equals("-1"))
                break;
            input=Integer.parseInt(temp);
        }while (true);
    }
}
