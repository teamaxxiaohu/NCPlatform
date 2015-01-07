package com.gov.nc.services;

/**
 * Created by Vincent_2 on 2015/1/5.
 */
public class MoAttack implements  ActorInterface{
    private  Actor  actor;
    @Override
    public void injectActor(Actor actor) {
        this.actor = actor;
    }
}
