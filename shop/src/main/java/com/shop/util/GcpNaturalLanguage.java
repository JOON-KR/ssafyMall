package com.shop.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.shop.dto.EntitiesDto;

public class GcpNaturalLanguage {
	private static String apiKey;
	private static final RestTemplate restTemplate = new RestTemplate();

	static {
		try {
			InputStream inputStream = GcpNaturalLanguage.class.getClassLoader()
					.getResourceAsStream("application.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			apiKey = properties.getProperty("google.api.key");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<EntitiesDto> analyzeText(String text,double SentimentScore, String itemName) {
		List<EntitiesDto> result = new ArrayList<EntitiesDto>();
		
		String sentimentUrl = "https://language.googleapis.com/v1/documents:analyzeSentiment?key=" + apiKey;
		String entitiesUrl = "https://language.googleapis.com/v1/documents:analyzeEntities?key=" + apiKey;

		Map<String, Object> document = new HashMap<>();
		document.put("type", "PLAIN_TEXT");
		document.put("content", text);

		Map<String, Object> request = new HashMap<>();
		request.put("document", document);
		request.put("encodingType", "UTF8");

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

		try {
			ResponseEntity<Map> sentimentResponse = restTemplate.exchange(sentimentUrl, HttpMethod.POST, entity,
					Map.class);
			Map<String, Object> sentimentBody = sentimentResponse.getBody();
			String sentimentResult = "No sentiment data found.";
			if (sentimentBody != null && sentimentBody.containsKey("documentSentiment")) {
				Map<String, Object> sentiment = (Map<String, Object>) sentimentBody.get("documentSentiment");
				Number score = (Number) sentiment.get("score");
				Number magnitude = (Number) sentiment.get("magnitude");
				SentimentScore = score.doubleValue();
				sentimentResult = String.format("Sentiment Score: %.2f\nSentiment Magnitude: %.2f", score.doubleValue(),
						magnitude.doubleValue());
			}

			ResponseEntity<Map> entitiesResponse = restTemplate.exchange(entitiesUrl, HttpMethod.POST, entity,
					Map.class);
			Map<String, Object> entitiesBody = entitiesResponse.getBody();
			StringBuilder entitiesResult = new StringBuilder("Entities:\n");
			if (entitiesBody != null && entitiesBody.containsKey("entities")) {
				List<Map<String, Object>> entities = (List<Map<String, Object>>) entitiesBody.get("entities");
				Map<String, EntityInfo> uniqueEntities = new HashMap<>();
				for (Map<String, Object> entityInfo : entities) {
					String name = (String) entityInfo.get("name");
					String type = (String) entityInfo.get("type");
					Number salience = (Number) entityInfo.get("salience");
					EntityInfo entity2 = uniqueEntities.getOrDefault(name, new EntityInfo(type, 0, 0.0));
					entity2.incrementCount();
					entity2.addSalience(salience.doubleValue());
					uniqueEntities.put(name, entity2);
				}
				List<Map.Entry<String, EntityInfo>> sortedEntities = new ArrayList<>(uniqueEntities.entrySet());
				sortedEntities
						.sort((e1, e2) -> Double.compare(e2.getValue().getSalience(), e1.getValue().getSalience()));
				
				for (Map.Entry<String, EntityInfo> entry : sortedEntities) {
					String name = entry.getKey();
					EntityInfo entityInfo = entry.getValue();
					EntitiesDto Entityitem = new EntitiesDto();
					Entityitem.setEntity(name);
					Entityitem.setItemNm(itemName);
					Entityitem.setWeight(entityInfo.getSalience());
					result.add(Entityitem);
					entitiesResult.append(String.format("%s (%s) - Count: %d, Salience: %.2f\n", name,
							entityInfo.getType(), entityInfo.getCount(), entityInfo.getSalience()));
				}
			} else {
				entitiesResult.append("No entities found.");
			}

			System.out.println(String.format("Text: %s\n\n%s\n\n%s", text, sentimentResult, entitiesResult.toString()));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the text to analyze:");
		System.out.println(apiKey);
		String text = scanner.nextLine();

		analyzeText(text,0,"Item");
	}
	
	public List<EntitiesDto> getAllItemEntities(String itemName){
		
	}
	
	static class EntityInfo {
		private final String type;
		private int count;
		private double totalSalience;

		public EntityInfo(String type, int count, double totalSalience) {
			this.type = type;
			this.count = count;
			this.totalSalience = totalSalience;
		}

		public String getType() {
			return type;
		}

		public int getCount() {
			return count;
		}

		public void incrementCount() {
			this.count++;
		}

		public double getSalience() {
			return totalSalience;
		}

		public void addSalience(double salience) {
			this.totalSalience += salience;
		}
	}
}
