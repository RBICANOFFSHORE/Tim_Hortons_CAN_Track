package com.cognizant.framework.api;

public class Entry {
	public static void main(String[] args) throws Exception {
		String email="priyo1993l@gmail.com";

		String accessToken = GmailApiUtil.generateAccessToken(email);
		//System.out.println(accessToken);
		String id = GmailApiUtil.findAllEmailId(accessToken);
		//System.out.println(id);

		System.out.println(GmailApiUtil.findLastReceivedEmailBody(accessToken, id));


	}

}







// String jsonString = "{\"client_id\":\"" + client_id +
// "\",\"client_secret\":\"" + client_secret
// + "\",\"refresh_token\":\"" + refresh_token +
// "\",\"grant_type\":\"refresh_token\"}";

// String[] command = { "curl", "-d", jsonString, "-H",
// "Content-Type:application/json", "-X", "POST", url };