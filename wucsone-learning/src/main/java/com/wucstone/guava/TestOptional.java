package com.wucstone.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TestOptional {

    @Test
    public void testOptional(){
        Optional<String> optional = Optional.of("null");

        String a = "asd";

        Preconditions.checkNotNull(a,"a is null");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(a));

        Objects.requireNonNull(a);

        System.out.println(MoreObjects.firstNonNull(null,"abc"));


        ImmutableList<String> list = ImmutableList.of("a","a","c");
        ImmutableSet<String> set = ImmutableSet.of("a","a","c");
        ImmutableMap<String,String> map = ImmutableMap.of("a","a");



        Multimap<String,Integer> mmap = ArrayListMultimap.create();
        mmap.put("aa", 1);
        mmap.put("aa", 2);
        System.out.println(map.get("aa"));  //[1, 2]



    }
}
