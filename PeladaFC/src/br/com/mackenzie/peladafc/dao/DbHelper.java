package br.com.mackenzie.peladafc.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
	 
	private static final String DB_NAME = "PELADAFC";
	private static final int DATABASE_VERSION = 1;
	public static final String TABELA_JOGADOR = "JOGADOR";
	 
	public static final String COLUNA_ID_JOGADOR = "jogador_id";
	public static final String COLUNA_APELIDO_JOGADOR = "jogador_apelido";
	public static final String COLUNA_NOME_JOGADOR = "jogador_nome";
	public static final String COLUNA_CLASSIFICACAO_JOGADOR = "jogador_classificacao";

	public static final String TABELA_MODALIDADE = "JOGADOR";
	 
	public static final String COLUNA_ID_MODALIDADE = "modalidade_id";
	public static final String COLUNA_DESCRICAO_MODALIDADE = "modalidade_descricao";
	public static final String COLUNA_QTDE_JOGADORES_MODALIDADE = "modalidade_qtde_jogadores";
	
	private static final String JOGADOR_CREATE_TABLE = "CREATE TABLE "
			+ TABELA_JOGADOR + "  (" + COLUNA_ID_JOGADOR
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COLUNA_APELIDO_JOGADOR + " text not null ," 
			+ COLUNA_NOME_JOGADOR + " text not null, "
			+ COLUNA_CLASSIFICACAO_JOGADOR + "INTEGER );";

		private static final String MODALIDADE_CREATE_TABLE = "CREATE TABLE "
			+ TABELA_MODALIDADE + "  (" + COLUNA_ID_MODALIDADE
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COLUNA_DESCRICAO_MODALIDADE + " text not null , "
			+ COLUNA_CLASSIFICACAO_JOGADOR + "INTEGER );";

		public DbHelper(Context context) {
			super(context, DB_NAME, null, DATABASE_VERSION);
		}
		
		@Override
		public void onOpen(SQLiteDatabase db)
		  {
			super.onOpen(db);
			if (!db.isReadOnly())
			{
			  db.execSQL("PRAGMA foreign_keys=ON;");
			}
		  }
	 
		@Override
		public void onCreate(SQLiteDatabase db) {
	 
			//cria as tabelas
			db.execSQL(JOGADOR_CREATE_TABLE);
			db.execSQL(MODALIDADE_CREATE_TABLE );
			
			//Insere valores iniciais na tabela MODALIDADE
			ContentValues values = new ContentValues();
			values.put(COLUNA_DESCRICAO_MODALIDADE, "CAMPO");
			values.put(COLUNA_QTDE_JOGADORES_MODALIDADE, 11);
			db.insert(TABELA_MODALIDADE, null, values);
			values.clear();
			values.put(COLUNA_DESCRICAO_MODALIDADE, "QUADRA");
			values.put(COLUNA_QTDE_JOGADORES_MODALIDADE, 5);
			db.insert(TABELA_MODALIDADE, null, values);
			values.clear();
			values.put(COLUNA_DESCRICAO_MODALIDADE, "SOCIETY");
			values.put(COLUNA_QTDE_JOGADORES_MODALIDADE, 7);
			db.insert(TABELA_MODALIDADE, null, values);
			values.clear();
			
			Log.w("DbAdapter","DB criado com sucesso!");
		}
	 
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(DbAdapter.class.getName(),  "Atualizando o banco de dados da versão " + oldVersion
					+ " para " + newVersion
					+ ", todos os dados serão perdidos!");
			//TODO ADICIONAR TODAS AS TABELAS AQUI 
			db.execSQL("DROP TABLE IF EXISTS " + TABELA_JOGADOR);
			onCreate(db);
		}
	}


