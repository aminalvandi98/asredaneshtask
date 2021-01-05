package com.asredanesh.sample.service.interfaces;

import com.asredanesh.sample.domain.Github;

import java.util.List;

public interface GithubService {
    List<Github> getDataFromGithubAPI(String username);
}
