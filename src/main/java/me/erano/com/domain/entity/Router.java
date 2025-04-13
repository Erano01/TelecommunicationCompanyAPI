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

    private RouterType type;
    private RouterId id;
    private Switch networkSwitch;

    public Router(){

    }

    public Router(RouterType type, RouterId id) {
        this.type = type;
        this.id = id;
    }

    public Router(RouterType type, RouterId id, Switch networkSwitch) {
        this.type = type;
        this.id = id;
        this.networkSwitch = networkSwitch;
    }

    public boolean isType(RouterType type){
        return this.type == type;
    }

    public void addNetworkToSwitch(Network network){
        this.networkSwitch = networkSwitch.addNetwork(network, this);
    }

    public Network createNetwork(IP address, String name, int cidr){
        return new Network(address, name, cidr);
    }

    public List<Network> retrieveNetworks(){
        return networkSwitch.getNetworks();
    }

    public RouterType getType() {
        return type;
    }

    public RouterId getId() {
        return id;
    }

    public Switch getNetworkSwitch() {
        return networkSwitch;
    }

    @Override
    public String toString() {
        return "Router{" +
                "type=" + type +
                ", id=" + id +
                ", networkSwitch=" + networkSwitch +
                '}';
    }
}
