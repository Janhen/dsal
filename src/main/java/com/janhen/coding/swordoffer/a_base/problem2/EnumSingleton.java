package main.java.janhen.swordoffer.a_base.problem2;

/**
 * 枚举单例
 *
 * @author Janhen
 */
public enum EnumSingleton {
    INSTANCE{
        protected  void printTest(){
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

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
