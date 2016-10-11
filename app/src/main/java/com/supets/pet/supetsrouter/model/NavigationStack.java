package com.supets.pet.supetsrouter.model;

import java.io.Serializable;

public final class NavigationStack implements Serializable {

    public String mClassName;

    public NavigationStack setClassName(String mClassName) {
        this.mClassName = mClassName;
        return this;
    }

    public Class<?> getClassType() {
        try {
            return  getClass().getClassLoader().loadClass(mClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}