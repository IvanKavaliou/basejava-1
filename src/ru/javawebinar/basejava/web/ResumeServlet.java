package ru.javawebinar.basejava.web;

import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.SqlStorage;
import ru.javawebinar.basejava.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ResumeServlet extends HttpServlet {

    private Storage storage;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String uuid = request.getParameter("uuid");
        if (uuid != null){
            Resume resume = storage.get(uuid);
            response.getWriter().write(resume.toString());
        } else {
            List<Resume> resumes = storage.getAllSorted();
            response.getWriter().write("<!DOCTYPE html><html><style>table, th, td {border:1px solid black;}</style><body><table style=\"width:100%\">");
            for (Resume r: resumes){
                response.getWriter().write("<tr><td>"+r.getUuid()+"</td><td>"+r.getFullName()+"</td></tr>");
            }
            response.getWriter().write("</table></body></html>");

        }

    }
}
