package com.smile.serializer;

import java.io.IOException;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: TODO
 * @date 2024/4/9 10:29
 */
public interface Serializer {

    <T> byte[] serialize(T object) throws IOException;

    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}
