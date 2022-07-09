package ru.netology.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

public interface IPostController {

    void all(HttpServletResponse response) throws IOException;

    void getById(long id, HttpServletResponse response) throws IOException;

    void save(Reader body, HttpServletResponse response) throws IOException;

    void removeById(long id, HttpServletResponse response) throws IOException;
}
