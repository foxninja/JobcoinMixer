package com.gemini.jobcoin;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class JobcoinClient {
	private static final String API_ADDRESS_URL_PROP = "jobcoin.apiAddressesUrl";
	private final Client client = ClientBuilder.newClient();
	private final WebTarget webTarget;

	public JobcoinClient() {
		JobcoinProperties properties = new JobcoinProperties();
		this.webTarget = client.target(properties.getProperty(API_ADDRESS_URL_PROP));
	}

	public PlaceholderResponse testGet() {
		return webTarget.path("posts/1")
				.request(MediaType.APPLICATION_JSON)
				.get(PlaceholderResponse.class);
	}

	static class PlaceholderResponse {

		Integer userId;
		Integer id;
		String title;
		String body;

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		@Override
		public String toString() {
			return "PlaceholderResponse ["
			+ "userId=" + userId
			+ ", id=" + id
			+ ", title=" + title
			+ ", body=" + body
			+ "]";
		}

	}
}
