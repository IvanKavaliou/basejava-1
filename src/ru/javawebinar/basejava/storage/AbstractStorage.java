package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doUpdate(Resume r, Object serachKey);

    protected abstract void doSave(Resume r, Object serachKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract boolean isExsist(Object searchKey);

    protected abstract Object getSearchKey(String uuid);


    @Override
    public void update(Resume r) {
        Object searchKey = getExsistSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public void save(Resume r) {
        Object searchKey = getNotExsistSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExsistSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExsistSearchKey(uuid);
        doDelete(searchKey);
    }

    private Object getExsistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExsist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExsistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExsist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
