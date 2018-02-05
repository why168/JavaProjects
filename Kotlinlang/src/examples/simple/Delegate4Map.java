package examples.simple;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

/**
 * 委托模式
 *
 * @author Edwin.Wu
 * @version 2018/2/2 下午3:29
 * @since JDK1.8
 */
class Delegate4Map extends Delegate {
    private Map orginClass = null; //原始对象
    private Map proxyClass = null; //代理对象

    public Map getOrgin() {
        return orginClass;
    }

    public Map getProxy() {
        return proxyClass;
    }

    public Delegate4Map(Map orgin) {
        super(orgin);
        orginClass = orgin;
        proxyClass = (Map) super.obj_proxy;
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
//        super.invoke(obj, method, args);
        if (method.getName().equals("size")) { //修改size处理逻辑
            Object res2 = -1;
            System.out.println("调用委托的方法");
            return res2;
        } else {
            System.out.println("调用原始的方法");
            return super.invoke(obj, method, args);
        }
    }

    public static void main(String[] args) {
        Delegate4Map rtm = new Delegate4Map(new Hashtable());
        Map m = rtm.getProxy();
        m.toString();
        System.out.println(m.size());

    }
}
