package org.first_bank.services;

import java.util.List;

public interface DiskManager {

    <T> void writeToDisk(Class<T> type,
                         Serializer<T> serializer,
                         List<T> list);

    <T> List<T> readFromDisk(Class<T> type,
                             Serializer<T> serializer);

}
