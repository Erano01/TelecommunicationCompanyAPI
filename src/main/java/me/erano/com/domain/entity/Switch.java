package me.erano.com.domain.entity;

import me.erano.com.domain.value.IP;
import me.erano.com.domain.value.Network;
import me.erano.com.domain.value.SwitchId;
import me.erano.com.domain.value.SwitchType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Switch {

    private SwitchId switchId;
    private SwitchType switchType;
    private List<Network> networks;
    private IP address;

    public Switch (SwitchId switchId, SwitchType switchType, List<Network> networks, IP address){
        this.switchId = switchId;
        this.switchType = switchType;
        this.networks = networks;
        this.address = address;
    }

    public Switch addNetwork(Network network, Router router){
        List<Network> newNetworks = new ArrayList<>();

        router.retrieveNetworks().forEach(net ->{
            newNetworks.add(net);
        });

        newNetworks.add(network);
        return new Switch(this.switchId, this.switchType, newNetworks, this.address);
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public SwitchId getSwitchId() {
        return switchId;
    }

    public SwitchType getSwitchType() {
        return switchType;
    }

    public IP getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "switchType=" + switchType +
                ", switchId=" + switchId +
                ", networks=" + networks +
                ", address=" + address +
                '}';
    }
}