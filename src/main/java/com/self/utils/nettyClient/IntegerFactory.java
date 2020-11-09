package com.self.utils.nettyClient;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerFactory {
	
	    /**
	     * AtomicInteger 线程安全的
	     * @author xuwenbin
	     * 
	     * AtomicInteger atomicInteger = new AtomicInteger();
	     * System.out.println(atomicInteger.get());
	     * 输出： 0
	     * 
	     * 
	     * AtomicInteger的作用，用原子方式更新的int值。主要用于在高并发环境下的高效程序处理。使用非阻塞算法来实现并发控制。
	     * atomicInteger.getAndIncrement();//count值自加1
	     *
	     */
	    private static class SingletonHolder {
	        private static final AtomicInteger INSTANCE = new AtomicInteger();
	    }

	    private IntegerFactory(){}
        //单例模式
	    public static final AtomicInteger getInstance() {
	        return SingletonHolder.INSTANCE;
	    }
}
