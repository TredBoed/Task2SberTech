package com.company;

import java.util.Iterator;
import java.util.LinkedList;



    public  class ListIterator<Type> implements Iterable<Type>
    {
        private LinkedList<Type> list;

        public ListIterator(LinkedList<Type> newList)
        {
            this.list = newList;
        }

        @Override
        public Iterator<Type> iterator()
        {
            Iterator<Type> it = new Iterator<Type>()
            {

                @Override
                public boolean hasNext()
                {
                    return !list.isEmpty();
                }

                @Override
                public Type next()
                {
                    return list.pop();
                }

                @Override
                public void remove()
                {
                    throw new UnsupportedOperationException();
                }
            };
            return it;
        }
    }

