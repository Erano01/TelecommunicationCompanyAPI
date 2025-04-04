package me.erano.com.domain.entity;

import me.erano.com.domain.value.IP;
import me.erano.com.domain.value.Network;
import me.erano.com.domain.value.RouterId;
import me.erano.com.domain.value.RouterType;

import java.util.List;
import java.util.function.Predicate;

//Entity
//Aggregate Root for network components (IP, Switch, Network)
public class Router {

    private final RouterType routerType;
    private final RouterId routerid;
    private Switch networkSwitch;

    public Router(RouterType routerType, RouterId routerid){
        this.routerType = routerType;
        this.routerid = routerid;
    }

    public static Predicate<Router> filterRouterByType(RouterType routerType){
        return routerType.equals(RouterType.CORE)
                ? Router.isCore() :
                Router.isEdge();
    }

    public static Predicate<Router> isCore(){
        return p -> p.getRouterType() == RouterType.CORE;
    }

    public static Predicate<Router> isEdge(){
        return p -> p.getRouterType() == RouterType.EDGE;
    }

    public void addNetworkToSwitch(Network network){
        this.networkSwitch = networkSwitch.addNetwork(network);
    }

    public Network createNetwork(IP address, String name, int cidr){
        return new Network(address, name, cidr);
    }

    public List<Network> retrieveNetworks(){
        return networkSwitch.getNetworks();
    }

    public RouterType getRouterType(){
        return routerType;
    }

    @Override
    public String toString(){
        return "Router{" +
                "type=" + routerType +
                ", id=" + routerid +
                '}';
    }
}
