package net.ddns.aislandener.bibliotecamobile.control;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import net.ddns.aislandener.bibliotecamobile.model.Usuario;

public class UsuarioDAO extends SQLiteOpenHelper {

    private Context context;

    public UsuarioDAO(Context context){
        super(context, IDAO.DATABASE_NAME,null, IDAO.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(IDAO.CREATE_TABLE_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL(IDAO.DROP_TABLE_USUARIO);
        onCreate(db);
    }

    public void inserir(Usuario user){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.insert("usuario", null, user.getContentValues());
            db.close();
        }catch (SQLiteException ex){
            onCreate(db);
            inserir(user);
        }
    }

    public void sair(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("usuario",null,null);
        db.close();
    }

    public Usuario recuperarUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[]{"id", "nome", "email", "senha", "telefone"};
        Cursor cu = db.query("usuario",columns,null,null,null,null,null);
        if(cu.moveToFirst()){
            return new Usuario(cu);
        }else{
            return new Usuario(0,"NAO LOGADO","","","");
        }
    }

}