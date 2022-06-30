package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.sql.ConnectionFactory;
import ru.javawebinar.basejava.sql.SqlHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {
    public final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        this.sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void clear() {
        sqlHelper.execute( (ps) -> {
            ps.execute();
            return null;
        }, "DELETE FROM resume");
    }

    @Override
    public Resume get(String uuid) {
        return sqlHelper.execute( (ps) -> {
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        }, "SELECT * FROM resume r WHERE r.uuid =?");
    }

    @Override
    public void update(Resume r) {
        sqlHelper.execute( (ps) -> {
            ps.setString(1, r.getFullName());
            ps.setString(2, r.getUuid());
            if (ps.executeUpdate() <=0){
                throw new NotExistStorageException(r.getUuid());
            }
            return null;
        }, "UPDATE resume SET full_name =? WHERE uuid=?");

    }

    @Override
    public void save(Resume r) {
        sqlHelper.execute( (ps) -> {
            try {
                get(r.getUuid());
                throw new ExistStorageException(r.getUuid());
            } catch (NotExistStorageException e){
                ps.setString(1, r.getUuid());
                ps.setString(2, r.getFullName());
                ps.execute();
            }
            return null;
        }, "INSERT INTO resume (uuid, full_name) VALUES (?,?)");

    }

    @Override
    public void delete(String uuid) {
        sqlHelper.execute( (ps) -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() <=0){
                throw new NotExistStorageException(uuid);
            }
            return null;
        }, "DELETE FROM resume WHERE uuid =?");
    }

    @Override
    public List<Resume> getAllSorted() {
        return sqlHelper.execute( (ps) -> {
            ResultSet rs = ps.executeQuery();
            List<Resume> result = new ArrayList<>();
            while (rs.next()){
                result.add(new Resume(rs.getString("uuid").trim(), rs.getString("full_name")));
            }
            return result;
        }, "SELECT * FROM resume");
    }

    @Override
    public int size() {
        return sqlHelper.execute( (ps) -> {
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }, "SELECT COUNT(*) FROM resume");
    }
}
