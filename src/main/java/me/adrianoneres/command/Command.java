package me.adrianoneres.command;

import java.util.Properties;

public interface Command {
    public Object executar(Properties properties);
}
