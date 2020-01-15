package com.wucstone.jdk.forkjoin;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class GenSheet {



    public static void main(String[] args) throws Exception{

        Workbook workbook = WorkbookFactory.create(new File("D://abc.xlsx"));
//        workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        ForkJoinPool forkjoinPool = new ForkJoinPool();

        ForkJoinTask task = new ForkJoinTask(1, 100,sheet);

        //执行一个任务
        Future<Integer> result = forkjoinPool.submit(task);

        System.out.println(result.get());

    }
}
