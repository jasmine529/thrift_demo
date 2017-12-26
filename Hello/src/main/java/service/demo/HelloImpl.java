package service.demo;

import org.apache.thrift.TException;
import service.demo.Hello.Iface;

public class HelloImpl implements Iface {
    @Override
    public String helloWorld(String name) throws TException {
        System.out.println("get"+name);
        return "helloWorldBY"+name;
    }
}