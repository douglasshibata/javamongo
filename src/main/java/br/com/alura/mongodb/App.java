package br.com.alura.mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        MongoClient cliente = new MongoClient();
        MongoDatabase bancoDeDados = cliente.getDatabase("test");
        MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
        Document aluno = alunos.find().first();
        System.out.println(aluno);
        cliente.close();
    }
}
