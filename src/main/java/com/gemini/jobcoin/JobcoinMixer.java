package com.gemini.jobcoin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class JobcoinMixer {
	private static String prompt = "Please enter a comma-separated list of new, unused Jobcoin addresses where your mixed Jobcoins will be sent.\n";
	private static String helpText = "" + "|Jobcoin Mixer\n" + "|\n"
			+ "|Takes in at least one return address as parameters (where to send coins after mixing). Returns a deposit address to send coins to.\n"
			+ "|\n" + "|Usage:\n" + "|    run return_addresses...\n";

	public static void main(String args[]) throws IOException {
//		JobcoinClient client = new JobcoinClient();
//		System.out.println(client.testGet());
		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print(prompt);
			String line = obj.readLine();

			List<String> addresses = Arrays.asList(line.split(","));
			if (line.trim().length() == 0) {
				System.out.println(String.format("You must specify empty addresses to mix into!\n%s", helpText));
			} else {
				UUID depositAddress = UUID.randomUUID();
				System.out.println(
					String.format(
						"You may now send Jobcoins to address %s. They will be mixed and sent to your destination addresses.",
						depositAddress)
					);
			}
		}

	}
}
