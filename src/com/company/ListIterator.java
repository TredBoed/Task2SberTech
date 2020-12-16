package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


    public  class ListIterator<Type> implements Iterable<Type> {

        private ArrayList<Type> arrlist;
        private int currentSize;

        public ListIterator(ArrayList<Type> newList) {
            this.arrlist = newList;
            this.currentSize = arrlist.size();
        }

        @Override
        public Iterator<Type> iterator() {
            Iterator<Type> it = new Iterator<Type>() {

                private int currentIndex = arrlist.size()-1;

                @Override
                public boolean hasNext() {
                    return currentIndex >= 0 &&  arrlist.get(currentIndex) != null;
                }

                @Override
                public Type next() {
                    return arrlist.get(currentIndex--);
                }

                @Override
                public void remove() {
                    arrlist.remove(currentIndex);
                }
            };
            return it;
        }
    }

