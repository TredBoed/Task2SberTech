package com.company;

import java.util.Iterator;
import java.util.List;


    public  class ListIterator<Type> implements Iterable<Type> {

        private List<Type> linkedList;
        private int currentSize;

        public ListIterator(List<Type> newList) {
            this.linkedList = newList;
            this.currentSize = linkedList.size();
        }

        @Override
        public Iterator<Type> iterator() {
            Iterator<Type> it = new Iterator<Type>() {

                private int currentIndex = linkedList.size()-1;

                @Override
                public boolean hasNext() {
                    return currentIndex >= 0 &&  linkedList.get(currentIndex) != null;
                }

                @Override
                public Type next() {
                    return linkedList.get(currentIndex--);
                }

                @Override
                public void remove() {
                    linkedList.remove(currentIndex);
                }
            };
            return it;
        }
    }

