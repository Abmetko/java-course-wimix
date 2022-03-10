package com.javc.api.github;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

import java.util.Arrays;

public class SiteCookie {

    public static Cookies defaultCookies() {
        return new Cookies(Arrays.asList(
                new Cookie.Builder("user_session", "B4476pQ-wgCTnY7iRJB4P3DGuvYhIQ-v6k8h98Y9Z-jjhaWg").build(),
                new Cookie.Builder("__Host-user_session_same_site", "B4476pQ-wgCTnY7iRJB4P3DGuvYhIQ-v6k8h98Y9Z-jjhaWg").build(),
                new Cookie.Builder("logged_in", "yes").build(),
                new Cookie.Builder("dotcom_user", "Abmetko").build(),
                new Cookie.Builder("_gh_sess", "Mw3LMJ+t7gbc7Tj5Z/VBZeMu/8H0kx11NFl1Jn+sdCZFdxQJqyxtw9ROxdDu2p1nW7rc/V4QhpcFUKhxIS9/VghN7ST6rkVKoarUz2UzTsmxbiGnZK9pjQGKSNlDgAjyy5f1PhipbJnLKq9H4XDB8EBvSLRBOyXnPnJmiKqDiUvOL6n5gC1dddJsLipCHGJ+IYTNhhKHzf4Sl6Pe2euBloNgAhry80xI7xbAQaip8DGvPGAwVz5D1sSzuhsLtx1tkshBfOv66teuBFIXs6kZHghXqoOtUSxZdTMwD9VILG4XCIPkqzvAmNHQodtWOaYncpE9xTWFy2P6AQ+5bIN5fEV8vOmeuAzuNNLZSXctL6DBSlgbSStAG7kfIrWsV0HJsm2GpX0XXuWvsudvYh6SDr0b9EjmA3UVwcopNVs76pH7Dr4AJ99G62SxkP/JUxMFes92v+D2A0IrADVa86Ef5VWk9x9ngGTLwW+xAklObHMtWs1/UxhgPLwZTXJ0yWyAqSU35DSFy6WbahMqxdFOz/zGyGG4JDVQ2vduYsfpBYp08nKNXLF1aWQUkJSvBfArynjrxx/CkjnVnqqO+9uJG68oaJd2ry1ICZ8nteheG4XDEahqHOxVVDzI6tkVYK51hvAOQa7Hw6zdKKUMP8bO65a6GYnMZyXBVtAh9eI5meiwhnE8GnW/RqY1cV5j+jNkF0nfppyprfRj+UyUr8JDsuIM8h+TJ3R1gKFQ613z4vZcSOIDolMLJAgQ6Xs7EI+S0sEN5D3hNWQj54Sja/442FayuJf+5Gr2CNITKErKjJbhSk28cFjEvSRlNEoR74Yp8zRdW85lif7bgJ9tuTh98ANMpahLJQ+6Pd5tYEspDCXBNFN2VhXK3UVdSRS6k2NCN+QjXlZFhKaq5ksDp7TWgC42KsjiVP/e--ys9yq6hSdStnALh+--UZObNf0QmdhWRCIUYjM62A==").build()
        ));
    }
}