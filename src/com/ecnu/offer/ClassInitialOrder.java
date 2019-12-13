package com.ecnu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * static关键字的代码块应该是最先执行，其次是非static关键字的代码块以及类的属性(Fields),最后是构造方法。
 * @author A
 *
 */
public class ClassInitialOrder {
	public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        BaseCodeBlock bcb = new CodeBlockForJava();
        bcb.msg();
    }
}

class CodeBlockForJava extends BaseCodeBlock {
    {
        System.out.println("这里是子类的普通代码块");
    }
    public CodeBlockForJava() {
        System.out.println("这里是子类的构造方法");
    }
    @Override
    public void msg() {
    	System.out.println("这里是子类的普通方法");
    }
    public static void msg2() {
        System.out.println("这里是子类的静态方法");
    }

    static {
        System.out.println("这里是子类的静态代码块");
    }
    
    Other o = new Other();
}

class BaseCodeBlock {
	{
        System.out.println("这里是父类的普通代码块");
    }
    public BaseCodeBlock() {
        System.out.println("这里是父类的构造方法");
    }
    public void msg() {
        System.out.println("这里是父类的普通方法");
    }
    public static void msg2() {
        System.out.println("这里是父类的静态方法");
    }
    static {
        System.out.println("这里是父类的静态代码块");
    }
    Another o2 = new Another();    
}

class Other {
    Other() {
        System.out.println("初始化子类的属性值");
    }
}

class Another {
    Another() {
        System.out.println("初始化父类的属性值");
    }
}