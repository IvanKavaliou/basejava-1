package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected void fillDeletedElment(int index) {
        System.arraycopy(storage,index+1,storage, index, size-index);
        storage[size] = null;
    }

    @Override
    protected void insertElemnt(Resume r, int index) {
            index = (index * -1) - 1;
            System.arraycopy(storage, index, storage, index+1, size-index);
            storage[index] = r;
    }

    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
