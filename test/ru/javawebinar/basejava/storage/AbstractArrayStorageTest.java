package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {

    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExsist() throws Exception {
        storage.update(new Resume("dummy"));
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,  storage.getAll().length);
    }

    @Test
    public void save() throws Exception {
        int sizeBeforeDelete = storage.size();
        Resume resume = new Resume("123");
        storage.save(resume);
        Assert.assertEquals(sizeBeforeDelete + 1, storage.size());
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test (expected = StorageException.class)
    public void saveOverfloveStorage() throws Exception{

        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT - 3; i++){
                Resume resume = new Resume(String.valueOf(i));
                storage.save(resume);
            }
        } catch (StorageException e){
            Assert.fail(e.getMessage());
        }

        storage.save(new Resume("123"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        int sizeBeforeDelete = storage.size();
        storage.delete(UUID_1);
        Assert.assertEquals(sizeBeforeDelete - 1,storage.size());
        storage.get(UUID_1);
    }

    @Test (expected = NotExistStorageException.class)
    public void deleteNotExsist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        Resume resume = new Resume("123");
        storage.save(resume);
        Assert.assertEquals(resume, storage.get("123"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}