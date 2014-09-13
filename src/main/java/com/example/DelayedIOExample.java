package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

//http://enterprisegeeks.hatenablog.com/entry/2014/08/04/091200
public class DelayedIOExample {

	static void delayedIO(String fileLocation) throws IOException,
			FileNotFoundException {
		// 10101行目から10200行目までを取得する。
		try (Reader r = new FileReader(fileLocation)) {
			Stream<String> lines = new BufferedReader(r).lines();
			List<String> contents = lines.skip(10100).limit(100)
					.collect(Collectors.toList());
			contents.forEach(System.out::println);
		}
		System.out.println("delayedIO done");
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		String fileLocation = args.length > 0 ? args[0] : "input/200mn.txt";
		delayedIO(fileLocation);
		nondelayedIO(fileLocation);
	}

	static void nondelayedIO(String fileLocation) throws IOException,
			FileNotFoundException {
		File file = new File(fileLocation);
		List<String> lines = FileUtils.readLines(file);
		List<String> subList = lines.subList(10100, 10200);
		subList.forEach(System.out::println);
		System.out.println("nondelayedIO done");
	}

}
