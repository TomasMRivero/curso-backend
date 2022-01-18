package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.util.ConfigObserver;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ConfigSubject {
    private Set<ConfigObserver> observers;

    public ConfigSubject(){ observers = Collections.synchronizedSet(new HashSet<>()); }

    public void addObserver(ConfigObserver observer) { observers.add(observer); }
    public void removeObserver(ConfigObserver observer) { observers.remove(observer); }

    public void notifyObserver(Object event){
        synchronized (observers) {
            for (ConfigObserver observer : observers) {
                observer.updateConfig(event);
            }
        }
    }
}
