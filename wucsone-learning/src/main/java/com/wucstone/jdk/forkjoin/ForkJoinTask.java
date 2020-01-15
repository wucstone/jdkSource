package com.wucstone.jdk.forkjoin;


import org.apache.poi.ss.usermodel.*;

import java.util.concurrent.RecursiveTask;


public class ForkJoinTask extends RecursiveTask {


    private Sheet sheet;
    private int start;
    private int end;
    public static final int threshold = 2;

    public ForkJoinTask(int start, int end, Sheet sheet) {
        this.start = start;
        this.end = end;
        this.sheet = sheet;
    }

    @Override
    protected Object compute() {
        if((end-start) <= threshold){
            for(int i = start ; i < end ; i++){
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue("abc"+ i );
            }
            System.out.println(Thread.currentThread().getName() + "完成任务: "+ start + "-->" + end);
            return sheet;
        }else{

            int middle = (start + end) / 2;
            ForkJoinTask leftTask = new ForkJoinTask(start, middle, sheet);
            ForkJoinTask rightTask = new ForkJoinTask(middle + 1, end,sheet);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            return sheet;
        }

    }
}
