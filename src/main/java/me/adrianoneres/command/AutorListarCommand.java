package me.adrianoneres.command;

import me.adrianoneres.dao.AutorDao;
import me.adrianoneres.model.Autor;

import javax.inject.Inject;
import java.util.List;
import java.util.Properties;

public class AutorListarCommand implements Command {

    @Inject
    private AutorDao autorDao;

    @Override
    public List<Autor> executar(Properties properties) {
        return autorDao.listar();
    }
}
