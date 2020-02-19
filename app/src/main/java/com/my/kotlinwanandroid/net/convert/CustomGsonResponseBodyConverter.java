package com.my.kotlinwanandroid.net.convert;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.my.kotlinwanandroid.net.base.ApiResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static java.nio.charset.StandardCharsets.UTF_8;

//CustomGsonResponseBodyConverter.java
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JsonReader jsonReader = new GsonBuilder().serializeNulls().create().newJsonReader(value.charStream());
        Object data = null;
        try {
            ApiResponse read = (ApiResponse) adapter.read(jsonReader);
            try {
                Method getData = read.getClass().getDeclaredMethod("getData");
                data = getData.invoke(read);

//                Type t = data.getGenericType();
//                ParameterizedType ptype = (ParameterizedType)t; //转成参数化类型
//                System.out.println(ptype.getActualTypeArguments()[0]); //取出第一个参数的实际类型
//                Log.e("ParameterizedType",ptype.getActualTypeArguments()[0].toString());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
//            Type type = ((ParameterizedType) read.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//            Log.e("ParameterizedType",type.toString());
            if (data == null) {
                read.setData(new Object());
//               data = new Object();
            }
            return (T) read;
        } finally {
            value.close();
        }
    }
}
