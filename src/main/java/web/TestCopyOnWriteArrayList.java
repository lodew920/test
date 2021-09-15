package web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * CopyOnWriteArrayList/CopyOnWriteArrayListOnWriteArraySet : “写入并复制”
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择。
 */
public class TestCopyOnWriteArrayList {


	/*

        public STATIC void
        public STATIC void
        public static void
        public STATIC void
        public static void

	*/


    public static void main(String[] args) {
        HelloThread ht = new HelloThread();

        for (int i = 0; i < 2; i++) {
            new Thread(ht).start();
        }
    }
}

class HelloThread implements Runnable {

//	private static List<String> list = Collections.synchronizedList(new ArrayList<String>());

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//	private static ArrayList<String> list = new ArrayList<>();


    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {

        Iterator<String> it = list.iterator();
        System.out.println("开始");

        while (it.hasNext()) {
            System.out.println(it.next());

            list.add("HH");

        }

        System.out.println("结束了");
//
//		Iterator<String> it2 = list.iterator();
//
//		while (it2.hasNext()) {
//			System.out.println(it2.next());
//
//		}


    }

}