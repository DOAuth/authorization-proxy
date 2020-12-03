package com.github.doauth.proxy.endpoint;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Pattern;
import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(AuthorizationEndpoint.ENDPOINT)
public class AuthorizationEndpoint {

    public static final String ENDPOINT = "/authorize";

    @GetMapping
    public String authorizationRequest(
            @RequestParam(name = "response_type") @Pattern(regexp = "code|token") String responseType,
            @RequestParam(name = "scope") String scope,
            @RequestParam(name = "client_id") String client_id,
            @RequestParam(name = "redirect_uri") URI redirectUri,
            @RequestParam(name = "state") String state
    ) {
        log.info(
                "Authorization Request: response_type={}, scope={}, redirect_uri={}, client_id={}, state={}",
                responseType,
                scope,
                client_id,
                redirectUri,
                state
        );

        return "index";
    }
}
