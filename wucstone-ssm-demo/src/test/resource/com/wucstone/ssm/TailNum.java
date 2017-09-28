package com.wucstone.ssm;
public class TailNum {


    private static TailNum instance;
    private long cnt = 0;
        TailNum() {
        }


        /**
         * 返回当前对象
         * 单例模式 同步
         */
        public static synchronized TailNum getInstance() {
            if (instance == null) {
                instance = new TailNum();
            }
            return instance;
        }

        public synchronized String getTailCnt(){
            if(cnt > 9999){
                cnt = 1;
            }

            return String.format("%04d" ,cnt ++);

        }

        public static void main(String[] args) {
        	TailNum tn=getInstance();
        	for (int i = 0; i < 10; i++) {
        		System.out.println(tn.getTailCnt());
			}
		}
    }
