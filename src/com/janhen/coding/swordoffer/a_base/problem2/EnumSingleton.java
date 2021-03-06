package com.janhen.coding.swordoffer.a_base.problem2;

/**
 * 枚举单例
 *
 * 自动进行反射、序列化防御
 */
public enum EnumSingleton {
    INSTANCE {
        // 单例中的方法
        protected void printTest() {
            System.out.println("Test");
        }
    };

    protected abstract void printTest();

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
