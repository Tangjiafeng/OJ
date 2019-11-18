package com.ecnu.offer;

/**
 * static�ؼ��ֵĴ����Ӧ��������ִ�У�����Ƿ�static�ؼ��ֵĴ�����Լ��������(Fields),����ǹ��췽����
 * @author A
 *
 */
public class ClassInitialOrder {
	public static void main(String[] args) {
        BaseCodeBlock bcb = new CodeBlockForJava();
        bcb.msg();
    }
}

class CodeBlockForJava extends BaseCodeBlock {
    {
        System.out.println("�������������ͨ�����");
    }
    public CodeBlockForJava() {
        System.out.println("����������Ĺ��췽��");
    }
    @Override
    public void msg() {
    	System.out.println("�������������ͨ����");
    }
    public static void msg2() {
        System.out.println("����������ľ�̬����");
    }

    static {
        System.out.println("����������ľ�̬�����");
    }
    
    Other o = new Other();
}

class BaseCodeBlock {
	{
        System.out.println("�����Ǹ������ͨ�����");
    }
    public BaseCodeBlock() {
        System.out.println("�����Ǹ���Ĺ��췽��");
    }
    public void msg() {
        System.out.println("�����Ǹ������ͨ����");
    }
    public static void msg2() {
        System.out.println("�����Ǹ���ľ�̬����");
    }
    static {
        System.out.println("�����Ǹ���ľ�̬�����");
    }
    Another o2 = new Another();    
}

class Other {
    Other() {
        System.out.println("��ʼ�����������ֵ");
    }
}

class Another {
    Another() {
        System.out.println("��ʼ�����������ֵ");
    }
}