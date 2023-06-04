package com.codestates.burgerqueenspring.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestClient {

    private String url;

    public TestClient(String url) {
        System.out.println("생성자 호출.");
        this.url = url;
    }

    @PostConstruct
    public void init() {
        System.out.println("init() 초기화 메서드 실행.");
    }

    public void connect() {
        System.out.println("클라이언트를 " + url + "로 연결.");
    }

    @PreDestroy
    public void close() {
        System.out.println("close() 종료 메서드 실행.");
    }

}
