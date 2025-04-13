package me.erano.com;

import com.sun.net.httpserver.HttpServer;
import me.erano.com.core.ports.input.RouterNetworkInputPort;
import me.erano.com.core.ports.output.RouterNetworkOutputPort;
import me.erano.com.core.usecases.RouterNetworkUseCase;
import me.erano.com.framework.adapters.input.RouterNetworkAdapter;
import me.erano.com.framework.adapters.input.rest.RouterNetworkRestAdapter;
import me.erano.com.framework.adapters.input.stdin.RouterNetworkCLIAdapter;
import me.erano.com.framework.adapters.input.stdin.RouterViewCLIAdapter;
import me.erano.com.framework.adapters.output.file.RouterNetworkFileAdapter;
import me.erano.com.framework.adapters.output.h2.RouterNetworkH2Adapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;

// to run :
// mvn clean package
// java -jar target/TelecommunicationCompanyAPI-1.0-SNAPSHOT-jar-with-dependencies.jar rest
public class Application {

    RouterNetworkAdapter inputAdapter;
    RouterNetworkUseCase usecase;
    RouterNetworkOutputPort outputPort;

    public static void main(String... args)  {
        var adapter = "cli";
        if(args.length>0) {
            adapter = args[0];
        }
        new Application().setAdapter(adapter);
    }

    void setAdapter(String adapter) {
        switch (adapter){
            case "rest":
                outputPort = RouterNetworkH2Adapter.getInstance();
                usecase = new RouterNetworkInputPort(outputPort);
                inputAdapter= new RouterNetworkRestAdapter(usecase);
                rest();
                break;
            default:
                outputPort = RouterNetworkFileAdapter.getInstance();
                usecase = new RouterNetworkInputPort(outputPort);
                inputAdapter= new RouterNetworkCLIAdapter(usecase);
                cli();
        }
    }

    private void cli() {
        Scanner scanner = new Scanner(System.in);
        inputAdapter.processRequest(scanner);
    }

    private void rest() {
        try {
            System.out.println("REST endpoint listening on port 8080...");
            var httpserver = HttpServer.create(new InetSocketAddress(8080), 0);
            inputAdapter.processRequest(httpserver);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
