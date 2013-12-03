package ch.uzh.inf01.cobol.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Set<T> {

    private final List<T> mItems;

    public Set() {
        mItems = new ArrayList<>();
    }

    public Set(T[] pArray) {
        this();

        for (int i = 0; i < pArray.length; i++) {
            add(pArray[i]);
        }
    }

    public Set(List<T> pList) {
        this();

        for (int i = 0; i < pList.size(); i++) {
            add(pList.get(i));
        }
    }

    public int size() {
        return mItems.size();
    }

    public Set<T> add(T item) {
        if (!contains(item)) {
            mItems.add(item);
        }
        return this;
    }

    // -> HUGE PRIVACY LEAK
    public List<T> toArrayList() {
        return Collections.unmodifiableList(mItems);
    }

    public Set<T> add(Set<T> pOther) {
        List<T> otherItems = pOther.toArrayList();
        for (T entry : otherItems) {
            add(entry);
        }
        return this;
    }

    public Set<T> remove(T pItem) {
        mItems.remove(pItem);
        return this;
    }

    public boolean contains(T item) {
//        boolean foundExisting = false;

        for (int i = 0; i < mItems.size(); i++) {
            if (mItems.get(i).equals(item)) {
//                foundExisting = true;
//                break;
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < mItems.size(); i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(mItems.get(i).toString());
        }
        builder.append("]");

        return builder.toString();
    }

}
