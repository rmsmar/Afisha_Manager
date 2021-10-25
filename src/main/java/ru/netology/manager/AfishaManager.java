package ru.netology.manager;

import ru.netology.domain.Afisha;

public class AfishaManager {

    private Afisha[] items = new Afisha[0];
    private int outItemCount = 10;

    public AfishaManager() {
    }

    public AfishaManager(int outItemCount) {
        if (outItemCount >= 0) {
            this.outItemCount = outItemCount;
        }
    }

    public Afisha[] getLast() {
        int count = items.length > outItemCount ? outItemCount : items.length;
        Afisha[] result = new Afisha[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Afisha[] getAll() {
        return items;
    }

    public void add(Afisha item) {
        int length = items.length + 1;
        Afisha[] tmp = new Afisha[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }
}
