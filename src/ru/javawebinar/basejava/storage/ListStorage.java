package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> storage = new LinkedList<>();

    @Override
    protected void doUpdate(Resume r, Object serachKey) {
        storage.remove(r);
        storage.add(r);
    }

    @Override
    protected void doSave(Resume r, Object serachKey) {
        storage.add(r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected boolean isExsist(Object searchKey) {
        if (searchKey!= null){
            return true;
        }
        return false;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (Resume r: storage){
            if (uuid.equals(r.getUuid())){
                return r;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        storage.clear();
    }


    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
