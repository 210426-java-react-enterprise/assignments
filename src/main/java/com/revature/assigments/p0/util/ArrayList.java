package com.revature.assigments.p0.util;

public class ArrayList<T> implements List<T> {

    private final int defaultArraySize = 9;
    private int arraySize = defaultArraySize;
    private int size=0;
    private Iterator[] iteArray = new Iterator[defaultArraySize];


    @Override
    public void add(T data) throws IllegalArgumentException {

        if (data == null) {
            throw new IllegalArgumentException("This Array List does not accept null values");
        } else {
            if (size == 0) {
                iteArray[size] = new Iterator(data);
                System.out.println("Testing Add Method>> " + iteArray[size].data);
                size++;
            } else{
                for (int i = 0; i < defaultArraySize; i++) {
                    if(iteArray[i] == null){
                        iteArray[i] = new Iterator(data);
                        System.out.println("Testing Add Method >> " + i);
                        iteArray[i].data = data;
                        break;
                    }

                }

            }
        }
    }

        @Override
        public T pop () {
            return null;
        }

        @Override
        public T get ( int index){
            return null;
        }

        @Override
        public boolean constains (T data){
            return false;
        }

        @Override
        public int size () {

            int evalSize = 0;

            while( iteArray[evalSize]!= null){
                evalSize++;
            }

            /*
            for (int i = 0; i < iteArray.length ; i++) {
                System.out.println(i);
                if(iteArray[i].data != null){
                    eval_size++;
                }
            }
            */
            System.out.println("Testing Size Method >> " + evalSize);
            return evalSize;
        }

        @Override
        public void sort (T data){

        }

        /*
        private Iterator[] grow(Iterator[] IteArray){
            int newSize = arraySize*2;
            Iterator[] newIteArray = new Iterator[newSize];
            newIteArray.

        }
        */

        private static class Iterator<T>{

            T data;

            Iterator(T data) {
                this.data = data;
            }

        }

    }