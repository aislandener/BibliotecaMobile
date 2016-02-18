package net.ddns.aislandener.bibliotecamobile.control;

public interface IDAO {
    public final String DATABASE_NAME="BibliotecaMobile";

    public final int DATABASE_VERSION = 1;

    public final String CREATE_TABLE_USUARIO =
            "CREATE TABLE usuario(" +
                    "id INTEGER PRIMARY KEY," +
                    "nome TEXT," +
                    "telefone TEXT," +
                    "email TEXT," +
                    "senha TEXT" +
                    ")";
    public final String DROP_TABLE_USUARIO =
            "DROP TABLE IF EXISTS usuario";

    public final String CREATE_TABLE_LIVROS =
            "CREATE TABLE livro" +
                    "id INTEGER PRIMARY KEY," +
                    "titulo TEXT" +
                    "autores TEXT" +
                    "edicao INTEGER" +
                    "editora TEXT" +
                    "cidade TEXT" +
                    "ano INTEGER" +
                    "descricao TEXT" +
                    ")";

    public final String DROP_TABLE_LIVRO =
            "DROP TABLE IF EXISTS livro";
}