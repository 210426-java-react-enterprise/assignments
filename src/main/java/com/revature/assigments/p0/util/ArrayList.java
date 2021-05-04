package com.revature.assigments.p0.util;

public class ArrayList<T> implements List<T>{

    private final int default_array_size = 10;
    private int size;
    Iterator[] iteArray;

    ArrayList(){

    }

    @Override
    public void add(T data) throws NullPointerException {
        try{
            if (size == 0){
                iteArray[0].data = data;
                size++;
            }else{

            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean constains(T data) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void sort(T data) {

    }

    private static class Iterator<T>{

        T data;

        Iterator(T data){
            this.data = data;
        }

    }

}
