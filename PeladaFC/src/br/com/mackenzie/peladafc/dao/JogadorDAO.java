package br.com.mackenzie.peladafc.dao;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.mackenzie.peladafc.model.Jogador;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : PeladaFC
//  @ File Name : JogadorDAO.java
//  @ Date : 07/09/2013
//  @ Author : 
//
//




/** */
public class JogadorDAO {
	
	private SQLiteDatabase database;
	private DbHelper dbHelper;
	private String[] allColumns = {DbHelper.COLUNA_ID_JOGADOR, DbHelper.COLUNA_NOME_JOGADOR, 
			DbHelper.COLUNA_APELIDO_JOGADOR,DbHelper.COLUNA_CLASSIFICACAO_JOGADOR };
	
	public JogadorDAO(Context context) {          
		dbHelper = new DbHelper(context);
	}
	
	
	private Jogador cursorToJogador(Cursor cursor) {
		Jogador jogador = new Jogador();
		jogador.setId(cursor.getInt(0));
		jogador.setNome(cursor.getString(1));
		jogador.setApelido(cursor.getString(2));
		jogador.setClassificao(cursor.getInt(3));
		return jogador;
	}

	/** */
	public void adiciona(Jogador jogador) {
        ContentValues values = new ContentValues(); 
        values.put(DbHelper.COLUNA_NOME_JOGADOR, jogador.getNome()); 
        values.put(DbHelper.COLUNA_APELIDO_JOGADOR,jogador.getApelido()); 
        values.put(DbHelper.COLUNA_CLASSIFICACAO_JOGADOR, jogador.getClassificao()); 
        database.insert(DbHelper.TABELA_JOGADOR, null, values); 

	}
	
	/** */
	public void atualiza(Jogador jogador) {
	
	}
	
	/** */
	public List<Jogador> obterListaJogadores() {
		return null;
	
	}
	
	/** */
	public Jogador obterJogador(int id) {
     // To show how to query 
      Cursor cursor = database.query(DbHelper.TABELA_JOGADOR, allColumns, DbHelper.COLUNA_ID_JOGADOR + " = " + 
      id, null,null, null, null); 
      cursor.moveToFirst(); 
      return cursorToJogador(cursor); 	
    }
	
	/** */
	public List<Jogador> obterListaJogadorApelido(String apelido) {
		return null;
	}
	
	/** */
	public List<Jogador> obterListaJogadorNome(String nome) {
		return null;
	}
	

}
