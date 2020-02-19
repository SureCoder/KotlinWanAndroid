package com.my.kotlinwanandroid.net.convert;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.my.kotlinwanandroid.net.base.ApiResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CustomGsonConverterFactory extends Converter.Factory {

    private final Gson gson;
    GsonConverterFactory factory;

    private CustomGsonConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    public static CustomGsonConverterFactory create() {
        return create(new Gson());
    }

    public CustomGsonConverterFactory create(GsonConverterFactory factory) {
        this.factory = factory;
        return create(new Gson());
    }

    public static CustomGsonConverterFactory create(Gson gson) {
        return new CustomGsonConverterFactory(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Log.e("type",type.toString());
        ParameterizedType wrappedType = new ParameterizedType() {
            @Override public Type[] getActualTypeArguments() {
                return new Type[] { type };
            }

            @Override public Type getOwnerType() {
                return null;
            }

            @Override public Type getRawType() {
                return ApiResponse.class;
            }
        };

//        Log.e("type",wrappedType.get);
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(wrappedType));
        return new CustomGsonResponseBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CustomGsonRequestBodyConverter<>(gson, adapter);
    }
}
