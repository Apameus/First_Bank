package services;

public interface Serializer <T> {

    String serialize(T t);

    T parse(String line);

}
