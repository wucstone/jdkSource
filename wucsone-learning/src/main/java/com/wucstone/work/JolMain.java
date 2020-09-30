package com.wucstone.work;

import org.openjdk.jol.info.ClassLayout;

public class JolMain {


    public static void main(String[] args) throws Exception{

        Thread.sleep(5000);

        A obj = new A();


        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("****************************无锁，可偏向状态"+JolHashUtils.hash(obj)+"********************************************");

        synchronized (obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            System.out.println("****************************偏向锁********************************************");
        }
        synchronized (obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            System.out.println("****************************偏向锁********************************************");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
                        System.out.println(JolHashUtils.hash(obj));
                        System.out.println("************************************************************************");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
                        System.out.println(JolHashUtils.hash(obj));
                        System.out.println("************************************************************************");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }).start();




    }
}
