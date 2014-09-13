package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class HelloJava8 {

	static void foo() {
		for (int i = 0; i < 1000; i++) {
			List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
			Collections.sort(list);
		}
	}

	static void bar() {
		for (int i = 0; i < 2000; i++) {
			List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c",
					"d"));
			Collections.sort(list);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SampleFunction function = (name) -> System.out
				.println("Hello, " + name);
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			function.say("テスト 太郎");
			foo();
			bar();
			Thread.sleep(1000);
		}
	}

	@FunctionalInterface
	private interface SampleFunction {
		public void say(String name);
	}

}
