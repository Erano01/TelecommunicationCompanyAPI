package me.erano.com;

import me.erano.com.framework.adapters.input.RouterViewCLIAdapter;

public class Application {

    public static void main(String... args) {
        var cli = new RouterViewCLIAdapter();
        var type = "EDGE";
        System.out.println(cli.obtainRelatedRouters(type));

    }
}
