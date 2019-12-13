package com.ecnu.offer;

/**
 * ÿһ�����̶��ǰ������ļ������Ա���ϵ���ִ��
 * new�����ʱ��ͬ���Ǵ��ϵ��¼���ÿһ����Ա
 * ����ع���:
 * 1��class�ļ���ClassLoader���ص��ڴ�
 * 2��linking����
 * 	2-1��verification ����﷨��ʽ
 *  2-2��preparation ��̬������Ĭ��ֵ
 *  2-3��resolution �������ҵ����췽����ֱ�ӿ������е�λ��
 * 3��initialzing ��̬������Ϊ��ʼֵ
 * 4��GC
 */
public class ClassLoadingProcedure {
	public static void main(String[] args) {
		System.out.println(T.count);
		System.out.println(T.t);
	}
}
class T {
	// ����һ�������е�˳��main�����е�count�ǲ�һ����
	// t��count��ֵ�仯���̣�
	// null��0��preparation��
	// null��1��resolution��new�����ʱ��ִ�й��췽����
	// T@ʮ�����ƹ�ϣ�룬8��initialzing�����췽����ɣ�����count��̬��Ա����������ʼֵ��
	public static T t = new T();
	public static int count = 8;
	
	// count��t��ֵ�仯���̣�
	// 0��null��preparation��
	// 8��null��resolution��
	// 9��T@ʮ�����ƹ�ϣ�루initialzing������t��̬��Ա������new��������˹��췽����
//	public static int count = 8;
//	public static T t = new T();
	Object o = new Object();
	
	private T() {
		count ++;
		System.out.println("T���췽���У�" + count);
		
	}	
}