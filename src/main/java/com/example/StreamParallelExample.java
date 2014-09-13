package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamParallelExample {

	public static void main(String[] args) {
		// http://news.mynavi.jp/special/2014/java8/007.html
		List<String> list = Arrays.asList("Java", "Groovy", "Scala");
		Stream<String> stream;
		if (false) {
			stream = list.parallelStream();
		} else {
			stream = list.stream();
		}
		stream.map(s -> toUpperCase(s)).forEach(System.out::println);
	}

	static String toUpperCase(String s) {
		String threadName = Thread.currentThread().getName();
		System.out.println("threadName =: " + threadName + ", s =: " + s);
		return s.toUpperCase();
	}

}
