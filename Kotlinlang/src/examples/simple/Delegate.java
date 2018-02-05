package examples.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 委托模式
 *
 * @author Edwin.Wu
 * @version 2018/2/2 下午3:20
 * @since JDK1.8
 */
public abstract class Delegate implements InvocationHandler {
    //--------------------------------------------
    protected Object obj_orgin = null; //原始对象
    protected Object obj_proxy = null; //代理对象
    //--------------------------------------------

    public Delegate() {
    }

    public Delegate(Object orgin) {
        this.createProxy(orgin);
    }


    protected Object createProxy(Object orgin) {
        obj_orgin = orgin;
        // 下面语句中orgin.getClass().getClassLoader()为加载器，orgin.getClass().getInterfaces()为接口集
        obj_proxy = Proxy.newProxyInstance(orgin.getClass().getClassLoader()
                , orgin.getClass().getInterfaces()
                , this); //委托
        return obj_proxy;
    }


    protected Object invokeSuper(Method method, Object[] args) throws Throwable {
        return method.invoke(obj_orgin, args);
    }

    //--------------实现InvocationHandler接口，要求覆盖------------
    //下面实现的方法是当委托的类调用toString()方法时，操作其他方法而不是该类默认的toString()，这个类的其他方法则不会。
    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        // 缺省实现：委托给obj_orgin完成对应的操作
        if (method.getName().equals("toString")) { //对其做额外处理
            return this.invokeSuper(method, args) + "$Proxy";
        } else { //注意，调用原始对象的方法，而不是代理的（obj==obj_proxy）
            return this.invokeSuper(method, args);
        }
    }
}
