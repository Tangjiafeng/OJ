package com.ecnu.offer;

/**
 * 每一个过程都是按照类文件的类成员从上到下执行
 * new对象的时候同样是从上到下加载每一个成员
 * 类加载过程:
 * 1，class文件由ClassLoader加载到内存
 * 2，linking过程
 * 	2-1，verification 检查语法格式
 *  2-2，preparation 静态变量赋默认值
 *  2-3，resolution 解析，找到构造方法等直接可以运行的位置
 * 3，initialzing 静态变量赋为初始值
 * 4，GC
 */
public class ClassLoadingProcedure {
	public static void main(String[] args) {
		System.out.println(T.count);
		System.out.println(T.t);
	}
}
class T {
	// 交换一下这两行的顺序，main函数中的count是不一样的
	// t，count的值变化过程：
	// null，0（preparation）
	// null，1（resolution，new对象的时候执行构造方法）
	// T@十六进制哈希码，8（initialzing，构造方法完成，加载count静态成员变量，赋初始值）
	public static T t = new T();
	public static int count = 8;
	
	// count，t的值变化过程：
	// 0，null（preparation）
	// 8，null（resolution）
	// 9，T@十六进制哈希码（initialzing，加载t静态成员变量，new对象调用了构造方法）
//	public static int count = 8;
//	public static T t = new T();
	Object o = new Object();
	
	private T() {
		count ++;
		System.out.println("T构造方法中：" + count);
		
	}	
}