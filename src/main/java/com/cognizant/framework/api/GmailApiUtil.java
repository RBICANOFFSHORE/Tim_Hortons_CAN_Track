package com.cognizant.framework.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class GmailApiUtil {

	@SuppressWarnings("unchecked")
	public static String generateAccessToken(String email) throws Exception {

		try {

			String[] credentials = findCredentials(email);

			String url = "https://oauth2.googleapis.com/token";

			if (credentials.length != 3) {
				throw new Exception();
			}

			String[] command = { "curl", "-d", "client_id=" + credentials[0] + "&client_secret=" + credentials[1]
					+ "&refresh_token=" + credentials[2] + "&grant_type=refresh_token", url };

			ProcessBuilder process = new ProcessBuilder(command);
			Process p;

			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();

			String line = null;

			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}

			String result = builder.toString();
			Gson gson = new Gson();
			Map<String, Object> map = gson.fromJson(result, Map.class);

			for (Map.Entry<String, Object> entry : map.entrySet()) {

				if (entry.getKey().equals("access_token")) {
					return (String) entry.getValue();
				}

			}

		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();

		}
		return null;

	}

	public static String findAllEmailId(String AccessToken) {

		String url = "https://www.googleapis.com/gmail/v1/users/me/messages";

		String bearerToken = "Authorization: Bearer " + AccessToken;

		String[] commandToFetchEmailList = { "curl", "-H", "Content-Type:application/json", "-H", bearerToken, "-X",
				"GET", url };

		ProcessBuilder process = new ProcessBuilder(commandToFetchEmailList);
		Process p;
		String result = null;
		try {
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			result = builder.toString();

		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();
		}

		// Convert Java Object to JSON Object and get access the latest ID
		Gson gson = new Gson();
		EmailListModel emailListInfo = gson.fromJson(result, EmailListModel.class);
		return emailListInfo.getMessages().get(0).getId();

	}

	@SuppressWarnings("unchecked")
	public static String findLastReceivedEmailBody(String accessToken, String id) {

		try {
			String url = "https://www.googleapis.com/gmail/v1/users/me/messages/" + id;

			String bearerToken = "Authorization: Bearer " + accessToken;
			String[] commandToFetchEmailList = { "curl", "-H", "Content-Type:application/json", "-H", bearerToken, "-X",
					"GET", url };

			ProcessBuilder process = new ProcessBuilder(commandToFetchEmailList);

			Process p;

			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			StringBuilder builder = new StringBuilder();

			String line = null;

			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}

			String result = builder.toString();
			//System.out.print(result);

			Gson gson = new Gson();

			Map<String, Object> map = gson.fromJson(result, Map.class);

			for (Map.Entry<String, Object> entry : map.entrySet()) {

				if (entry.getKey().equals("snippet")) {
					return (String) entry.getValue();
					// return (String) entry.getValue();
				}

			}

		} catch (IOException e) {

			System.out.print("error");
			e.printStackTrace();

		}
		return null;
	}

	public static String[] findCredentials(String email) {

		try {

			//String path = "E://Workspace-Office//Gmail//src//main//java//com//cognizant//framework//api//credentials.json";
			String path = "src//main//java//com//cognizant//framework//api//credentials.json";
			JsonReader reader = new JsonReader(new FileReader(path));
			Credentials[] credentials = new Gson().fromJson(reader, Credentials[].class);

			String[] items = new String[3];
			for (int index = 0; index < credentials.length; index++) {

				if (credentials[index].getEmail().toLowerCase().equals(email.trim().toLowerCase())) {

					items[0] = credentials[index].getClient_id();
					items[1] = credentials[index].getClient_secret();
					items[2] = credentials[index].getRefresh_token();
					break;

				}
			}

			reader.close();

			if (items != null) {
				return items;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}

}
