package br.com.alura.screenmacth.service;

public interface IConverteDados {
     <T> T conversor(String json, Class<T> classe);

}
