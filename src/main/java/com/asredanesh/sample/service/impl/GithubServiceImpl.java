package com.asredanesh.sample.service.impl;

import com.asredanesh.sample.domain.Github;
import com.asredanesh.sample.service.interfaces.GithubService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GithubServiceImpl implements GithubService {
    /**
     *
     * @param username
     * @return
     */
    @Override
    public List<Github> getDataFromGithubAPI(String username) {
        List<Github> githubList = new ArrayList<>();
        int i = 1;
        try{
            while (true) {
                RestTemplate restTemplate = new RestTemplate();
                String resourceUrl = "https://api.github.com/users/" + username + "/repos?per_page=100&page=" + i;
                ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
                JSONArray jsonArray = new JSONArray(response.getBody());
                if (jsonArray.length() == 0) break;
                List<String> repositoryNameList = IntStream.range(0, jsonArray.length())
                        .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString("name"))
                        .collect(Collectors.toList());
                for (String name : repositoryNameList) {
                    Github github = new Github();
                    github.setName(name);
                    githubList.add(github);
                }
                i++;
            }
        }catch (Exception exception){
            return githubList;
        }
        return githubList;
    }
}
