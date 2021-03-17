package com.github;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class Application {
    //定义 mock 服务端的端口
    private static final int PORT= 9090;

    //定义 mock 服务的地址
    private static final  String LOCALHOST="localhost";

    //定义  mapping 文件的目录
    private static final String MOCK_DIR ="mock";

    /**
     * 启动 mock 服务
     *
     */
    public static void main(String[] args) {
        final WireMockConfiguration config = wireMockConfig().
                                                port(PORT).
                                                usingFilesUnderClasspath(MOCK_DIR);
        final WireMockServer WireMockServer= new WireMockServer(config);
        WireMockServer.start();
        WireMock.configureFor(LOCALHOST,PORT);
    }
}
