package cn.minalz.ipregion;

import org.lionsoul.ip2region.xdb.Searcher;
import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * 【基于文件查询】
 */
public class SearcherTest1 {
    public static void main(String[] args) {
        // 1、创建 searcher 对象
        String dbPath = "D:/AAAProject/ip2region/data/ip2region.xdb";
        Searcher searcher = null;
        try {
            searcher = Searcher.newWithFileOnly(dbPath);
        } catch (IOException e) {
            System.out.printf("failed to create searcher with `%s`: %s\n", dbPath, e);
            return;
        }

        // 2、查询
        String ip = "47.96.73.9";
        try {
            long sTime = System.nanoTime();
            String region = searcher.search(ip);
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
        } catch (Exception e) {
            System.out.printf("failed to search(%s): %s\n", ip, e);
        }

        // 3、备注：并发使用，每个线程需要创建一个独立的 searcher 对象单独使用。
    }
}
